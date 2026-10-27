package com.minuevaapp.tv.data

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName

// Modelos de la API Xtream Codes (player_api.php) y listas M3U.
// Se usan String en casi todo porque los servidores devuelven tipos inconsistentes.

data class Playlist(
    val name: String,
    val serverUrl: String,
    val username: String = "",
    val password: String = "",
    val type: String? = TYPE_XTREAM,
    val m3uUrl: String? = "",
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

data class LoginResponse(
    @SerializedName("user_info") val userInfo: UserInfo?,
    @SerializedName("server_info") val serverInfo: ServerInfo?,
)

data class UserInfo(
    val username: String?,
    val status: String?,
    val auth: String?,
    @SerializedName("exp_date") val expDate: String?,
    @SerializedName("max_connections") val maxConnections: String?,
    @SerializedName("active_cons") val activeConnections: String?,
)

data class ServerInfo(
    val url: String?,
    val port: String?,
    @SerializedName("server_protocol") val protocol: String?,
    val timezone: String?,
)

data class Category(
    @SerializedName("category_id") val id: String,
    @SerializedName("category_name") val name: String?,
)

data class LiveStream(
    val num: String? = null,
    val name: String?,
    @SerializedName("stream_id") val streamId: String,
    @SerializedName("stream_icon") val icon: String? = null,
    @SerializedName("epg_channel_id") val epgChannelId: String? = null,
    @SerializedName("category_id") val categoryId: String? = null,
    @SerializedName("tv_archive") val tvArchive: String? = null,
    @SerializedName("tv_archive_duration") val tvArchiveDuration: String? = null,
    val directUrl: String? = null,
)

data class VodStream(
    val name: String?,
    @SerializedName("stream_id") val streamId: String,
    @SerializedName("stream_icon") val icon: String? = null,
    val rating: String? = null,
    @SerializedName("category_id") val categoryId: String? = null,
    @SerializedName("container_extension") val extension: String? = null,
    val added: String? = null,
    val directUrl: String? = null,
)

data class Series(
    @SerializedName("series_id") val seriesId: String,
    val name: String?,
    val cover: String? = null,
    val plot: String? = null,
    val rating: String? = null,
    val genre: String? = null,
    @SerializedName("category_id") val categoryId: String? = null,
    @SerializedName("releaseDate") val releaseDate: String? = null,
)

data class VodInfoResponse(
    val info: VodInfo?,
    @SerializedName("movie_data") val movieData: VodData?,
)

data class VodInfo(
    val name: String?,
    val plot: String? = null,
    val cast: String? = null,
    val director: String? = null,
    val genre: String? = null,
    @SerializedName("releasedate") val releaseDate: String? = null,
    val rating: String? = null,
    val duration: String? = null,
    @SerializedName("movie_image") val image: String? = null,
    @SerializedName("backdrop_path") val backdrop: JsonElement? = null,
    @SerializedName("youtube_trailer") val trailer: String? = null,
    @SerializedName("tmdb_id") val tmdbId: String? = null,
)

data class VodData(
    @SerializedName("stream_id") val streamId: String?,
    val name: String?,
    @SerializedName("container_extension") val extension: String?,
)

data class SeriesInfoResponse(
    val info: SeriesDetails?,
    // Puede venir como objeto {"1":[...]} o como array vacío; se parsea a mano.
    val episodes: JsonElement?,
)

data class SeriesDetails(
    val name: String?,
    val cover: String? = null,
    val plot: String? = null,
    val cast: String? = null,
    val genre: String? = null,
    val rating: String? = null,
    @SerializedName("releaseDate") val releaseDate: String? = null,
)

data class Episode(
    val id: String,
    @SerializedName("episode_num") val episodeNum: String?,
    val title: String?,
    @SerializedName("container_extension") val extension: String? = null,
    val season: String? = null,
    val info: EpisodeInfo? = null,
    val directUrl: String? = null,
)

data class EpisodeInfo(
    val plot: String? = null,
    val duration: String? = null,
    @SerializedName("movie_image") val image: String? = null,
)

data class EpgResponse(
    @SerializedName("epg_listings") val listings: List<EpgListing>?,
)

data class EpgListing(
    val title: String?,        // Base64
    val description: String?,  // Base64
    val start: String?,
    val end: String?,
    @SerializedName("start_timestamp") val startTs: String?,
    @SerializedName("stop_timestamp") val stopTs: String?,
)
