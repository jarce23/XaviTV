package com.minuevaapp.tv.shared.data

import com.minuevaapp.tv.shared.platform.PlatformStorage
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

enum class SyncStatus {
    IDLE,
    SYNCING,
    UP_TO_DATE,
    UPDATED,
    OFFLINE_FALLBACK
}

data class M3uSyncState(
    val status: SyncStatus = SyncStatus.IDLE,
    val playlistName: String = "",
    val playlistUrl: String = "",
    val channelCount: Int = 0,
    val versionToken: Long = 0L,
    val contentSignature: String = "",
    val isFromLocalCache: Boolean = false,
    val message: String? = null
)

data class M3uSyncOutcome(
    val catalog: M3uCatalog,
    val changed: Boolean,
    val usedLocalFallback: Boolean
)

data class RefreshResult(
    val success: Boolean,
    val liveCount: Int = 0,
    val vodCount: Int = 0,
    val seriesCount: Int = 0,
    val error: String? = null
)

class PlaylistStore {
    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
        encodeDefaults = true
    }

    private var data: StoredAppState = loadState()

    init {
        ensureDefaultPlaylistInjected()
    }

    private fun loadState(): StoredAppState {
        val raw = PlatformStorage.loadStateJson()
        if (raw.isNullOrBlank()) return StoredAppState()
        return runCatching {
            json.decodeFromString<StoredAppState>(raw)
        }.getOrDefault(StoredAppState())
    }

    private fun persist() {
        runCatching {
            PlatformStorage.saveStateJson(json.encodeToString(data))
        }
    }

    fun ensureDefaultPlaylistInjected(): List<Playlist> {
        if (data.playlists.isEmpty() || !data.defaultTdtSeeded) {
            val hasTdt = data.playlists.any {
                it.effectiveM3uUrl.equals(DEFAULT_TDT_URL, ignoreCase = true) ||
                    it.name.equals(defaultTdtPlaylist.name, ignoreCase = true)
            }
            if (!hasTdt) {
                data.playlists.add(0, defaultTdtPlaylist)
            }
            data.defaultTdtSeeded = true
            persist()
        }
        if (data.activeName.isNullOrBlank() || data.playlists.none { it.name == data.activeName }) {
            data.activeName = data.playlists.first().name
            persist()
        }
        return data.playlists.toList()
    }

    fun all(): List<Playlist> = ensureDefaultPlaylistInjected()

    fun add(p: Playlist) {
        data.playlists.removeAll { it.name.equals(p.name, ignoreCase = true) }
        data.playlists.add(p)
        data.activeName = p.name
        persist()
    }

    fun update(original: Playlist, updated: Playlist) {
        val idx = data.playlists.indexOfFirst {
            it.name.equals(original.name, ignoreCase = true) && it.playlistType == original.playlistType
        }
        if (idx >= 0) {
            data.playlists[idx] = updated
            data.playlists = data.playlists.filterIndexed { index, item ->
                index == idx || !item.name.equals(updated.name, ignoreCase = true)
            }.toMutableList()
        } else {
            data.playlists.add(updated)
        }
        if (data.activeName == original.name) {
            data.activeName = updated.name
        }
        persist()
    }

    fun remove(p: Playlist) {
        data.playlists.removeAll { it.name == p.name && it.playlistType == p.playlistType }
        if (data.playlists.isEmpty()) {
            ensureDefaultPlaylistInjected()
        } else if (data.activeName == p.name) {
            data.activeName = data.playlists.first().name
        }
        persist()
    }

    var activeName: String?
        get() = data.activeName
        set(v) {
            data.activeName = v
            persist()
        }

    fun active(): Playlist {
        val list = ensureDefaultPlaylistInjected()
        return list.firstOrNull { it.name == data.activeName } ?: list.first().also {
            data.activeName = it.name
            persist()
        }
    }

    fun favorites(type: String): Set<String> =
        data.favorites[type]?.toSet().orEmpty()

    fun toggleFavorite(type: String, id: String) {
        val set = data.favorites.getOrPut(type) { mutableSetOf() }
        if (!set.add(id)) set.remove(id)
        persist()
    }

    fun getResumePosition(key: String): Long = data.resumePositions[key] ?: 0L

    fun saveResumePosition(key: String, posMs: Long) {
        data.resumePositions[key] = posMs
        persist()
    }

    fun getRecentlyViewed(type: String): List<String> =
        data.recentlyViewed[type]?.toList().orEmpty()

    fun addRecentlyViewed(type: String, id: String, maxItems: Int = 40) {
        if (id.isBlank()) return
        val list = data.recentlyViewed.getOrPut(type) { mutableListOf() }
        list.remove(id)
        list.add(0, id)
        while (list.size > maxItems) {
            list.removeAt(list.lastIndex)
        }
        persist()
    }

    fun clearRecentlyViewed(type: String) {
        data.recentlyViewed.remove(type)
        persist()
    }

    companion object {
        const val DEFAULT_TDT_URL = "https://www.tdtchannels.com/lists/tvradio.m3u"

        val defaultTdtPlaylist = Playlist(
            name = "TDT España (TDTChannels)",
            serverUrl = DEFAULT_TDT_URL,
            type = Playlist.TYPE_M3U,
            m3uUrl = DEFAULT_TDT_URL
        )
    }
}

class XtreamRepository(
    val playlist: Playlist,
    private val httpClient: HttpClient
) {
    private val base = playlist.serverUrl.trim().trimEnd('/')
    private val u = playlist.username.trim()
    private val p = playlist.password

    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
        coerceInputValues = true
    }

    private val liveMutex = Mutex()
    private val vodMutex = Mutex()
    private val seriesMutex = Mutex()
    private val m3uMutex = Mutex()

    private var liveCache: Pair<List<Category>, List<LiveStream>>? = null
    private var vodCache: Pair<List<Category>, List<VodStream>>? = null
    private var seriesCache: Pair<List<Category>, List<Series>>? = null
    private var m3uCatalog: M3uCatalog? = null

    private val _m3uCatalogFlow = MutableStateFlow<M3uCatalog?>(null)
    val m3uCatalogFlow: StateFlow<M3uCatalog?> = _m3uCatalogFlow.asStateFlow()

    private val _catalogVersion = MutableStateFlow(0L)
    val catalogVersion: StateFlow<Long> = _catalogVersion.asStateFlow()

    private fun publishM3uCatalog(catalog: M3uCatalog) {
        m3uCatalog = catalog
        _m3uCatalogFlow.value = catalog
        _catalogVersion.value += 1L
    }

    /**
     * Carga inmediatamente la última lista M3U guardada en el almacenamiento local (Dispatchers.IO)
     * para garantizar el acceso instantáneo a los canales incluso sin conexión a internet.
     */
    suspend fun preloadM3uFromCache(): M3uCatalog? {
        if (!playlist.isM3u) return null
        return m3uMutex.withLock {
            m3uCatalog?.let { return@withLock it }
            val cached = M3uParser.loadFromLocalCache(playlist.effectiveM3uUrl)
            if (cached != null) {
                publishM3uCatalog(cached)
            }
            cached
        }
    }

    /**
     * Sincroniza en segundo plano (Dispatchers.IO) la lista M3U consultando la URL oficial (ej. TDTChannels):
     * - Si la descarga tiene éxito y detecta cambios respecto a la versión en caché/memoria,
     *   actualiza el almacenamiento local y emite el nuevo catálogo por StateFlow.
     * - Si el dispositivo no tiene internet o el servidor falla, activa el fallback local inmediatamente.
     */
    suspend fun syncM3uWithRemote(): M3uSyncOutcome = withContext(Dispatchers.IO) {
        val url = playlist.effectiveM3uUrl
        val cacheKey = M3uParser.cacheKeyForUrl(url)

        // Obtenemos la firma previa (de memoria o del respaldo local en disco)
        val previousCatalog = m3uMutex.withLock { m3uCatalog }
        val previousCachedText = PlatformStorage.loadCachedM3u(cacheKey)?.takeIf { it.isNotBlank() }
        val previousSignature = previousCatalog?.contentSignature?.takeIf { it.isNotBlank() }
            ?: previousCachedText?.let { M3uParser.computeContentSignature(it) }.orEmpty()

        try {
            val remoteRawText = M3uParser.fetchRawText(url, httpClient)
            val newSignature = M3uParser.computeContentSignature(remoteRawText)
            val hasChanged = previousSignature.isEmpty() || newSignature != previousSignature

            if (!hasChanged && previousCatalog != null) {
                return@withContext M3uSyncOutcome(
                    catalog = previousCatalog,
                    changed = false,
                    usedLocalFallback = false
                )
            }

            val parsedRemote = M3uParser.parseText(remoteRawText, isFromLocalCache = false)
            PlatformStorage.saveCachedM3u(cacheKey, remoteRawText)

            m3uMutex.withLock {
                publishM3uCatalog(parsedRemote)
            }

            M3uSyncOutcome(
                catalog = parsedRemote,
                changed = hasChanged,
                usedLocalFallback = false
            )
        } catch (networkError: Throwable) {
            // Fallback local inmediato si no hay internet o el servidor de origen falla
            val fallbackCatalog = m3uMutex.withLock {
                m3uCatalog ?: previousCachedText?.let {
                    runCatching { M3uParser.parseText(it, isFromLocalCache = true) }.getOrNull()
                }?.also { publishM3uCatalog(it) }
            }
            if (fallbackCatalog != null) {
                M3uSyncOutcome(
                    catalog = fallbackCatalog,
                    changed = previousCatalog == null,
                    usedLocalFallback = true
                )
            } else {
                throw networkError
            }
        }
    }

    private suspend fun ensureM3uLoaded(forceRefresh: Boolean = false): M3uCatalog =
        m3uMutex.withLock {
            if (!forceRefresh) {
                m3uCatalog?.let { return@withLock it }
                // Si existe respaldo local en almacenamiento, lo cargamos primero sin esperar a la red
                val localCached = M3uParser.loadFromLocalCache(playlist.effectiveM3uUrl)
                if (localCached != null) {
                    publishM3uCatalog(localCached)
                    return@withLock localCached
                }
            }
            withContext(Dispatchers.IO) {
                M3uParser.fetchAndParse(playlist.effectiveM3uUrl, httpClient).also {
                    publishM3uCatalog(it)
                }
            }
        }

    private suspend inline fun <reified T> callPlayerApi(
        action: String? = null,
        extraParams: Map<String, String> = emptyMap()
    ): T {
        val respText = httpClient.get("$base/player_api.php") {
            parameter("username", u)
            parameter("password", p)
            if (action != null) {
                parameter("action", action)
            }
            extraParams.forEach { (k, v) -> parameter(k, v) }
        }.bodyAsText()
        return json.decodeFromString(respText)
    }

    suspend fun login(): LoginResponse {
        if (playlist.isM3u) {
            val catalog = ensureM3uLoaded()
            val totalItems = catalog.liveStreams.size + catalog.vodStreams.size + catalog.seriesList.size
            return LoginResponse(
                userInfo = UserInfo(
                    username = playlist.name,
                    status = "Active",
                    maxConnections = totalItems.toString(),
                    activeConnections = "1"
                ),
                serverInfo = ServerInfo(
                    url = playlist.effectiveM3uUrl,
                    protocol = "M3U"
                )
            )
        }
        return callPlayerApi()
    }

    suspend fun live(forceRefresh: Boolean = false): Pair<List<Category>, List<LiveStream>> {
        if (playlist.isM3u) {
            val catalog = ensureM3uLoaded(forceRefresh)
            return catalog.liveCategories to catalog.liveStreams
        }
        return liveMutex.withLock {
            if (!forceRefresh) liveCache?.let { return@withLock it }
            val cats = callPlayerApi<List<Category>>("get_live_categories")
            val streams = callPlayerApi<List<LiveStream>>("get_live_streams")
            (cats to streams).also { liveCache = it }
        }
    }

    suspend fun vod(forceRefresh: Boolean = false): Pair<List<Category>, List<VodStream>> {
        if (playlist.isM3u) {
            val catalog = ensureM3uLoaded(forceRefresh)
            return catalog.vodCategories to catalog.vodStreams
        }
        return vodMutex.withLock {
            if (!forceRefresh) vodCache?.let { return@withLock it }
            val cats = callPlayerApi<List<Category>>("get_vod_categories")
            val streams = callPlayerApi<List<VodStream>>("get_vod_streams")
            (cats to streams).also { vodCache = it }
        }
    }

    suspend fun series(forceRefresh: Boolean = false): Pair<List<Category>, List<Series>> {
        if (playlist.isM3u) {
            val catalog = ensureM3uLoaded(forceRefresh)
            return catalog.seriesCategories to catalog.seriesList
        }
        return seriesMutex.withLock {
            if (!forceRefresh) seriesCache?.let { return@withLock it }
            val cats = callPlayerApi<List<Category>>("get_series_categories")
            val items = callPlayerApi<List<Series>>("get_series")
            (cats to items).also { seriesCache = it }
        }
    }

    suspend fun refreshAllXtream(): RefreshResult = withContext(Dispatchers.IO) {
        liveMutex.withLock { liveCache = null }
        vodMutex.withLock { vodCache = null }
        seriesMutex.withLock { seriesCache = null }

        if (playlist.isM3u) {
            return@withContext runCatching {
                val outcome = syncM3uWithRemote()
                RefreshResult(
                    success = true,
                    liveCount = outcome.catalog.liveStreams.size,
                    vodCount = outcome.catalog.vodStreams.size,
                    seriesCount = outcome.catalog.seriesList.size
                )
            }.getOrElse {
                RefreshResult(success = false, error = sanitizeError(it, playlist))
            }
        }

        try {
            login()
            val (_, liveItems) = live(forceRefresh = true)
            val (_, vodItems) = vod(forceRefresh = true)
            val (_, seriesItems) = series(forceRefresh = true)
            RefreshResult(
                success = true,
                liveCount = liveItems.size,
                vodCount = vodItems.size,
                seriesCount = seriesItems.size
            )
        } catch (e: Throwable) {
            RefreshResult(
                success = false,
                error = sanitizeError(e, playlist)
            )
        }
    }

    suspend fun vodInfo(id: String): VodInfoResponse {
        if (playlist.isM3u) {
            val catalog = ensureM3uLoaded()
            return catalog.vodDetails[id] ?: VodInfoResponse(
                info = VodInfo(name = "Película"),
                movieData = VodData(streamId = id, name = "Película", extension = "mp4")
            )
        }
        return callPlayerApi("get_vod_info", mapOf("vod_id" to id))
    }

    suspend fun seriesInfo(id: String): Pair<SeriesDetails?, Map<String, List<Episode>>> {
        if (playlist.isM3u) {
            val catalog = ensureM3uLoaded()
            return catalog.seriesDetails[id] ?: (null to emptyMap())
        }
        val r = callPlayerApi<SeriesInfoResponse>("get_series_info", mapOf("series_id" to id))
        val map = linkedMapOf<String, List<Episode>>()
        val el: JsonElement? = r.episodes
        if (el is JsonObject) {
            el.entries
                .sortedBy { it.key.toIntOrNull() ?: 0 }
                .forEach { (season, arr) ->
                    map[season] = runCatching {
                        json.decodeFromJsonElement<List<Episode>>(arr)
                    }.getOrDefault(emptyList())
                }
        } else if (el is JsonArray) {
            el.forEach { seasonArr ->
                val eps = runCatching {
                    json.decodeFromJsonElement<List<Episode>>(seasonArr)
                }.getOrDefault(emptyList())
                eps.firstOrNull()?.let { map[it.season ?: "${map.size + 1}"] = eps }
            }
        }
        return r.info to map
    }

    suspend fun shortEpg(streamId: String): List<EpgListing> {
        if (playlist.isM3u) return emptyList()
        return runCatching {
            callPlayerApi<EpgResponse>("get_short_epg", mapOf("stream_id" to streamId, "limit" to "10"))
                .listings.orEmpty()
        }.getOrDefault(emptyList())
    }

    private fun resolveDirectUrl(id: String): String? {
        if (id.startsWith("http://", ignoreCase = true) ||
            id.startsWith("https://", ignoreCase = true) ||
            id.startsWith("rtmp://", ignoreCase = true) ||
            id.startsWith("rtsp://", ignoreCase = true)
        ) {
            return id
        }
        return m3uCatalog?.directUrls?.get(id)
    }

    /**
     * En iOS (AVPlayer), los flujos en directo de Xtream Codes se sirven preferiblemente en formato .m3u8
     * con fallback automático a .ts en el reproductor nativo.
     */
    fun liveUrl(streamId: String, ext: String = "m3u8"): String =
        resolveDirectUrl(streamId) ?: "$base/live/$u/$p/$streamId.$ext"

    fun movieUrl(streamId: String, ext: String?): String =
        resolveDirectUrl(streamId) ?: "$base/movie/$u/$p/$streamId.${ext?.ifBlank { "mp4" } ?: "mp4"}"

    fun episodeUrl(episodeId: String, ext: String?): String =
        resolveDirectUrl(episodeId) ?: "$base/series/$u/$p/$episodeId.${ext?.ifBlank { "mp4" } ?: "mp4"}"

    companion object {
        @OptIn(ExperimentalEncodingApi::class)
        fun decodeB64(s: String?): String =
            if (s.isNullOrEmpty()) "" else runCatching {
                Base64.decode(s.trim()).decodeToString().trim()
            }.getOrDefault(s)

        fun sanitizeError(t: Throwable, playlist: Playlist? = null): String {
            var msg = t.message ?: "Error de conexión con el servidor"
            playlist?.let {
                if (it.password.isNotEmpty()) msg = msg.replace(it.password, "***")
                if (it.username.isNotEmpty()) msg = msg.replace(it.username, "***")
            }
            return msg
        }
    }
}
