package com.minuevaapp.tv.data

import android.content.Context
import android.util.Base64
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
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
    private val ioScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    /** Copia en memoria de las listas leídas de disco (se rellena síncronamente en el init). */
    @Volatile
    private var cachedList: List<Playlist>? = null

    init {
        // Lectura SÍNCRONA de las listas guardadas antes de que la UI decida qué pantalla mostrar.
        ensureDefaultPlaylistInjected()
    }

    /**
     * Lee las listas de disco. Devuelve null si existe un JSON guardado pero no se puede interpretar
     * (para no sobrescribirlo jamás con una lista vacía), o una lista vacía si nunca se guardó nada.
     * Se usa Array<Playlist> en lugar de TypeToken para que R8/ProGuard no rompa la deserialización.
     */
    private fun readRawListOrNull(): List<Playlist>? {
        val json = prefs.getString(KEY_LIST, null) ?: prefs.getString(KEY_LIST_BACKUP, null) ?: return emptyList()
        return runCatching {
            gson.fromJson(json, Array<Playlist>::class.java)
                ?.filter { !it.name.isNullOrBlank() }
                .orEmpty()
        }.getOrNull() ?: runCatching {
            val backup = prefs.getString(KEY_LIST_BACKUP, null) ?: return@runCatching null
            gson.fromJson(backup, Array<Playlist>::class.java)?.filter { !it.name.isNullOrBlank() }
        }.getOrNull()
    }

    private fun readRawList(): List<Playlist> = cachedList ?: (readRawListOrNull() ?: emptyList())

    /**
     * Garantiza que en el primer arranque (o si no hay listas guardadas) se inserte
     * automáticamente la lista M3U por defecto de TDTChannels en almacenamiento local.
     * Nunca elimina ni sobrescribe listas del usuario ya guardadas.
     */
    @Synchronized
    fun ensureDefaultPlaylistInjected(): List<Playlist> {
        val fromDisk = cachedList ?: readRawListOrNull()
        if (fromDisk == null) {
            // JSON corrupto/ilegible: no tocar el disco; usar la lista por defecto solo en memoria.
            return listOf(defaultTdtPlaylist).also { cachedList = it }
        }
        val current = fromDisk.toMutableList()
        val alreadySeeded = prefs.getBoolean(KEY_DEFAULT_TDT_SEEDED, false)

        if (current.isEmpty() || !alreadySeeded) {
            val hasTdt = current.any {
                it.effectiveM3uUrl.equals(DEFAULT_TDT_URL, ignoreCase = true) ||
                    it.name.equals(defaultTdtPlaylist.name, ignoreCase = true)
            }
            if (!hasTdt) {
                current.add(0, defaultTdtPlaylist)
            }
            save(current)
            prefs.edit().putBoolean(KEY_DEFAULT_TDT_SEEDED, true).commit()
        }
        cachedList = current.toList()

        val savedActive = prefs.getString(KEY_ACTIVE, null)
        if (savedActive.isNullOrBlank() || current.none { it.name == savedActive }) {
            // Prioriza la última lista añadida por el usuario frente a la de TDT por defecto
            val preferred = current.lastOrNull { !it.name.equals(defaultTdtPlaylist.name, ignoreCase = true) }
                ?: current.first()
            activeName = preferred.name
        }
        return current.toList()
    }

    fun all(): List<Playlist> = ensureDefaultPlaylistInjected()

    /** Indica si el usuario tiene guardada al menos una lista propia (Xtream o M3U) además de la TDT. */
    fun hasUserPlaylists(): Boolean =
        all().any { !it.name.equals(defaultTdtPlaylist.name, ignoreCase = true) }

    /** Guarda las listas de forma síncrona en disco (commit) y mantiene una copia de seguridad. */
    @Synchronized
    fun save(list: List<Playlist>) {
        val json = gson.toJson(list)
        prefs.edit()
            .putString(KEY_LIST, json)
            .putString(KEY_LIST_BACKUP, json)
            .commit()
        cachedList = list.toList()
    }

    @Synchronized
    fun add(p: Playlist) {
        val updated = readRawList().filterNot { it.name.equals(p.name, ignoreCase = true) } + p
        save(updated)
        activeName = p.name
    }

    @Synchronized
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

    @Synchronized
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
        get() = prefs.getString(KEY_ACTIVE, null)
        set(v) {
            prefs.edit().putString(KEY_ACTIVE, v).commit()
        }

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
        prefs.edit().putStringSet("fav_$type", updated).commit()
    }

    private val recentMemoryCache = mutableMapOf<String, List<String>>()
    private val _recentUpdates = MutableStateFlow(0)
    val recentUpdates: StateFlow<Int> = _recentUpdates.asStateFlow()

    @Synchronized
    fun getRecentlyViewed(type: String): List<String> {
        recentMemoryCache[type]?.let { return it }
        val json = prefs.getString("recent_$type", null) ?: return emptyList()
        return runCatching {
            gson.fromJson(json, Array<String>::class.java)?.toList().orEmpty()
        }.getOrDefault(emptyList()).also {
            recentMemoryCache[type] = it
        }
    }

    @Synchronized
    fun addRecentlyViewed(type: String, id: String, maxItems: Int = 40, notifyUi: Boolean = false) {
        if (id.isBlank()) return
        val list = getRecentlyViewed(type).toMutableList()
        if (list.firstOrNull() == id) return
        list.remove(id)
        list.add(0, id)
        while (list.size > maxItems) {
            list.removeAt(list.lastIndex)
        }
        val snapshot = list.toList()
        recentMemoryCache[type] = snapshot
        if (notifyUi) {
            _recentUpdates.value++
        }
        ioScope.launch(Dispatchers.IO) {
            prefs.edit().putString("recent_$type", gson.toJson(snapshot)).apply()
        }
    }

    @Synchronized
    fun clearRecentlyViewed(type: String) {
        recentMemoryCache.remove(type)
        _recentUpdates.value++
        ioScope.launch(Dispatchers.IO) {
            prefs.edit().remove("recent_$type").apply()
        }
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

    private val progressMap: MutableMap<String, PlaybackProgress> = readPlaybackProgressFromDisk().toMutableMap()
    private val _playbackProgressFlow = MutableStateFlow<Map<String, PlaybackProgress>>(progressMap.toMap())
    val playbackProgressFlow: StateFlow<Map<String, PlaybackProgress>> = _playbackProgressFlow.asStateFlow()

    private fun readPlaybackProgressFromDisk(): Map<String, PlaybackProgress> {
        val json = prefs.getString(KEY_PLAYBACK_PROGRESS, null) ?: return emptyMap()
        return runCatching {
            val entries = gson.fromJson(json, Array<PlaybackProgressEntry>::class.java).orEmpty()
            entries.filter { it.id.isNotBlank() }.associate { entry ->
                entry.id to PlaybackProgress(
                    positionMs = entry.positionMs,
                    durationMs = entry.durationMs,
                    updatedAt = entry.updatedAt,
                )
            }
        }.getOrDefault(emptyMap())
    }

    @Synchronized
    private fun snapshotProgressEntries(): Array<PlaybackProgressEntry> =
        progressMap.entries.map { (k, v) ->
            PlaybackProgressEntry(
                id = k,
                positionMs = v.positionMs,
                durationMs = v.durationMs,
                updatedAt = v.updatedAt,
            )
        }.toTypedArray()

    /**
     * Persiste el mapa de progreso en SharedPreferences:
     * - Guardado periódico (commitSync = false): serializa y ejecuta .apply() en Dispatchers.IO sin
     *   bloquear jamás el hilo principal ni forzar recomposiciones innecesarias durante el vídeo.
     * - Eventos críticos (commitSync = true, ej. onPause / onStop / onDestroy): actualiza los flujos
     *   reactivos de UI y confirma en disco con .commit().
     */
    private fun persistPlaybackProgress(commitSync: Boolean, notifyUi: Boolean) {
        val snapshotMap: Map<String, PlaybackProgress>
        val entriesSnapshot: Array<PlaybackProgressEntry>
        synchronized(this) {
            snapshotMap = progressMap.toMap()
            entriesSnapshot = snapshotProgressEntries()
        }
        if (notifyUi) {
            _playbackProgressFlow.value = snapshotMap
            _recentUpdates.value++
        }
        if (commitSync) {
            val json = gson.toJson(entriesSnapshot)
            prefs.edit().putString(KEY_PLAYBACK_PROGRESS, json).commit()
        } else {
            ioScope.launch(Dispatchers.IO) {
                val json = gson.toJson(entriesSnapshot)
                prefs.edit().putString(KEY_PLAYBACK_PROGRESS, json).apply()
            }
        }
    }

    fun savePlaybackProgress(
        id: String,
        positionMs: Long,
        durationMs: Long,
        commitSync: Boolean = true,
        notifyUi: Boolean = true,
    ) {
        val cleanId = id.trim()
        if (cleanId.isEmpty() || positionMs < 0L) return

        // Si ambos son 0L, significa reseteo explícito ("Desde el principio")
        if (positionMs == 0L && durationMs == 0L) {
            synchronized(this) {
                removeProgressKeys(cleanId)
            }
            persistPlaybackProgress(commitSync = commitSync, notifyUi = notifyUi)
            return
        }

        val shouldPersist = synchronized(this) {
            val existing = getPlaybackProgress(cleanId)
            val effectiveDuration = when {
                durationMs > 0L -> durationMs
                existing != null && existing.durationMs > 0L -> existing.durationMs
                else -> 0L
            }
            if (effectiveDuration <= 0L && positionMs <= 0L) return@synchronized false

            val rawFraction = if (effectiveDuration > 0L) {
                (positionMs.toFloat() / effectiveDuration.toFloat()).coerceIn(0f, 1f)
            } else {
                0f
            }

            // Si ya estaba completado y apenas empieza a reproducirse (< 3s), no machacar la barra llena todavía
            if (existing?.isCompleted == true && positionMs < 3_000L && rawFraction < 0.02f) {
                return@synchronized false
            }

            // Si supera el 95% (>= 0.95f), se marca como completado manteniendo la barra llena (positionMs = durationMs)
            // y PlaybackProgress.resumePositionMs devolverá 0L en futuras reproducciones.
            val finalPos = if (effectiveDuration > 0L && rawFraction >= 0.95f) effectiveDuration else positionMs
            val progress = PlaybackProgress(
                positionMs = finalPos,
                durationMs = effectiveDuration,
                updatedAt = System.currentTimeMillis(),
            )

            storeProgressUnderAliases(cleanId, progress)
            true
        }
        if (shouldPersist) {
            persistPlaybackProgress(commitSync = commitSync, notifyUi = notifyUi)
        }
    }

    private fun removeProgressKeys(cleanId: String) {
        progressMap.remove(cleanId)
        if (cleanId.startsWith("series:") && cleanId.contains(":ep:")) {
            val epId = cleanId.substringAfter(":ep:")
            progressMap.remove("episode:$epId")
            progressMap.remove("series:$epId")
            progressMap.remove(epId)
        } else if (cleanId.contains(':')) {
            val raw = cleanId.substringAfterLast(':')
            progressMap.remove("movie:$raw")
            progressMap.remove("vod:$raw")
            progressMap.remove("episode:$raw")
            progressMap.remove("series:$raw")
            progressMap.remove(raw)
        } else {
            progressMap.remove("movie:$cleanId")
            progressMap.remove("vod:$cleanId")
            progressMap.remove("episode:$cleanId")
            progressMap.remove("series:$cleanId")
        }
    }

    private fun storeProgressUnderAliases(cleanId: String, progress: PlaybackProgress) {
        progressMap[cleanId] = progress
        if (cleanId.startsWith("series:") && cleanId.contains(":ep:")) {
            val seriesId = cleanId.substringAfter("series:").substringBefore(":ep:")
            val epId = cleanId.substringAfter(":ep:")
            if (epId.isNotBlank()) {
                progressMap["episode:$epId"] = progress
                progressMap["series:$epId"] = progress
                progressMap[epId] = progress
            }
            if (seriesId.isNotBlank()) {
                progressMap["series_cover:$seriesId"] = progress
            }
        } else if (cleanId.startsWith("movie:") || cleanId.startsWith("vod:")) {
            val raw = cleanId.substringAfter(':')
            if (raw.isNotBlank()) {
                progressMap["movie:$raw"] = progress
                progressMap["vod:$raw"] = progress
                progressMap[raw] = progress
            }
        } else if (cleanId.startsWith("episode:") || cleanId.startsWith("series:")) {
            val raw = cleanId.substringAfter(':')
            if (raw.isNotBlank()) {
                progressMap["episode:$raw"] = progress
                progressMap["series:$raw"] = progress
                progressMap[raw] = progress
            }
        } else {
            progressMap["movie:$cleanId"] = progress
            progressMap["vod:$cleanId"] = progress
        }
    }

    @Synchronized
    fun getPlaybackProgress(id: String): PlaybackProgress? {
        val cleanId = id.trim()
        if (cleanId.isEmpty()) return null
        progressMap[cleanId]?.let { return it }
        if (cleanId.startsWith("series:") && cleanId.contains(":ep:")) {
            val epId = cleanId.substringAfter(":ep:")
            return progressMap["episode:$epId"] ?: progressMap["series:$epId"] ?: progressMap[epId]
        }
        val raw = cleanId.substringAfterLast(':')
        return progressMap["movie:$cleanId"]
            ?: progressMap["vod:$cleanId"]
            ?: progressMap["episode:$cleanId"]
            ?: progressMap["series:$cleanId"]
            ?: progressMap["series_cover:$cleanId"]
            ?: progressMap[raw]
    }

    companion object {
        private const val KEY_DEFAULT_TDT_SEEDED = "default_tdt_seeded_v1"
        private const val KEY_LIST = "list"
        private const val KEY_LIST_BACKUP = "list_backup"
        private const val KEY_ACTIVE = "active"
        private const val KEY_PLAYBACK_PROGRESS = "playback_progress_v1"
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

    private fun JsonObject.optString(vararg keys: String): String? {
        for (k in keys) {
            val el = get(k)
            if (el != null && !el.isJsonNull && el.isJsonPrimitive) {
                val s = runCatching { el.asString }.getOrNull()
                if (!s.isNullOrBlank()) return s
            }
        }
        return null
    }

    private fun parseVodInfoObject(infoEl: JsonElement?): VodInfo {
        if (infoEl == null || !infoEl.isJsonObject) return VodInfo()
        runCatching { gson.fromJson(infoEl, VodInfo::class.java) }.getOrNull()?.let { return it }
        val obj = infoEl.asJsonObject
        return VodInfo(
            name = obj.optString("name", "title"),
            plot = obj.optString("plot", "description"),
            cast = obj.optString("cast", "actors"),
            director = obj.optString("director"),
            genre = obj.optString("genre"),
            releaseDate = obj.optString("releasedate", "releaseDate"),
            rating = obj.optString("rating"),
            duration = obj.optString("duration"),
            image = obj.optString("movie_image", "cover_big", "cover"),
            backdrop = obj.get("backdrop_path"),
            trailer = obj.optString("youtube_trailer"),
            tmdbId = obj.optString("tmdb_id"),
        )
    }

    private fun parseVodDataObject(movieDataEl: JsonElement?, fallbackId: String): VodData {
        if (movieDataEl != null && movieDataEl.isJsonObject) {
            runCatching { gson.fromJson(movieDataEl, VodData::class.java) }.getOrNull()?.let { return it }
            val obj = movieDataEl.asJsonObject
            return VodData(
                streamId = obj.optString("stream_id") ?: fallbackId,
                name = obj.optString("name"),
                extension = obj.optString("container_extension") ?: "mp4",
            )
        }
        return VodData(streamId = fallbackId, name = null, extension = "mp4")
    }

    private fun parseSeriesDetailsObject(infoEl: JsonElement?): SeriesDetails {
        if (infoEl == null || !infoEl.isJsonObject) return SeriesDetails()
        runCatching { gson.fromJson(infoEl, SeriesDetails::class.java) }.getOrNull()?.let { return it }
        val obj = infoEl.asJsonObject
        return SeriesDetails(
            name = obj.optString("name", "title"),
            cover = obj.optString("cover", "cover_big"),
            plot = obj.optString("plot", "description"),
            cast = obj.optString("cast"),
            genre = obj.optString("genre"),
            rating = obj.optString("rating"),
            releaseDate = obj.optString("releaseDate", "releasedate"),
        )
    }

    private fun parseEpisodeInfoObject(infoEl: JsonElement?): EpisodeInfo? {
        if (infoEl == null || !infoEl.isJsonObject) return null
        runCatching { gson.fromJson(infoEl, EpisodeInfo::class.java) }.getOrNull()?.let { return it }
        val obj = infoEl.asJsonObject
        return EpisodeInfo(
            plot = obj.optString("plot", "overview"),
            duration = obj.optString("duration"),
            image = obj.optString("movie_image", "cover_big", "cover"),
        )
    }

    private fun parseSingleEpisode(epEl: JsonElement?, fallbackSeason: String? = null): Episode? {
        if (epEl == null || !epEl.isJsonObject) return null
        val obj = epEl.asJsonObject
        val id = obj.optString("id", "stream_id") ?: return null
        return Episode(
            id = id,
            episodeNum = obj.optString("episode_num", "episode"),
            title = obj.optString("title", "name"),
            extension = obj.optString("container_extension") ?: "mp4",
            season = obj.optString("season") ?: fallbackSeason,
            info = parseEpisodeInfoObject(obj.get("info")),
            directUrl = obj.optString("direct_source"),
        )
    }

    private fun parseSeasonEpisodesElement(seasonEl: JsonElement?, fallbackSeason: String? = null): List<Episode> {
        if (seasonEl == null || seasonEl.isJsonNull) return emptyList()
        val result = ArrayList<Episode>()
        if (seasonEl.isJsonArray) {
            seasonEl.asJsonArray.forEach { item: JsonElement ->
                parseSingleEpisode(item, fallbackSeason)?.let { result.add(it) }
            }
        } else if (seasonEl.isJsonObject) {
            seasonEl.asJsonObject.entrySet().forEach { entry ->
                parseSingleEpisode(entry.value, fallbackSeason)?.let { result.add(it) }
            }
        }
        return result
    }

    suspend fun vodInfo(id: String): VodInfoResponse = withContext(Dispatchers.IO) {
        if (playlist.isM3u) {
            val catalog = ensureM3uLoaded()
            catalog.vodDetails[id] ?: VodInfoResponse(
                info = VodInfo(name = "Película"),
                movieData = VodData(streamId = id, name = "Película", extension = "mp4"),
            )
        } else {
            val rootEl: JsonElement? = runCatching { api.vodInfo(u, p, id) }.getOrNull()
            val rootObj: JsonObject? = if (rootEl != null && rootEl.isJsonObject) rootEl.asJsonObject else null
            val parsedInfo = parseVodInfoObject(rootObj?.get("info"))
            val parsedMovieData = parseVodDataObject(rootObj?.get("movie_data"), id)
            VodInfoResponse(info = parsedInfo, movieData = parsedMovieData)
        }
    }

    /** Devuelve (detalles, temporada -> episodios). */
    suspend fun seriesInfo(id: String): Pair<SeriesDetails?, Map<String, List<Episode>>> =
        withContext(Dispatchers.IO) {
            if (playlist.isM3u) {
                val catalog = ensureM3uLoaded()
                return@withContext catalog.seriesDetails[id] ?: (null to emptyMap())
            }
            val rootEl: JsonElement? = runCatching { api.seriesInfo(u, p, id) }.getOrNull()
            val rootObj: JsonObject? = if (rootEl != null && rootEl.isJsonObject) rootEl.asJsonObject else null
            val parsedDetails = parseSeriesDetailsObject(rootObj?.get("info"))
            val map = linkedMapOf<String, List<Episode>>()
            val el: JsonElement? = rootObj?.get("episodes")
            if (el != null && el.isJsonObject) {
                el.asJsonObject.entrySet()
                    .sortedBy { entry -> entry.key.toIntOrNull() ?: 0 }
                    .forEach { entry ->
                        val season: String = entry.key
                        val arr: JsonElement = entry.value
                        val eps = parseSeasonEpisodesElement(arr, season)
                        if (eps.isNotEmpty()) {
                            map[season] = eps
                        }
                    }
            } else if (el != null && el.isJsonArray) {
                el.asJsonArray.forEach { seasonArr: JsonElement ->
                    if (seasonArr.isJsonArray) {
                        val eps = parseSeasonEpisodesElement(seasonArr, null)
                        eps.firstOrNull()?.let { ep: Episode ->
                            val sKey = ep.season ?: "${map.size + 1}"
                            map[sKey] = eps
                        }
                    } else if (seasonArr.isJsonObject) {
                        val singleEp = parseSingleEpisode(seasonArr, null)
                        if (singleEp != null) {
                            val sKey = singleEp.season ?: "1"
                            val list = map.getOrPut(sKey) { emptyList() }
                            map[sKey] = list + singleEp
                        } else {
                            val eps = parseSeasonEpisodesElement(seasonArr, null)
                            eps.firstOrNull()?.let { ep: Episode ->
                                val sKey = ep.season ?: "${map.size + 1}"
                                map[sKey] = eps
                            }
                        }
                    }
                }
            }
            parsedDetails to map
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
