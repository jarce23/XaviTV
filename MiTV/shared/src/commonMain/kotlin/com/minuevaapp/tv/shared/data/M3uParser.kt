package com.minuevaapp.tv.shared.data

import com.minuevaapp.tv.shared.platform.PlatformStorage
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.statement.bodyAsText
import io.ktor.http.isSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

class M3uCatalog(
    val liveCategories: List<Category>,
    val liveStreams: List<LiveStream>,
    val vodCategories: List<Category>,
    val vodStreams: List<VodStream>,
    val vodDetails: Map<String, VodInfoResponse>,
    val seriesCategories: List<Category>,
    val seriesList: List<Series>,
    val seriesDetails: Map<String, Pair<SeriesDetails, Map<String, List<Episode>>>>,
    val directUrls: Map<String, String>,
    val contentSignature: String = "",
    val isFromLocalCache: Boolean = false
)

object M3uParser {
    private val sePattern1 = Regex("""(?i)^(.*?)[\s._-]*S(\d{1,2})[\s._-]*E(\d{1,3})\b""")
    private val sePattern2 = Regex("""(?i)^(.*?)[\s._-]*(\d{1,2})x(\d{1,3})\b""")
    private val sePattern3 = Regex("""(?i)^(.*?)[\s._-]*(?:Temp(?:orada)?|T)\s*(\d{1,2})[\s._-]*(?:Cap(?:[íi]tulo)?|Ep(?:isodio)?|E)\s*(\d{1,3})\b""")

    private val vodExtensions = setOf("mp4", "mkv", "avi", "mov", "wmv", "flv", "webm", "m4v")
    private val liveExtensions = setOf("m3u8", "ts", "mpd", "aac", "mp3", "ogg", "m4a", "pls")

    private val seriesGroupKeywords = listOf(
        "serie", "series", "temporada", "season", "novela", "telenovela", "anime", "dorama", "miniserie"
    )
    private val movieGroupKeywords = listOf(
        "pelicula", "película", "peliculas", "películas", "movie", "movies", "vod", "film", "films", "taquilla"
    )

    private enum class Kind { LIVE, MOVIE, SERIES }

    private data class SeriesAcc(
        val seriesId: String,
        val name: String,
        var cover: String?,
        val categoryId: String,
        val categoryName: String,
        val episodesBySeason: MutableMap<String, MutableList<Episode>> = linkedMapOf()
    )

    private class ExtInfBuffer {
        var title: String? = null
        var logo: String? = null
        var group: String? = null
        var tvgId: String? = null

        fun reset() {
            title = null
            logo = null
            group = null
            tvgId = null
        }
    }

    /**
     * Genera una clave determinista de almacenamiento local para cada URL M3U.
     */
    fun cacheKeyForUrl(url: String): String {
        val clean = url.trim().lowercase()
        var hash = -3750763034362895579L // FNV-1a 64-bit offset basis
        for (i in clean.indices) {
            hash = hash xor clean[i].code.toLong()
            hash *= 1099511628211L
        }
        return hash.toULong().toString(16)
    }

    /**
     * Calcula una huella digital (hash FNV-1a 64-bit + longitud) sobre el contenido M3U
     * para detectar de manera fiable si la lista descargada tiene cambios respecto a la caché local.
     */
    fun computeContentSignature(content: String): String {
        var hash = -3750763034362895579L
        var nonEmptyLines = 0
        for (rawLine in content.lineSequence()) {
            val trimmed = rawLine.trim()
            if (trimmed.isEmpty()) continue
            nonEmptyLines++
            for (i in trimmed.indices) {
                hash = hash xor trimmed[i].code.toLong()
                hash *= 1099511628211L
            }
        }
        return "${hash.toULong().toString(16)}_${nonEmptyLines}"
    }

    /**
     * Descarga el texto bruto de la lista M3U en segundo plano (Dispatchers.IO) validando el estado HTTP.
     */
    suspend fun fetchRawText(url: String, client: HttpClient): String = withContext(Dispatchers.IO) {
        val response = client.get(url.trim()) {
            header("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 17_5 like Mac OS X; XaviTV/1.1)")
        }
        if (!response.status.isSuccess()) {
            throw IllegalStateException("No se pudo descargar la lista M3U (HTTP ${response.status.value})")
        }
        val text = response.bodyAsText()
        if (text.isBlank()) {
            throw IllegalStateException("La lista M3U descargada está vacía")
        }
        text
    }

    /**
     * Carga y parsea inmediatamente la última lista M3U guardada en el almacenamiento local (fallback offline).
     */
    suspend fun loadFromLocalCache(url: String): M3uCatalog? = withContext(Dispatchers.IO) {
        val key = cacheKeyForUrl(url)
        val cachedText = PlatformStorage.loadCachedM3u(key)?.takeIf { it.isNotBlank() }
            ?: return@withContext null
        runCatching {
            parseText(cachedText, isFromLocalCache = true)
        }.getOrNull()
    }

    /**
     * Descarga y parsea la lista M3U en Dispatchers.IO guardando una copia local de respaldo.
     * Si el dispositivo no tiene internet o el servidor falla, recurre automáticamente a la última
     * lista guardada en el almacenamiento local.
     */
    suspend fun fetchAndParse(url: String, client: HttpClient): M3uCatalog = withContext(Dispatchers.IO) {
        val key = cacheKeyForUrl(url)
        try {
            val text = fetchRawText(url, client)
            val catalog = parseText(text, isFromLocalCache = false)
            PlatformStorage.saveCachedM3u(key, text)
            catalog
        } catch (networkError: Throwable) {
            val fallbackText = PlatformStorage.loadCachedM3u(key)?.takeIf { it.isNotBlank() }
            if (fallbackText != null) {
                runCatching {
                    parseText(fallbackText, isFromLocalCache = true)
                }.getOrElse { throw networkError }
            } else {
                throw networkError
            }
        }
    }

    /**
     * Parser lineal de etiquetas #EXTINF sin crear mapas ni regex por línea.
     * Localiza la primera coma fuera de comillas para preservar títulos que contienen comas.
     */
    private fun parseExtInfLine(line: String, out: ExtInfBuffer) {
        out.reset()
        val len = line.length
        var inQuotes = false
        var commaIdx = -1
        for (i in 8 until len) {
            val c = line[i]
            if (c == '"') {
                inQuotes = !inQuotes
            } else if (c == ',' && !inQuotes) {
                commaIdx = i
                break
            }
        }

        val headerEnd = if (commaIdx >= 0) commaIdx else len
        var tvgName: String? = null

        var i = 8
        while (i < headerEnd) {
            while (i < headerEnd && line[i] <= ' ') i++
            val keyStart = i
            while (i < headerEnd && line[i] != '=' && line[i] > ' ') i++
            val keyEnd = i
            while (i < headerEnd && line[i] <= ' ') i++
            if (i < headerEnd && line[i] == '=') {
                i++
                while (i < headerEnd && line[i] <= ' ') i++
                if (i < headerEnd && line[i] == '"') {
                    val valStart = ++i
                    while (i < headerEnd && line[i] != '"') i++
                    val valEnd = i
                    if (i < headerEnd) i++ // consumir comilla de cierre

                    val keyLen = keyEnd - keyStart
                    if (valEnd > valStart && keyLen in 6..11) {
                        when {
                            keyLen == 8 && line.regionMatches(keyStart, "tvg-logo", 0, 8, ignoreCase = true) ->
                                out.logo = line.substring(valStart, valEnd).trim().takeIf { it.isNotEmpty() }
                            keyLen == 11 && line.regionMatches(keyStart, "group-title", 0, 11, ignoreCase = true) ->
                                out.group = line.substring(valStart, valEnd).trim().takeIf { it.isNotEmpty() }
                            keyLen == 8 && line.regionMatches(keyStart, "tvg-name", 0, 8, ignoreCase = true) ->
                                tvgName = line.substring(valStart, valEnd).trim().takeIf { it.isNotEmpty() }
                            keyLen == 6 && line.regionMatches(keyStart, "tvg-id", 0, 6, ignoreCase = true) ->
                                out.tvgId = line.substring(valStart, valEnd).trim().takeIf { it.isNotEmpty() }
                        }
                    }
                } else {
                    while (i < headerEnd && line[i] > ' ') i++
                }
            }
        }

        val titleAfterComma = if (commaIdx >= 0 && commaIdx + 1 < len) {
            line.substring(commaIdx + 1).trim()
        } else {
            ""
        }
        out.title = titleAfterComma.ifBlank { tvgName.orEmpty() }
    }

    private fun hasDigit(s: String): Boolean {
        for (i in s.indices) {
            if (s[i] in '0'..'9') return true
        }
        return false
    }

    private fun extractLowerExtension(url: String): String {
        val queryIdx = url.indexOf('?')
        val end = if (queryIdx >= 0) queryIdx else url.length
        val slashIdx = url.lastIndexOf('/', end - 1)
        val dotIdx = url.lastIndexOf('.', end - 1)
        if (dotIdx <= slashIdx || dotIdx < 0 || dotIdx + 1 >= end) return ""
        return url.substring(dotIdx + 1, end).lowercase()
    }

    fun parseText(content: String, isFromLocalCache: Boolean = false): M3uCatalog {
        val liveCatMap = linkedMapOf<String, Category>()
        val vodCatMap = linkedMapOf<String, Category>()
        val seriesCatMap = linkedMapOf<String, Category>()

        val liveStreams = ArrayList<LiveStream>(256)
        val vodStreams = ArrayList<VodStream>(64)
        val vodDetails = HashMap<String, VodInfoResponse>(64)
        val seriesAccMap = linkedMapOf<String, SeriesAcc>()
        val directUrls = HashMap<String, String>(320)

        val extInf = ExtInfBuffer()
        var itemIndex = 0

        // Cálculo de firma en una sola pasada simultánea al parsing
        var sigHash = -3750763034362895579L
        var nonEmptyLines = 0

        for (rawLine in content.lineSequence()) {
            val rawTrimmed = rawLine.trim()
            if (rawTrimmed.isEmpty()) continue
            nonEmptyLines++
            for (i in rawTrimmed.indices) {
                sigHash = sigHash xor rawTrimmed[i].code.toLong()
                sigHash *= 1099511628211L
            }

            val trimmed = if (rawTrimmed[0] == '\uFEFF') rawTrimmed.substring(1) else rawTrimmed
            if (trimmed.isEmpty()) continue

            if (trimmed[0] == '#') {
                if (trimmed.startsWith("#EXTINF:", ignoreCase = true)) {
                    parseExtInfLine(trimmed, extInf)
                } else if (trimmed.startsWith("#EXTGRP:", ignoreCase = true)) {
                    val grp = trimmed.substringAfter(':').trim()
                    if (grp.isNotEmpty() && extInf.group.isNullOrBlank()) {
                        extInf.group = grp
                    }
                }
            } else {
                if (isStreamUrl(trimmed)) {
                    itemIndex++
                    val streamUrl = trimmed
                    val rawTitle = extInf.title?.takeIf { it.isNotBlank() } ?: "Canal $itemIndex"
                    val groupName = extInf.group?.takeIf { it.isNotBlank() } ?: "General"
                    val logo = extInf.logo

                    val lowerUrl = streamUrl.lowercase()
                    val lowerGroup = groupName.lowercase()
                    val extLower = extractLowerExtension(streamUrl)

                    val isLiveExt = extLower.isNotEmpty() && extLower in liveExtensions
                    val seMatch = if (!isLiveExt && hasDigit(rawTitle)) {
                        sePattern1.find(rawTitle)
                            ?: sePattern2.find(rawTitle)
                            ?: sePattern3.find(rawTitle)
                    } else {
                        null
                    }

                    val kind = classifyStream(lowerUrl, lowerGroup, extLower, seMatch != null)

                    when (kind) {
                        Kind.LIVE -> {
                            val catId = "live_cat_${lowerGroup.hashCode()}"
                            liveCatMap.getOrPut(catId) { Category(catId, groupName) }
                            val id = "m3u_live_$itemIndex"
                            directUrls[id] = streamUrl
                            liveStreams.add(
                                LiveStream(
                                    name = rawTitle,
                                    streamId = id,
                                    icon = logo,
                                    epgChannelId = extInf.tvgId,
                                    categoryId = catId,
                                    directUrl = streamUrl
                                )
                            )
                        }
                        Kind.MOVIE -> {
                            val catId = "vod_cat_${lowerGroup.hashCode()}"
                            vodCatMap.getOrPut(catId) { Category(catId, groupName) }
                            val id = "m3u_vod_$itemIndex"
                            val ext = extLower.ifBlank { "mp4" }
                            directUrls[id] = streamUrl
                            vodStreams.add(
                                VodStream(
                                    name = rawTitle,
                                    streamId = id,
                                    icon = logo,
                                    categoryId = catId,
                                    extension = ext,
                                    directUrl = streamUrl
                                )
                            )
                            vodDetails[id] = VodInfoResponse(
                                info = VodInfo(
                                    name = rawTitle,
                                    plot = "Categoría: $groupName",
                                    genre = groupName,
                                    image = logo
                                ),
                                movieData = VodData(
                                    streamId = id,
                                    name = rawTitle,
                                    extension = ext
                                )
                            )
                        }
                        Kind.SERIES -> {
                            val catId = "ser_cat_${lowerGroup.hashCode()}"
                            seriesCatMap.getOrPut(catId) { Category(catId, groupName) }

                            val seriesTitle: String
                            val seasonNum: String
                            val epNum: String
                            if (seMatch != null) {
                                seriesTitle = seMatch.groupValues[1].trim(' ', '-', '_', '.', ':').ifBlank { rawTitle }
                                seasonNum = seMatch.groupValues[2].trimStart('0').ifBlank { "1" }
                                epNum = seMatch.groupValues[3].trimStart('0').ifBlank { "1" }
                            } else {
                                seriesTitle = rawTitle
                                seasonNum = "1"
                                epNum = "1"
                            }

                            val seriesKey = seriesTitle.lowercase()
                            val acc = seriesAccMap.getOrPut(seriesKey) {
                                SeriesAcc(
                                    seriesId = "m3u_ser_${seriesAccMap.size + 1}",
                                    name = seriesTitle,
                                    cover = logo,
                                    categoryId = catId,
                                    categoryName = groupName
                                )
                            }
                            if (acc.cover == null && logo != null) acc.cover = logo

                            val epId = "m3u_ep_$itemIndex"
                            val ext = extLower.ifBlank { "mp4" }
                            directUrls[epId] = streamUrl
                            val seasonList = acc.episodesBySeason.getOrPut(seasonNum) { ArrayList() }
                            val resolvedEpNum = if (seMatch != null) epNum else (seasonList.size + 1).toString()
                            seasonList.add(
                                Episode(
                                    id = epId,
                                    episodeNum = resolvedEpNum,
                                    title = rawTitle,
                                    extension = ext,
                                    season = seasonNum,
                                    info = EpisodeInfo(
                                        plot = groupName,
                                        image = logo ?: acc.cover
                                    ),
                                    directUrl = streamUrl
                                )
                            )
                        }
                    }
                }
                extInf.reset()
            }
        }

        if (liveStreams.isEmpty() && vodStreams.isEmpty() && seriesAccMap.isEmpty()) {
            throw IllegalStateException("No se encontraron canales ni streams válidos en la URL M3U proporcionada")
        }

        val seriesList = ArrayList<Series>(seriesAccMap.size)
        val seriesDetails = HashMap<String, Pair<SeriesDetails, Map<String, List<Episode>>>>(seriesAccMap.size)
        for (acc in seriesAccMap.values) {
            seriesList.add(
                Series(
                    seriesId = acc.seriesId,
                    name = acc.name,
                    cover = acc.cover,
                    plot = "Categoría: ${acc.categoryName}",
                    genre = acc.categoryName,
                    categoryId = acc.categoryId
                )
            )
            seriesDetails[acc.seriesId] = SeriesDetails(
                name = acc.name,
                cover = acc.cover,
                plot = "Serie de la lista M3U (${acc.categoryName})",
                genre = acc.categoryName
            ) to acc.episodesBySeason
        }

        return M3uCatalog(
            liveCategories = liveCatMap.values.toList(),
            liveStreams = liveStreams,
            vodCategories = vodCatMap.values.toList(),
            vodStreams = vodStreams,
            vodDetails = vodDetails,
            seriesCategories = seriesCatMap.values.toList(),
            seriesList = seriesList,
            seriesDetails = seriesDetails,
            directUrls = directUrls,
            contentSignature = "${sigHash.toULong().toString(16)}_${nonEmptyLines}",
            isFromLocalCache = isFromLocalCache
        )
    }

    private fun isStreamUrl(line: String): Boolean {
        return line.startsWith("http://", ignoreCase = true) ||
            line.startsWith("https://", ignoreCase = true) ||
            line.startsWith("rtmp://", ignoreCase = true) ||
            line.startsWith("rtsp://", ignoreCase = true) ||
            line.startsWith("mms://", ignoreCase = true)
    }

    private fun classifyStream(
        lowerUrl: String,
        lowerGroup: String,
        extLower: String,
        hasSeasonEpisodePattern: Boolean
    ): Kind {
        if (hasSeasonEpisodePattern || lowerUrl.contains("/series/")) return Kind.SERIES
        if (lowerUrl.contains("/movie/") || lowerUrl.contains("/movies/") || lowerUrl.contains("/vod/")) return Kind.MOVIE
        if (extLower.isNotEmpty() && extLower in vodExtensions) {
            return if (seriesGroupKeywords.any { lowerGroup.contains(it) }) Kind.SERIES else Kind.MOVIE
        }
        if (extLower.isNotEmpty() && extLower in liveExtensions) return Kind.LIVE
        if (seriesGroupKeywords.any { lowerGroup.contains(it) }) return Kind.SERIES
        if (movieGroupKeywords.any { lowerGroup.contains(it) }) return Kind.MOVIE
        return Kind.LIVE
    }
}
