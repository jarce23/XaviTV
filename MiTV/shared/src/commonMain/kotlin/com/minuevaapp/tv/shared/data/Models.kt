package com.minuevaapp.tv.shared.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class Playlist(
    val name: String,
    val serverUrl: String,
    val username: String = "",
    val password: String = "",
    val type: String? = TYPE_XTREAM,
    val m3uUrl: String? = ""
) {
    val playlistType: String
        get() = if (type.equals(TYPE_M3U, ignoreCase = true)) TYPE_M3U else TYPE_XTREAM

    val isM3u: Boolean
        get() = playlistType == TYPE_M3U

    val effectiveM3uUrl: String
        get() = m3uUrl?.takeIf { it.isNotBlank() } ?: serverUrl

    companion object {
        const val TYPE_XTREAM = "XTREAM"
        const val TYPE_M3U = "M3U"
    }
}

@Serializable
data class StoredAppState(
    var activeName: String? = null,
    var defaultTdtSeeded: Boolean = false,
    var playlists: MutableList<Playlist> = mutableListOf(),
    var favorites: MutableMap<String, MutableSet<String>> = mutableMapOf(),
    var resumePositions: MutableMap<String, Long> = mutableMapOf()
)

@Serializable
data class LoginResponse(
    @SerialName("user_info") val userInfo: UserInfo? = null,
    @SerialName("server_info") val serverInfo: ServerInfo? = null
)

@Serializable
data class UserInfo(
    val username: String? = null,
    val status: String? = null,
    val auth: JsonElement? = null,
    @SerialName("exp_date") val expDate: String? = null,
    @SerialName("max_connections") val maxConnections: String? = null,
    @SerialName("active_cons") val activeConnections: String? = null
)

@Serializable
data class ServerInfo(
    val url: String? = null,
    val port: String? = null,
    @SerialName("server_protocol") val protocol: String? = null,
    val timezone: String? = null
)

@Serializable
data class Category(
    @SerialName("category_id") val id: String,
    @SerialName("category_name") val name: String? = null
)

@Serializable
data class LiveStream(
    val num: JsonElement? = null,
    val name: String? = null,
    @SerialName("stream_id") val streamId: String,
    @SerialName("stream_icon") val icon: String? = null,
    @SerialName("epg_channel_id") val epgChannelId: String? = null,
    @SerialName("category_id") val categoryId: String? = null,
    val directUrl: String? = null
)

@Serializable
data class VodStream(
    val name: String? = null,
    @SerialName("stream_id") val streamId: String,
    @SerialName("stream_icon") val icon: String? = null,
    val rating: String? = null,
    @SerialName("category_id") val categoryId: String? = null,
    @SerialName("container_extension") val extension: String? = null,
    val added: String? = null,
    val directUrl: String? = null
)

@Serializable
data class Series(
    @SerialName("series_id") val seriesId: String,
    val name: String? = null,
    val cover: String? = null,
    val plot: String? = null,
    val rating: String? = null,
    val genre: String? = null,
    @SerialName("category_id") val categoryId: String? = null,
    @SerialName("releaseDate") val releaseDate: String? = null
)

@Serializable
data class VodInfoResponse(
    val info: VodInfo? = null,
    @SerialName("movie_data") val movieData: VodData? = null
)

@Serializable
data class VodInfo(
    val name: String? = null,
    val plot: String? = null,
    val cast: String? = null,
    val director: String? = null,
    val genre: String? = null,
    @SerialName("releasedate") val releaseDate: String? = null,
    val rating: String? = null,
    val duration: String? = null,
    @SerialName("movie_image") val image: String? = null
)

@Serializable
data class VodData(
    @SerialName("stream_id") val streamId: String? = null,
    val name: String? = null,
    @SerialName("container_extension") val extension: String? = null
)

@Serializable
data class SeriesInfoResponse(
    val info: SeriesDetails? = null,
    val episodes: JsonElement? = null
)

@Serializable
data class SeriesDetails(
    val name: String? = null,
    val cover: String? = null,
    val plot: String? = null,
    val cast: String? = null,
    val genre: String? = null,
    val rating: String? = null,
    @SerialName("releaseDate") val releaseDate: String? = null
)

@Serializable
data class Episode(
    val id: String,
    @SerialName("episode_num") val episodeNum: String? = null,
    val title: String? = null,
    @SerialName("container_extension") val extension: String? = null,
    val season: String? = null,
    val info: EpisodeInfo? = null,
    val directUrl: String? = null
)

@Serializable
data class EpisodeInfo(
    val plot: String? = null,
    val duration: String? = null,
    @SerialName("movie_image") val image: String? = null
)

@Serializable
data class EpgResponse(
    @SerialName("epg_listings") val listings: List<EpgListing>? = null
)

@Serializable
data class EpgListing(
    val title: String? = null,
    val description: String? = null,
    val start: String? = null,
    val end: String? = null,
    @SerialName("start_timestamp") val startTs: String? = null,
    @SerialName("stop_timestamp") val stopTs: String? = null
)
