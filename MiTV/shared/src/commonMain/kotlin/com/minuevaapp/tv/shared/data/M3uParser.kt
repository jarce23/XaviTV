package com.minuevaapp.tv.shared.data

import com.minuevaapp.tv.shared.platform.PlatformStorage
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.statement.bodyAsText
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
    private val attrRegex = Regex("""([a-zA-Z0-9_-]+)\s*=\s*"([^"]*)"""")
    private val sePattern1 = Regex("""(?i)^(.*?)[\s._-]*S(\d{1,2})[\s._-]*E(\d{1,3})\b""")
    private val sePattern2 = Regex("""(?i)^(.*?)[\s._-]*(\d{1,2})x(\d{1,3})\b""")
    private val sePattern3 = Regex("""(?i)^(.*?)[\s._-]*(?:Temp(?:orada)?|T)\s*(\d{1,2})[\s._-]*(?:Cap(?:[íi]tulo)?|Ep(?:isodio)?|E)\s*(\d{1,3})\b""")
    private val vodExtRegex = Regex("""(?i)\.(mp4|mkv|avi|mov|wmv|flv|webm)(\?.*)?$""")
    private val liveManifestOrAudioExtRegex = Regex("""(?i)\.(m3u8|ts|mpd|aac|mp3|ogg|m4a)(\?.*)?$""")

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
     * Descarga el texto bruto de la lista M3U en segundo plano (Dispatchers.IO).
     */
    suspend fun fetchRawText(url: String, client: HttpClient): String = withContext(Dispatchers.IO) {
        val response = client.get(url.trim()) {
            header("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 17_5 like Mac OS X; XaviTV/1.1)")
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

    fun parseText(content: String, isFromLocalCache: Boolean = false): M3uCatalog {
        val liveCatMap = linkedMapOf<String, Category>()
        val vodCatMap = linkedMapOf<String, Category>()
        val seriesCatMap = linkedMapOf<String, Category>()

        val liveStreams = mutableListOf<LiveStream>()
        val vodStreams = mutableListOf<VodStream>()
        val vodDetails = mutableMapOf<String, VodInfoResponse>()
        val seriesAccMap = linkedMapOf<String, SeriesAcc>()
        val directUrls = mutableMapOf<String, String>()

        var currentTitle: String? = null
        var currentLogo: String? = null
        var currentGroup: String? = null
        var currentTvgId: String? = null
        var itemIndex = 0

        for (rawLine in content.lineSequence()) {
            val trimmed = rawLine.trim().removePrefix("\uFEFF")
            if (trimmed.startsWith("#EXTINF:", ignoreCase = true)) {
                val attrs = mutableMapOf<String, String>()
                attrRegex.findAll(trimmed).forEach { m ->
                    attrs[m.groupValues[1].lowercase()] = m.groupValues[2].trim()
                }
                val commaIdx = trimmed.lastIndexOf(',')
                val titleAfterComma = if (commaIdx >= 0 && commaIdx + 1 < trimmed.length) {
                    trimmed.substring(commaIdx + 1).trim()
                } else {
                    ""
                }
                currentTitle = titleAfterComma.ifBlank { attrs["tvg-name"].orEmpty() }
                currentLogo = attrs["tvg-logo"]?.takeIf { it.isNotBlank() }
                currentGroup = attrs["group-title"]?.takeIf { it.isNotBlank() }
                currentTvgId = attrs["tvg-id"]?.takeIf { it.isNotBlank() }
            } else if (trimmed.startsWith("#EXTGRP:", ignoreCase = true)) {
                val grp = trimmed.substringAfter(":").trim()
                if (grp.isNotEmpty() && currentGroup.isNullOrBlank()) {
                    currentGroup = grp
                }
            } else if (trimmed.isNotEmpty() && !trimmed.startsWith("#")) {
                if (isStreamUrl(trimmed)) {
                    itemIndex++
                    val streamUrl = trimmed
                    val rawTitle = currentTitle?.takeIf { it.isNotBlank() } ?: "Canal $itemIndex"
                    val groupName = currentGroup?.takeIf { it.isNotBlank() } ?: "General"
                    val logo = currentLogo

                    val seMatch = sePattern1.find(rawTitle)
                        ?: sePattern2.find(rawTitle)
                        ?: sePattern3.find(rawTitle)

                    val kind = classifyStream(streamUrl, groupName, seMatch != null)

                    when (kind) {
                        Kind.LIVE -> {
                            val catId = "live_cat_${groupName.lowercase().hashCode()}"
                            liveCatMap.getOrPut(catId) { Category(catId, groupName) }
                            val id = "m3u_live_$itemIndex"
                            directUrls[id] = streamUrl
                            liveStreams.add(
                                LiveStream(
                                    name = rawTitle,
                                    streamId = id,
                                    icon = logo,
                                    epgChannelId = currentTvgId,
                                    categoryId = catId,
                                    directUrl = streamUrl
                                )
                            )
                        }
                        Kind.MOVIE -> {
                            val catId = "vod_cat_${groupName.lowercase().hashCode()}"
                            vodCatMap.getOrPut(catId) { Category(catId, groupName) }
                            val id = "m3u_vod_$itemIndex"
                            val ext = extractExtension(streamUrl)
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
                            val catId = "ser_cat_${groupName.lowercase().hashCode()}"
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
                            val ext = extractExtension(streamUrl)
                            directUrls[epId] = streamUrl
                            val seasonList = acc.episodesBySeason.getOrPut(seasonNum) { mutableListOf() }
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
                currentTitle = null
                currentLogo = null
                currentGroup = null
                currentTvgId = null
            }
        }

        if (liveStreams.isEmpty() && vodStreams.isEmpty() && seriesAccMap.isEmpty()) {
            throw IllegalStateException("No se encontraron canales ni streams válidos en la URL M3U proporcionada")
        }

        val seriesList = mutableListOf<Series>()
        val seriesDetails = mutableMapOf<String, Pair<SeriesDetails, Map<String, List<Episode>>>>()
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
            contentSignature = computeContentSignature(content),
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

    private fun classifyStream(url: String, groupName: String, hasSeasonEpisodePattern: Boolean): Kind {
        val lowerUrl = url.lowercase()
        val lowerGroup = groupName.lowercase()
        val isVodFile = vodExtRegex.containsMatchIn(lowerUrl)
        val isLiveStreamFormat = liveManifestOrAudioExtRegex.containsMatchIn(lowerUrl)

        if (hasSeasonEpisodePattern || lowerUrl.contains("/series/")) return Kind.SERIES
        if (lowerUrl.contains("/movie/") || lowerUrl.contains("/movies/") || lowerUrl.contains("/vod/")) return Kind.MOVIE
        if (isVodFile) {
            return if (seriesGroupKeywords.any { lowerGroup.contains(it) }) Kind.SERIES else Kind.MOVIE
        }
        if (isLiveStreamFormat) return Kind.LIVE
        if (seriesGroupKeywords.any { lowerGroup.contains(it) }) return Kind.SERIES
        if (movieGroupKeywords.any { lowerGroup.contains(it) }) return Kind.MOVIE
        return Kind.LIVE
    }

    private fun extractExtension(url: String): String {
        val clean = url.substringBefore('?').substringAfterLast('/')
        val ext = clean.substringAfterLast('.', "")
        return ext.ifBlank { "mp4" }
    }
}
