package com.minuevaapp.tv.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.io.StringReader
import java.nio.charset.StandardCharsets

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
)

object M3uParser {
    private const val READ_BUFFER_SIZE = 64 * 1024
    private const val DISK_CACHE_TTL_MS = 6 * 60 * 60 * 1000L // 6 horas de validez de caché rápida

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
        val episodesBySeason: MutableMap<String, MutableList<Episode>> = linkedMapOf(),
    )

    private fun cacheFileForUrl(url: String): File {
        val cacheDir = File(System.getProperty("user.home"), ".xavitv/cache").apply { mkdirs() }
        val hash = url.trim().lowercase().hashCode().toUInt().toString(16)
        return File(cacheDir, "playlist_$hash.m3u")
    }

    /**
     * Descarga y analiza la lista M3U en segundo plano (Dispatchers.IO).
     * Utiliza caché en disco local para acelerar drásticamente las lecturas repetidas al arrancar.
     */
    suspend fun fetchAndParse(
        url: String,
        client: OkHttpClient,
        forceRefresh: Boolean = false
    ): M3uCatalog = withContext(Dispatchers.IO) {
        val cleanUrl = url.trim()
        val cacheFile = runCatching { cacheFileForUrl(cleanUrl) }.getOrNull()

        // 1. Si existe caché en disco reciente y no se fuerza recarga, leer directamente desde disco en milisegundos
        if (!forceRefresh && cacheFile != null && cacheFile.exists() && cacheFile.length() > 64L) {
            val ageMs = System.currentTimeMillis() - cacheFile.lastModified()
            if (ageMs in 0..DISK_CACHE_TTL_MS) {
                runCatching {
                    BufferedReader(
                        InputStreamReader(cacheFile.inputStream(), StandardCharsets.UTF_8),
                        READ_BUFFER_SIZE
                    ).use { reader ->
                        return@withContext parseReader(reader)
                    }
                }
            }
        }

        // 2. Descargar desde red en Dispatchers.IO y actualizar caché en disco
        val request = Request.Builder()
            .url(cleanUrl)
            .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; XaviTV/1.0)")
            .build()

        try {
            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful) {
                    throw IllegalStateException("No se pudo descargar la lista M3U (HTTP ${response.code})")
                }
                val body = response.body ?: throw IllegalStateException("La lista M3U está vacía")
                val rawText = body.string()
                if (cacheFile != null && rawText.isNotBlank()) {
                    runCatching { cacheFile.writeText(rawText, StandardCharsets.UTF_8) }
                }
                BufferedReader(StringReader(rawText), READ_BUFFER_SIZE).use { reader ->
                    parseReader(reader)
                }
            }
        } catch (netEx: Exception) {
            // Fallback a caché en disco aunque haya expirado si hay fallo temporal de red
            if (cacheFile != null && cacheFile.exists() && cacheFile.length() > 64L) {
                BufferedReader(
                    InputStreamReader(cacheFile.inputStream(), StandardCharsets.UTF_8),
                    READ_BUFFER_SIZE
                ).use { reader ->
                    parseReader(reader)
                }
            } else {
                throw netEx
            }
        }
    }

    fun parseReader(reader: BufferedReader): M3uCatalog {
        val liveCatMap = linkedMapOf<String, Category>()
        val vodCatMap = linkedMapOf<String, Category>()
        val seriesCatMap = linkedMapOf<String, Category>()

        val liveStreams = ArrayList<LiveStream>(512)
        val vodStreams = ArrayList<VodStream>(128)
        val vodDetails = HashMap<String, VodInfoResponse>(128)
        val seriesAccMap = linkedMapOf<String, SeriesAcc>()
        val directUrls = HashMap<String, String>(640)

        var currentTitle: String? = null
        var currentLogo: String? = null
        var currentGroup: String? = null
        var currentTvgId: String? = null
        var itemIndex = 0

        var line: String? = reader.readLine()
        while (line != null) {
            val trimmed = line.trim().removePrefix("\uFEFF")
            if (trimmed.startsWith("#EXTINF:", ignoreCase = true)) {
                val attrs = HashMap<String, String>(6)
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
                                    num = liveStreams.size.plus(1).toString(),
                                    name = rawTitle,
                                    streamId = id,
                                    icon = logo,
                                    epgChannelId = currentTvgId,
                                    categoryId = catId,
                                    directUrl = streamUrl,
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
                                    directUrl = streamUrl,
                                )
                            )
                            vodDetails[id] = VodInfoResponse(
                                info = VodInfo(
                                    name = rawTitle,
                                    plot = "Categoría: $groupName",
                                    genre = groupName,
                                    image = logo,
                                ),
                                movieData = VodData(
                                    streamId = id,
                                    name = rawTitle,
                                    extension = ext,
                                ),
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
                                    categoryName = groupName,
                                )
                            }
                            if (acc.cover == null && logo != null) acc.cover = logo

                            val epId = "m3u_ep_$itemIndex"
                            val ext = extractExtension(streamUrl)
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
                                        image = logo ?: acc.cover,
                                    ),
                                    directUrl = streamUrl,
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
            line = reader.readLine()
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
                    categoryId = acc.categoryId,
                )
            )
            seriesDetails[acc.seriesId] = SeriesDetails(
                name = acc.name,
                cover = acc.cover,
                plot = "Serie de la lista M3U (${acc.categoryName})",
                genre = acc.categoryName,
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
