package com.minuevaapp.tv.data

import android.content.Context
import android.util.Base64
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

data class RefreshResult(
    val success: Boolean,
    val liveCount: Int = 0,
    val vodCount: Int = 0,
    val seriesCount: Int = 0,
    val error: String? = null
)

/**
 * Guarda listas (playlists Xtream o M3U) y favoritos en SharedPreferences.
 * En el primer arranque (o si la base de datos local queda vacía), inyecta y guarda
 * automáticamente de forma nativa la lista M3U oficial de TDTChannels España.
 */
class PlaylistStore(context: Context) {
    private val prefs = context.applicationContext.getSharedPreferences("playlists", Context.MODE_PRIVATE)
    private val gson = Gson()

    init {
        ensureDefaultPlaylistInjected()
    }

    private fun readRawList(): List<Playlist> {
        val json = prefs.getString("list", null) ?: return emptyList()
        return runCatching {
            val type = object : TypeToken<List<Playlist>>() {}.type
            gson.fromJson<List<Playlist>>(json, type).orEmpty()
        }.getOrDefault(emptyList())
    }

    /**
     * Garantiza que en el primer arranque (o si no hay listas guardadas) se inserte
     * automáticamente la lista M3U por defecto de TDTChannels en almacenamiento local.
     */
    fun ensureDefaultPlaylistInjected(): List<Playlist> {
        val current = readRawList().toMutableList()
        val alreadySeeded = prefs.getBoolean(KEY_DEFAULT_TDT_SEEDED, false)

        if (current.isEmpty() || !alreadySeeded) {
            val hasTdt = current.any {
                it.effectiveM3uUrl.equals(DEFAULT_TDT_URL, ignoreCase = true) ||
                    it.name.equals(defaultTdtPlaylist.name, ignoreCase = true)
            }
            if (!hasTdt) {
                current.add(0, defaultTdtPlaylist)
            }
            prefs.edit()
                .putString("list", gson.toJson(current))
                .putBoolean(KEY_DEFAULT_TDT_SEEDED, true)
                .apply()
        }

        if (activeName.isNullOrBlank() || current.none { it.name == activeName }) {
            activeName = current.first().name
        }
        return current
    }

    fun all(): List<Playlist> = ensureDefaultPlaylistInjected()

    fun save(list: List<Playlist>) {
        prefs.edit().putString("list", gson.toJson(list)).apply()
    }

    fun add(p: Playlist) {
        val updated = readRawList().filterNot { it.name.equals(p.name, ignoreCase = true) } + p
        save(updated)
        activeName = p.name
    }

    fun update(original: Playlist, updated: Playlist) {
        val current = readRawList().toMutableList()
        val idx = current.indexOfFirst {
            it.name.equals(original.name, ignoreCase = true) && it.playlistType == original.playlistType
        }
        if (idx >= 0) {
            current[idx] = updated
            // Elimina posibles duplicados si se renombró igual que otra entrada
            val deduplicated = current.filterIndexed { index, item ->
                index == idx || !item.name.equals(updated.name, ignoreCase = true)
            }
            save(deduplicated)
        } else {
            add(updated)
        }
        if (activeName == original.name) {
            activeName = updated.name
        }
    }

    fun remove(p: Playlist) {
        val remaining = readRawList().filterNot { it.name == p.name && it.playlistType == p.playlistType }
        save(remaining)
        if (remaining.isEmpty()) {
            ensureDefaultPlaylistInjected()
        } else if (activeName == p.name) {
            activeName = remaining.first().name
        }
    }

    var activeName: String?
        get() = prefs.getString("active", null)
        set(v) = prefs.edit().putString("active", v).apply()

    fun active(): Playlist {
        val list = ensureDefaultPlaylistInjected()
        return list.firstOrNull { it.name == activeName } ?: list.first().also { activeName = it.name }
    }

    // Favoritos por tipo ("live", "movie", "series")
    fun favorites(type: String): Set<String> =
        prefs.getStringSet("fav_$type", emptySet())?.toSet().orEmpty()

    fun toggleFavorite(type: String, id: String) {
        val updated = favorites(type).toMutableSet()
        if (!updated.add(id)) updated.remove(id)
        prefs.edit().putStringSet("fav_$type", updated).apply()
    }

    fun getRecentlyViewed(type: String): List<String> {
        val json = prefs.getString("recent_$type", null) ?: return emptyList()
        return runCatching {
            val listType = object : TypeToken<List<String>>() {}.type
            gson.fromJson<List<String>>(json, listType).orEmpty()
        }.getOrDefault(emptyList())
    }

    fun addRecentlyViewed(type: String, id: String, maxItems: Int = 40) {
        if (id.isBlank()) return
        val list = getRecentlyViewed(type).toMutableList()
        list.remove(id)
        list.add(0, id)
        while (list.size > maxItems) {
            list.removeAt(list.lastIndex)
        }
        prefs.edit().putString("recent_$type", gson.toJson(list)).apply()
    }

    fun clearRecentlyViewed(type: String) {
        prefs.edit().remove("recent_$type").apply()
    }

    fun getSelectedCategory(type: String): String =
        prefs.getString("selected_cat_$type", "__all") ?: "__all"

    fun setSelectedCategory(type: String, categoryId: String) {
        prefs.edit().putString("selected_cat_$type", categoryId).apply()
    }

    fun getScrollPosition(key: String): Pair<Int, Int> {
        val idx = prefs.getInt("scroll_idx_$key", 0)
        val off = prefs.getInt("scroll_off_$key", 0)
        return idx to off
    }

    fun saveScrollPosition(key: String, index: Int, offset: Int) {
        if (index >= 0 && offset >= 0) {
            prefs.edit()
                .putInt("scroll_idx_$key", index)
                .putInt("scroll_off_$key", offset)
                .apply()
        }
    }

    companion object {
        private const val KEY_DEFAULT_TDT_SEEDED = "default_tdt_seeded_v1"
        const val DEFAULT_TDT_URL = "https://www.tdtchannels.com/lists/tvradio.m3u"

        val defaultTdtPlaylist = Playlist(
            name = "TDT España (TDTChannels)",
            serverUrl = DEFAULT_TDT_URL,
            type = Playlist.TYPE_M3U,
            m3uUrl = DEFAULT_TDT_URL,
        )
    }
}

/**
 * Repositorio unificado con soporte para servidores Xtream Codes y listas M3U / M3U8.
 * Mantiene caché en memoria segura para concurrencia del contenido de la lista activa.
 */
class XtreamRepository(
    val playlist: Playlist,
    private val httpClient: OkHttpClient,
) {
    private val base = playlist.serverUrl.trim().trimEnd('/')
    private val u = playlist.username.trim()
    private val p = playlist.password
    private val gson = Gson()

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
                M3uParser.fetchAndParse(playlist.effectiveM3uUrl, httpClient).also {
                    m3uCatalog = it
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
                    seriesCount = catalog.seriesList.size
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

    /** Devuelve (detalles, temporada -> episodios). */
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

    // Construcción de URLs de stream (soporta URL directa M3U o formato Xtream Codes)
    fun liveUrl(streamId: String, ext: String = "ts"): String =
        resolveDirectUrl(streamId) ?: "$base/live/$u/$p/$streamId.$ext"

    fun movieUrl(streamId: String, ext: String?): String =
        resolveDirectUrl(streamId) ?: "$base/movie/$u/$p/$streamId.${ext?.ifBlank { "mp4" } ?: "mp4"}"

    fun episodeUrl(episodeId: String, ext: String?): String =
        resolveDirectUrl(episodeId) ?: "$base/series/$u/$p/$episodeId.${ext?.ifBlank { "mp4" } ?: "mp4"}"

    fun catchupUrl(streamId: String, start: String, durationMin: Int) =
        "$base/timeshift/$u/$p/$durationMin/$start/$streamId.ts"

    companion object {
        fun decodeB64(s: String?): String =
            if (s.isNullOrEmpty()) "" else runCatching {
                String(Base64.decode(s, Base64.DEFAULT), Charsets.UTF_8).trim()
            }.getOrDefault(s)

        /** Oculta credenciales en mensajes de error para evitar exponer usuario o contraseña en pantalla. */
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
