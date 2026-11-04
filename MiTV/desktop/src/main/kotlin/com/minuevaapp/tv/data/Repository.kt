package com.minuevaapp.tv.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.nio.charset.StandardCharsets
import java.util.Base64

private data class DesktopStorageData(
    var activeName: String? = null,
    var defaultTdtSeeded: Boolean = false,
    var playlists: MutableList<Playlist> = mutableListOf(),
    var favorites: MutableMap<String, MutableSet<String>> = mutableMapOf(),
    var resumePositions: MutableMap<String, Long> = mutableMapOf(),
    var recentlyViewed: MutableMap<String, MutableList<String>> = mutableMapOf(),
    var selectedCategories: MutableMap<String, String> = mutableMapOf(),
    var scrollPositions: MutableMap<String, List<Int>> = mutableMapOf(),
    var playbackProgress: MutableMap<String, PlaybackProgress> = mutableMapOf(),
)

data class RefreshResult(
    val success: Boolean,
    val liveCount: Int = 0,
    val vodCount: Int = 0,
    val seriesCount: Int = 0,
    val error: String? = null,
)

/**
 * Almacenamiento local para Windows Desktop (~/.xavitv/store.json).
 * - Lee el archivo JSON de forma SÍNCRONA en el constructor (es un archivo pequeño), de modo que
 *   antes de decidir la primera pantalla ya están en memoria las listas y la lista activa guardadas.
 * - Toda modificación de listas/credenciales se escribe inmediatamente en disco (persistSync)
 *   mediante escritura atómica (archivo temporal + reemplazo) y copia de seguridad store.json.bak.
 * - Si el JSON no se puede leer, NUNCA se sobrescribe: se intenta la copia de seguridad y se
 *   conserva el archivo original como store.json.corrupt.
 */
class PlaylistStore {
    private val gson by lazy { Gson() }
    private val ioScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private val storeDir by lazy { File(System.getProperty("user.home"), ".xavitv").apply { mkdirs() } }
    private val storeFile by lazy { File(storeDir, "store.json") }
    private val backupFile by lazy { File(storeDir, "store.json.bak") }

    private var data: DesktopStorageData = DesktopStorageData(
        activeName = defaultTdtPlaylist.name,
        defaultTdtSeeded = true,
        playlists = mutableListOf(defaultTdtPlaylist)
    )

    @Volatile
    private var diskLoaded = false

    /** Si el archivo existía pero era ilegible, se bloquea la escritura para no machacarlo. */
    @Volatile
    private var writeBlocked = false

    // Contador observable por Compose para recomponer tras cambios en el almacenamiento
    var stateVersion by mutableIntStateOf(0)
        private set

    private val _playbackProgressFlow = MutableStateFlow<Map<String, PlaybackProgress>>(emptyMap())
    val playbackProgressFlow: StateFlow<Map<String, PlaybackProgress>> = _playbackProgressFlow.asStateFlow()

    private fun notifyStateChanged() {
        stateVersion++
        _playbackProgressFlow.value = data.playbackProgress.toMap()
    }

    init {
        loadFromDiskSync()
        _playbackProgressFlow.value = data.playbackProgress.toMap()
    }

    private fun parseStore(file: File): DesktopStorageData? {
        if (!file.exists() || file.length() == 0L) return null
        return runCatching {
            gson.fromJson(file.readText(StandardCharsets.UTF_8), DesktopStorageData::class.java)
        }.getOrNull()?.let { normalize(it) }
    }

    /** Gson puede dejar a null colecciones ausentes en JSON antiguos: se normalizan aquí. */
    @Suppress("SENSELESS_COMPARISON", "UNNECESSARY_SAFE_CALL")
    private fun normalize(d: DesktopStorageData): DesktopStorageData = DesktopStorageData(
        activeName = d.activeName,
        defaultTdtSeeded = d.defaultTdtSeeded,
        playlists = (d.playlists ?: mutableListOf()).filter { it != null && !it.name.isNullOrBlank() }.toMutableList(),
        favorites = d.favorites ?: mutableMapOf(),
        resumePositions = d.resumePositions ?: mutableMapOf(),
        recentlyViewed = d.recentlyViewed ?: mutableMapOf(),
        selectedCategories = d.selectedCategories ?: mutableMapOf(),
        scrollPositions = d.scrollPositions ?: mutableMapOf(),
        playbackProgress = d.playbackProgress ?: mutableMapOf(),
    )

    /** Lectura síncrona del disco. Se llama en el constructor, antes de mostrar ninguna pantalla. */
    @Synchronized
    private fun loadFromDiskSync() {
        if (diskLoaded) return
        val fileExists = storeFile.exists() && storeFile.length() > 0L
        val loaded = parseStore(storeFile) ?: parseStore(backupFile)

        if (loaded == null && fileExists) {
            // Archivo ilegible: lo conservamos y no permitimos que se sobrescriba con datos vacíos
            runCatching { storeFile.copyTo(File(storeDir, "store.json.corrupt"), overwrite = true) }
            writeBlocked = !backupFile.exists()
        }

        var needsPersist = false
        if (loaded != null) {
            data = loaded
        }
        if (data.playlists.isEmpty() || !data.defaultTdtSeeded) {
            val hasTdt = data.playlists.any {
                it.effectiveM3uUrl.equals(DEFAULT_TDT_URL, ignoreCase = true) ||
                    it.name.equals(defaultTdtPlaylist.name, ignoreCase = true)
            }
            if (!hasTdt) {
                data.playlists.add(0, defaultTdtPlaylist)
            }
            data.defaultTdtSeeded = true
            needsPersist = true
        }
        if (data.activeName.isNullOrBlank() || data.playlists.none { it.name == data.activeName }) {
            val preferred = data.playlists.lastOrNull { !it.name.equals(defaultTdtPlaylist.name, ignoreCase = true) }
                ?: data.playlists.first()
            data.activeName = preferred.name
            needsPersist = true
        }
        diskLoaded = true

        if ((needsPersist || !storeFile.exists()) && !writeBlocked) {
            persistSync()
        }
    }

    /**
     * Compatibilidad con el arranque anterior: la carga ya se hizo síncronamente en el constructor,
     * aquí solo se notifica a Compose.
     */
    suspend fun initializeAsync() = withContext(Dispatchers.IO) {
        loadFromDiskSync()
        notifyStateChanged()
    }

    /** Indica si hay listas del usuario guardadas (además de la TDT por defecto). */
    @Synchronized
    fun hasUserPlaylists(): Boolean =
        data.playlists.any { !it.name.equals(defaultTdtPlaylist.name, ignoreCase = true) }

    @Synchronized
    private fun snapshotJson(): String = gson.toJson(data)

    /** Escritura inmediata y atómica en disco (tmp + reemplazo) con copia de seguridad. */
    @Synchronized
    private fun persistSync() {
        if (!diskLoaded) return
        runCatching {
            val json = snapshotJson()
            val tmp = File(storeDir, "store.json.tmp")
            tmp.writeText(json, StandardCharsets.UTF_8)
            runCatching {
                java.nio.file.Files.move(
                    tmp.toPath(),
                    storeFile.toPath(),
                    java.nio.file.StandardCopyOption.REPLACE_EXISTING,
                    java.nio.file.StandardCopyOption.ATOMIC_MOVE
                )
            }.getOrElse {
                java.nio.file.Files.move(tmp.toPath(), storeFile.toPath(), java.nio.file.StandardCopyOption.REPLACE_EXISTING)
            }
            backupFile.writeText(json, StandardCharsets.UTF_8)
            writeBlocked = false
        }
    }

    private fun persistAsync() {
        ioScope.launch {
            persistSync()
        }
    }

    @Synchronized
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
            persistSync()
        }
        if (data.activeName.isNullOrBlank() || data.playlists.none { it.name == data.activeName }) {
            data.activeName = data.playlists.first().name
            persistSync()
        }
        return data.playlists.toList()
    }

    @Synchronized
    fun all(): List<Playlist> = ensureDefaultPlaylistInjected()

    @Synchronized
    fun add(p: Playlist) {
        data.playlists.removeAll { it.name.equals(p.name, ignoreCase = true) }
        data.playlists.add(p)
        data.activeName = p.name
        notifyStateChanged()
        persistSync()
    }

    @Synchronized
    fun update(original: Playlist, updated: Playlist) {
        val idx = data.playlists.indexOfFirst {
            it.name.equals(original.name, ignoreCase = true) && it.playlistType == original.playlistType
        }
        if (idx >= 0) {
            data.playlists[idx] = updated
            val deduplicated = data.playlists.filterIndexed { index, item ->
                index == idx || !item.name.equals(updated.name, ignoreCase = true)
            }.toMutableList()
            data.playlists = deduplicated
        } else {
            data.playlists.add(updated)
        }
        if (data.activeName == original.name) {
            data.activeName = updated.name
        }
        notifyStateChanged()
        persistSync()
    }

    @Synchronized
    fun remove(p: Playlist) {
        data.playlists.removeAll { it.name == p.name && it.playlistType == p.playlistType }
        if (data.playlists.isEmpty()) {
            ensureDefaultPlaylistInjected()
        } else if (data.activeName == p.name) {
            data.activeName = data.playlists.first().name
        }
        notifyStateChanged()
        persistSync()
    }

    var activeName: String?
        @Synchronized get() = data.activeName
        @Synchronized set(v) {
            data.activeName = v
            notifyStateChanged()
            persistSync()
        }

    @Synchronized
    fun active(): Playlist {
        val list = ensureDefaultPlaylistInjected()
        return list.firstOrNull { it.name == data.activeName } ?: list.first().also {
            data.activeName = it.name
            persistSync()
        }
    }

    @Synchronized
    fun favorites(type: String): Set<String> =
        data.favorites[type]?.toSet().orEmpty()

    @Synchronized
    fun toggleFavorite(type: String, id: String) {
        val set = data.favorites.getOrPut(type) { mutableSetOf() }
        if (!set.add(id)) set.remove(id)
        persistSync()
    }

    @Synchronized
    fun getResumePosition(url: String): Long {
        getPlaybackProgress(url)?.let { return it.resumePositionMs }
        return data.resumePositions[url] ?: 0L
    }

    @Synchronized
    fun saveResumePosition(url: String, posMs: Long) {
        data.resumePositions[url] = posMs
        val existingDur = getPlaybackProgress(url)?.durationMs ?: 0L
        savePlaybackProgress(url, posMs, existingDur)
    }

    @Synchronized
    fun savePlaybackProgress(id: String, positionMs: Long, durationMs: Long) {
        val cleanId = id.trim()
        if (cleanId.isEmpty() || positionMs < 0L) return

        if (positionMs == 0L && durationMs == 0L) {
            removeProgressKeys(cleanId)
            data.resumePositions.remove(cleanId)
            notifyStateChanged()
            persistSync()
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
            updatedAt = System.currentTimeMillis(),
        )
        storeProgressUnderAliases(cleanId, progress)
        data.resumePositions[cleanId] = progress.resumePositionMs
        notifyStateChanged()
        persistSync()
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

    @Synchronized
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

    @Synchronized
    fun getSelectedCategory(type: String): String =
        data.selectedCategories[type] ?: "ALL"

    @Synchronized
    fun setSelectedCategory(type: String, categoryId: String) {
        data.selectedCategories[type] = categoryId
        persistSync()
    }

    @Synchronized
    fun getScrollPosition(key: String): Pair<Int, Int> =
        data.scrollPositions[key]?.takeIf { it.size >= 2 }?.let { it[0] to it[1] } ?: (0 to 0)

    @Synchronized
    fun saveScrollPosition(key: String, index: Int, offset: Int) {
        if (index >= 0 && offset >= 0) {
            data.scrollPositions[key] = listOf(index, offset)
            persistAsync()
        }
    }

    @Synchronized
    fun getRecentlyViewed(type: String): List<String> {
        val direct = data.recentlyViewed[type]?.toList().orEmpty()
        if (direct.isNotEmpty()) return direct
        if (type == "movie") return data.recentlyViewed["vod"]?.toList().orEmpty()
        if (type == "vod") return data.recentlyViewed["movie"]?.toList().orEmpty()
        return emptyList()
    }

    @Synchronized
    fun addRecentlyViewed(type: String, id: String, maxItems: Int = 40) {
        if (id.isBlank()) return
        val list = data.recentlyViewed.getOrPut(type) { mutableListOf() }
        list.remove(id)
        list.add(0, id)
        while (list.size > maxItems) {
            list.removeAt(list.lastIndex)
        }
        if (type == "movie") {
            val vodList = data.recentlyViewed.getOrPut("vod") { mutableListOf() }
            vodList.remove(id)
            vodList.add(0, id)
            while (vodList.size > maxItems) {
                vodList.removeAt(vodList.lastIndex)
            }
        }
        notifyStateChanged()
        persistSync()
    }

    @Synchronized
    fun clearRecentlyViewed(type: String) {
        data.recentlyViewed.remove(type)
        if (type == "movie") data.recentlyViewed.remove("vod")
        if (type == "vod") data.recentlyViewed.remove("movie")
        notifyStateChanged()
        persistSync()
    }

    companion object {
        const val DEFAULT_TDT_URL = "https://www.tdtchannels.com/lists/tvradio.m3u"

        val defaultTdtPlaylist = Playlist(
            name = "TDT España (TDTChannels)",
            serverUrl = DEFAULT_TDT_URL,
            type = Playlist.TYPE_M3U,
            m3uUrl = DEFAULT_TDT_URL,
        )
    }
}

class XtreamRepository(
    val playlist: Playlist,
    private val httpClient: OkHttpClient,
) {
    private val base = playlist.serverUrl.trim().trimEnd('/')
    private val u = playlist.username.trim()
    private val p = playlist.password
    private val gson by lazy { Gson() }

    private val api: XtreamApi by lazy {
        Retrofit.Builder()
            .baseUrl("$base/")
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(XtreamApi::class.java)
    }

    private val liveMutex = Mutex()
    private val vodMutex = Mutex()
    private val seriesMutex = Mutex()
    private val m3uMutex = Mutex()

    @Volatile
    private var liveCache: Pair<List<Category>, List<LiveStream>>? = null
    @Volatile
    private var vodCache: Pair<List<Category>, List<VodStream>>? = null
    @Volatile
    private var seriesCache: Pair<List<Category>, List<Series>>? = null
    @Volatile
    private var m3uCatalog: M3uCatalog? = null

    private suspend fun ensureM3uLoaded(forceRefresh: Boolean = false): M3uCatalog =
        m3uMutex.withLock {
            if (!forceRefresh) m3uCatalog?.let { return@withLock it }
            withContext(Dispatchers.IO) {
                M3uParser.fetchAndParse(playlist.effectiveM3uUrl, httpClient, forceRefresh).also {
                    m3uCatalog = it
                }
            }
        }

    /**
     * Precarga en segundo plano (Dispatchers.IO) la lista M3U o canales en directo activos
     * para que al entrar en «TV en directo» el listado esté inmediatamente disponible en memoria.
     */
    suspend fun warmUpInBackground() = withContext(Dispatchers.IO) {
        runCatching {
            if (playlist.isM3u) {
                ensureM3uLoaded(forceRefresh = false)
            } else {
                live(forceRefresh = false)
            }
        }
    }

    suspend fun login(): LoginResponse = withContext(Dispatchers.IO) {
        if (playlist.isM3u) {
            val catalog = ensureM3uLoaded()
            val totalItems = catalog.liveStreams.size + catalog.vodStreams.size + catalog.seriesList.size
            LoginResponse(
                userInfo = UserInfo(
                    username = playlist.name,
                    status = "Lista M3U (${catalog.liveStreams.size} canales · ${catalog.vodStreams.size} películas · ${catalog.seriesList.size} series)",
                    auth = "1",
                    expDate = null,
                    maxConnections = totalItems.toString(),
                    activeConnections = "1",
                ),
                serverInfo = ServerInfo(
                    url = playlist.effectiveM3uUrl,
                    port = null,
                    protocol = "M3U",
                    timezone = null,
                ),
            )
        } else {
            api.login(u, p)
        }
    }

    suspend fun live(forceRefresh: Boolean = false): Pair<List<Category>, List<LiveStream>> {
        if (playlist.isM3u) {
            val catalog = ensureM3uLoaded(forceRefresh)
            return catalog.liveCategories to catalog.liveStreams
        }
        return liveMutex.withLock {
            if (!forceRefresh) liveCache?.let { return@withLock it }
            withContext(Dispatchers.IO) {
                (api.liveCategories(u, p) to api.liveStreams(u, p)).also { liveCache = it }
            }
        }
    }

    suspend fun vod(forceRefresh: Boolean = false): Pair<List<Category>, List<VodStream>> {
        if (playlist.isM3u) {
            val catalog = ensureM3uLoaded(forceRefresh)
            return catalog.vodCategories to catalog.vodStreams
        }
        return vodMutex.withLock {
            if (!forceRefresh) vodCache?.let { return@withLock it }
            withContext(Dispatchers.IO) {
                (api.vodCategories(u, p) to api.vodStreams(u, p)).also { vodCache = it }
            }
        }
    }

    suspend fun series(forceRefresh: Boolean = false): Pair<List<Category>, List<Series>> {
        if (playlist.isM3u) {
            val catalog = ensureM3uLoaded(forceRefresh)
            return catalog.seriesCategories to catalog.seriesList
        }
        return seriesMutex.withLock {
            if (!forceRefresh) seriesCache?.let { return@withLock it }
            withContext(Dispatchers.IO) {
                (api.seriesCategories(u, p) to api.series(u, p)).also { seriesCache = it }
            }
        }
    }

    suspend fun refreshAllXtream(): RefreshResult = withContext(Dispatchers.IO) {
        liveMutex.withLock { liveCache = null }
        vodMutex.withLock { vodCache = null }
        seriesMutex.withLock { seriesCache = null }

        if (playlist.isM3u) {
            return@withContext runCatching {
                val catalog = ensureM3uLoaded(forceRefresh = true)
                RefreshResult(
                    success = true,
                    liveCount = catalog.liveStreams.size,
                    vodCount = catalog.vodStreams.size,
                    seriesCount = catalog.seriesList.size,
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
                seriesCount = seriesItems.size,
            )
        } catch (e: Throwable) {
            RefreshResult(
                success = false,
                error = sanitizeError(e, playlist),
            )
        }
    }

    suspend fun vodInfo(id: String): VodInfoResponse = withContext(Dispatchers.IO) {
        if (playlist.isM3u) {
            val catalog = ensureM3uLoaded()
            catalog.vodDetails[id] ?: VodInfoResponse(
                info = VodInfo(name = "Película"),
                movieData = VodData(streamId = id, name = "Película", extension = "mp4"),
            )
        } else {
            api.vodInfo(u, p, id)
        }
    }

    suspend fun seriesInfo(id: String): Pair<SeriesDetails?, Map<String, List<Episode>>> =
        withContext(Dispatchers.IO) {
            if (playlist.isM3u) {
                val catalog = ensureM3uLoaded()
                return@withContext catalog.seriesDetails[id] ?: (null to emptyMap())
            }
            val r = api.seriesInfo(u, p, id)
            val map = linkedMapOf<String, List<Episode>>()
            val el: JsonElement? = r.episodes
            val listType = object : TypeToken<List<Episode>>() {}.type
            if (el != null && el.isJsonObject) {
                el.asJsonObject.entrySet()
                    .sortedBy { it.key.toIntOrNull() ?: 0 }
                    .forEach { (season, arr) ->
                        map[season] = runCatching { gson.fromJson<List<Episode>>(arr, listType) }.getOrDefault(emptyList())
                    }
            } else if (el != null && el.isJsonArray) {
                el.asJsonArray.forEach { seasonArr ->
                    val eps: List<Episode> = runCatching { gson.fromJson<List<Episode>>(seasonArr, listType) }.getOrDefault(emptyList())
                    eps.firstOrNull()?.let { map[it.season ?: "${map.size + 1}"] = eps }
                }
            }
            r.info to map
        }

    suspend fun shortEpg(streamId: String): List<EpgListing> = withContext(Dispatchers.IO) {
        if (playlist.isM3u) return@withContext emptyList()
        runCatching { api.shortEpg(u, p, streamId).listings.orEmpty() }.getOrDefault(emptyList())
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

    fun liveUrl(streamId: String, ext: String = "ts"): String =
        resolveDirectUrl(streamId) ?: "$base/live/$u/$p/$streamId.$ext"

    fun movieUrl(streamId: String, ext: String?): String =
        resolveDirectUrl(streamId) ?: "$base/movie/$u/$p/$streamId.${ext?.ifBlank { "mp4" } ?: "mp4"}"

    fun episodeUrl(episodeId: String, ext: String?): String =
        resolveDirectUrl(episodeId) ?: "$base/series/$u/$p/$episodeId.${ext?.ifBlank { "mp4" } ?: "mp4"}"

    companion object {
        fun decodeB64(s: String?): String =
            if (s.isNullOrEmpty()) "" else runCatching {
                String(Base64.getDecoder().decode(s.trim()), StandardCharsets.UTF_8).trim()
            }.getOrDefault(s)

        fun sanitizeError(t: Throwable, playlist: Playlist? = null): String {
            var msg = t.localizedMessage ?: t.message ?: "Error de conexión con el servidor"
            playlist?.let {
                if (it.password.isNotEmpty()) msg = msg.replace(it.password, "***")
                if (it.username.isNotEmpty()) msg = msg.replace(it.username, "***")
            }
            return msg
        }
    }
}
