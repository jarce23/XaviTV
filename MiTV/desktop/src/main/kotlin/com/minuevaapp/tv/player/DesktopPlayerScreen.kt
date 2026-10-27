package com.minuevaapp.tv.player

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.OpenInNew
import androidx.compose.material.icons.automirrored.filled.VolumeOff
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.awt.SwingPanel
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.minuevaapp.tv.ui.LocalAppState
import com.minuevaapp.tv.ui.theme.*
import com.sun.jna.NativeLibrary
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import uk.co.caprica.vlcj.binding.support.runtime.RuntimeUtil
import uk.co.caprica.vlcj.factory.MediaPlayerFactory
import uk.co.caprica.vlcj.factory.discovery.NativeDiscovery
import uk.co.caprica.vlcj.player.base.MediaPlayer
import uk.co.caprica.vlcj.player.base.MediaPlayerEventAdapter
import uk.co.caprica.vlcj.player.component.CallbackMediaPlayerComponent
import java.awt.AWTEvent
import java.awt.BorderLayout
import java.awt.Cursor
import java.awt.Desktop
import java.awt.Point
import java.awt.Toolkit
import java.awt.event.AWTEventListener
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.awt.event.MouseMotionAdapter
import java.awt.image.BufferedImage
import java.io.File
import java.net.URI
import java.nio.charset.StandardCharsets
import java.util.concurrent.TimeUnit
import javax.swing.JPanel
import javax.swing.SwingUtilities
import kotlin.math.abs

private const val VLC_USER_AGENT =
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36"

private const val LIVE_CACHING_MS = 300
private const val VOD_CACHING_MS = 600
private const val MAX_AUTO_RETRIES = 3
private const val FULLSCREEN_CONTROLS_HIDE_DELAY_MS = 3_000L

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun DesktopPlayerScreen(
    url: String,
    title: String,
    subtitle: String = "",
    streamType: String = "live",
    resumeKey: String = "",
    isFullscreen: Boolean = false,
    onToggleFullscreen: () -> Unit = {},
    onClose: () -> Unit
) {
    val appState = LocalAppState.current
    val scope = rememberCoroutineScope()
    val isLive = streamType.equals("live", ignoreCase = true)

    var isBuffering by remember { mutableStateOf(true) }
    var isPlaying by remember { mutableStateOf(true) }
    var isMuted by remember { mutableStateOf(false) }
    var volume by remember { mutableFloatStateOf(1.0f) }
    var useSoftwareDecoder by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    var statusBanner by remember { mutableStateOf<String?>("Conectando canal...") }
    var externalNotice by remember { mutableStateOf<String?>(null) }
    var autoRetryCount by remember { mutableIntStateOf(0) }
    var reloadTrigger by remember { mutableIntStateOf(0) }

    var videoResolutionText by remember { mutableStateOf("") }
    var currentPosMs by remember { mutableLongStateOf(0L) }
    var totalDurationMs by remember { mutableLongStateOf(0L) }
    var seekApplied by remember { mutableStateOf(false) }

    // Estado de visibilidad de controles para el modo inmersivo en pantalla completa
    var controlsVisible by remember { mutableStateOf(true) }
    var lastMouseActivityMs by remember { mutableLongStateOf(System.currentTimeMillis()) }
    var lastScreenX by remember { mutableIntStateOf(-1) }
    var lastScreenY by remember { mutableIntStateOf(-1) }

    val vlcComponentRef = remember { mutableStateOf<CallbackMediaPlayerComponent?>(null) }
    val swingContainerRef = remember { mutableStateOf<JPanel?>(null) }

    // Cursor invisible para cuando los controles se ocultan en pantalla completa
    val blankCursor = remember {
        runCatching {
            val cursorImg = BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB)
            Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, Point(0, 0), "blank_cursor")
        }.getOrDefault(Cursor.getDefaultCursor())
    }

    fun updateVideoSurfaceCursor(visible: Boolean) {
        val targetCursor = if (visible || !isFullscreen) Cursor.getDefaultCursor() else blankCursor
        SwingUtilities.invokeLater {
            swingContainerRef.value?.cursor = targetCursor
            vlcComponentRef.value?.cursor = targetCursor
            vlcComponentRef.value?.videoSurfaceComponent()?.cursor = targetCursor
        }
    }

    fun notifyMouseActivity() {
        lastMouseActivityMs = System.currentTimeMillis()
        if (!controlsVisible) {
            controlsVisible = true
            updateVideoSurfaceCursor(true)
        }
    }

    // Al entrar o salir de pantalla completa, sincronizar visibilidad y temporizador de inactividad
    LaunchedEffect(isFullscreen) {
        if (isFullscreen) {
            lastMouseActivityMs = System.currentTimeMillis()
            controlsVisible = true
            updateVideoSurfaceCursor(true)
        } else {
            controlsVisible = true
            updateVideoSurfaceCursor(true)
        }
    }

    // Temporizador automático que oculta las barras tras 3 segundos de inactividad en pantalla completa
    LaunchedEffect(isFullscreen, controlsVisible, lastMouseActivityMs) {
        if (!isFullscreen) {
            controlsVisible = true
            updateVideoSurfaceCursor(true)
            return@LaunchedEffect
        }
        while (isFullscreen && controlsVisible) {
            val elapsed = System.currentTimeMillis() - lastMouseActivityMs
            val remaining = FULLSCREEN_CONTROLS_HIDE_DELAY_MS - elapsed
            if (remaining <= 0L) {
                controlsVisible = false
                updateVideoSurfaceCursor(false)
                break
            }
            delay(remaining.coerceAtMost(250L))
        }
    }

    // Detector global AWT de movimiento y clics del ratón (captura eventos sobre SwingPanel / LibVLC y sobre Compose)
    DisposableEffect(Unit) {
        val awtListener = AWTEventListener { event ->
            if (event is MouseEvent) {
                when (event.id) {
                    MouseEvent.MOUSE_MOVED, MouseEvent.MOUSE_DRAGGED -> {
                        val sx = event.xOnScreen
                        val sy = event.yOnScreen
                        if (abs(sx - lastScreenX) > 2 || abs(sy - lastScreenY) > 2) {
                            lastScreenX = sx
                            lastScreenY = sy
                            notifyMouseActivity()
                        }
                    }
                    MouseEvent.MOUSE_PRESSED, MouseEvent.MOUSE_RELEASED, MouseEvent.MOUSE_WHEEL -> {
                        notifyMouseActivity()
                    }
                }
            }
        }
        val mask = AWTEvent.MOUSE_MOTION_EVENT_MASK or
            AWTEvent.MOUSE_EVENT_MASK or
            AWTEvent.MOUSE_WHEEL_EVENT_MASK
        runCatching {
            Toolkit.getDefaultToolkit().addAWTEventListener(awtListener, mask)
        }
        onDispose {
            runCatching {
                Toolkit.getDefaultToolkit().removeAWTEventListener(awtListener)
            }
        }
    }

    fun pauseCurrentPlayback() {
        runCatching {
            vlcComponentRef.value?.mediaPlayer()?.controls()?.pause()
        }
        isPlaying = false
    }

    fun launchExternalPlayer() {
        pauseCurrentPlayback()
        scope.launch {
            val playerUsed = withContext(Dispatchers.IO) {
                VlcExternalLauncher.openStream(url, title)
            }
            externalNotice = "Abierto en $playerUsed"
        }
    }

    fun handleStreamFailure(detail: String) {
        if (!useSoftwareDecoder) {
            useSoftwareDecoder = true
            statusBanner = "Conmutando a decodificación VLC por software (SW)..."
            return
        }
        if (autoRetryCount < MAX_AUTO_RETRIES) {
            val next = autoRetryCount + 1
            autoRetryCount = next
            statusBanner = "Reconectando stream ($next/$MAX_AUTO_RETRIES)..."
            scope.launch {
                delay(800L * next)
                reloadTrigger++
            }
        } else {
            isBuffering = false
            statusBanner = null
            errorMessage =
                "No se pudo decodificar la señal tras varios intentos ($detail). " +
                    "Puedes reintentar o abrir el canal en una ventana independiente de VLC."
        }
    }

    // Ocultar aviso de reproductor externo tras 4 segundos
    LaunchedEffect(externalNotice) {
        if (externalNotice != null) {
            delay(4500)
            externalNotice = null
        }
    }

    // Guardado periódico de progreso VOD y actualización de resolución en segundo plano
    LaunchedEffect(Unit) {
        while (true) {
            delay(1000)
            val mp = vlcComponentRef.value?.mediaPlayer()
            if (mp != null) {
                val playingNow = withContext(Dispatchers.IO) {
                    runCatching { mp.status().isPlaying }.getOrDefault(false)
                }
                if (playingNow) {
                    val cur = withContext(Dispatchers.IO) {
                        runCatching { mp.status().time() }.getOrDefault(0L).coerceAtLeast(0L)
                    }
                    val tot = withContext(Dispatchers.IO) {
                        runCatching { mp.status().length() }.getOrDefault(0L)
                    }
                    currentPosMs = cur
                    if (tot > 0L && tot < Long.MAX_VALUE / 2) {
                        totalDurationMs = tot
                    }
                    if (videoResolutionText.isEmpty()) {
                        val dim = withContext(Dispatchers.IO) {
                            runCatching { mp.video().videoDimension() }.getOrNull()
                        }
                        if (dim != null && dim.width > 0 && dim.height > 0) {
                            videoResolutionText = "${dim.width}×${dim.height}"
                        }
                    }
                    if (!isLive && resumeKey.isNotEmpty() && cur > 5_000L) {
                        appState.store.saveResumePosition(resumeKey, cur)
                    }
                }
            }
        }
    }

    // Carga perezosa (Lazy Initialization) de LibVLC en Dispatchers.IO y zapping ultrarrápido (300ms buffer)
    LaunchedEffect(url, useSoftwareDecoder, reloadTrigger, errorMessage) {
        if (errorMessage != null) return@LaunchedEffect

        isBuffering = true
        videoResolutionText = ""
        seekApplied = false
        statusBanner = if (useSoftwareDecoder) {
            "Zapping rápido · Motor VLCJ (SW · ${LIVE_CACHING_MS}ms)..."
        } else {
            "Zapping rápido · Motor VLCJ (HW · ${LIVE_CACHING_MS}ms)..."
        }

        // 1. Inicialización perezosa de LibVLC exclusivamente al entrar al reproductor y en Dispatchers.IO
        val factory = VlcRuntimeManager.ensureFactoryInitializedAsync()
        if (factory == null) {
            isBuffering = false
            statusBanner = null
            errorMessage =
                "No se encontraron las librerías nativas de LibVLC (libvlc.dll / libvlccore.dll). " +
                    "Puedes abrir el stream con el botón «Abrir en VLC externo»."
            return@LaunchedEffect
        }

        // 2. Esperar a que el contenedor Swing esté montado (intervalo corto de 10ms para no retrasar el zapping)
        var waitTicks = 0
        while (swingContainerRef.value == null && waitTicks < 40) {
            delay(10)
            waitTicks++
        }

        // 3. Crear el CallbackMediaPlayerComponent una sola vez y montarlo en AWT
        var comp = vlcComponentRef.value
        if (comp == null) {
            val created = withContext(Dispatchers.IO) {
                runCatching {
                    CallbackMediaPlayerComponent(factory, null, null, true, null).apply {
                        background = java.awt.Color.BLACK
                        videoSurfaceComponent().background = java.awt.Color.BLACK

                        val swingMotionListener = object : MouseMotionAdapter() {
                            override fun mouseMoved(e: MouseEvent) {
                                notifyMouseActivity()
                            }

                            override fun mouseDragged(e: MouseEvent) {
                                notifyMouseActivity()
                            }
                        }
                        val swingClickListener = object : MouseAdapter() {
                            override fun mousePressed(e: MouseEvent) {
                                notifyMouseActivity()
                            }

                            override fun mouseClicked(e: MouseEvent) {
                                notifyMouseActivity()
                                if (e.clickCount == 2 && SwingUtilities.isLeftMouseButton(e)) {
                                    onToggleFullscreen()
                                }
                            }
                        }
                        addMouseMotionListener(swingMotionListener)
                        addMouseListener(swingClickListener)
                        videoSurfaceComponent().addMouseMotionListener(swingMotionListener)
                        videoSurfaceComponent().addMouseListener(swingClickListener)

                        mediaPlayer().events().addMediaPlayerEventListener(
                            object : MediaPlayerEventAdapter() {
                                override fun opening(mediaPlayer: MediaPlayer) {
                                    isBuffering = true
                                }

                                override fun buffering(mediaPlayer: MediaPlayer, newCache: Float) {
                                    if (newCache < 100f) {
                                        isBuffering = true
                                        statusBanner = "Búfer rápido (${newCache.toInt()}%)..."
                                    } else {
                                        isBuffering = false
                                        statusBanner = null
                                    }
                                }

                                override fun playing(mediaPlayer: MediaPlayer) {
                                    isBuffering = false
                                    isPlaying = true
                                    statusBanner = null
                                    errorMessage = null
                                    autoRetryCount = 0

                                    if (!isLive && !seekApplied && resumeKey.isNotEmpty()) {
                                        seekApplied = true
                                        val savedPos = appState.store.getResumePosition(resumeKey)
                                        if (savedPos > 5_000L) {
                                            runCatching { mediaPlayer.controls().setTime(savedPos) }
                                        }
                                    }
                                }

                                override fun paused(mediaPlayer: MediaPlayer) {
                                    isPlaying = false
                                }

                                override fun videoOutput(mediaPlayer: MediaPlayer, newCount: Int) {
                                    isBuffering = false
                                    statusBanner = null
                                    val dim = runCatching { mediaPlayer.video().videoDimension() }.getOrNull()
                                    if (dim != null && dim.width > 0 && dim.height > 0) {
                                        videoResolutionText = "${dim.width}×${dim.height}"
                                    }
                                    SwingUtilities.invokeLater {
                                        swingContainerRef.value?.let { container ->
                                            container.revalidate()
                                            container.repaint()
                                        }
                                    }
                                }

                                override fun timeChanged(mediaPlayer: MediaPlayer, newTime: Long) {
                                    currentPosMs = newTime.coerceAtLeast(0L)
                                    if (isBuffering && newTime > 0L) {
                                        isBuffering = false
                                        statusBanner = null
                                    }
                                }

                                override fun lengthChanged(mediaPlayer: MediaPlayer, newLength: Long) {
                                    if (newLength > 0L && newLength < Long.MAX_VALUE / 2) {
                                        totalDurationMs = newLength
                                    }
                                }

                                override fun error(mediaPlayer: MediaPlayer) {
                                    scope.launch {
                                        handleStreamFailure("Error de flujo o contenedor en LibVLC")
                                    }
                                }
                            }
                        )
                    }
                }.getOrNull()
            }

            if (created == null) {
                handleStreamFailure("No se pudo inicializar CallbackMediaPlayerComponent")
                return@LaunchedEffect
            }

            comp = created
            vlcComponentRef.value = created
            SwingUtilities.invokeLater {
                swingContainerRef.value?.let { container ->
                    container.removeAll()
                    container.add(created, BorderLayout.CENTER)
                    container.revalidate()
                    container.repaint()
                }
            }
        }

        // 4. Iniciar reproducción directamente en Dispatchers.IO sin petición HTTP previa redundante
        val cleanUrl = url.trim()
        val cachingMs = if (isLive) LIVE_CACHING_MS else VOD_CACHING_MS
        val originReferer = cleanUrl.toHttpUrlOrNull()?.let { "${it.scheme}://${it.host}/" }
        val mediaOptions = buildList {
            add(":http-user-agent=$VLC_USER_AGENT")
            if (originReferer != null) {
                add(":http-referrer=$originReferer")
            }
            add(":network-caching=$cachingMs")
            add(":live-caching=$cachingMs")
            add(":file-caching=$cachingMs")
            add(":clock-jitter=0")
            add(":clock-synchro=0")
            add(":http-reconnect")
            add(":no-sub-autodetect-file")
            add(":avcodec-fast")
            add(":avcodec-skiploopfilter=1")
            if (useSoftwareDecoder) {
                add(":avcodec-hw=none")
            } else {
                add(":avcodec-hw=any")
            }
        }.toTypedArray()

        withContext(Dispatchers.IO) {
            try {
                val mp = comp.mediaPlayer()
                mp.audio().setMute(isMuted)
                mp.audio().setVolume((volume * 100).toInt().coerceIn(0, 100))
                mp.media().play(cleanUrl, *mediaOptions)
            } catch (t: Throwable) {
                withContext(Dispatchers.Main) {
                    handleStreamFailure(t.localizedMessage ?: "Error al abrir el flujo en LibVLC")
                }
            }
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            val comp = vlcComponentRef.value
            vlcComponentRef.value = null
            if (comp != null) {
                if (!isLive && resumeKey.isNotEmpty() && currentPosMs > 5_000L) {
                    appState.store.saveResumePosition(resumeKey, currentPosMs)
                }
                Thread {
                    runCatching {
                        comp.mediaPlayer().controls().stop()
                        comp.release()
                    }
                }.apply { isDaemon = true }.start()
            }
        }
    }

    val showBars = !isFullscreen || controlsVisible

    Box(
        Modifier
            .fillMaxSize()
            .background(if (isFullscreen) Color.Black else BgDeepCharcoal)
            .onPointerEvent(PointerEventType.Move) { notifyMouseActivity() }
            .onPointerEvent(PointerEventType.Press) { notifyMouseActivity() }
    ) {
        // ─── 1. LIENZO CENTRAL DE VÍDEO (100% de la ventana en Pantalla Completa) ─
        Box(
            Modifier
                .fillMaxSize()
                .padding(
                    top = if (isFullscreen) 0.dp else 60.dp,
                    bottom = if (isFullscreen) 0.dp else 68.dp
                )
                .background(Color.Black)
        ) {
            if (errorMessage != null) {
                Column(
                    Modifier
                        .align(Alignment.Center)
                        .widthIn(max = 580.dp)
                        .padding(28.dp)
                        .clip(RoundedCornerShape(18.dp))
                        .background(BgCardSurface)
                        .border(1.5.dp, GoldAccent, RoundedCornerShape(18.dp))
                        .padding(26.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        Icons.Default.ErrorOutline,
                        contentDescription = null,
                        tint = GoldAccent,
                        modifier = Modifier.size(46.dp)
                    )
                    Spacer(Modifier.height(12.dp))
                    Text(
                        "Error al reproducir el stream",
                        color = TextPureWhite,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        errorMessage ?: "",
                        color = TextSilverGray,
                        fontSize = 13.sp,
                        textAlign = TextAlign.Center
                    )
                    Spacer(Modifier.height(20.dp))
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(
                            onClick = {
                                autoRetryCount = 0
                                errorMessage = null
                                reloadTrigger++
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = GoldAccent,
                                contentColor = BgDeepCharcoal
                            ),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .height(44.dp)
                                .pointerHoverIcon(PointerIcon(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)))
                        ) {
                            Icon(Icons.Default.Refresh, contentDescription = null, modifier = Modifier.size(18.dp))
                            Spacer(Modifier.width(6.dp))
                            Text("Reintentar", fontWeight = FontWeight.ExtraBold)
                        }
                        OutlinedButton(
                            onClick = {
                                autoRetryCount = 0
                                errorMessage = null
                                useSoftwareDecoder = !useSoftwareDecoder
                            },
                            border = BorderStroke(1.dp, GoldChampagne),
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.outlinedButtonColors(contentColor = GoldChampagne),
                            modifier = Modifier
                                .height(44.dp)
                                .pointerHoverIcon(PointerIcon(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)))
                        ) {
                            Icon(Icons.Default.Memory, contentDescription = null, modifier = Modifier.size(18.dp))
                            Spacer(Modifier.width(6.dp))
                            Text(if (useSoftwareDecoder) "Usar HW" else "Forzar SW")
                        }
                        OutlinedButton(
                            onClick = { launchExternalPlayer() },
                            border = BorderStroke(1.dp, BetisGreenLeaf),
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.outlinedButtonColors(contentColor = TextPureWhite),
                            modifier = Modifier
                                .height(44.dp)
                                .pointerHoverIcon(PointerIcon(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)))
                        ) {
                            Icon(
                                Icons.AutoMirrored.Filled.OpenInNew,
                                contentDescription = null,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(Modifier.width(6.dp))
                            Text("Abrir en VLC externo")
                        }
                    }
                }
            } else {
                SwingPanel(
                    background = Color.Black,
                    modifier = Modifier.fillMaxSize(),
                    factory = {
                        JPanel(BorderLayout()).apply {
                            background = java.awt.Color.BLACK
                            addMouseMotionListener(object : MouseMotionAdapter() {
                                override fun mouseMoved(e: MouseEvent) {
                                    notifyMouseActivity()
                                }
                            })
                            swingContainerRef.value = this
                            vlcComponentRef.value?.let { existingComp ->
                                add(existingComp, BorderLayout.CENTER)
                            }
                        }
                    }
                )
            }
        }

        // ─── 2. CABECERA SUPERIOR (Ocultación automática en Pantalla Completa) ─
        AnimatedVisibility(
            visible = showBars,
            enter = fadeIn(animationSpec = tween(220)) + slideInVertically(animationSpec = tween(220)) { -it },
            exit = fadeOut(animationSpec = tween(320)) + slideOutVertically(animationSpec = tween(320)) { -it },
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth()
        ) {
            Surface(
                color = if (isFullscreen) BgCardSurface.copy(alpha = 0.90f) else BgCardSurface,
                tonalElevation = 6.dp,
                border = BorderStroke(1.dp, BetisGreenLeaf.copy(alpha = 0.35f)),
                modifier = Modifier
                    .onPointerEvent(PointerEventType.Move) { notifyMouseActivity() }
            ) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 18.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = onClose,
                        modifier = Modifier
                            .size(38.dp)
                            .clip(CircleShape)
                            .background(BetisGreenPrimary)
                            .border(1.dp, GoldAccent, CircleShape)
                            .pointerHoverIcon(PointerIcon(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)))
                    ) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver",
                            tint = GoldChampagne
                        )
                    }
                    Spacer(Modifier.width(12.dp))
                    Column(Modifier.weight(1f)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            if (isLive) {
                                Box(
                                    Modifier
                                        .clip(RoundedCornerShape(6.dp))
                                        .background(BetisGreenPrimary)
                                        .border(1.dp, GoldAccent, RoundedCornerShape(6.dp))
                                        .padding(horizontal = 8.dp, vertical = 2.dp)
                                ) {
                                    Text(
                                        "● EN DIRECTO",
                                        color = GoldChampagne,
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.ExtraBold
                                    )
                                }
                                Spacer(Modifier.width(8.dp))
                            }
                            Text(
                                text = title,
                                color = TextPureWhite,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            if (videoResolutionText.isNotEmpty()) {
                                Spacer(Modifier.width(8.dp))
                                Box(
                                    Modifier
                                        .clip(RoundedCornerShape(5.dp))
                                        .background(BgDeepCharcoal)
                                        .border(1.dp, GoldAccent.copy(alpha = 0.7f), RoundedCornerShape(5.dp))
                                        .padding(horizontal = 6.dp, vertical = 1.dp)
                                ) {
                                    Text(
                                        videoResolutionText,
                                        color = GoldChampagne,
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                        }
                        val infoLine = statusBanner ?: externalNotice ?: subtitle
                        if (infoLine.isNotBlank()) {
                            Text(
                                text = infoLine,
                                color = if (externalNotice != null || statusBanner != null) GoldAccent else TextSilverGray,
                                fontSize = 11.sp,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }

                    // Botón para abrir en ventana externa de VLC si el usuario lo desea
                    Button(
                        onClick = { launchExternalPlayer() },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = GoldAccent,
                            contentColor = BgDeepCharcoal
                        ),
                        shape = RoundedCornerShape(10.dp),
                        contentPadding = PaddingValues(horizontal = 14.dp, vertical = 8.dp),
                        modifier = Modifier.pointerHoverIcon(PointerIcon(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)))
                    ) {
                        Icon(
                            Icons.AutoMirrored.Filled.OpenInNew,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(Modifier.width(6.dp))
                        Text(
                            "Abrir en VLC externo",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.ExtraBold
                        )
                    }

                    Spacer(Modifier.width(8.dp))

                    // Conmutador de decodificación LibVLC (HW / SW)
                    OutlinedButton(
                        onClick = {
                            autoRetryCount = 0
                            errorMessage = null
                            useSoftwareDecoder = !useSoftwareDecoder
                        },
                        shape = RoundedCornerShape(10.dp),
                        border = BorderStroke(1.dp, GoldAccent),
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = BgDeepCharcoal,
                            contentColor = GoldChampagne
                        ),
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
                        modifier = Modifier.pointerHoverIcon(PointerIcon(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)))
                    ) {
                        Icon(Icons.Default.Memory, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(Modifier.width(6.dp))
                        Text(
                            if (useSoftwareDecoder) "VLCJ · SW" else "VLCJ · HW",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                    Spacer(Modifier.width(8.dp))

                    // Botón de reconexión rápida
                    IconButton(
                        onClick = {
                            autoRetryCount = 0
                            errorMessage = null
                            statusBanner = "Reconectando stream..."
                            reloadTrigger++
                        },
                        modifier = Modifier
                            .size(36.dp)
                            .clip(CircleShape)
                            .background(BgDeepCharcoal)
                            .border(1.dp, BetisGreenLeaf, CircleShape)
                            .pointerHoverIcon(PointerIcon(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)))
                    ) {
                        Icon(Icons.Default.Refresh, contentDescription = "Reconectar", tint = GoldChampagne)
                    }

                    Spacer(Modifier.width(6.dp))

                    // Pantalla completa (F11)
                    IconButton(
                        onClick = onToggleFullscreen,
                        modifier = Modifier
                            .size(36.dp)
                            .clip(CircleShape)
                            .background(BgDeepCharcoal)
                            .border(1.dp, GoldAccent, CircleShape)
                            .pointerHoverIcon(PointerIcon(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)))
                    ) {
                        Icon(
                            if (isFullscreen) Icons.Default.FullscreenExit else Icons.Default.Fullscreen,
                            contentDescription = "Pantalla completa",
                            tint = GoldChampagne
                        )
                    }
                }
            }
        }

        // ─── 3. BARRA INFERIOR DE TRANSPORTE (Ocultación automática en Pantalla Completa) ─
        AnimatedVisibility(
            visible = showBars,
            enter = fadeIn(animationSpec = tween(220)) + slideInVertically(animationSpec = tween(220)) { it },
            exit = fadeOut(animationSpec = tween(320)) + slideOutVertically(animationSpec = tween(320)) { it },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        ) {
            Surface(
                color = if (isFullscreen) BgCardSurface.copy(alpha = 0.90f) else BgCardSurface,
                tonalElevation = 6.dp,
                border = BorderStroke(1.dp, BetisGreenLeaf.copy(alpha = 0.35f)),
                modifier = Modifier
                    .onPointerEvent(PointerEventType.Move) { notifyMouseActivity() }
            ) {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 22.dp, vertical = 10.dp)
                ) {
                    if (isBuffering && errorMessage == null) {
                        LinearProgressIndicator(
                            color = GoldAccent,
                            trackColor = BetisGreenPrimary,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(3.dp)
                                .padding(bottom = 6.dp)
                        )
                    }

                    if (!isLive && totalDurationMs > 0L) {
                        Slider(
                            value = (currentPosMs.toFloat() / totalDurationMs.toFloat()).coerceIn(0f, 1f),
                            onValueChange = { fraction ->
                                notifyMouseActivity()
                                val targetMs = (fraction * totalDurationMs).toLong()
                                currentPosMs = targetMs
                                runCatching {
                                    vlcComponentRef.value?.mediaPlayer()?.controls()?.setTime(targetMs)
                                }
                            },
                            colors = SliderDefaults.colors(
                                thumbColor = GoldAccent,
                                activeTrackColor = GoldAccent,
                                inactiveTrackColor = BetisGreenPrimary
                            ),
                            modifier = Modifier.fillMaxWidth().height(26.dp)
                        )
                    }

                    Row(
                        Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            IconButton(
                                onClick = {
                                    notifyMouseActivity()
                                    val mp = vlcComponentRef.value?.mediaPlayer() ?: return@IconButton
                                    if (isPlaying) mp.controls().pause() else mp.controls().play()
                                },
                                modifier = Modifier
                                    .size(38.dp)
                                    .clip(CircleShape)
                                    .background(GoldAccent)
                                    .pointerHoverIcon(PointerIcon(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)))
                            ) {
                                Icon(
                                    if (isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                                    contentDescription = if (isPlaying) "Pausar" else "Reproducir",
                                    tint = BgDeepCharcoal
                                )
                            }

                            if (!isLive) {
                                IconButton(
                                    onClick = {
                                        notifyMouseActivity()
                                        val target = (currentPosMs - 10_000L).coerceAtLeast(0L)
                                        currentPosMs = target
                                        runCatching {
                                            vlcComponentRef.value?.mediaPlayer()?.controls()?.setTime(target)
                                        }
                                    }
                                ) {
                                    Icon(Icons.Default.Replay10, contentDescription = "-10s", tint = TextPureWhite)
                                }
                                IconButton(
                                    onClick = {
                                        notifyMouseActivity()
                                        val target = currentPosMs + 10_000L
                                        currentPosMs = target
                                        runCatching {
                                            vlcComponentRef.value?.mediaPlayer()?.controls()?.setTime(target)
                                        }
                                    }
                                ) {
                                    Icon(Icons.Default.Forward10, contentDescription = "+10s", tint = TextPureWhite)
                                }
                                Text(
                                    "${formatTimeMs(currentPosMs)} / ${formatTimeMs(totalDurationMs)}",
                                    color = TextSilverGray,
                                    fontSize = 12.sp
                                )
                            } else {
                                Text(
                                    statusBanner
                                        ?: "Reproduciendo en directo · Zapping VLCJ (${if (useSoftwareDecoder) "SW" else "HW"} · ${LIVE_CACHING_MS}ms)",
                                    color = GoldChampagne,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Medium
                                )
                            }
                        }

                        // Controles de audio
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            IconButton(
                                onClick = {
                                    notifyMouseActivity()
                                    isMuted = !isMuted
                                    runCatching {
                                        vlcComponentRef.value?.mediaPlayer()?.audio()?.setMute(isMuted)
                                    }
                                }
                            ) {
                                Icon(
                                    if (isMuted || volume == 0f) Icons.AutoMirrored.Filled.VolumeOff
                                    else Icons.AutoMirrored.Filled.VolumeUp,
                                    contentDescription = "Silenciar",
                                    tint = GoldChampagne
                                )
                            }
                            Slider(
                                value = if (isMuted) 0f else volume,
                                onValueChange = { v ->
                                    notifyMouseActivity()
                                    volume = v
                                    isMuted = v == 0f
                                    runCatching {
                                        vlcComponentRef.value?.mediaPlayer()?.audio()?.setMute(isMuted)
                                        vlcComponentRef.value?.mediaPlayer()?.audio()?.setVolume((v * 100).toInt())
                                    }
                                },
                                colors = SliderDefaults.colors(
                                    thumbColor = GoldAccent,
                                    activeTrackColor = GoldAccent,
                                    inactiveTrackColor = BetisGreenPrimary
                                ),
                                modifier = Modifier.width(120.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

/**
 * Gestor del motor nativo LibVLC (vlcj) para Windows con Carga Perezosa (Lazy Initialization):
 * - No carga ningún binario nativo al arrancar la aplicación para que la ventana principal abra al instante.
 * - Inicializa LibVLC de forma asíncrona en Dispatchers.IO exclusivamente cuando el usuario accede al reproductor.
 * - Configura MediaPlayerFactory con parámetros de Zapping Rápido (búfer de 300ms, jitter 0 y desactivación de
 *   módulos innecesarios de subtítulos/OSD/estadísticas).
 */
object VlcRuntimeManager {
    private val initMutex = Mutex()
    private val warmUpScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    @Volatile
    private var sharedFactory: MediaPlayerFactory? = null

    @Volatile
    var detectedVlcDir: File? = null
        private set

    /**
     * Permite precalentar los binarios de LibVLC de forma totalmente asíncrona en segundo plano
     * si se desea, sin bloquear jamás el hilo principal.
     */
    fun warmUpAsync() {
        if (sharedFactory != null) return
        warmUpScope.launch {
            ensureFactoryInitializedAsync()
        }
    }

    /**
     * Inicializa y devuelve el MediaPlayerFactory compartido ejecutándose estrictamente en Dispatchers.IO.
     */
    suspend fun ensureFactoryInitializedAsync(): MediaPlayerFactory? {
        sharedFactory?.let { return it }
        return withContext(Dispatchers.IO) {
            initMutex.withLock {
                sharedFactory?.let { return@withLock it }
                createFactoryBlocking().also {
                    sharedFactory = it
                }
            }
        }
    }

    private fun createFactoryBlocking(): MediaPlayerFactory? {
        val vlcDir = locateVlcDirectory()
        if (vlcDir != null) {
            detectedVlcDir = vlcDir
            val path = vlcDir.absolutePath
            val pluginsDir = File(vlcDir, "plugins")

            System.setProperty("jna.library.path", path)
            if (pluginsDir.exists()) {
                System.setProperty("VLC_PLUGIN_PATH", pluginsDir.absolutePath)
            }

            NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcCoreLibraryName(), path)
            NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), path)

            val coreDll = File(vlcDir, "libvlccore.dll")
            val vlcDll = File(vlcDir, "libvlc.dll")
            if (coreDll.exists()) {
                runCatching { System.load(coreDll.absolutePath) }
            }
            if (vlcDll.exists()) {
                runCatching { System.load(vlcDll.absolutePath) }
            }
        }

        return runCatching {
            NativeDiscovery().discover()
            // Argumentos agresivos de baja latencia y zapping rápido para flujos IPTV (.ts / .m3u8 / Xtream)
            val args = mutableListOf(
                "--network-caching=$LIVE_CACHING_MS",
                "--live-caching=$LIVE_CACHING_MS",
                "--file-caching=$LIVE_CACHING_MS",
                "--disc-caching=$LIVE_CACHING_MS",
                "--clock-jitter=0",
                "--clock-synchro=0",
                "--http-reconnect",
                "--http-continuous",
                "--no-osd",
                "--no-video-title-show",
                "--no-stats",
                "--no-sub-autodetect-file",
                "--no-spu",
                "--no-snapshot-preview",
                "--no-metadata-network-access",
                "--avcodec-fast",
                "--avcodec-skiploopfilter=1",
                "--avcodec-hw=any",
                "--quiet"
            )
            detectedVlcDir?.let { dir ->
                val plugins = File(dir, "plugins")
                if (plugins.exists()) {
                    args.add("--plugin-path=${plugins.absolutePath}")
                }
            }
            MediaPlayerFactory(args)
        }.getOrNull()
    }

    fun locateVlcDirectory(): File? {
        detectedVlcDir?.let { return it }
        val candidates = mutableListOf<File>()

        // 1. Directorio de recursos empaquetado junto a XaviTV.exe (compose.application.resources.dir)
        System.getProperty("compose.application.resources.dir")?.takeIf { it.isNotBlank() }?.let { resDir ->
            candidates.add(File(resDir, "vlc"))
            candidates.add(File(resDir))
        }

        // 2. Rutas relativas al ejecutable o directorio de trabajo en modo portable / desarrollo
        val userDir = File(System.getProperty("user.dir") ?: ".")
        candidates.add(File(userDir, "app/resources/vlc"))
        candidates.add(File(userDir, "resources/vlc"))
        candidates.add(File(userDir, "vlc"))
        candidates.add(File(userDir, "desktop/app-resources/windows/vlc"))
        candidates.add(File(userDir, "app-resources/windows/vlc"))

        // 3. Rutas estándar de instalación de VLC en Windows (64-bit)
        candidates.add(File("C:\\Program Files\\VideoLAN\\VLC"))
        System.getenv("ProgramFiles")?.let { candidates.add(File(it, "VideoLAN\\VLC")) }
        System.getenv("LOCALAPPDATA")?.let { candidates.add(File(it, "Programs\\VideoLAN\\VLC")) }

        return candidates.firstOrNull { dir ->
            dir.exists() && dir.isDirectory &&
                File(dir, "libvlc.dll").exists() &&
                File(dir, "libvlccore.dll").exists()
        }?.also {
            detectedVlcDir = it
        }
    }
}

/**
 * Lanzador de ventana externa de VLC (usa primero el vlc.exe incluido en XaviTV o el instalado en el PC).
 */
private object VlcExternalLauncher {
    fun openStream(url: String, title: String): String {
        val cleanUrl = url.trim()
        val safeTitle = title.replace("\"", "'").trim().ifBlank { "XaviTV Stream" }

        findVlcExecutable()?.let { vlcExe ->
            runCatching {
                ProcessBuilder(
                    vlcExe.absolutePath,
                    "--meta-title=$safeTitle",
                    "--http-user-agent=$VLC_USER_AGENT",
                    "--network-caching=$LIVE_CACHING_MS",
                    "--live-caching=$LIVE_CACHING_MS",
                    "--clock-jitter=0",
                    "--no-sub-autodetect-file",
                    cleanUrl
                ).directory(vlcExe.parentFile).start()
                return "VLC Media Player"
            }
        }

        val tempM3u = runCatching {
            val file = File(System.getProperty("java.io.tmpdir"), "XaviTV_Canal.m3u")
            val m3uContent = buildString {
                append("#EXTM3U\r\n")
                append("#EXTINF:-1,").append(safeTitle).append("\r\n")
                append(cleanUrl).append("\r\n")
            }
            file.writeText(m3uContent, StandardCharsets.UTF_8)
            file
        }.getOrNull()

        if (tempM3u != null) {
            runCatching {
                if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.OPEN)) {
                    Desktop.getDesktop().open(tempM3u)
                    return "Reproductor del sistema (.m3u)"
                }
            }
            runCatching {
                ProcessBuilder("cmd", "/c", "start", "", tempM3u.absolutePath).start()
                return "Reproductor del sistema"
            }
        }

        runCatching {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(URI(cleanUrl))
            }
        }
        return "Aplicación predeterminada"
    }

    private fun findVlcExecutable(): File? {
        val candidates = mutableListOf<File>()

        // 1. vlc.exe empaquetado junto a XaviTV
        VlcRuntimeManager.locateVlcDirectory()?.let { dir ->
            candidates.add(File(dir, "vlc.exe"))
        }

        // 2. Rutas estándar de Windows
        candidates.add(File("C:\\Program Files\\VideoLAN\\VLC\\vlc.exe"))
        candidates.add(File("C:\\Program Files (x86)\\VideoLAN\\VLC\\vlc.exe"))
        System.getenv("ProgramFiles")?.let { candidates.add(File(it, "VideoLAN\\VLC\\vlc.exe")) }
        System.getenv("ProgramFiles(x86)")?.let { candidates.add(File(it, "VideoLAN\\VLC\\vlc.exe")) }
        System.getenv("LOCALAPPDATA")?.let { candidates.add(File(it, "Programs\\VideoLAN\\VLC\\vlc.exe")) }

        candidates.firstOrNull { it.exists() && it.isFile }?.let { return it }

        // 3. Registro de Windows
        val regKeys = listOf(
            "HKLM\\SOFTWARE\\VideoLAN\\VLC",
            "HKLM\\SOFTWARE\\WOW6432Node\\VideoLAN\\VLC",
            "HKCU\\SOFTWARE\\VideoLAN\\VLC"
        )
        for (key in regKeys) {
            val out = runRegistryQuery(key, "InstallDir")
            if (!out.isNullOrBlank()) {
                val f = File(out.trim(), "vlc.exe")
                if (f.exists()) return f
            }
        }
        return null
    }

    private fun runRegistryQuery(key: String, valueName: String): String? {
        return try {
            val proc = ProcessBuilder("reg", "query", key, "/v", valueName)
                .redirectErrorStream(true)
                .start()
            proc.waitFor(2, TimeUnit.SECONDS)
            val output = proc.inputStream.bufferedReader().readText()
            val match = Regex("""REG_SZ\s+(.+)""").find(output)
            match?.groupValues?.get(1)?.trim()
        } catch (_: Exception) {
            null
        }
    }
}

private fun formatTimeMs(ms: Long): String {
    val totalSeconds = (ms / 1000L).coerceAtLeast(0L)
    val hours = totalSeconds / 3600L
    val minutes = (totalSeconds % 3600L) / 60L
    val seconds = totalSeconds % 60L
    return if (hours > 0) {
        "%d:%02d:%02d".format(hours, minutes, seconds)
    } else {
        "%02d:%02d".format(minutes, seconds)
    }
}
