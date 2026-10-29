package com.minuevaapp.tv.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.BrokenImage
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.key.*
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.minuevaapp.tv.data.Playlist
import com.minuevaapp.tv.data.PlaylistStore
import com.minuevaapp.tv.data.XtreamRepository
import com.minuevaapp.tv.ui.theme.*
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.ConnectionPool
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import okhttp3.Request
import org.jetbrains.skia.Image as SkiaImage
import java.awt.Cursor
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.TimeUnit

class DesktopAppState {
    val store: PlaylistStore = PlaylistStore()
    private val backgroundScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    var isRefreshing by mutableStateOf(false)
        private set
    var refreshFeedback by mutableStateOf<String?>(null)
        private set
    var catalogRefreshVersion by mutableIntStateOf(0)
        private set

    fun refreshCurrentPlaylistAsync() {
        if (isRefreshing) return
        backgroundScope.launch {
            isRefreshing = true
            val current = store.active()
            refreshFeedback = "Actualizando catálogo de ${current.name}..."
            val result = repo().refreshAllXtream()
            isRefreshing = false
            catalogRefreshVersion++
            refreshFeedback = if (result.success) {
                if (current.isM3u) "Lista M3U actualizada (${result.liveCount} canales)"
                else "Lista actualizada (${result.liveCount} TV, ${result.vodCount} Películas, ${result.seriesCount} Series)"
            } else {
                result.error ?: "Error al actualizar la lista"
            }
        }
    }

    fun clearRefreshFeedback() {
        refreshFeedback = null
    }

    // Inicialización perezosa de OkHttpClient para no penalizar el arranque del primer frame de UI
    val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .dispatcher(
                Dispatcher().apply {
                    maxRequests = 64
                    maxRequestsPerHost = 16
                }
            )
            .connectionPool(ConnectionPool(16, 5, TimeUnit.MINUTES))
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .followRedirects(true)
            .followSslRedirects(true)
            .build()
    }

    private val imageCache = ConcurrentHashMap<String, ImageBitmap>()

    @Volatile
    private var currentRepoPlaylist: Playlist? = null

    @Volatile
    private var currentRepo: XtreamRepository? = null

    /**
     * Inicializa en segundo plano (Dispatchers.IO) la base de datos local y precarga la lista M3U
     * activa (ej. TDTChannels) sin bloquear jamás el hilo principal de interfaz.
     */
    fun initializeInBackground() {
        backgroundScope.launch {
            store.initializeAsync()
            repo().warmUpInBackground()
        }
    }

    fun warmUpActiveCatalogAsync() {
        backgroundScope.launch {
            repo().warmUpInBackground()
        }
    }

    fun repo(): XtreamRepository {
        val active = store.active()
        val cached = currentRepo
        if (cached != null && currentRepoPlaylist == active) return cached
        return synchronized(this) {
            val again = currentRepo
            if (again != null && currentRepoPlaylist == active) {
                again
            } else {
                XtreamRepository(active, okHttpClient).also {
                    currentRepoPlaylist = active
                    currentRepo = it
                }
            }
        }
    }

    fun createRepo(playlist: Playlist): XtreamRepository =
        XtreamRepository(playlist, okHttpClient)

    fun invalidateRepo() {
        synchronized(this) {
            currentRepoPlaylist = null
            currentRepo = null
        }
        warmUpActiveCatalogAsync()
    }

    suspend fun loadImage(url: String): ImageBitmap? {
        val clean = url.trim()
        if (clean.isEmpty()) return null
        imageCache[clean]?.let { return it }
        return withContext(Dispatchers.IO) {
            runCatching {
                val req = Request.Builder()
                    .url(clean)
                    .header("User-Agent", "XaviTV/2.0 (Windows Desktop)")
                    .build()
                okHttpClient.newCall(req).execute().use { resp ->
                    if (!resp.isSuccessful) return@use null
                    val bytes = resp.body?.bytes() ?: return@use null
                    if (bytes.isEmpty()) return@use null
                    val bitmap = SkiaImage.makeFromEncoded(bytes).toComposeImageBitmap()
                    if (imageCache.size > 300) {
                        imageCache.clear()
                    }
                    imageCache[clean] = bitmap
                    bitmap
                }
            }.getOrNull()
        }
    }
}

val LocalAppState = staticCompositionLocalOf<DesktopAppState> {
    error("DesktopAppState no inicializado")
}

sealed interface Load<out T> {
    data object Loading : Load<Nothing>
    data class Ok<T>(val data: T) : Load<T>
    data class Error(val msg: String, val retry: () -> Unit) : Load<Nothing>
}

@Composable
fun <T> rememberLoad(vararg keys: Any?, block: suspend () -> T): Load<T> {
    val appState = LocalAppState.current
    var retryToken by remember { mutableIntStateOf(0) }
    val retry: () -> Unit = remember { { retryToken++ } }
    val state by produceState<Load<T>>(Load.Loading, *keys, retryToken) {
        value = Load.Loading
        value = try {
            Load.Ok(block())
        } catch (ce: CancellationException) {
            throw ce
        } catch (e: Exception) {
            val playlist = runCatching { appState.store.active() }.getOrNull()
            Load.Error(XtreamRepository.sanitizeError(e, playlist), retry)
        }
    }
    return state
}

@Composable
fun <T> LoadContent(state: Load<T>, content: @Composable (T) -> Unit) {
    when (state) {
        Load.Loading -> Box(Modifier.fillMaxSize(), Alignment.Center) {
            CircularProgressIndicator(color = GoldPrimary, strokeWidth = 3.dp)
        }
        is Load.Error -> Box(Modifier.fillMaxSize().padding(24.dp), Alignment.Center) {
            Column(
                modifier = Modifier
                    .background(DarkSurface, RoundedCornerShape(14.dp))
                    .border(1.dp, GoldPrimary.copy(alpha = 0.35f), RoundedCornerShape(14.dp))
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(14.dp),
            ) {
                Text(
                    text = "Error: ${state.msg}",
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium,
                )
                Button(
                    onClick = state.retry,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = GoldPrimary,
                        contentColor = DarkBackground,
                    ),
                    shape = RoundedCornerShape(10.dp),
                ) {
                    Icon(Icons.Default.Refresh, contentDescription = null)
                    Spacer(Modifier.width(8.dp))
                    Text("Reintentar", fontWeight = FontWeight.Bold)
                }
            }
        }
        is Load.Ok -> content(state.data)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScaffold(
    title: String,
    subtitle: String? = null,
    onBack: (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
    content: @Composable (PaddingValues) -> Unit,
) {
    Scaffold(
        containerColor = DarkBackground,
        topBar = {
            Column {
                TopAppBar(
                    title = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource("app_logo.png"),
                                contentDescription = "XaviTV",
                                modifier = Modifier
                                    .size(32.dp)
                                    .clip(CircleShape)
                                    .background(Color.White, CircleShape)
                                    .padding(2.dp),
                            )
                            Spacer(Modifier.width(10.dp))
                            Column {
                                Text(
                                    text = title,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                    fontWeight = FontWeight.Bold,
                                    color = TextPrimaryWhite,
                                )
                                if (!subtitle.isNullOrBlank()) {
                                    Text(
                                        text = subtitle,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis,
                                        style = MaterialTheme.typography.labelSmall,
                                        color = GoldLight,
                                    )
                                }
                            }
                        }
                    },
                    navigationIcon = {
                        if (onBack != null) {
                            IconButton(
                                onClick = onBack,
                                modifier = Modifier.pointerHoverIcon(PointerIcon(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)))
                            ) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "Atrás",
                                    tint = GoldLight,
                                )
                            }
                        }
                    },
                    actions = actions,
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xFF0B1F15),
                        titleContentColor = TextPrimaryWhite,
                        actionIconContentColor = GoldLight,
                    ),
                )
                HorizontalDivider(thickness = 1.dp, color = GoldPrimary.copy(alpha = 0.25f))
            }
        },
    ) { pad ->
        Box(
            Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            BetisGreenDark.copy(alpha = 0.38f),
                            DarkBackground,
                            DarkBackground,
                        )
                    )
                )
        ) {
            content(pad)
        }
    }
}

@Composable
fun GoldOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        singleLine = true,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = GoldLight,
            unfocusedBorderColor = GoldPrimary.copy(alpha = 0.30f),
            focusedLabelColor = GoldLight,
            unfocusedLabelColor = TextSecondaryGray,
            cursorColor = GoldLight,
            focusedTextColor = TextPrimaryWhite,
            unfocusedTextColor = TextPrimaryWhite,
            focusedContainerColor = DarkSurface,
            unfocusedContainerColor = DarkSurface.copy(alpha = 0.85f),
            focusedLeadingIconColor = GoldLight,
            unfocusedLeadingIconColor = TextSecondaryGray,
        ),
        modifier = modifier,
    )
}

fun Modifier.tvClickable(
    shape: Shape = RoundedCornerShape(12.dp),
    borderWidth: Dp = 2.5.dp,
    idleBorderColor: Color = GoldPrimary.copy(alpha = 0.18f),
    onFocused: (() -> Unit)? = null,
    onClick: () -> Unit,
): Modifier = composed {
    var focused by remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }
    val hovered by interactionSource.collectIsHoveredAsState()
    val highlighted = focused || hovered
    this
        .clip(shape)
        .hoverable(interactionSource)
        .pointerHoverIcon(PointerIcon(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)))
        .onFocusChanged {
            focused = it.isFocused
            if (it.isFocused) onFocused?.invoke()
        }
        .border(
            width = if (highlighted) borderWidth else 1.dp,
            color = if (highlighted) GoldLight else idleBorderColor,
            shape = shape,
        )
        .onKeyEvent { event ->
            if (event.type == KeyEventType.KeyUp &&
                (event.key == Key.DirectionCenter || event.key == Key.Enter || event.key == Key.NumPadEnter)
            ) {
                onClick()
                true
            } else {
                false
            }
        }
        .focusable()
        .clickable(
            interactionSource = interactionSource,
            indication = null,
            onClick = onClick
        )
}

@Composable
fun NetworkImage(
    url: String?,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop,
    fallbackIcon: ImageVector = Icons.Default.Movie,
    alpha: Float = 1f,
) {
    val appState = LocalAppState.current
    val cleanUrl = url?.trim()?.takeIf { it.isNotEmpty() }
    var bitmap by remember(cleanUrl) { mutableStateOf<ImageBitmap?>(null) }
    var failed by remember(cleanUrl) { mutableStateOf(false) }

    LaunchedEffect(cleanUrl) {
        if (cleanUrl == null) {
            failed = true
            return@LaunchedEffect
        }
        failed = false
        val loaded = appState.loadImage(cleanUrl)
        if (loaded != null) {
            bitmap = loaded
        } else {
            failed = true
        }
    }

    Box(
        modifier = modifier.background(DarkSurfaceVariant),
        contentAlignment = Alignment.Center,
    ) {
        val currentBitmap = bitmap
        if (currentBitmap != null) {
            Image(
                bitmap = currentBitmap,
                contentDescription = contentDescription,
                contentScale = contentScale,
                alpha = alpha,
                modifier = Modifier.fillMaxSize(),
            )
        } else if (failed || cleanUrl == null) {
            Icon(
                imageVector = if (cleanUrl == null) fallbackIcon else Icons.Default.BrokenImage,
                contentDescription = contentDescription,
                tint = GoldPrimary.copy(alpha = 0.45f),
                modifier = Modifier.size(30.dp),
            )
        } else {
            CircularProgressIndicator(
                modifier = Modifier.size(22.dp),
                strokeWidth = 2.dp,
                color = GoldPrimary.copy(alpha = 0.65f),
            )
        }
    }
}

@Composable
fun PosterCard(
    title: String?,
    image: String?,
    subtitle: String? = null,
    isFavorite: Boolean = false,
    onClick: () -> Unit,
) {
    val cardShape = RoundedCornerShape(12.dp)
    Column(
        Modifier
            .width(150.dp)
            .shadow(elevation = 6.dp, shape = cardShape)
            .tvClickable(
                shape = cardShape,
                idleBorderColor = if (isFavorite) GoldPrimary.copy(alpha = 0.55f) else GoldPrimary.copy(alpha = 0.22f),
                onClick = onClick,
            )
            .background(DarkSurface)
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .aspectRatio(2f / 3f)
        ) {
            NetworkImage(
                url = image,
                contentDescription = title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(),
            )
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(44.dp)
                    .align(Alignment.BottomCenter)
                    .background(
                        Brush.verticalGradient(
                            listOf(Color.Transparent, DarkSurface.copy(alpha = 0.92f))
                        )
                    )
            )
            if (isFavorite) {
                Box(
                    Modifier
                        .align(Alignment.TopEnd)
                        .padding(6.dp)
                        .size(26.dp)
                        .background(DarkBackground.copy(alpha = 0.85f), CircleShape)
                        .border(1.dp, GoldLight, CircleShape),
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Favorito",
                        tint = GoldLight,
                        modifier = Modifier.size(16.dp),
                    )
                }
            }
            if (!subtitle.isNullOrBlank()) {
                Box(
                    Modifier
                        .align(Alignment.BottomStart)
                        .padding(6.dp)
                        .background(BetisGreenDark.copy(alpha = 0.90f), RoundedCornerShape(6.dp))
                        .border(0.8.dp, GoldPrimary.copy(alpha = 0.55f), RoundedCornerShape(6.dp))
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = subtitle,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.labelSmall,
                        color = GoldLight,
                        fontWeight = FontWeight.SemiBold,
                    )
                }
            }
        }
        Text(
            text = title?.ifBlank { "Sin título" } ?: "Sin título",
            maxLines = 2,
            minLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Medium,
            color = TextPrimaryWhite,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
        )
    }
}
