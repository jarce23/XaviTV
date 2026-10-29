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
    var scrollPositions: MutableMap<String, Pair<Int, Int>> = mutableMapOf(),
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
 * Optimizado para Arranque Instantáneo:
 * - No bloquea el hilo principal de UI durante la creación de la ventana.
 * - Inicia en memoria inmediatamente con la lista por defecto (TDTChannels) disponible.
 * - Carga y persiste el archivo JSON de forma asíncrona en segundo plano (Dispatchers.IO).
 */
class PlaylistStore {
    private val gson by lazy { Gson() }
    private val ioScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private val storeDir by lazy { File(System.getProperty("user.home"), ".xavitv").apply { mkdirs() } }
    private val storeFile by lazy { File(storeDir, "store.json") }

    // Estado inicial inmediato en RAM para que la primera pantalla renderice en 0ms sin esperar a disco
    private var data: DesktopStorageData = DesktopStorageData(
        activeName = defaultTdtPlaylist.name,
        defaultTdtSeeded = true,
        playlists = mutableListOf(defaultTdtPlaylist)
    )

    @Volatile
    private var diskLoaded = false

    // Contador observable por Compose para recomponer suavemente tras completar la lectura en Dispatchers.IO
    var stateVersion by mutableIntStateOf(0)
        private set

    private fun notifyStateChanged() {
        stateVersion++
    }

    /**
     * Inicializa el almacenamiento desde disco en segundo plano (Dispatchers.IO)
     * sin bloquear el renderizado inicial de la ventana de Compose.
     */
    suspend fun initializeAsync() = withContext(Dispatchers.IO) {
        if (diskLoaded) return@withContext
        val loaded = if (storeFile.exists()) {
            runCatching {
                gson.fromJson(storeFile.readText(StandardCharsets.UTF_8), DesktopStorageData::class.java)
            }.getOrNull()
        } else {
            null
        }

        var needsPersist = false
        synchronized(this@PlaylistStore) {
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
                data.activeName = data.playlists.first().name
                needsPersist = true
            }
            diskLoaded = true
        }

        if (needsPersist || !storeFile.exists()) {
            persistSync()
        }
        notifyStateChanged()
    }

    @Synchronized
    private fun snapshotJson(): String = gson.toJson(data)

    private fun persistSync() {
        runCatching {
            val json = snapshotJson()
            storeFile.writeText(json, StandardCharsets.UTF_8)
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
            if (diskLoaded) persistAsync()
        }
        if (data.activeName.isNullOrBlank() || data.playlists.none { it.name == data.activeName }) {
            data.activeName = data.playlists.first().name
            if (diskLoaded) persistAsync()
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
        persistAsync()
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
        persistAsync()
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
        persistAsync()
    }

    var activeName: String?
        @Synchronized get() = data.activeName
        @Synchronized set(v) {
            data.activeName = v
            notifyStateChanged()
            persistAsync()
        }

    @Synchronized
    fun active(): Playlist {
        val list = ensureDefaultPlaylistInjected()
        return list.firstOrNull { it.name == data.activeName } ?: list.first().also {
            data.activeName = it.name
            if (diskLoaded) persistAsync()
        }
    }

    @Synchronized
    fun favorites(type: String): Set<String> =
        data.favorites[type]?.toSet().orEmpty()

    @Synchronized
    fun toggleFavorite(type: String, id: String) {
        val set = data.favorites.getOrPut(type) { mutableSetOf() }
        if (!set.add(id)) set.remove(id)
        persistAsync()
    }

    @Synchronized
    fun getResumePosition(url: String): Long = data.resumePositions[url] ?: 0L

    @Synchronized
    fun saveResumePosition(url: String, posMs: Long) {
        data.resumePositions[url] = posMs
        persistAsync()
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
        data.scrollPositions[key] ?: (0 to 0)

    @Synchronized
    fun saveScrollPosition(key: String, index: Int, offset: Int) {
        if (index >= 0 && offset >= 0) {
            data.scrollPositions[key] = index to offset
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
