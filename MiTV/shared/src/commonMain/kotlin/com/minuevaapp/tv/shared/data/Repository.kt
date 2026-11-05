package com.minuevaapp.tv.shared.data

import com.minuevaapp.tv.shared.platform.PlatformStorage
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.statement.bodyAsText
import io.ktor.util.date.getTimeMillis
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.contentOrNull
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

    private val ioScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private val diskWriteMutex = Mutex()
    private var writeBlocked: Boolean = false
    private var data: StoredAppState = loadState()

    private val _playbackProgressFlow = MutableStateFlow<Map<String, PlaybackProgress>>(data.playbackProgress.toMap())
    val playbackProgressFlow: StateFlow<Map<String, PlaybackProgress>> = _playbackProgressFlow.asStateFlow()

    init {
        ensureDefaultPlaylistInjected()
        _playbackProgressFlow.value = data.playbackProgress.toMap()
    }

    private fun loadState(): StoredAppState {
        val raw = PlatformStorage.loadStateJson()
        if (raw.isNullOrBlank()) return StoredAppState()
        val parsed = runCatching {
            json.decodeFromString<StoredAppState>(raw)
        }.getOrNull()
        if (parsed == null) {
            writeBlocked = true
            return StoredAppState()
        }
        return parsed
    }

    private fun snapshotState(): StoredAppState = StoredAppState(
        playlists = data.playlists.toMutableList(),
        activeName = data.activeName,
        defaultTdtSeeded = data.defaultTdtSeeded,
        favorites = data.favorites.mapValues { (_, v) -> v.toMutableSet() }.toMutableMap(),
        resumePositions = data.resumePositions.toMutableMap(),
        recentlyViewed = data.recentlyViewed.mapValues { (_, v) -> v.toMutableList() }.toMutableMap(),
        playbackProgress = data.playbackProgress.toMutableMap(),
    )

    private fun persist() {
        if (writeBlocked) return
        val snap = snapshotState()
        runCatching {
            PlatformStorage.saveStateJson(json.encodeToString(snap))
        }
    }

    private fun persistAsync() {
        if (writeBlocked) return
        val snap = snapshotState()
        ioScope.launch(Dispatchers.IO) {
            diskWriteMutex.withLock {
                runCatching {
                    PlatformStorage.saveStateJson(json.encodeToString(snap))
                }
            }
        }
    }

    fun ensureDefaultPlaylistInjected(): List<Playlist> {
        var changed = false
        if (data.playlists.isEmpty() || !data.defaultTdtSeeded) {
            val hasTdt = data.playlists.any {
                it.effectiveM3uUrl.equals(DEFAULT_TDT_URL, ignoreCase = true) ||
                    it.name.equals(defaultTdtPlaylist.name, ignoreCase = true)
            }
            if (!hasTdt) {
                data.playlists.add(0, defaultTdtPlaylist)
            }
            data.defaultTdtSeeded = true
            changed = true
        }
        if (data.activeName.isNullOrBlank() || data.playlists.none { it.name == data.activeName }) {
            val preferred = data.playlists.lastOrNull { !it.name.equals(defaultTdtPlaylist.name, ignoreCase = true) }
                ?: data.playlists.first()
            data.activeName = preferred.name
            changed = true
        }
        if (changed) {
            persist()
        }
        return data.playlists.toList()
    }

    fun all(): List<Playlist> = ensureDefaultPlaylistInjected()

    fun add(p: Playlist) {
        writeBlocked = false
        data.playlists.removeAll { it.name.equals(p.name, ignoreCase = true) }
        data.playlists.add(p)
        data.activeName = p.name
        persist()
    }

    fun update(original: Playlist, updated: Playlist) {
        writeBlocked = false
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
        writeBlocked = false
        data.playlists.removeAll { it.name == p.name && it.playlistType == p.playlistType }
        if (data.playlists.isEmpty()) {
            ensureDefaultPlaylistInjected()
        } else if (data.activeName == p.name) {
            val preferred = data.playlists.lastOrNull { !it.name.equals(defaultTdtPlaylist.name, ignoreCase = true) }
                ?: data.playlists.first()
            data.activeName = preferred.name
        }
        persist()
    }

    var activeName: String?
        get() = data.activeName
        set(v) {
            writeBlocked = false
            data.activeName = v
            persist()
        }

    fun active(): Playlist {
        val list = ensureDefaultPlaylistInjected()
        val preferred = list.firstOrNull { it.name == data.activeName }
            ?: list.lastOrNull { !it.name.equals(defaultTdtPlaylist.name, ignoreCase = true) }
            ?: list.first()
        if (data.activeName != preferred.name) {
            data.activeName = preferred.name
            persist()
        }
        return preferred
    }

    fun favorites(type: String): Set<String> =
        data.favorites[type]?.toSet().orEmpty()

    fun toggleFavorite(type: String, id: String) {
        val set = data.favorites.getOrPut(type) { mutableSetOf() }
        if (!set.add(id)) set.remove(id)
        persist()
    }

    fun getResumePosition(key: String): Long {
        getPlaybackProgress(key)?.let { return it.resumePositionMs }
        return data.resumePositions[key] ?: 0L
    }

    fun saveResumePosition(key: String, posMs: Long, asyncIo: Boolean = true, notifyUi: Boolean = false) {
        data.resumePositions[key] = posMs
        val existingDur = getPlaybackProgress(key)?.durationMs ?: 0L
        savePlaybackProgress(key, posMs, existingDur, asyncIo = asyncIo, notifyUi = notifyUi)
    }

    /**
     * Versión segura para invocarse desde `CoroutineScope(Dispatchers.IO).launch` en el guardado
     * periódico cada 5 segundos sin bloquear jamás el hilo principal de iOS ni recomponer la UI.
     */
    suspend fun savePlaybackProgressBg(
        id: String,
        positionMs: Long,
        durationMs: Long,
        notifyUi: Boolean = false,
    ) {
        val cleanId = id.trim()
        if (cleanId.isEmpty() || positionMs < 0L) return

        diskWriteMutex.withLock {
            val existing = getPlaybackProgress(cleanId)
            val effectiveDuration = when {
                durationMs > 0L -> durationMs
                existing != null && existing.durationMs > 0L -> existing.durationMs
                else -> 0L
            }
            if (effectiveDuration <= 0L && positionMs <= 0L) return@withLock

            val rawFraction = if (effectiveDuration > 0L) {
                (positionMs.toFloat() / effectiveDuration.toFloat()).coerceIn(0f, 1f)
            } else {
                0f
            }
            if (existing?.isCompleted == true && positionMs < 3_000L && rawFraction < 0.02f) {
                return@withLock
            }

            val finalPos = if (effectiveDuration > 0L && rawFraction >= 0.95f) effectiveDuration else positionMs
            val progress = PlaybackProgress(
                positionMs = finalPos,
                durationMs = effectiveDuration,
                updatedAt = getTimeMillis()
            )
            storeProgressUnderAliases(cleanId, progress)
            data.resumePositions[cleanId] = progress.resumePositionMs
            if (notifyUi) {
                _playbackProgressFlow.value = data.playbackProgress.toMap()
            }
            if (!writeBlocked) {
                val snap = snapshotState()
                runCatching {
                    PlatformStorage.saveStateJson(json.encodeToString(snap))
                }
            }
        }
    }

    fun savePlaybackProgress(
        id: String,
        positionMs: Long,
        durationMs: Long,
        asyncIo: Boolean = false,
        notifyUi: Boolean = true,
    ) {
        val cleanId = id.trim()
        if (cleanId.isEmpty() || positionMs < 0L) return

        if (positionMs == 0L && durationMs == 0L) {
            removeProgressKeys(cleanId)
            data.resumePositions.remove(cleanId)
            if (notifyUi) {
                _playbackProgressFlow.value = data.playbackProgress.toMap()
            }
            if (asyncIo) persistAsync() else persist()
            return
        }

        val existing = getPlaybackProgress(cleanId)
        val effectiveDuration = when {
            durationMs > 0L -> durationMs
            existing != null && existing.durationMs > 0L -> existing.durationMs
            else -> 0L
        }
        if (effectiveDuration <= 0L && positionMs <= 0L) return

        val rawFraction = if (effectiveDuration > 0L) {
            (positionMs.toFloat() / effectiveDuration.toFloat()).coerceIn(0f, 1f)
        } else {
            0f
        }

        if (existing?.isCompleted == true && positionMs < 3_000L && rawFraction < 0.02f) {
            return
        }

        val finalPos = if (effectiveDuration > 0L && rawFraction >= 0.95f) effectiveDuration else positionMs
        val progress = PlaybackProgress(
            positionMs = finalPos,
            durationMs = effectiveDuration,
            updatedAt = getTimeMillis()
        )
        storeProgressUnderAliases(cleanId, progress)
        data.resumePositions[cleanId] = progress.resumePositionMs
        if (notifyUi) {
            _playbackProgressFlow.value = data.playbackProgress.toMap()
        }
        if (asyncIo) persistAsync() else persist()
    }

    private fun removeProgressKeys(cleanId: String) {
        data.playbackProgress.remove(cleanId)
        if (cleanId.startsWith("series:") && cleanId.contains(":ep:")) {
            val epId = cleanId.substringAfter(":ep:")
            data.playbackProgress.remove("episode:$epId")
            data.playbackProgress.remove("series:$epId")
            data.playbackProgress.remove(epId)
        } else if (cleanId.contains(':')) {
            val raw = cleanId.substringAfterLast(':')
            data.playbackProgress.remove("movie:$raw")
            data.playbackProgress.remove("vod:$raw")
            data.playbackProgress.remove("episode:$raw")
            data.playbackProgress.remove("series:$raw")
            data.playbackProgress.remove(raw)
        } else {
            data.playbackProgress.remove("movie:$cleanId")
            data.playbackProgress.remove("vod:$cleanId")
            data.playbackProgress.remove("episode:$cleanId")
            data.playbackProgress.remove("series:$cleanId")
        }
    }

    private fun storeProgressUnderAliases(cleanId: String, progress: PlaybackProgress) {
        data.playbackProgress[cleanId] = progress
        if (cleanId.startsWith("series:") && cleanId.contains(":ep:")) {
            val seriesId = cleanId.substringAfter("series:").substringBefore(":ep:")
            val epId = cleanId.substringAfter(":ep:")
            if (epId.isNotBlank()) {
                data.playbackProgress["episode:$epId"] = progress
                data.playbackProgress["series:$epId"] = progress
                data.playbackProgress[epId] = progress
            }
            if (seriesId.isNotBlank()) {
                data.playbackProgress["series_cover:$seriesId"] = progress
            }
        } else if (cleanId.startsWith("movie:") || cleanId.startsWith("vod:")) {
            val raw = cleanId.substringAfter(':')
            if (raw.isNotBlank()) {
                data.playbackProgress["movie:$raw"] = progress
                data.playbackProgress["vod:$raw"] = progress
                data.playbackProgress[raw] = progress
            }
        } else if (cleanId.startsWith("episode:") || cleanId.startsWith("series:")) {
            val raw = cleanId.substringAfter(':')
            if (raw.isNotBlank()) {
                data.playbackProgress["episode:$raw"] = progress
                data.playbackProgress["series:$raw"] = progress
                data.playbackProgress[raw] = progress
            }
        } else {
            data.playbackProgress["movie:$cleanId"] = progress
            data.playbackProgress["vod:$cleanId"] = progress
        }
    }

    fun getPlaybackProgress(id: String): PlaybackProgress? {
        val cleanId = id.trim()
        if (cleanId.isEmpty()) return null
        data.playbackProgress[cleanId]?.let { return it }
        if (cleanId.startsWith("series:") && cleanId.contains(":ep:")) {
            val epId = cleanId.substringAfter(":ep:")
            return data.playbackProgress["episode:$epId"] ?: data.playbackProgress["series:$epId"] ?: data.playbackProgress[epId]
        }
        val raw = cleanId.substringAfterLast(':')
        return data.playbackProgress["movie:$cleanId"]
            ?: data.playbackProgress["vod:$cleanId"]
            ?: data.playbackProgress["episode:$cleanId"]
            ?: data.playbackProgress["series:$cleanId"]
            ?: data.playbackProgress["series_cover:$cleanId"]
            ?: data.playbackProgress[raw]
    }

    fun getRecentlyViewed(type: String): List<String> =
        data.recentlyViewed[type]?.toList().orEmpty()

    fun addRecentlyViewed(type: String, id: String, maxItems: Int = 40) {
        if (id.isBlank()) return
        val list = data.recentlyViewed.getOrPut(type) { mutableListOf() }
        if (list.firstOrNull() == id) return
        list.remove(id)
        list.add(0, id)
        while (list.size > maxItems) {
            list.removeAt(list.lastIndex)
        }
        persistAsync()
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

    private fun JsonObject.optString(vararg keys: String): String? {
        for (k in keys) {
            val el = this[k]
            if (el is JsonPrimitive && el !is JsonNull) {
                val s = el.contentOrNull
                if (!s.isNullOrBlank()) return s
            }
        }
        return null
    }

    private fun parseVodInfoObject(infoEl: JsonElement?): VodInfo {
        if (infoEl !is JsonObject) return VodInfo()
        runCatching { json.decodeFromJsonElement<VodInfo>(infoEl) }.getOrNull()?.let { return it }
        return VodInfo(
            name = infoEl.optString("name", "title"),
            plot = infoEl.optString("plot", "description"),
            cast = infoEl.optString("cast", "actors"),
            director = infoEl.optString("director"),
            genre = infoEl.optString("genre"),
            releaseDate = infoEl.optString("releasedate", "releaseDate"),
            rating = infoEl.optString("rating"),
            duration = infoEl.optString("duration"),
            image = infoEl.optString("movie_image", "cover_big", "cover")
        )
    }

    private fun parseVodDataObject(movieDataEl: JsonElement?, fallbackId: String): VodData {
        if (movieDataEl is JsonObject) {
            runCatching { json.decodeFromJsonElement<VodData>(movieDataEl) }.getOrNull()?.let { return it }
            return VodData(
                streamId = movieDataEl.optString("stream_id") ?: fallbackId,
                name = movieDataEl.optString("name"),
                extension = movieDataEl.optString("container_extension") ?: "mp4"
            )
        }
        return VodData(streamId = fallbackId, name = null, extension = "mp4")
    }

    private fun parseSeriesDetailsObject(infoEl: JsonElement?): SeriesDetails {
        if (infoEl !is JsonObject) return SeriesDetails()
        runCatching { json.decodeFromJsonElement<SeriesDetails>(infoEl) }.getOrNull()?.let { return it }
        return SeriesDetails(
            name = infoEl.optString("name", "title"),
            cover = infoEl.optString("cover", "cover_big"),
            plot = infoEl.optString("plot", "description"),
            cast = infoEl.optString("cast"),
            genre = infoEl.optString("genre"),
            rating = infoEl.optString("rating"),
            releaseDate = infoEl.optString("releaseDate", "releasedate")
        )
    }

    private fun parseEpisodeInfoObject(infoEl: JsonElement?): EpisodeInfo? {
        if (infoEl !is JsonObject) return null
        runCatching { json.decodeFromJsonElement<EpisodeInfo>(infoEl) }.getOrNull()?.let { return it }
        return EpisodeInfo(
            plot = infoEl.optString("plot", "overview"),
            duration = infoEl.optString("duration"),
            image = infoEl.optString("movie_image", "cover_big", "cover")
        )
    }

    private fun parseSingleEpisode(epEl: JsonElement?, fallbackSeason: String? = null): Episode? {
        if (epEl !is JsonObject) return null
        val id = epEl.optString("id", "stream_id") ?: return null
        return Episode(
            id = id,
            episodeNum = epEl.optString("episode_num", "episode"),
            title = epEl.optString("title", "name"),
            extension = epEl.optString("container_extension") ?: "mp4",
            season = epEl.optString("season") ?: fallbackSeason,
            info = parseEpisodeInfoObject(epEl["info"]),
            directUrl = epEl.optString("direct_source")
        )
    }

    private fun parseSeasonEpisodesElement(seasonEl: JsonElement?, fallbackSeason: String? = null): List<Episode> {
        if (seasonEl == null || seasonEl is JsonNull) return emptyList()
        val result = mutableListOf<Episode>()
        when (seasonEl) {
            is JsonArray -> {
                seasonEl.forEach { item ->
                    parseSingleEpisode(item, fallbackSeason)?.let { result.add(it) }
                }
            }
            is JsonObject -> {
                seasonEl.entries.forEach { (_, value) ->
                    parseSingleEpisode(value, fallbackSeason)?.let { result.add(it) }
                }
            }
            else -> Unit
        }
        return result
    }

    suspend fun vodInfo(id: String): VodInfoResponse {
        if (playlist.isM3u) {
            val catalog = ensureM3uLoaded()
            return catalog.vodDetails[id] ?: VodInfoResponse(
                info = VodInfo(name = "Película"),
                movieData = VodData(streamId = id, name = "Película", extension = "mp4")
            )
        }
        val rootEl = runCatching {
            callPlayerApi<JsonElement>("get_vod_info", mapOf("vod_id" to id))
        }.getOrNull()
        val rootObj = rootEl as? JsonObject
        val parsedInfo = parseVodInfoObject(rootObj?.get("info"))
        val parsedMovieData = parseVodDataObject(rootObj?.get("movie_data"), id)
        return VodInfoResponse(info = parsedInfo, movieData = parsedMovieData)
    }

    suspend fun seriesInfo(id: String): Pair<SeriesDetails?, Map<String, List<Episode>>> {
        if (playlist.isM3u) {
            val catalog = ensureM3uLoaded()
            return catalog.seriesDetails[id] ?: (null to emptyMap())
        }
        val rootEl = runCatching {
            callPlayerApi<JsonElement>("get_series_info", mapOf("series_id" to id))
        }.getOrNull()
        val rootObj = rootEl as? JsonObject
        val parsedDetails = parseSeriesDetailsObject(rootObj?.get("info"))
        val map = linkedMapOf<String, List<Episode>>()
        val el: JsonElement? = rootObj?.get("episodes")
        if (el is JsonObject) {
            el.entries
                .sortedBy { it.key.toIntOrNull() ?: 0 }
                .forEach { (season, arr) ->
                    val eps = parseSeasonEpisodesElement(arr, season)
                    if (eps.isNotEmpty()) {
                        map[season] = eps
                    }
                }
        } else if (el is JsonArray) {
            el.forEach { seasonArr ->
                when (seasonArr) {
                    is JsonArray -> {
                        val eps = parseSeasonEpisodesElement(seasonArr, null)
                        eps.firstOrNull()?.let { ep ->
                            val sKey = ep.season ?: "${map.size + 1}"
                            map[sKey] = eps
                        }
                    }
                    is JsonObject -> {
                        val singleEp = parseSingleEpisode(seasonArr, null)
                        if (singleEp != null) {
                            val sKey = singleEp.season ?: "1"
                            val list = map.getOrPut(sKey) { emptyList() }
                            map[sKey] = list + singleEp
                        } else {
                            val eps = parseSeasonEpisodesElement(seasonArr, null)
                            eps.firstOrNull()?.let { ep ->
                                val sKey = ep.season ?: "${map.size + 1}"
                                map[sKey] = eps
                            }
                        }
                    }
                    else -> Unit
                }
            }
        }
        return parsedDetails to map
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
     * En iOS (VLCKit), los flujos en directo de Xtream Codes se sirven directamente en formato .ts
     * (igual que en Android y Windows Desktop) con fallback automático a .m3u8 en el reproductor nativo.
     */
    fun liveUrl(streamId: String, ext: String = "ts"): String =
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
