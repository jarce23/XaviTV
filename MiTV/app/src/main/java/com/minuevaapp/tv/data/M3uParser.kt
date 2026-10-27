package com.minuevaapp.tv.data

import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.BufferedReader
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets

/** Resultado estructurado tras analizar una lista M3U / M3U8 completa. */
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

/**
 * Descarga y analiza listas M3U / M3U8 (#EXTM3U / #EXTINF), incluyendo listas públicas como TDTChannels,
 * clasificando los streams en TV en directo, Películas y Series y conservando el orden de categorías.
 */
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
        val episodesBySeason: MutableMap<String, MutableList<Episode>> = linkedMapOf(),
    )

    fun fetchAndParse(url: String, client: OkHttpClient): M3uCatalog {
        val request = Request.Builder()
            .url(url.trim())
            .header("User-Agent", "Mozilla/5.0 (Android; XaviTV/1.0)")
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) {
                throw IllegalStateException("No se pudo descargar la lista M3U (HTTP ${response.code})")
            }
            val body = response.body ?: throw IllegalStateException("La lista M3U está vacía")
            BufferedReader(InputStreamReader(body.byteStream(), StandardCharsets.UTF_8)).use { reader ->
                return parseReader(reader)
            }
        }
    }

    fun parseReader(reader: BufferedReader): M3uCatalog {
        val liveCatMap = linkedMapOf<String, Category>()
        val vodCatMap = linkedMapOf<String, Category>()
        val seriesCatMap = linkedMapOf<String, Category>()

        val liveStreams = ArrayList<LiveStream>()
        val vodStreams = ArrayList<VodStream>()
        val vodDetails = HashMap<String, VodInfoResponse>()
        val seriesAccMap = linkedMapOf<String, SeriesAcc>()
        val directUrls = HashMap<String, String>()

        var currentTitle: String? = null
        var currentLogo: String? = null
        var currentGroup: String? = null
        var currentTvgId: String? = null
        var itemIndex = 0

        var line: String? = reader.readLine()
        while (line != null) {
            val trimmed = line.trim().removePrefix("\uFEFF")
            if (trimmed.startsWith("#EXTINF:", ignoreCase = true)) {
                val attrs = HashMap<String, String>()
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

        // 1. Rutas explícitas de Series o patrones S01E02
        if (hasSeasonEpisodePattern || lowerUrl.contains("/series/")) {
            return Kind.SERIES
        }
        // 2. Rutas explícitas de Películas o archivos de vídeo VOD (.mp4, .mkv, .avi...)
        if (lowerUrl.contains("/movie/") || lowerUrl.contains("/movies/") || lowerUrl.contains("/vod/")) {
            return Kind.MOVIE
        }
        if (isVodFile) {
            return if (seriesGroupKeywords.any { lowerGroup.contains(it) }) Kind.SERIES else Kind.MOVIE
        }
        // 3. Si es un manifiesto o stream en vivo (.m3u8, .ts, .mp3, .aac como TDTChannels), es TV/Radio en directo
        if (isLiveStreamFormat) {
            return Kind.LIVE
        }
        // 4. Por nombre de grupo si la URL no tiene extensión conocida
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
