package com.minuevaapp.tv.shared.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Label
import androidx.compose.material.icons.automirrored.filled.OpenInNew
import androidx.compose.material.icons.automirrored.filled.PlaylistPlay
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.minuevaapp.tv.shared.data.*
import com.minuevaapp.tv.shared.platform.*
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.statement.readBytes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext

/**
 * Gestor de estado compartido para iOS y iPadOS con control estricto de memoria (Kotlin/Native)
 * y sincronización automática reactiva (StateFlow + Dispatchers.IO) de listas M3U:
 * - Al arrancar la app, lanza una corrutina en Dispatchers.IO que carga primero la caché local de respaldo
 *   y después consulta la URL oficial M3U (ej. TDTChannels) en segundo plano sin bloquear la UI.
 * - Si la descarga detecta cambios respecto a la versión guardada, actualiza el almacenamiento local
 *   y emite un nuevo token en catalogRefreshVersion (StateFlow) para que la interfaz repinte el catálogo
 *   de forma transparente.
 * - Impone un límite máximo de 16 MB y 48 entradas en el caché LRU de imágenes en RAM.
 */
class SharedAppState {
    companion object {
        private const val MAX_IMAGE_CACHE_ENTRIES = 48
        private const val MAX_IMAGE_CACHE_BYTES = 16 * 1024 * 1024 // 16 MB límite estricto en RAM
    }

    private data class CachedImageEntry(
        val image: ImageBitmap,
        val sizeInBytes: Int
    )

    val store: PlaylistStore = PlaylistStore()
    val httpClient: HttpClient by lazy { createPlatformHttpClient() }

    private val backgroundScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private var activeSyncJob: Job? = null

    private val _m3uSyncState = MutableStateFlow(M3uSyncState())
    val m3uSyncState: StateFlow<M3uSyncState> = _m3uSyncState.asStateFlow()

    private val _catalogRefreshVersion = MutableStateFlow(0L)
    val catalogRefreshVersion: StateFlow<Long> = _catalogRefreshVersion.asStateFlow()

    private val cacheMutex = Mutex()
    private val imageCache: MutableMap<String, CachedImageEntry> = linkedMapOf()
    private var currentCacheBytes: Int = 0

    private var currentRepoPlaylist: Playlist? = null
    private var currentRepo: XtreamRepository? = null

    init {
        startBackgroundM3uSync()
    }

    fun repo(): XtreamRepository {
        val active = store.active()
        val cached = currentRepo
        if (cached != null && currentRepoPlaylist == active) return cached
        return XtreamRepository(active, httpClient).also {
            currentRepoPlaylist = active
            currentRepo = it
        }
    }

    fun createRepo(playlist: Playlist): XtreamRepository =
        XtreamRepository(playlist, httpClient)

    fun invalidateRepo() {
        currentRepoPlaylist = null
        currentRepo = null
        clearImageCache()
        startBackgroundM3uSync()
    }

    /**
     * Rutina de inicialización y actualización automática en segundo plano (Dispatchers.IO):
     * 1. Pre-carga inmediatamente la última lista M3U guardada en almacenamiento local (fallback offline).
     * 2. Consulta la URL oficial de la lista M3U (ej. TDTChannels) en segundo plano sin bloquear la UI.
     * 3. Si detecta cambios en la nueva descarga, actualiza el StateFlow global (catalogRefreshVersion
     *    y m3uSyncState) para que las pantallas abiertas repinten los canales de forma transparente.
     */
    fun startBackgroundM3uSync(targetPlaylist: Playlist = store.active()) {
        activeSyncJob?.cancel()
        activeSyncJob = backgroundScope.launch(Dispatchers.IO) {
            // Si la lista activa no es la oficial de TDTChannels, mantenemos también actualizado el respaldo local de TDTChannels
            if (!targetPlaylist.effectiveM3uUrl.equals(PlaylistStore.DEFAULT_TDT_URL, ignoreCase = true)) {
                launch(Dispatchers.IO) {
                    runCatching {
                        val tdtText = M3uParser.fetchRawText(PlaylistStore.DEFAULT_TDT_URL, httpClient)
                        val tdtKey = M3uParser.cacheKeyForUrl(PlaylistStore.DEFAULT_TDT_URL)
                        val prevTdt = PlatformStorage.loadCachedM3u(tdtKey)
                        if (prevTdt == null ||
                            M3uParser.computeContentSignature(prevTdt) != M3uParser.computeContentSignature(tdtText)
                        ) {
                            PlatformStorage.saveCachedM3u(tdtKey, tdtText)
                        }
                    }
                }
            }

            if (!targetPlaylist.isM3u) {
                _m3uSyncState.value = M3uSyncState(
                    status = SyncStatus.IDLE,
                    playlistName = targetPlaylist.name
                )
                return@launch
            }

            val activeRepo = repo()
            val url = targetPlaylist.effectiveM3uUrl

            _m3uSyncState.value = _m3uSyncState.value.copy(
                status = SyncStatus.SYNCING,
                playlistName = targetPlaylist.name,
                playlistUrl = url,
                message = "Sincronizando lista M3U en segundo plano..."
            )

            // Paso 1: Cargar inmediatamente el respaldo local si existe para respuesta instantánea o modo sin conexión
            val cachedCatalog = runCatching { activeRepo.preloadM3uFromCache() }.getOrNull()
            if (cachedCatalog != null) {
                val nextToken = _catalogRefreshVersion.value + 1L
                _catalogRefreshVersion.value = nextToken
                _m3uSyncState.value = M3uSyncState(
                    status = SyncStatus.SYNCING,
                    playlistName = targetPlaylist.name,
                    playlistUrl = url,
                    channelCount = cachedCatalog.liveStreams.size,
                    versionToken = nextToken,
                    contentSignature = cachedCatalog.contentSignature,
                    isFromLocalCache = true,
                    message = "Caché local activa (${cachedCatalog.liveStreams.size} canales) · Verificando actualizaciones..."
                )
            }

            // Paso 2: Consultar la URL oficial remota en Dispatchers.IO y detectar cambios
            runCatching {
                activeRepo.syncM3uWithRemote()
            }.onSuccess { outcome ->
                val count = outcome.catalog.liveStreams.size
                if (outcome.usedLocalFallback) {
                    val nextToken = _catalogRefreshVersion.value + 1L
                    _catalogRefreshVersion.value = nextToken
                    _m3uSyncState.value = M3uSyncState(
                        status = SyncStatus.OFFLINE_FALLBACK,
                        playlistName = targetPlaylist.name,
                        playlistUrl = url,
                        channelCount = count,
                        versionToken = nextToken,
                        contentSignature = outcome.catalog.contentSignature,
                        isFromLocalCache = true,
                        message = "Modo sin conexión: respaldo local cargado ($count canales)"
                    )
                } else if (outcome.changed) {
                    val nextToken = _catalogRefreshVersion.value + 1L
                    _catalogRefreshVersion.value = nextToken
                    _m3uSyncState.value = M3uSyncState(
                        status = SyncStatus.UPDATED,
                        playlistName = targetPlaylist.name,
                        playlistUrl = url,
                        channelCount = count,
                        versionToken = nextToken,
                        contentSignature = outcome.catalog.contentSignature,
                        isFromLocalCache = false,
                        message = "Catálogo actualizado ($count canales)"
                    )
                } else {
                    _m3uSyncState.value = M3uSyncState(
                        status = SyncStatus.UP_TO_DATE,
                        playlistName = targetPlaylist.name,
                        playlistUrl = url,
                        channelCount = count,
                        versionToken = _catalogRefreshVersion.value,
                        contentSignature = outcome.catalog.contentSignature,
                        isFromLocalCache = false,
                        message = "Lista M3U al día ($count canales)"
                    )
                }
            }.onFailure { err ->
                if (cachedCatalog != null) {
                    _m3uSyncState.value = M3uSyncState(
                        status = SyncStatus.OFFLINE_FALLBACK,
                        playlistName = targetPlaylist.name,
                        playlistUrl = url,
                        channelCount = cachedCatalog.liveStreams.size,
                        versionToken = _catalogRefreshVersion.value,
                        contentSignature = cachedCatalog.contentSignature,
                        isFromLocalCache = true,
                        message = "Sin conexión al servidor · Usando respaldo local (${cachedCatalog.liveStreams.size} canales)"
                    )
                } else {
                    _m3uSyncState.value = M3uSyncState(
                        status = SyncStatus.OFFLINE_FALLBACK,
                        playlistName = targetPlaylist.name,
                        playlistUrl = url,
                        isFromLocalCache = false,
                        message = XtreamRepository.sanitizeError(err, targetPlaylist)
                    )
                }
            }
        }
    }

    fun clearImageCache() {
        imageCache.clear()
        currentCacheBytes = 0
        trimPlatformMemory()
    }

    suspend fun loadImage(url: String, maxDimension: Int = 280): ImageBitmap? {
        val clean = url.trim()
        if (clean.isEmpty()) return null

        cacheMutex.withLock {
            val existing: CachedImageEntry? = imageCache.remove(clean)
            if (existing != null) {
                imageCache[clean] = existing
                return existing.image
            }
        }

        return withContext(Dispatchers.Default) {
            runCatching {
                val bytes = httpClient.get(clean) {
                    header("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 17_5 like Mac OS X; XaviTV/1.1)")
                }.readBytes()
                if (bytes.isEmpty() || bytes.size > 4 * 1024 * 1024) return@runCatching null

                val decodedImage = decodeImageBytes(bytes, maxDimension) ?: return@runCatching null
                val estimatedBytes = (decodedImage.width * decodedImage.height * 4).coerceAtLeast(1024)

                cacheMutex.withLock {
                    var evictedAny = false
                    while (
                        imageCache.isNotEmpty() &&
                        (imageCache.size >= MAX_IMAGE_CACHE_ENTRIES ||
                            currentCacheBytes + estimatedBytes > MAX_IMAGE_CACHE_BYTES)
                    ) {
                        val oldestKey: String = imageCache.keys.firstOrNull() ?: break
                        val removed: CachedImageEntry? = imageCache.remove(oldestKey)
                        if (removed != null) {
                            currentCacheBytes = (currentCacheBytes - removed.sizeInBytes).coerceAtLeast(0)
                            evictedAny = true
                        }
                    }
                    imageCache[clean] = CachedImageEntry(decodedImage, estimatedBytes)
                    currentCacheBytes += estimatedBytes
                    if (evictedAny && imageCache.size % 12 == 0) {
                        trimPlatformMemory()
                    }
                }
                decodedImage
            }.getOrNull()
        }
    }
}

val LocalSharedAppState = staticCompositionLocalOf<SharedAppState> {
    error("SharedAppState no inicializado")
}

sealed class IosScreen {
    data object Playlists : IosScreen()
    data object Home : IosScreen()
    data class Catalog(val kind: CatalogKind) : IosScreen()
    data class MovieDetail(val movie: VodStream) : IosScreen()
    data class SeriesDetail(val series: Series) : IosScreen()
    data object Search : IosScreen()
    data class Player(
        val url: String,
        val title: String,
        val subtitle: String = "",
        val isLive: Boolean = true,
        val resumeKey: String = ""
    ) : IosScreen()
}

enum class CatalogKind { LIVE, MOVIES, SERIES, FAVORITES }

@Composable
fun IosXaviTVApp() {
    val appState = remember { SharedAppState() }
    val stack = remember {
        mutableStateListOf<IosScreen>(
            if (appState.store.all().isNotEmpty()) IosScreen.Home else IosScreen.Playlists
        )
    }

    fun navigate(screen: IosScreen) {
        stack.add(screen)
    }

    fun popBack() {
        if (stack.size > 1) {
            stack.removeAt(stack.lastIndex)
        }
    }

    CompositionLocalProvider(LocalSharedAppState provides appState) {
        XaviTVTheme {
            when (val current = stack.last()) {
                is IosScreen.Playlists -> IosPlaylistsScreen(
                    onConnected = {
                        stack.clear()
                        stack.add(IosScreen.Home)
                    }
                )
                is IosScreen.Home -> IosHomeScreen(
                    onOpenLive = { navigate(IosScreen.Catalog(CatalogKind.LIVE)) },
                    onOpenMovies = { navigate(IosScreen.Catalog(CatalogKind.MOVIES)) },
                    onOpenSeries = { navigate(IosScreen.Catalog(CatalogKind.SERIES)) },
                    onOpenFavorites = { navigate(IosScreen.Catalog(CatalogKind.FAVORITES)) },
                    onOpenSearch = { navigate(IosScreen.Search) },
                    onOpenPlaylists = { navigate(IosScreen.Playlists) }
                )
                is IosScreen.Catalog -> IosCatalogScreen(
                    kind = current.kind,
                    onBack = { popBack() },
                    onPlayStream = { url, title, subtitle, isLive, resumeKey ->
                        navigate(
                            IosScreen.Player(
                                url = url,
                                title = title,
                                subtitle = subtitle,
                                isLive = isLive,
                                resumeKey = resumeKey
                            )
                        )
                    },
                    onOpenMovie = { navigate(IosScreen.MovieDetail(it)) },
                    onOpenSeries = { navigate(IosScreen.SeriesDetail(it)) }
                )
                is IosScreen.MovieDetail -> IosMovieDetailScreen(
                    movie = current.movie,
                    onBack = { popBack() },
                    onPlay = { url, title, resumeKey ->
                        navigate(
                            IosScreen.Player(
                                url = url,
                                title = title,
                                subtitle = "Película",
                                isLive = false,
                                resumeKey = resumeKey
                            )
                        )
                    }
                )
                is IosScreen.SeriesDetail -> IosSeriesDetailScreen(
                    series = current.series,
                    onBack = { popBack() },
                    onPlayEpisode = { url, title, subtitle, resumeKey ->
                        navigate(
                            IosScreen.Player(
                                url = url,
                                title = title,
                                subtitle = subtitle,
                                isLive = false,
                                resumeKey = resumeKey
                            )
                        )
                    }
                )
                is IosScreen.Search -> IosSearchScreen(
                    onBack = { popBack() },
                    onPlayLive = { ch, url ->
                        navigate(
                            IosScreen.Player(
                                url = url,
                                title = ch.name ?: "Canal",
                                subtitle = "TV en directo",
                                isLive = true
                            )
                        )
                    },
                    onOpenMovie = { navigate(IosScreen.MovieDetail(it)) },
                    onOpenSeries = { navigate(IosScreen.SeriesDetail(it)) }
                )
                is IosScreen.Player -> NativeVideoPlayer(
                    url = current.url,
                    title = current.title,
                    subtitle = current.subtitle,
                    isLive = current.isLive,
                    resumeKey = current.resumeKey,
                    initialPositionMs = if (current.isLive || current.resumeKey.isEmpty()) 0L
                    else appState.store.getResumePosition(current.resumeKey),
                    onSavePosition = { posMs ->
                        if (!current.isLive && current.resumeKey.isNotEmpty() && posMs > 5_000L) {
                            appState.store.saveResumePosition(current.resumeKey, posMs)
                        }
                    },
                    onClose = { popBack() }
                )
            }
        }
    }
}

/**
 * Scaffold universal adaptado a las Safe Areas de iOS e iPadOS (Notch, Isla Dinámica, barra Home y multitarea).
 * Extiende los colores corporativos verde bético oscuro (#0B1F15) y carbón (#0E1410) de borde a borde
 * aplicando WindowInsets.safeDrawing únicamente al contenido interactivo.
 */
@Composable
fun IosAppScaffold(
    title: String,
    subtitle: String? = null,
    onBack: (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
    content: @Composable BoxScope.() -> Unit
) {
    Column(
        Modifier
            .fillMaxSize()
            .background(BgDeepCharcoal)
    ) {
        // Cabecera superior extendida detrás del Notch / Isla Dinámica con color verde oscuro corporativo
        Surface(
            color = Color(0xFF0B1F15),
            tonalElevation = 6.dp,
            border = BorderStroke(1.dp, GoldPrimary.copy(alpha = 0.28f))
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .windowInsetsPadding(
                        WindowInsets.safeDrawing.only(WindowInsetsSides.Top + WindowInsetsSides.Horizontal)
                    )
                    .padding(horizontal = 16.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (onBack != null) {
                    IconButton(
                        onClick = onBack,
                        modifier = Modifier
                            .size(38.dp)
                            .clip(CircleShape)
                            .background(BetisGreenPrimary)
                            .border(1.dp, GoldAccent, CircleShape)
                    ) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver",
                            tint = GoldChampagne
                        )
                    }
                    Spacer(Modifier.width(12.dp))
                } else {
                    Box(
                        Modifier
                            .size(36.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Brush.linearGradient(listOf(BetisGreenPrimary, BetisGreenLeaf)))
                            .border(1.5.dp, GoldAccent, RoundedCornerShape(10.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            Icons.Default.LiveTv,
                            contentDescription = "XaviTV",
                            tint = GoldChampagne,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                    Spacer(Modifier.width(10.dp))
                }

                Column(Modifier.weight(1f)) {
                    Text(
                        text = title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = TextPureWhite,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    if (!subtitle.isNullOrBlank()) {
                        Text(
                            text = subtitle,
                            fontSize = 11.sp,
                            color = GoldChampagne,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    content = actions
                )
            }
        }

        // Cuerpo principal respetando los márgenes seguros inferiores y laterales (Home Indicator y bordes curvos)
        Box(
            Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(
                            BetisGreenDark.copy(alpha = 0.42f),
                            BgDeepCharcoal,
                            BgDeepCharcoal
                        )
                    )
                )
                .windowInsetsPadding(
                    WindowInsets.safeDrawing.only(WindowInsetsSides.Bottom + WindowInsetsSides.Horizontal)
                ),
            content = content
        )
    }
}

@Composable
fun IosGoldOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        singleLine = true,
        visualTransformation = visualTransformation,
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = GoldLight,
            unfocusedBorderColor = GoldPrimary.copy(alpha = 0.35f),
            focusedLabelColor = GoldLight,
            unfocusedLabelColor = TextSecondaryGray,
            cursorColor = GoldLight,
            focusedTextColor = TextPrimaryWhite,
            unfocusedTextColor = TextPrimaryWhite,
            focusedContainerColor = DarkSurface,
            unfocusedContainerColor = DarkSurface.copy(alpha = 0.85f),
            focusedLeadingIconColor = GoldLight,
            unfocusedLeadingIconColor = TextSecondaryGray
        ),
        modifier = modifier
    )
}

@Composable
fun IosNetworkImage(
    url: String?,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop,
    maxDimension: Int = 260
) {
    val appState = LocalSharedAppState.current
    val cleanUrl = url?.trim().orEmpty()
    var loadedImage by remember(cleanUrl) { mutableStateOf<ImageBitmap?>(null) }
    var failed by remember(cleanUrl) { mutableStateOf(false) }

    LaunchedEffect(cleanUrl) {
        if (cleanUrl.isEmpty()) {
            failed = true
            return@LaunchedEffect
        }
        failed = false
        val loaded = appState.loadImage(cleanUrl, maxDimension = maxDimension)
        if (loaded != null) {
            loadedImage = loaded
        } else {
            failed = true
        }
    }

    Box(
        modifier = modifier.background(DarkSurfaceVariant),
        contentAlignment = Alignment.Center
    ) {
        val currentImage = loadedImage
        if (currentImage != null) {
            Image(
                bitmap = currentImage,
                contentDescription = contentDescription,
                contentScale = contentScale,
                modifier = Modifier.fillMaxSize()
            )
        } else if (failed) {
            Icon(
                Icons.Default.BrokenImage,
                contentDescription = contentDescription,
                tint = GoldAccent.copy(alpha = 0.45f),
                modifier = Modifier.size(26.dp)
            )
        } else {
            Icon(
                Icons.Default.Tv,
                contentDescription = contentDescription,
                tint = GoldAccent.copy(alpha = 0.45f),
                modifier = Modifier.size(26.dp)
            )
        }
    }
}

@Composable
fun IosPosterCard(
    title: String?,
    image: String?,
    subtitle: String? = null,
    isFavorite: Boolean = false,
    modifier: Modifier = Modifier.width(138.dp),
    onClick: () -> Unit
) {
    val shape = RoundedCornerShape(12.dp)
    Column(
        modifier
            .clip(shape)
            .background(DarkSurface)
            .border(
                width = 1.dp,
                color = if (isFavorite) GoldAccent else GoldPrimary.copy(alpha = 0.25f),
                shape = shape
            )
            .clickable(onClick = onClick)
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .aspectRatio(2f / 3f)
        ) {
            IosNetworkImage(
                url = image,
                contentDescription = title,
                contentScale = ContentScale.Crop,
                maxDimension = 280,
                modifier = Modifier.fillMaxSize()
            )
            if (isFavorite) {
                Box(
                    Modifier
                        .align(Alignment.TopEnd)
                        .padding(6.dp)
                        .size(24.dp)
                        .background(DarkBackground.copy(alpha = 0.85f), CircleShape)
                        .border(1.dp, GoldLight, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        Icons.Default.Star,
                        contentDescription = "Favorito",
                        tint = GoldLight,
                        modifier = Modifier.size(14.dp)
                    )
                }
            }
            if (!subtitle.isNullOrBlank()) {
                Box(
                    Modifier
                        .align(Alignment.BottomStart)
                        .padding(6.dp)
                        .background(BetisGreenDark.copy(alpha = 0.92f), RoundedCornerShape(6.dp))
                        .border(0.8.dp, GoldPrimary.copy(alpha = 0.6f), RoundedCornerShape(6.dp))
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = subtitle,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 10.sp,
                        color = GoldLight,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
        Text(
            text = title?.ifBlank { "Sin título" } ?: "Sin título",
            maxLines = 2,
            minLines = 2,
            overflow = TextOverflow.Ellipsis,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = TextPrimaryWhite,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp)
        )
    }
}

// ─── 1. GESTOR DE LISTAS (Diseño Dual-Pane en iPad / Columna en iPhone) ──
@Composable
fun IosPlaylistsScreen(onConnected: () -> Unit) {
    val appState = LocalSharedAppState.current
    val store = remember { appState.store }
    var saved by remember { mutableStateOf(store.all()) }
    var activeName by remember { mutableStateOf(store.activeName) }

    var editingOriginal by remember { mutableStateOf<Playlist?>(null) }
    var selectedType by remember { mutableStateOf(Playlist.TYPE_XTREAM) }

    var name by remember { mutableStateOf("") }
    var host by remember { mutableStateOf("") }
    var user by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }
    var m3uUrl by remember { mutableStateOf("") }

    var showPassword by remember { mutableStateOf(false) }
    var loading by remember { mutableStateOf(false) }
    var error by remember { mutableStateOf<String?>(null) }
    val scope = rememberCoroutineScope()

    fun resetFormFields() {
        editingOriginal = null
        name = ""
        host = ""
        user = ""
        pass = ""
        m3uUrl = ""
        showPassword = false
        error = null
    }

    fun loadPlaylistIntoForm(pl: Playlist) {
        editingOriginal = pl
        error = null
        if (pl.isM3u) {
            selectedType = Playlist.TYPE_M3U
            name = pl.name
            m3uUrl = pl.effectiveM3uUrl
            host = ""
            user = ""
            pass = ""
        } else {
            selectedType = Playlist.TYPE_XTREAM
            name = pl.name
            host = pl.serverUrl
            user = pl.username
            pass = pl.password
            m3uUrl = ""
        }
    }

    fun connectAndSave(p: Playlist, originalToUpdate: Playlist? = null, clearFormOnSuccess: Boolean = false) {
        loading = true
        error = null
        scope.launch {
            runCatching {
                appState.createRepo(p).login()
            }.onSuccess { resp ->
                val authOk = p.isM3u ||
                    resp.userInfo?.status.equals("Active", ignoreCase = true) ||
                    resp.userInfo?.auth?.toString()?.contains("1") == true
                if (!authOk) {
                    error = "Cuenta no activa (${resp.userInfo?.status ?: "Sin autorización"})"
                    loading = false
                } else {
                    if (originalToUpdate != null) {
                        store.update(originalToUpdate, p)
                    } else {
                        store.add(p)
                    }
                    store.activeName = p.name
                    appState.invalidateRepo()
                    saved = store.all()
                    activeName = store.activeName
                    if (clearFormOnSuccess) {
                        resetFormFields()
                    }
                    loading = false
                    onConnected()
                }
            }.onFailure { e ->
                error = XtreamRepository.sanitizeError(e, p)
                loading = false
            }
        }
    }

    @Composable
    fun PlaylistItemRow(pl: Playlist) {
        val isCurrent = activeName == pl.name
        val isBeingEdited = editingOriginal?.name == pl.name &&
            editingOriginal?.playlistType == pl.playlistType
        Row(
            Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(14.dp))
                .background(
                    when {
                        isBeingEdited -> BetisGreenLeaf.copy(alpha = 0.42f)
                        isCurrent -> BetisGreenPrimary.copy(alpha = 0.55f)
                        else -> BgCardSurface
                    }
                )
                .border(
                    width = if (isCurrent || isBeingEdited) 1.5.dp else 1.dp,
                    color = if (isCurrent || isBeingEdited) GoldAccent else BetisGreenLeaf.copy(alpha = 0.35f),
                    shape = RoundedCornerShape(14.dp)
                )
                .clickable {
                    store.activeName = pl.name
                    appState.invalidateRepo()
                    activeName = pl.name
                    onConnected()
                }
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                Modifier
                    .size(38.dp)
                    .clip(CircleShape)
                    .background(if (isCurrent) GoldAccent else BetisGreenPrimary),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    if (pl.isM3u) Icons.AutoMirrored.Filled.PlaylistPlay else Icons.Default.Tv,
                    contentDescription = null,
                    tint = if (isCurrent) BgDeepCharcoal else GoldChampagne,
                    modifier = Modifier.size(20.dp)
                )
            }
            Spacer(Modifier.width(12.dp))
            Column(Modifier.weight(1f)) {
                Text(
                    pl.name,
                    fontWeight = FontWeight.Bold,
                    color = TextPureWhite,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    if (pl.isM3u) pl.effectiveM3uUrl else "${pl.username} · ${pl.serverUrl}",
                    fontSize = 12.sp,
                    color = if (isCurrent) GoldChampagne else TextSilverGray,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            IconButton(onClick = { loadPlaylistIntoForm(pl) }) {
                Icon(
                    Icons.Default.Edit,
                    contentDescription = "Editar",
                    tint = GoldChampagne
                )
            }
            IconButton(
                onClick = {
                    if (editingOriginal?.name == pl.name) resetFormFields()
                    store.remove(pl)
                    appState.invalidateRepo()
                    saved = store.all()
                    activeName = store.activeName
                }
            ) {
                Icon(
                    Icons.Default.Delete,
                    contentDescription = "Eliminar",
                    tint = TextSilverGray
                )
            }
        }
    }

    @Composable
    fun PlaylistEditorCard(modifier: Modifier = Modifier) {
        Surface(
            shape = RoundedCornerShape(18.dp),
            color = BgCardSurface,
            border = BorderStroke(1.5.dp, GoldAccent.copy(alpha = 0.65f)),
            modifier = modifier.fillMaxWidth()
        ) {
            Column(Modifier.padding(18.dp)) {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        if (editingOriginal != null) "Editar lista" else "Añadir nueva lista",
                        fontWeight = FontWeight.Bold,
                        fontSize = 17.sp,
                        color = TextPureWhite
                    )
                    if (editingOriginal != null) {
                        TextButton(onClick = { resetFormFields() }) {
                            Text("Cancelar", color = GoldChampagne)
                        }
                    }
                }

                Spacer(Modifier.height(10.dp))

                Row(
                    Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .background(BgDeepCharcoal)
                        .padding(4.dp),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    val isXtream = selectedType == Playlist.TYPE_XTREAM
                    Box(
                        Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(8.dp))
                            .background(if (isXtream) GoldAccent else Color.Transparent)
                            .clickable { selectedType = Playlist.TYPE_XTREAM }
                            .padding(vertical = 10.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "Xtream Codes",
                            fontWeight = FontWeight.Bold,
                            color = if (isXtream) BgDeepCharcoal else TextPureWhite
                        )
                    }
                    val isM3u = selectedType == Playlist.TYPE_M3U
                    Box(
                        Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(8.dp))
                            .background(if (isM3u) GoldAccent else Color.Transparent)
                            .clickable { selectedType = Playlist.TYPE_M3U }
                            .padding(vertical = 10.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            "Lista M3U",
                            fontWeight = FontWeight.Bold,
                            color = if (isM3u) BgDeepCharcoal else TextPureWhite
                        )
                    }
                }

                Spacer(Modifier.height(12.dp))

                IosGoldOutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = "Nombre identificativo",
                    leadingIcon = { Icon(Icons.AutoMirrored.Filled.Label, contentDescription = null) },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(10.dp))

                if (selectedType == Playlist.TYPE_XTREAM) {
                    IosGoldOutlinedTextField(
                        value = host,
                        onValueChange = { host = it },
                        label = "URL del servidor (http://servidor:puerto)",
                        leadingIcon = { Icon(Icons.Default.Language, contentDescription = null) },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(Modifier.height(10.dp))
                    IosGoldOutlinedTextField(
                        value = user,
                        onValueChange = { user = it },
                        label = "Usuario",
                        leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(Modifier.height(10.dp))
                    IosGoldOutlinedTextField(
                        value = pass,
                        onValueChange = { pass = it },
                        label = "Contraseña",
                        leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
                        trailingIcon = {
                            IconButton(onClick = { showPassword = !showPassword }) {
                                Icon(
                                    if (showPassword) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                                    contentDescription = null
                                )
                            }
                        },
                        visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth()
                    )
                } else {
                    IosGoldOutlinedTextField(
                        value = m3uUrl,
                        onValueChange = { m3uUrl = it },
                        label = "URL de la lista (.m3u o .m3u8)",
                        leadingIcon = { Icon(Icons.Default.Link, contentDescription = null) },
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                error?.let {
                    Spacer(Modifier.height(10.dp))
                    Text(it, color = ErrorCrimson, fontSize = 12.sp)
                }

                Spacer(Modifier.height(14.dp))

                val isFormValid = if (selectedType == Playlist.TYPE_XTREAM) {
                    host.isNotBlank() && user.isNotBlank() && pass.isNotBlank()
                } else {
                    m3uUrl.isNotBlank()
                }

                Button(
                    onClick = {
                        val newPlaylist = if (selectedType == Playlist.TYPE_XTREAM) {
                            val normalizedHost = host.trim().let {
                                if (!it.startsWith("http://", true) && !it.startsWith("https://", true)) "http://$it" else it
                            }.trimEnd('/')
                            Playlist(
                                name = name.trim().ifBlank { "Servidor Xtream" },
                                serverUrl = normalizedHost,
                                username = user.trim(),
                                password = pass.trim(),
                                type = Playlist.TYPE_XTREAM,
                                m3uUrl = ""
                            )
                        } else {
                            val cleanUrl = m3uUrl.trim()
                            Playlist(
                                name = name.trim().ifBlank { "Lista M3U" },
                                serverUrl = cleanUrl,
                                type = Playlist.TYPE_M3U,
                                m3uUrl = cleanUrl
                            )
                        }
                        connectAndSave(
                            p = newPlaylist,
                            originalToUpdate = editingOriginal,
                            clearFormOnSuccess = true
                        )
                    },
                    enabled = !loading && isFormValid,
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = GoldAccent,
                        contentColor = BgDeepCharcoal
                    ),
                    modifier = Modifier.fillMaxWidth().height(48.dp)
                ) {
                    Text(
                        if (editingOriginal != null) "Actualizar lista" else "Guardar y conectar",
                        fontWeight = FontWeight.ExtraBold
                    )
                }
            }
        }
    }

    IosAppScaffold(
        title = "XaviTV · iOS / iPadOS",
        subtitle = "Gestión de listas Xtream Codes y M3U"
    ) {
        BoxWithConstraints(Modifier.fillMaxSize()) {
            val isTablet = maxWidth >= 700.dp
            if (isTablet) {
                // Diseño de doble panel (Dual-Pane) para iPad y pantallas horizontales grandes
                Row(
                    Modifier
                        .fillMaxSize()
                        .padding(22.dp),
                    horizontalArrangement = Arrangement.spacedBy(22.dp)
                ) {
                    Column(Modifier.weight(1f).fillMaxHeight()) {
                        Text(
                            "Listas guardadas",
                            fontWeight = FontWeight.Bold,
                            fontSize = 17.sp,
                            color = GoldChampagne
                        )
                        Spacer(Modifier.height(12.dp))
                        LazyColumn(
                            verticalArrangement = Arrangement.spacedBy(10.dp),
                            modifier = Modifier.fillMaxSize()
                        ) {
                            items(saved, key = { "${it.playlistType}:${it.name}" }) { pl ->
                                PlaylistItemRow(pl)
                            }
                        }
                    }
                    Box(
                        Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .verticalScroll(rememberScrollState())
                    ) {
                        PlaylistEditorCard()
                    }
                }
            } else {
                // Diseño compacto de una columna para iPhone vertical
                LazyColumn(
                    Modifier.fillMaxSize().padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    item {
                        Text(
                            "Listas guardadas",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = GoldChampagne
                        )
                    }
                    items(saved, key = { "${it.playlistType}:${it.name}" }) { pl ->
                        PlaylistItemRow(pl)
                    }
                    item {
                        PlaylistEditorCard()
                    }
                }
            }
        }
    }
}

// ─── 2. PANTALLA PRINCIPAL (Responsive iPhone & iPad Multi-Columna) ───
@Composable
fun IosHomeScreen(
    onOpenLive: () -> Unit,
    onOpenMovies: () -> Unit,
    onOpenSeries: () -> Unit,
    onOpenFavorites: () -> Unit,
    onOpenSearch: () -> Unit,
    onOpenPlaylists: () -> Unit
) {
    val appState = LocalSharedAppState.current
    val active = remember { appState.store.active() }
    val syncState by appState.m3uSyncState.collectAsState()

    val homeSubtitle = remember(active, syncState) {
        if (active.isM3u) {
            val statusDetail = syncState.message?.takeIf { it.isNotBlank() } ?: "M3U"
            "${active.name} · $statusDetail"
        } else {
            "${active.name} · ${active.username}"
        }
    }

    IosAppScaffold(
        title = "XaviTV",
        subtitle = homeSubtitle,
        actions = {
            if (active.isM3u) {
                IconButton(onClick = { appState.startBackgroundM3uSync(active) }) {
                    Icon(
                        imageVector = when (syncState.status) {
                            SyncStatus.OFFLINE_FALLBACK -> Icons.Default.CloudOff
                            SyncStatus.UPDATED, SyncStatus.UP_TO_DATE -> Icons.Default.CloudDone
                            else -> Icons.Default.Sync
                        },
                        contentDescription = "Sincronizar M3U",
                        tint = if (syncState.status == SyncStatus.OFFLINE_FALLBACK) GoldAccent else GoldChampagne
                    )
                }
            }
            IconButton(onClick = onOpenSearch) {
                Icon(Icons.Default.Search, contentDescription = "Buscar", tint = GoldChampagne)
            }
            IconButton(onClick = onOpenPlaylists) {
                Icon(Icons.Default.SwitchAccount, contentDescription = "Listas", tint = GoldChampagne)
            }
        }
    ) {
        BoxWithConstraints(Modifier.fillMaxSize()) {
            val isTablet = maxWidth >= 700.dp
            if (isTablet) {
                // Diseño expandido para iPad: 3 grandes bloques en paralelo + fila de accesos rápidos
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        horizontalArrangement = Arrangement.spacedBy(18.dp)
                    ) {
                        IosTabletHeroTile(
                            title = "TV en directo",
                            subtitle = "Canales TDT e IPTV con AVPlayer, PiP y zapping rápido",
                            badge = "LIVE TV",
                            icon = Icons.Default.LiveTv,
                            onClick = onOpenLive,
                            modifier = Modifier.weight(1f).fillMaxHeight()
                        )
                        IosTabletHeroTile(
                            title = "Películas",
                            subtitle = "Catálogo de cine VOD bajo demanda en alta definición",
                            badge = "CINE & VOD",
                            icon = Icons.Default.Movie,
                            onClick = onOpenMovies,
                            modifier = Modifier.weight(1f).fillMaxHeight()
                        )
                        IosTabletHeroTile(
                            title = "Series",
                            subtitle = "Temporadas completas organizadas por episodios",
                            badge = "SERIES",
                            icon = Icons.Default.VideoLibrary,
                            onClick = onOpenSeries,
                            modifier = Modifier.weight(1f).fillMaxHeight()
                        )
                    }
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        OutlinedButton(
                            onClick = onOpenFavorites,
                            border = BorderStroke(1.dp, GoldAccent),
                            shape = RoundedCornerShape(14.dp),
                            colors = ButtonDefaults.outlinedButtonColors(contentColor = GoldChampagne),
                            modifier = Modifier.weight(1f).height(54.dp)
                        ) {
                            Icon(Icons.Default.Star, contentDescription = null, tint = GoldAccent)
                            Spacer(Modifier.width(8.dp))
                            Text("Mis Favoritos", fontWeight = FontWeight.Bold)
                        }
                        OutlinedButton(
                            onClick = onOpenSearch,
                            border = BorderStroke(1.dp, BetisGreenLeaf),
                            shape = RoundedCornerShape(14.dp),
                            colors = ButtonDefaults.outlinedButtonColors(contentColor = TextPureWhite),
                            modifier = Modifier.weight(1f).height(54.dp)
                        ) {
                            Icon(Icons.Default.Search, contentDescription = null, tint = GoldChampagne)
                            Spacer(Modifier.width(8.dp))
                            Text("Búsqueda Global", fontWeight = FontWeight.Bold)
                        }
                        OutlinedButton(
                            onClick = onOpenPlaylists,
                            border = BorderStroke(1.dp, GoldPrimary.copy(alpha = 0.6f)),
                            shape = RoundedCornerShape(14.dp),
                            colors = ButtonDefaults.outlinedButtonColors(contentColor = TextPureWhite),
                            modifier = Modifier.weight(1f).height(54.dp)
                        ) {
                            Icon(Icons.AutoMirrored.Filled.PlaylistPlay, contentDescription = null, tint = GoldChampagne)
                            Spacer(Modifier.width(8.dp))
                            Text("Gestionar Listas", fontWeight = FontWeight.Bold)
                        }
                    }
                }
            } else {
                // Diseño vertical para iPhone
                LazyColumn(
                    Modifier.fillMaxSize().padding(18.dp),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    item {
                        IosHomeCard(
                            title = "TV en directo",
                            subtitle = "Canales TDT e IPTV con reproductor nativo AVPlayer y PiP",
                            badge = "LIVE TV",
                            icon = Icons.Default.LiveTv,
                            onClick = onOpenLive
                        )
                    }
                    item {
                        IosHomeCard(
                            title = "Películas",
                            subtitle = "Catálogo de cine bajo demanda",
                            badge = "VOD",
                            icon = Icons.Default.Movie,
                            onClick = onOpenMovies
                        )
                    }
                    item {
                        IosHomeCard(
                            title = "Series",
                            subtitle = "Temporadas completas y episodios",
                            badge = "SERIES",
                            icon = Icons.Default.VideoLibrary,
                            onClick = onOpenSeries
                        )
                    }
                    item {
                        Row(
                            Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            OutlinedButton(
                                onClick = onOpenFavorites,
                                border = BorderStroke(1.dp, GoldAccent),
                                shape = RoundedCornerShape(12.dp),
                                colors = ButtonDefaults.outlinedButtonColors(contentColor = GoldChampagne),
                                modifier = Modifier.weight(1f).height(48.dp)
                            ) {
                                Icon(Icons.Default.Star, contentDescription = null, tint = GoldAccent)
                                Spacer(Modifier.width(6.dp))
                                Text("Favoritos", fontWeight = FontWeight.Bold)
                            }
                            OutlinedButton(
                                onClick = onOpenSearch,
                                border = BorderStroke(1.dp, BetisGreenLeaf),
                                shape = RoundedCornerShape(12.dp),
                                colors = ButtonDefaults.outlinedButtonColors(contentColor = TextPureWhite),
                                modifier = Modifier.weight(1f).height(48.dp)
                            ) {
                                Icon(Icons.Default.Search, contentDescription = null, tint = GoldChampagne)
                                Spacer(Modifier.width(6.dp))
                                Text("Buscador", fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun IosTabletHeroTile(
    title: String,
    subtitle: String,
    badge: String,
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val shape = RoundedCornerShape(22.dp)
    Box(
        modifier
            .clip(shape)
            .background(Brush.linearGradient(listOf(BetisGreenDark, BetisGreenPrimary, BetisGreenLeaf)))
            .border(1.5.dp, GoldAccent, shape)
            .clickable(onClick = onClick)
            .padding(24.dp)
    ) {
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Box(
                    Modifier
                        .size(60.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(GoldAccent.copy(alpha = 0.18f))
                        .border(1.dp, GoldAccent, RoundedCornerShape(16.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(icon, contentDescription = title, tint = GoldChampagne, modifier = Modifier.size(34.dp))
                }
                Box(
                    Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(BgDeepCharcoal.copy(alpha = 0.7f))
                        .border(1.dp, GoldAccent, RoundedCornerShape(8.dp))
                        .padding(horizontal = 10.dp, vertical = 4.dp)
                ) {
                    Text(
                        badge,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = GoldChampagne
                    )
                }
            }
            Column {
                Text(
                    title,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = TextPureWhite
                )
                Spacer(Modifier.height(6.dp))
                Text(
                    subtitle,
                    fontSize = 13.sp,
                    color = TextSilverGray,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
private fun IosHomeCard(
    title: String,
    subtitle: String,
    badge: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    val shape = RoundedCornerShape(18.dp)
    Row(
        Modifier
            .fillMaxWidth()
            .clip(shape)
            .background(Brush.linearGradient(listOf(BetisGreenDark, BetisGreenPrimary, BetisGreenLeaf)))
            .border(1.5.dp, GoldAccent, shape)
            .clickable(onClick = onClick)
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            Modifier
                .size(54.dp)
                .clip(RoundedCornerShape(14.dp))
                .background(GoldAccent.copy(alpha = 0.18f))
                .border(1.dp, GoldAccent, RoundedCornerShape(14.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(icon, contentDescription = title, tint = GoldChampagne, modifier = Modifier.size(30.dp))
        }
        Spacer(Modifier.width(16.dp))
        Column(Modifier.weight(1f)) {
            Text(
                badge,
                fontSize = 10.sp,
                fontWeight = FontWeight.ExtraBold,
                color = GoldChampagne
            )
            Text(
                title,
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                color = TextPureWhite
            )
            Text(
                subtitle,
                fontSize = 12.sp,
                color = TextSilverGray,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

// ─── 3. CATÁLOGO RESPONSIVE (Doble Panel y Grids Multi-Columna en iPad) ─
@Composable
fun IosCatalogScreen(
    kind: CatalogKind,
    onBack: () -> Unit,
    onPlayStream: (url: String, title: String, subtitle: String, isLive: Boolean, resumeKey: String) -> Unit,
    onOpenMovie: (VodStream) -> Unit,
    onOpenSeries: (Series) -> Unit
) {
    val appState = LocalSharedAppState.current
    val repo = remember { appState.repo() }
    val store = remember { appState.store }
    val catalogVersion by appState.catalogRefreshVersion.collectAsState()
    val syncState by appState.m3uSyncState.collectAsState()

    var categories by remember { mutableStateOf<List<Category>>(emptyList()) }
    var selectedCategory by remember { mutableStateOf("ALL") }
    var searchQuery by remember { mutableStateOf("") }
    var loading by remember { mutableStateOf(true) }
    var error by remember { mutableStateOf<String?>(null) }

    var liveItems by remember { mutableStateOf<List<LiveStream>>(emptyList()) }
    var movieItems by remember { mutableStateOf<List<VodStream>>(emptyList()) }
    var seriesItems by remember { mutableStateOf<List<Series>>(emptyList()) }
    var selectedLiveChannel by remember { mutableStateOf<LiveStream?>(null) }
    var favRefresh by remember { mutableIntStateOf(0) }

    // Refresco reactivo transparente: observa catalogVersion (StateFlow) para repintar automáticamente
    // el catálogo cuando la sincronización en segundo plano detecta cambios sin bloquear ni parpadear la UI.
    LaunchedEffect(kind, catalogVersion) {
        val hasExistingContent = when (kind) {
            CatalogKind.LIVE -> liveItems.isNotEmpty()
            CatalogKind.MOVIES -> movieItems.isNotEmpty()
            CatalogKind.SERIES -> seriesItems.isNotEmpty()
            CatalogKind.FAVORITES -> liveItems.isNotEmpty() || movieItems.isNotEmpty() || seriesItems.isNotEmpty()
        }
        if (!hasExistingContent) {
            loading = true
        }
        error = null
        val allCat = Category("ALL", "Todos")
        runCatching {
            when (kind) {
                CatalogKind.LIVE -> {
                    val (cats, items) = repo.live()
                    categories = listOf(allCat) + cats
                    liveItems = items
                    if (selectedLiveChannel == null || items.none { it.streamId == selectedLiveChannel?.streamId }) {
                        selectedLiveChannel = items.firstOrNull()
                    } else {
                        selectedLiveChannel = items.firstOrNull { it.streamId == selectedLiveChannel?.streamId }
                    }
                }
                CatalogKind.MOVIES -> {
                    val (cats, items) = repo.vod()
                    categories = listOf(allCat) + cats
                    movieItems = items
                }
                CatalogKind.SERIES -> {
                    val (cats, items) = repo.series()
                    categories = listOf(allCat) + cats
                    seriesItems = items
                }
                CatalogKind.FAVORITES -> {
                    liveItems = runCatching { repo.live().second }.getOrDefault(emptyList())
                    movieItems = runCatching { repo.vod().second }.getOrDefault(emptyList())
                    seriesItems = runCatching { repo.series().second }.getOrDefault(emptyList())
                }
            }
        }.onFailure { e ->
            if (!hasExistingContent) {
                error = XtreamRepository.sanitizeError(e, repo.playlist)
            }
        }
        loading = false
    }

    val filteredLive = remember(liveItems, selectedCategory, searchQuery) {
        val byCat = if (selectedCategory == "ALL") liveItems else liveItems.filter { it.categoryId == selectedCategory }
        val q = searchQuery.trim()
        if (q.isEmpty()) byCat else byCat.filter { it.name?.contains(q, ignoreCase = true) == true }
    }
    val filteredMovies = remember(movieItems, selectedCategory, searchQuery) {
        val byCat = if (selectedCategory == "ALL") movieItems else movieItems.filter { it.categoryId == selectedCategory }
        val q = searchQuery.trim()
        if (q.isEmpty()) byCat else byCat.filter { it.name?.contains(q, ignoreCase = true) == true }
    }
    val filteredSeries = remember(seriesItems, selectedCategory, searchQuery) {
        val byCat = if (selectedCategory == "ALL") seriesItems else seriesItems.filter { it.categoryId == selectedCategory }
        val q = searchQuery.trim()
        if (q.isEmpty()) byCat else byCat.filter { it.name?.contains(q, ignoreCase = true) == true }
    }

    val title = when (kind) {
        CatalogKind.LIVE -> "TV en directo"
        CatalogKind.MOVIES -> "Películas"
        CatalogKind.SERIES -> "Series"
        CatalogKind.FAVORITES -> "Favoritos"
    }

    @Composable
    fun LiveChannelCard(ch: LiveStream, isFav: Boolean, isSelected: Boolean, isTablet: Boolean) {
        val shape = RoundedCornerShape(14.dp)
        Row(
            Modifier
                .fillMaxWidth()
                .clip(shape)
                .background(
                    if (isSelected && isTablet) BetisGreenPrimary.copy(alpha = 0.65f) else BgCardSurface
                )
                .border(
                    width = if (isSelected && isTablet) 1.5.dp else 1.dp,
                    color = if (isSelected && isTablet) GoldAccent else BetisGreenLeaf.copy(alpha = 0.35f),
                    shape = shape
                )
                .clickable {
                    selectedLiveChannel = ch
                    val url = ch.directUrl?.takeIf { it.isNotBlank() }
                        ?: repo.liveUrl(ch.streamId, "m3u8")
                    onPlayStream(url, ch.name ?: "Canal", "TV en directo", true, "")
                }
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IosNetworkImage(
                url = ch.icon,
                contentDescription = ch.name,
                contentScale = ContentScale.Fit,
                maxDimension = 128,
                modifier = Modifier
                    .size(46.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
            Spacer(Modifier.width(12.dp))
            Column(Modifier.weight(1f)) {
                Text(
                    ch.name ?: "Canal",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = TextPureWhite,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    "LIVE • Pulsa para abrir en AVPlayer",
                    fontSize = 11.sp,
                    color = GoldChampagne,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            IconButton(
                onClick = {
                    store.toggleFavorite("live", ch.streamId)
                    favRefresh++
                }
            ) {
                Icon(
                    if (isFav) Icons.Default.Star else Icons.Default.StarBorder,
                    contentDescription = "Favorito",
                    tint = if (isFav) GoldAccent else TextSilverGray
                )
            }
        }
    }

    val selectedCategoryName = categories.firstOrNull { it.id == selectedCategory }?.name
    val catalogSubtitle = buildString {
        if (!selectedCategoryName.isNullOrBlank()) {
            append(selectedCategoryName)
        }
        if (repo.playlist.isM3u && syncState.message != null) {
            if (isNotEmpty()) append(" · ")
            append(syncState.message)
        }
    }.ifBlank { null }

    IosAppScaffold(
        title = title,
        subtitle = catalogSubtitle,
        onBack = onBack,
        actions = {
            if (repo.playlist.isM3u) {
                IconButton(onClick = { appState.startBackgroundM3uSync(repo.playlist) }) {
                    Icon(
                        imageVector = when (syncState.status) {
                            SyncStatus.OFFLINE_FALLBACK -> Icons.Default.CloudOff
                            SyncStatus.UPDATED, SyncStatus.UP_TO_DATE -> Icons.Default.CloudDone
                            else -> Icons.Default.Sync
                        },
                        contentDescription = "Sincronizar lista M3U",
                        tint = if (syncState.status == SyncStatus.OFFLINE_FALLBACK) GoldAccent else GoldChampagne
                    )
                }
            }
        }
    ) {
        BoxWithConstraints(Modifier.fillMaxSize()) {
            val isTablet = maxWidth >= 700.dp
            val isWideTablet = maxWidth >= 1020.dp

            Column(Modifier.fillMaxSize()) {
                // Barra superior de búsqueda rápida en tiempo real
                Box(Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp)) {
                    IosGoldOutlinedTextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        label = "Buscar en $title...",
                        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                        trailingIcon = {
                            if (searchQuery.isNotEmpty()) {
                                IconButton(onClick = { searchQuery = "" }) {
                                    Icon(Icons.Default.Clear, contentDescription = "Limpiar", tint = GoldChampagne)
                                }
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                // En iPhone (!isTablet), las categorías se muestran como chips horizontales
                if (!isTablet && kind != CatalogKind.FAVORITES && categories.isNotEmpty()) {
                    LazyRow(
                        contentPadding = PaddingValues(horizontal = 14.dp, vertical = 4.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(categories, key = { it.id }) { cat ->
                            val sel = cat.id == selectedCategory
                            Box(
                                Modifier
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(if (sel) GoldAccent else BgCardSurface)
                                    .border(
                                        1.dp,
                                        if (sel) GoldAccent else BetisGreenLeaf.copy(alpha = 0.4f),
                                        RoundedCornerShape(10.dp)
                                    )
                                    .clickable { selectedCategory = cat.id }
                                    .padding(horizontal = 14.dp, vertical = 8.dp)
                            ) {
                                Text(
                                    cat.name ?: "General",
                                    color = if (sel) BgDeepCharcoal else TextPureWhite,
                                    fontWeight = if (sel) FontWeight.Bold else FontWeight.Medium,
                                    fontSize = 12.sp
                                )
                            }
                        }
                    }
                }

                // Cuerpo principal: en iPad (isTablet) usa Doble Panel (barra lateral de categorías + grid multi-columna)
                Row(Modifier.weight(1f).fillMaxWidth()) {
                    if (isTablet && kind != CatalogKind.FAVORITES && categories.isNotEmpty()) {
                        LazyColumn(
                            Modifier
                                .width(235.dp)
                                .fillMaxHeight()
                                .background(BgCardSurface.copy(alpha = 0.88f))
                                .border(BorderStroke(1.dp, BetisGreenLeaf.copy(alpha = 0.25f)))
                                .padding(10.dp),
                            verticalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            items(categories, key = { it.id }) { cat ->
                                val sel = cat.id == selectedCategory
                                Row(
                                    Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(10.dp))
                                        .background(if (sel) BetisGreenPrimary else Color.Transparent)
                                        .border(
                                            width = if (sel) 1.dp else 0.dp,
                                            color = if (sel) GoldAccent else Color.Transparent,
                                            shape = RoundedCornerShape(10.dp)
                                        )
                                        .clickable { selectedCategory = cat.id }
                                        .padding(horizontal = 12.dp, vertical = 10.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = cat.name ?: "General",
                                        color = if (sel) GoldChampagne else TextPureWhite,
                                        fontWeight = if (sel) FontWeight.Bold else FontWeight.Medium,
                                        fontSize = 13.sp,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            }
                        }
                    }

                    // Panel derecho de contenido con Grids adaptativos
                    Box(Modifier.weight(1f).fillMaxHeight()) {
                        when {
                            loading -> CircularProgressIndicator(Modifier.align(Alignment.Center), color = GoldAccent)
                            error != null -> Text(
                                error ?: "",
                                color = ErrorCrimson,
                                modifier = Modifier.align(Alignment.Center).padding(20.dp)
                            )
                            kind == CatalogKind.LIVE -> {
                                val favLive = remember(favRefresh) { store.favorites("live") }
                                if (isTablet) {
                                    // En iPad: Cuadrícula (Grid) multi-columna de canales + panel inspector en pantallas anchas
                                    Row(Modifier.fillMaxSize()) {
                                        LazyVerticalGrid(
                                            columns = GridCells.Adaptive(minSize = 240.dp),
                                            contentPadding = PaddingValues(16.dp),
                                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                                            verticalArrangement = Arrangement.spacedBy(12.dp),
                                            modifier = Modifier.weight(1f).fillMaxHeight()
                                        ) {
                                            items(filteredLive, key = { it.streamId }) { ch ->
                                                LiveChannelCard(
                                                    ch = ch,
                                                    isFav = favLive.contains(ch.streamId),
                                                    isSelected = selectedLiveChannel?.streamId == ch.streamId,
                                                    isTablet = true
                                                )
                                            }
                                        }

                                        // Inspector lateral en iPad horizontal (isWideTablet)
                                        if (isWideTablet && selectedLiveChannel != null) {
                                            val ch = selectedLiveChannel!!
                                            val streamUrl = ch.directUrl?.takeIf { it.isNotBlank() }
                                                ?: repo.liveUrl(ch.streamId, "m3u8")
                                            Surface(
                                                color = BgCardSurface.copy(alpha = 0.92f),
                                                border = BorderStroke(1.dp, GoldPrimary.copy(alpha = 0.3f)),
                                                modifier = Modifier
                                                    .width(290.dp)
                                                    .fillMaxHeight()
                                                    .padding(14.dp),
                                                shape = RoundedCornerShape(18.dp)
                                            ) {
                                                Column(
                                                    Modifier.padding(18.dp),
                                                    horizontalAlignment = Alignment.CenterHorizontally,
                                                    verticalArrangement = Arrangement.spacedBy(12.dp)
                                                ) {
                                                    IosNetworkImage(
                                                        url = ch.icon,
                                                        contentDescription = ch.name,
                                                        contentScale = ContentScale.Fit,
                                                        maxDimension = 180,
                                                        modifier = Modifier
                                                            .size(96.dp)
                                                            .clip(RoundedCornerShape(16.dp))
                                                    )
                                                    Text(
                                                        ch.name ?: "Canal",
                                                        fontWeight = FontWeight.ExtraBold,
                                                        fontSize = 17.sp,
                                                        color = TextPureWhite,
                                                        maxLines = 2,
                                                        overflow = TextOverflow.Ellipsis
                                                    )
                                                    Text(
                                                        "Reproducción nativa AVPlayer con Picture-in-Picture (PiP) y AirPlay",
                                                        fontSize = 12.sp,
                                                        color = TextSilverGray
                                                    )
                                                    Spacer(Modifier.height(6.dp))
                                                    Button(
                                                        onClick = {
                                                            onPlayStream(
                                                                streamUrl,
                                                                ch.name ?: "Canal",
                                                                "TV en directo",
                                                                true,
                                                                ""
                                                            )
                                                        },
                                                        colors = ButtonDefaults.buttonColors(
                                                            containerColor = GoldAccent,
                                                            contentColor = BgDeepCharcoal
                                                        ),
                                                        shape = RoundedCornerShape(12.dp),
                                                        modifier = Modifier.fillMaxWidth().height(46.dp)
                                                    ) {
                                                        Icon(Icons.Default.PlayArrow, contentDescription = null)
                                                        Spacer(Modifier.width(6.dp))
                                                        Text("Ver ahora", fontWeight = FontWeight.ExtraBold)
                                                    }
                                                    OutlinedButton(
                                                        onClick = {
                                                            openStreamInExternalApp(streamUrl, ch.name ?: "Canal")
                                                        },
                                                        border = BorderStroke(1.dp, GoldAccent),
                                                        shape = RoundedCornerShape(12.dp),
                                                        modifier = Modifier.fillMaxWidth().height(44.dp)
                                                    ) {
                                                        Icon(
                                                            Icons.AutoMirrored.Filled.OpenInNew,
                                                            contentDescription = null,
                                                            tint = GoldChampagne
                                                        )
                                                        Spacer(Modifier.width(6.dp))
                                                        Text("Abrir en VLC", color = GoldChampagne)
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    // En iPhone: Lista vertical ágil
                                    LazyColumn(
                                        contentPadding = PaddingValues(14.dp),
                                        verticalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        items(filteredLive, key = { it.streamId }) { ch ->
                                            LiveChannelCard(
                                                ch = ch,
                                                isFav = favLive.contains(ch.streamId),
                                                isSelected = false,
                                                isTablet = false
                                            )
                                        }
                                    }
                                }
                            }
                            kind == CatalogKind.MOVIES -> {
                                val favVod = remember(favRefresh) { store.favorites("vod") }
                                LazyVerticalGrid(
                                    columns = GridCells.Adaptive(if (isTablet) 155.dp else 125.dp),
                                    contentPadding = PaddingValues(14.dp),
                                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                                    verticalArrangement = Arrangement.spacedBy(12.dp)
                                ) {
                                    items(filteredMovies, key = { it.streamId }) { m ->
                                        IosPosterCard(
                                            title = m.name,
                                            image = m.icon,
                                            subtitle = m.rating,
                                            isFavorite = favVod.contains(m.streamId),
                                            modifier = Modifier.fillMaxWidth(),
                                            onClick = { onOpenMovie(m) }
                                        )
                                    }
                                }
                            }
                            kind == CatalogKind.SERIES -> {
                                val favSeries = remember(favRefresh) { store.favorites("series") }
                                LazyVerticalGrid(
                                    columns = GridCells.Adaptive(if (isTablet) 155.dp else 125.dp),
                                    contentPadding = PaddingValues(14.dp),
                                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                                    verticalArrangement = Arrangement.spacedBy(12.dp)
                                ) {
                                    items(filteredSeries, key = { it.seriesId }) { s ->
                                        IosPosterCard(
                                            title = s.name,
                                            image = s.cover,
                                            subtitle = s.rating,
                                            isFavorite = favSeries.contains(s.seriesId),
                                            modifier = Modifier.fillMaxWidth(),
                                            onClick = { onOpenSeries(s) }
                                        )
                                    }
                                }
                            }
                            kind == CatalogKind.FAVORITES -> {
                                val favLiveIds = remember(favRefresh) { store.favorites("live") }
                                val favLiveList = filteredLive.filter { favLiveIds.contains(it.streamId) }
                                LazyVerticalGrid(
                                    columns = GridCells.Adaptive(if (isTablet) 240.dp else 160.dp),
                                    contentPadding = PaddingValues(14.dp),
                                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                                    verticalArrangement = Arrangement.spacedBy(12.dp)
                                ) {
                                    items(favLiveList, key = { it.streamId }) { ch ->
                                        LiveChannelCard(
                                            ch = ch,
                                            isFav = true,
                                            isSelected = false,
                                            isTablet = isTablet
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun IosMovieDetailScreen(
    movie: VodStream,
    onBack: () -> Unit,
    onPlay: (url: String, title: String, resumeKey: String) -> Unit
) {
    val appState = LocalSharedAppState.current
    val repo = remember { appState.repo() }
    val store = remember { appState.store }
    var info by remember { mutableStateOf<VodInfoResponse?>(null) }

    LaunchedEffect(movie.streamId) {
        runCatching { repo.vodInfo(movie.streamId) }.onSuccess { info = it }
    }

    val ext = info?.movieData?.extension ?: movie.extension ?: "mp4"
    val streamUrl = movie.directUrl?.takeIf { it.isNotBlank() } ?: repo.movieUrl(movie.streamId, ext)
    val resumeKey = "vod:${movie.streamId}"

    IosAppScaffold(title = movie.name ?: "Película", onBack = onBack) {
        BoxWithConstraints(Modifier.fillMaxSize()) {
            val isTablet = maxWidth >= 700.dp
            if (isTablet) {
                Row(
                    Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                    horizontalArrangement = Arrangement.spacedBy(24.dp)
                ) {
                    IosNetworkImage(
                        url = info?.info?.image ?: movie.icon,
                        contentDescription = movie.name,
                        contentScale = ContentScale.Crop,
                        maxDimension = 360,
                        modifier = Modifier
                            .width(240.dp)
                            .aspectRatio(2f / 3f)
                            .clip(RoundedCornerShape(16.dp))
                    )
                    Column(
                        Modifier
                            .weight(1f)
                            .verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        Text(
                            movie.name ?: "",
                            fontSize = 26.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = TextPureWhite
                        )
                        Text(
                            info?.info?.plot ?: "Sin sinopsis disponible.",
                            fontSize = 15.sp,
                            color = TextSilverGray
                        )
                        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                            Button(
                                onClick = { onPlay(streamUrl, movie.name ?: "Película", resumeKey) },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = GoldAccent,
                                    contentColor = BgDeepCharcoal
                                ),
                                shape = RoundedCornerShape(12.dp),
                                modifier = Modifier.height(48.dp)
                            ) {
                                Icon(Icons.Default.PlayArrow, contentDescription = null)
                                Spacer(Modifier.width(6.dp))
                                Text("Reproducir con AVPlayer (PiP)", fontWeight = FontWeight.ExtraBold)
                            }
                            OutlinedButton(
                                onClick = { store.toggleFavorite("vod", movie.streamId) },
                                border = BorderStroke(1.dp, GoldAccent),
                                shape = RoundedCornerShape(12.dp),
                                colors = ButtonDefaults.outlinedButtonColors(contentColor = GoldChampagne),
                                modifier = Modifier.height(48.dp)
                            ) {
                                Icon(Icons.Default.Star, contentDescription = null, tint = GoldAccent)
                                Spacer(Modifier.width(6.dp))
                                Text("Guardar en Favoritos")
                            }
                        }
                    }
                }
            } else {
                Column(
                    Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    Text(
                        movie.name ?: "",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = TextPureWhite
                    )
                    Text(
                        info?.info?.plot ?: "Sin sinopsis disponible.",
                        fontSize = 14.sp,
                        color = TextSilverGray
                    )
                    Button(
                        onClick = { onPlay(streamUrl, movie.name ?: "Película", resumeKey) },
                        colors = ButtonDefaults.buttonColors(containerColor = GoldAccent, contentColor = BgDeepCharcoal),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.fillMaxWidth().height(48.dp)
                    ) {
                        Icon(Icons.Default.PlayArrow, contentDescription = null)
                        Spacer(Modifier.width(6.dp))
                        Text("Reproducir con AVPlayer", fontWeight = FontWeight.ExtraBold)
                    }
                    OutlinedButton(
                        onClick = { store.toggleFavorite("vod", movie.streamId) },
                        border = BorderStroke(1.dp, GoldAccent),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = GoldChampagne),
                        modifier = Modifier.fillMaxWidth().height(46.dp)
                    ) {
                        Icon(Icons.Default.Star, contentDescription = null, tint = GoldAccent)
                        Spacer(Modifier.width(6.dp))
                        Text("Guardar en Favoritos")
                    }
                }
            }
        }
    }
}

@Composable
fun IosSeriesDetailScreen(
    series: Series,
    onBack: () -> Unit,
    onPlayEpisode: (url: String, title: String, subtitle: String, resumeKey: String) -> Unit
) {
    val appState = LocalSharedAppState.current
    val repo = remember { appState.repo() }
    var episodesBySeason by remember { mutableStateOf<Map<String, List<Episode>>>(emptyMap()) }
    var selectedSeason by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(series.seriesId) {
        runCatching { repo.seriesInfo(series.seriesId) }.onSuccess { (_, map) ->
            episodesBySeason = map
            selectedSeason = map.keys.firstOrNull()
        }
    }

    val seasons = episodesBySeason.keys.sortedBy { it.toIntOrNull() ?: 0 }
    val episodes = selectedSeason?.let { episodesBySeason[it] }.orEmpty()

    IosAppScaffold(title = series.name ?: "Serie", onBack = onBack) {
        BoxWithConstraints(Modifier.fillMaxSize()) {
            val isTablet = maxWidth >= 700.dp
            Column(Modifier.fillMaxSize().padding(16.dp)) {
                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(seasons) { s ->
                        val sel = s == selectedSeason
                        Box(
                            Modifier
                                .clip(RoundedCornerShape(10.dp))
                                .background(if (sel) GoldAccent else BgCardSurface)
                                .clickable { selectedSeason = s }
                                .padding(horizontal = 14.dp, vertical = 8.dp)
                        ) {
                            Text(
                                "Temporada $s",
                                color = if (sel) BgDeepCharcoal else TextPureWhite,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
                Spacer(Modifier.height(12.dp))
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(if (isTablet) 280.dp else 220.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(episodes, key = { it.id }) { ep ->
                        val ext = ep.extension ?: "mp4"
                        val url = ep.directUrl?.takeIf { it.isNotBlank() } ?: repo.episodeUrl(ep.id, ext)
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(12.dp))
                                .background(BgCardSurface)
                                .border(1.dp, BetisGreenLeaf.copy(alpha = 0.35f), RoundedCornerShape(12.dp))
                                .clickable {
                                    onPlayEpisode(
                                        url,
                                        "${series.name} · T${selectedSeason}E${ep.episodeNum ?: ""}",
                                        ep.title ?: "",
                                        "series:${ep.id}"
                                    )
                                }
                                .padding(14.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(Icons.Default.PlayArrow, contentDescription = null, tint = GoldAccent)
                            Spacer(Modifier.width(10.dp))
                            Text(
                                "${ep.episodeNum ?: "-"}. ${ep.title ?: "Episodio"}",
                                color = TextPureWhite,
                                fontWeight = FontWeight.SemiBold,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun IosSearchScreen(
    onBack: () -> Unit,
    onPlayLive: (LiveStream, String) -> Unit,
    onOpenMovie: (VodStream) -> Unit,
    onOpenSeries: (Series) -> Unit
) {
    val appState = LocalSharedAppState.current
    val repo = remember { appState.repo() }
    val catalogVersion by appState.catalogRefreshVersion.collectAsState()
    var query by remember { mutableStateOf("") }
    var liveAll by remember { mutableStateOf<List<LiveStream>>(emptyList()) }
    var vodAll by remember { mutableStateOf<List<VodStream>>(emptyList()) }
    var seriesAll by remember { mutableStateOf<List<Series>>(emptyList()) }

    LaunchedEffect(catalogVersion) {
        runCatching { repo.live() }.onSuccess { liveAll = it.second }
        runCatching { repo.vod() }.onSuccess { vodAll = it.second }
        runCatching { repo.series() }.onSuccess { seriesAll = it.second }
    }

    val q = query.trim()
    val liveMatches = remember(q, liveAll) {
        if (q.length < 2) emptyList() else liveAll.filter { it.name?.contains(q, true) == true }.take(30)
    }
    val vodMatches = remember(q, vodAll) {
        if (q.length < 2) emptyList() else vodAll.filter { it.name?.contains(q, true) == true }.take(30)
    }
    val seriesMatches = remember(q, seriesAll) {
        if (q.length < 2) emptyList() else seriesAll.filter { it.name?.contains(q, true) == true }.take(30)
    }

    IosAppScaffold(title = "Búsqueda Global", onBack = onBack) {
        Column(Modifier.fillMaxSize().padding(16.dp)) {
            IosGoldOutlinedTextField(
                value = query,
                onValueChange = { query = it },
                label = "Buscar canales, películas o series...",
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(14.dp))
            LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                if (liveMatches.isNotEmpty()) {
                    item {
                        Text("Canales (${liveMatches.size})", fontWeight = FontWeight.Bold, color = GoldChampagne)
                        Spacer(Modifier.height(8.dp))
                        LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                            items(liveMatches, key = { it.streamId }) { ch ->
                                IosPosterCard(
                                    title = ch.name,
                                    image = ch.icon,
                                    subtitle = "LIVE",
                                    onClick = {
                                        val url = ch.directUrl?.takeIf { it.isNotBlank() }
                                            ?: repo.liveUrl(ch.streamId, "m3u8")
                                        onPlayLive(ch, url)
                                    }
                                )
                            }
                        }
                    }
                }
                if (vodMatches.isNotEmpty()) {
                    item {
                        Text("Películas (${vodMatches.size})", fontWeight = FontWeight.Bold, color = GoldChampagne)
                        Spacer(Modifier.height(8.dp))
                        LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                            items(vodMatches, key = { it.streamId }) { m ->
                                IosPosterCard(
                                    title = m.name,
                                    image = m.icon,
                                    subtitle = m.rating,
                                    onClick = { onOpenMovie(m) }
                                )
                            }
                        }
                    }
                }
                if (seriesMatches.isNotEmpty()) {
                    item {
                        Text("Series (${seriesMatches.size})", fontWeight = FontWeight.Bold, color = GoldChampagne)
                        Spacer(Modifier.height(8.dp))
                        LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                            items(seriesMatches, key = { it.seriesId }) { s ->
                                IosPosterCard(
                                    title = s.name,
                                    image = s.cover,
                                    subtitle = s.rating,
                                    onClick = { onOpenSeries(s) }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
