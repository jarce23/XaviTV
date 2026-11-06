@file:OptIn(
    kotlinx.cinterop.ExperimentalForeignApi::class,
    kotlin.experimental.ExperimentalNativeApi::class,
    kotlin.native.runtime.NativeRuntimeApi::class
)

package com.minuevaapp.tv.shared.platform

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.OpenInNew
import androidx.compose.material.icons.filled.Forward10
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Replay10
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.interop.UIKitView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.minuevaapp.tv.shared.ui.*
import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.delay
import kotlinx.serialization.json.Json
import org.jetbrains.skia.FilterMipmap
import org.jetbrains.skia.FilterMode
import org.jetbrains.skia.Image
import org.jetbrains.skia.MipmapMode
import org.jetbrains.skia.Paint
import org.jetbrains.skia.Rect
import org.jetbrains.skia.SamplingMode
import org.jetbrains.skia.Surface
import platform.AVFAudio.*
import platform.AVFoundation.*
import platform.AVKit.AVPlayerViewController
import platform.CoreMedia.CMTimeGetSeconds
import platform.CoreMedia.CMTimeMakeWithSeconds
import platform.Foundation.*
import platform.Foundation.NSClassFromString
import platform.Foundation.NSSelectorFromString
import platform.UIKit.UIApplication
import platform.UIKit.UIColor
import platform.UIKit.UIView
import platform.darwin.NSObject
import platform.darwin.NSObjectMeta
import kotlinx.cinterop.*
import kotlin.math.max
import kotlin.math.roundToInt
import kotlin.native.runtime.GC

var vlcPlayerViewFactory: (() -> UIView)? = null

fun registerVlcPlayerViewFactory(factory: () -> UIView) {
    vlcPlayerViewFactory = factory
}

var vlcToggleOverlayHandler: (() -> Unit)? = null

fun registerVlcToggleOverlayHandler(handler: () -> Unit) {
    vlcToggleOverlayHandler = handler
}

private const val PREFS_STATE_KEY = "xavitv_ios_local_state_v1"
private const val PREFS_M3U_FALLBACK_PREFIX = "xavitv_ios_m3u_cache_"

// Búfer ultrarreducido (0.45 segundos) para zapping instantáneo en canales en directo con AVPlayer
private const val IOS_LIVE_FORWARD_BUFFER_SECONDS = 0.45
private const val IOS_VOD_FORWARD_BUFFER_SECONDS = 2.0

actual object PlatformStorage {
    private val documentsDir: String? by lazy {
        val paths = NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, true)
        (paths.firstOrNull() as? String)?.takeIf { it.isNotBlank() }
    }

    private val cachesDir: String? by lazy {
        val paths = NSSearchPathForDirectoriesInDomains(NSCachesDirectory, NSUserDomainMask, true)
        (paths.firstOrNull() as? String)?.takeIf { it.isNotBlank() } ?: documentsDir
    }

    private fun stateFilePath(): String? = documentsDir?.let { "$it/xavitv_ios_state.json" }
    private fun stateBackupFilePath(): String? = documentsDir?.let { "$it/xavitv_ios_state.json.bak" }

    private fun m3uCacheFilePath(cacheKey: String): String? {
        val safeKey = cacheKey.replace(Regex("[^a-zA-Z0-9._-]"), "_")
        return cachesDir?.let { "$it/xavitv_m3u_$safeKey.m3u" }
    }

    private fun readUtf8File(path: String?): String? {
        if (path.isNullOrBlank()) return null
        return runCatching {
            NSString.stringWithContentsOfFile(
                path = path,
                encoding = NSUTF8StringEncoding,
                error = null
            )?.takeIf { it.isNotBlank() }
        }.getOrNull()
    }

    private fun writeUtf8File(path: String?, content: String) {
        if (path.isNullOrBlank() || content.isBlank()) return
        runCatching {
            val nsString = NSString.create(string = content)
            nsString.writeToFile(
                path = path,
                atomically = true,
                encoding = NSUTF8StringEncoding,
                error = null
            )
        }
    }

    actual fun loadStateJson(): String? {
        readUtf8File(stateFilePath())?.let { return it }
        readUtf8File(stateBackupFilePath())?.let { return it }
        return runCatching {
            NSUserDefaults.standardUserDefaults.stringForKey(PREFS_STATE_KEY)?.takeIf { it.isNotBlank() }
        }.getOrNull()
    }

    actual fun saveStateJson(json: String) {
        if (json.isBlank()) return
        writeUtf8File(stateFilePath(), json)
        writeUtf8File(stateBackupFilePath(), json)
        runCatching {
            NSUserDefaults.standardUserDefaults.setObject(json, forKey = PREFS_STATE_KEY)
            NSUserDefaults.standardUserDefaults.synchronize()
        }
    }

    actual fun loadCachedM3u(cacheKey: String): String? {
        readUtf8File(m3uCacheFilePath(cacheKey))?.let { return it }
        return runCatching {
            NSUserDefaults.standardUserDefaults.stringForKey(PREFS_M3U_FALLBACK_PREFIX + cacheKey)
        }.getOrNull()
    }

    actual fun saveCachedM3u(cacheKey: String, content: String) {
        if (content.isBlank()) return
        writeUtf8File(m3uCacheFilePath(cacheKey), content)
        runCatching {
            NSUserDefaults.standardUserDefaults.removeObjectForKey(PREFS_M3U_FALLBACK_PREFIX + cacheKey)
        }
    }
}

actual fun createPlatformHttpClient(): HttpClient {
    runCatching {
        NSURLCache.sharedURLCache.setMemoryCapacity(4UL * 1024UL * 1024UL)
        NSURLCache.sharedURLCache.setDiskCapacity(24UL * 1024UL * 1024UL)
    }

    return HttpClient(Darwin) {
        engine {
            configureRequest {
                setAllowsCellularAccess(true)
                setCachePolicy(NSURLRequestReloadIgnoringLocalCacheData)
            }
        }
        install(HttpTimeout) {
            requestTimeoutMillis = 20_000
            connectTimeoutMillis = 12_000
            socketTimeoutMillis = 20_000
        }
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                    coerceInputValues = true
                }
            )
        }
    }
}

actual fun decodeImageBytes(bytes: ByteArray, maxDimension: Int): ImageBitmap? {
    if (bytes.isEmpty() || bytes.size > 4 * 1024 * 1024) return null
    return try {
        val rawImage = Image.makeFromEncoded(bytes)
        try {
            val srcW = rawImage.width
            val srcH = rawImage.height
            if (srcW <= 0 || srcH <= 0) return null

            val largestSide = max(srcW, srcH)
            if (largestSide <= maxDimension) {
                rawImage.toComposeImageBitmap()
            } else {
                val scale = maxDimension.toFloat() / largestSide.toFloat()
                val dstW = (srcW * scale).roundToInt().coerceAtLeast(1)
                val dstH = (srcH * scale).roundToInt().coerceAtLeast(1)
                val surface = Surface.makeRasterN32Premul(dstW, dstH)
                try {
                    val paint = Paint().apply { isAntiAlias = true }
                    surface.canvas.drawImageRect(
                        rawImage,
                        Rect.makeWH(srcW.toFloat(), srcH.toFloat()),
                        Rect.makeWH(dstW.toFloat(), dstH.toFloat()),
                        FilterMipmap(FilterMode.LINEAR, MipmapMode.NONE) as SamplingMode,
                        paint,
                        true
                    )
                    val scaledImage = surface.makeImageSnapshot()
                    try {
                        scaledImage.toComposeImageBitmap()
                    } finally {
                        scaledImage.close()
                    }
                } finally {
                    surface.close()
                }
            }
        } finally {
            rawImage.close()
        }
    } catch (_: Throwable) {
        null
    }
}

actual fun trimPlatformMemory() {
    runCatching {
        NSURLCache.sharedURLCache.removeAllCachedResponses()
        GC.collect()
    }
}

actual fun openStreamInExternalApp(url: String, title: String): Boolean {
    val cleanUrl = url.trim()
    if (cleanUrl.isBlank()) return false

    val candidates = listOf(
        "vlc-x-callback://x-callback-url/stream?url=$cleanUrl",
        "vlc://$cleanUrl",
        cleanUrl
    )

    val app = UIApplication.sharedApplication
    for (candidate in candidates) {
        val nsUrl = NSURL.URLWithString(candidate) ?: continue
        if (app.canOpenURL(nsUrl)) {
            app.openURL(nsUrl)
            return true
        }
    }
    return false
}

private fun formatIosPlayerTime(ms: Long): String {
    if (ms <= 0L) return "00:00"
    val totalSeconds = ms / 1000L
    val s = totalSeconds % 60
    val m = (totalSeconds / 60) % 60
    val h = totalSeconds / 3600
    val ss = if (s < 10) "0$s" else "$s"
    val mm = if (m < 10) "0$m" else "$m"
    return if (h > 0) {
        val hh = if (h < 10) "0$h" else "$h"
        "$hh:$mm:$ss"
    } else {
        "$mm:$ss"
    }
}

private fun buildIosCandidateStreamUrls(originalUrl: String, isLive: Boolean): List<String> {
    val clean = originalUrl.trim()
    val candidates = mutableListOf<String>()

    fun addUnique(u: String) {
        if (u.isNotBlank() && u !in candidates) {
            candidates.add(u)
        }
    }

    addUnique(clean)

    val isTsUrl = clean.endsWith(".ts", ignoreCase = true) || clean.contains(".ts?", ignoreCase = true)
    if (isTsUrl) {
        val m3u8Variant = clean.replace(Regex("\\.ts(\\?.*)?$", RegexOption.IGNORE_CASE), ".m3u8$1")
        addUnique(m3u8Variant)
        if (!clean.contains("/live/", ignoreCase = true)) {
            val parts = m3u8Variant.split("/")
            if (parts.size >= 6) {
                val base = parts.take(3).joinToString("/")
                val rest = parts.drop(3).joinToString("/")
                addUnique("$base/live/$rest")
            }
        }
    } else if (clean.endsWith(".m3u8", ignoreCase = true) || clean.contains(".m3u8?", ignoreCase = true)) {
        val tsVariant = clean.replace(Regex("\\.m3u8(\\?.*)?$", RegexOption.IGNORE_CASE), ".ts$1")
        addUnique(tsVariant)
    }

    return candidates
}

@Composable
private fun IsolatedIosVlcSurface(
    onViewCreated: (UIView) -> Unit,
    modifier: Modifier = Modifier
) {
    UIKitView(
        factory = {
            val rawClass = NSClassFromString("VLCPlayerHostView") ?: NSClassFromString("iosApp.VLCPlayerHostView")
            val classAsObj = rawClass as? NSObject
            val view = vlcPlayerViewFactory?.invoke()
                ?: (classAsObj?.performSelector(NSSelectorFromString("new")) as? UIView)
                ?: UIView().apply { backgroundColor = UIColor.blackColor }
            onViewCreated(view)
            view
        },
        update = { _ -> },
        modifier = modifier
    )
}

@Composable
actual fun NativeVideoPlayer(
    url: String,
    title: String,
    subtitle: String,
    isLive: Boolean,
    resumeKey: String,
    initialPositionMs: Long,
    onSavePosition: (Long) -> Unit,
    onSaveProgress: (positionMs: Long, durationMs: Long) -> Unit,
    onClose: () -> Unit
) {
    LaunchedEffect(Unit) {
        runCatching {
            val session = AVAudioSession.sharedInstance()
            session.setCategory(AVAudioSessionCategoryPlayback, null)
            session.setMode(AVAudioSessionModeMoviePlayback, null)
            session.setActive(true, null)
        }
    }

    val candidates = remember(url, isLive) { buildIosCandidateStreamUrls(url, isLive) }
    var candidateIndex by remember(url) { mutableStateOf(0) }
    var reloadSalt by remember(url) { mutableStateOf(0) }
    var isPlaying by remember(url) { mutableStateOf(true) }
    var currentAspectIndex by remember(url) { mutableStateOf(0) }
    val aspectRatios = remember { listOf("DEFAULT", "16:9", "4:3", "FILL") }
    var statusLabel by remember(url) { mutableStateOf("VLCKit • Iniciando decodificador...") }
    var hasPlaybackError by remember(url) { mutableStateOf(false) }
    var showOverlayBar by remember { mutableStateOf(true) }
    var lastInteractionTick by remember { mutableStateOf(0) }
    var hostViewRef by remember { mutableStateOf<UIView?>(null) }

    // Estados de reproducción VOD interactivos
    var currentPosMs by remember(url) { mutableStateOf(if (!isLive && initialPositionMs > 0L) initialPositionMs else 0L) }
    var totalDurationMs by remember(url) { mutableStateOf(0L) }
    var isDraggingSlider by remember(url) { mutableStateOf(false) }
    var sliderDragFraction by remember(url) { mutableStateOf(0f) }
    val playbackClockHolder = remember(url) { LongArray(2) } // [0] = timeMs, [1] = durationMs
    val seekAppliedHolder = remember(url) { BooleanArray(1) }

    val currentStreamUrl = candidates.getOrElse(candidateIndex) { url }

    // Ocultación automática tras 4 segundos sin interacción (solo si no se está arrastrando el slider)
    LaunchedEffect(showOverlayBar, lastInteractionTick, hasPlaybackError, isDraggingSlider) {
        if (showOverlayBar && !hasPlaybackError && !isDraggingSlider) {
            delay(4_000L)
            showOverlayBar = false
        }
    }

    // Inicialización y carga del flujo
    LaunchedEffect(currentStreamUrl, reloadSalt, hostViewRef) {
        val hostView = hostViewRef ?: return@LaunchedEffect
        hasPlaybackError = false
        isPlaying = true
        showOverlayBar = true
        seekAppliedHolder[0] = false

        val formatTag = when {
            currentStreamUrl.contains(".ts", ignoreCase = true) -> "MPEG-TS (.ts)"
            currentStreamUrl.contains(".m3u8", ignoreCase = true) -> "HLS (.m3u8)"
            else -> "Stream directo"
        }
        statusLabel = "VLCKit • Conectando $formatTag..."

        val playSel = if (isLive) NSSelectorFromString("playStreamUrl:") else NSSelectorFromString("playVodUrl:")
        val safeUrl = currentStreamUrl.trim().ifBlank { "" }
        val nsUrl = NSString.create(string = safeUrl)
        (hostView as? NSObject)?.performSelector(playSel, withObject = nsUrl)

        if (!isLive && initialPositionMs > 3_000L) {
            val sec = initialPositionMs.toDouble() / 1000.0
            val seekSel = NSSelectorFromString("seekToNumber:")
            val nsSec = NSNumber(double = sec)
            (hostView as? NSObject)?.performSelector(seekSel, withObject = nsSec)
        }

        val aspectSel = NSSelectorFromString("setAspectRatio:")
        val safeRatio = aspectRatios.getOrNull(currentAspectIndex) ?: "DEFAULT"
        val nsRatio = NSString.create(string = safeRatio)
        (hostView as? NSObject)?.performSelector(aspectSel, withObject = nsRatio)
    }

    // Supervisión periódica cada 1s: telemetría, detección de errores, reanudación y guardado continuo
    LaunchedEffect(currentStreamUrl, reloadSalt, hostViewRef) {
        val hostView = hostViewRef ?: return@LaunchedEffect
        var tickCount = 0
        while (true) {
            delay(1000L)
            tickCount++

            val errSel = NSSelectorFromString("getHasErrorNumber")
            val hasErr = ((hostView as? NSObject)?.performSelector(errSel) as? NSNumber)?.boolValue
                ?: ((hostView as? NSObject)?.valueForKey("currentHasError") as? NSNumber)?.boolValue
                ?: false

            if (hasErr && !hasPlaybackError) {
                if (candidateIndex + 1 < candidates.size) {
                    candidateIndex += 1
                    statusLabel = "Conmutando variante (${candidateIndex + 1}/${candidates.size})..."
                    break
                } else {
                    hasPlaybackError = true
                    showOverlayBar = true
                    statusLabel = "Fallo de decodificación. Reintenta o abre en VLC externo"
                }
            } else if (!hasPlaybackError) {
                val isPlayingNum = (hostView as? NSObject)?.performSelector(NSSelectorFromString("getIsPlayingNumber")) as? NSNumber
                val playingNow = isPlayingNum?.boolValue ?: isPlaying
                if (isPlaying != playingNow) {
                    isPlaying = playingNow
                }
                val formatTag = when {
                    currentStreamUrl.contains(".ts", ignoreCase = true) -> "MPEG-TS (.ts)"
                    currentStreamUrl.contains(".m3u8", ignoreCase = true) -> "HLS (.m3u8)"
                    else -> "Stream directo"
                }
                statusLabel = if (isPlaying) {
                    if (isLive) "VLCKit • En directo ($formatTag)" else "VLCKit • Reproduciendo"
                } else {
                    "VLCKit • En pausa"
                }
            }

            if (!isLive) {
                val timeSel = NSSelectorFromString("getPlaybackTimeMs")
                val durSel = NSSelectorFromString("getDurationMs")
                val timeNum = (hostView as? NSObject)?.performSelector(timeSel) as? NSNumber
                val durNum = (hostView as? NSObject)?.performSelector(durSel) as? NSNumber
                val timeMs = timeNum?.longLongValue ?: 0L
                val durMs = durNum?.longLongValue ?: 0L

                if (timeMs > 0L) {
                    playbackClockHolder[0] = timeMs
                    if (!isDraggingSlider) {
                        currentPosMs = timeMs
                    }
                }
                if (durMs > 0L) {
                    playbackClockHolder[1] = durMs
                    totalDurationMs = durMs
                }

                // Reanudación automática al segundo exacto en cuanto el reproductor esté activo
                if (!seekAppliedHolder[0] && initialPositionMs > 3_000L && (timeMs > 0L || durMs > 0L || isPlaying)) {
                    val sec = initialPositionMs.toDouble() / 1000.0
                    val seekSel = NSSelectorFromString("seekToNumber:")
                    val nsSec = NSNumber(double = sec)
                    (hostView as? NSObject)?.performSelector(seekSel, withObject = nsSec)
                    seekAppliedHolder[0] = true
                    if (!isDraggingSlider) {
                        currentPosMs = initialPositionMs
                    }
                }

                // Guardado periódico cada 5 segundos en background
                if (tickCount % 5 == 0 && timeMs > 2_000L && isPlaying) {
                    onSaveProgress(timeMs, durMs)
                }
            }
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            val hostView = hostViewRef
            if (!isLive) {
                val timeSel = NSSelectorFromString("getPlaybackTimeMs")
                val durSel = NSSelectorFromString("getDurationMs")
                val curPos = ((hostView as? NSObject)?.performSelector(timeSel) as? NSNumber)?.longLongValue ?: 0L
                val curDur = ((hostView as? NSObject)?.performSelector(durSel) as? NSNumber)?.longLongValue ?: 0L
                val finalPos = if (curPos > 0L) curPos else playbackClockHolder[0]
                val finalDur = if (curDur > 0L) curDur else playbackClockHolder[1]
                if (finalPos > 2000L) {
                    onSaveProgress(finalPos, finalDur)
                    onSavePosition(finalPos)
                }
            }
            (hostView as? NSObject)?.performSelector(NSSelectorFromString("stopStream"))
            hostViewRef = null
            trimPlatformMemory()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        IsolatedIosVlcSurface(
            onViewCreated = { view -> hostViewRef = view },
            modifier = Modifier.fillMaxSize()
        )

        // Capa táctil transparente para alternar la visibilidad de los controles
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) {
                    showOverlayBar = !showOverlayBar
                    lastInteractionTick++
                }
        )

        // Barra superior de controles superpuesta
        AnimatedVisibility(
            visible = showOverlayBar || hasPlaybackError,
            enter = fadeIn(tween(250)) + slideInVertically(tween(250)) { -it },
            exit = fadeOut(tween(300)) + slideOutVertically(tween(300)) { -it },
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth()
        ) {
            Surface(
                color = Color(0xFF0B1F15).copy(alpha = 0.92f),
                border = BorderStroke(1.dp, GoldPrimary.copy(alpha = 0.35f))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .windowInsetsPadding(
                            WindowInsets.safeDrawing.only(WindowInsetsSides.Top + WindowInsetsSides.Horizontal)
                        )
                        .padding(horizontal = 14.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    IconButton(
                        onClick = onClose,
                        modifier = Modifier
                            .size(38.dp)
                            .clip(CircleShape)
                            .background(GreenBetis)
                            .border(1.dp, GoldPrimary, CircleShape)
                    ) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver",
                            tint = GoldLight
                        )
                    }

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = title,
                            color = TextWhite,
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = if (subtitle.isNotBlank()) "$subtitle • $statusLabel" else statusLabel,
                            color = if (hasPlaybackError) GoldPrimary else GoldLight,
                            style = MaterialTheme.typography.labelSmall,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }

                    // Selector de relación de aspecto
                    OutlinedButton(
                        onClick = {
                            lastInteractionTick++
                            currentAspectIndex = (currentAspectIndex + 1) % aspectRatios.size
                            val selectedRatio = aspectRatios[currentAspectIndex]
                            val aspectSel = NSSelectorFromString("setAspectRatio:")
                            val nsRatio = NSString.create(string = selectedRatio)
                            (hostViewRef as? NSObject)?.performSelector(aspectSel, withObject = nsRatio)
                        },
                        border = BorderStroke(1.dp, GoldPrimary),
                        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp)
                    ) {
                        Icon(
                            Icons.Default.Tune,
                            contentDescription = "Relación de aspecto",
                            tint = GoldPrimary,
                            modifier = Modifier.size(14.dp)
                        )
                        Spacer(Modifier.width(4.dp))
                        Text(
                            aspectRatios[currentAspectIndex],
                            color = GoldPrimary,
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    if (isLive && candidates.size > 1) {
                        OutlinedButton(
                            onClick = {
                                lastInteractionTick++
                                candidateIndex = (candidateIndex + 1) % candidates.size
                            },
                            border = BorderStroke(1.dp, GoldPrimary),
                            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp)
                        ) {
                            Text(
                                "${candidateIndex + 1}/${candidates.size}",
                                color = GoldPrimary,
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    if (isLive) {
                        IconButton(
                            onClick = {
                                lastInteractionTick++
                                reloadSalt += 1
                            },
                            modifier = Modifier
                                .size(38.dp)
                                .background(SurfaceCard, RoundedCornerShape(10.dp))
                        ) {
                            Icon(Icons.Default.Refresh, contentDescription = "Recargar stream", tint = TextWhite)
                        }
                    }

                    IconButton(
                        onClick = { openStreamInExternalApp(url, title) },
                        modifier = Modifier
                            .size(38.dp)
                            .background(GreenBetis, RoundedCornerShape(10.dp))
                            .border(1.dp, GoldPrimary.copy(alpha = 0.6f), RoundedCornerShape(10.dp))
                    ) {
                        Icon(
                            Icons.AutoMirrored.Filled.OpenInNew,
                            contentDescription = "Abrir en VLC externo",
                            tint = GoldPrimary
                        )
                    }
                }
            }
        }

        // Barra inferior de controles (VOD / Directo)
        AnimatedVisibility(
            visible = showOverlayBar || hasPlaybackError,
            enter = fadeIn(tween(250)) + slideInVertically(tween(250)) { it },
            exit = fadeOut(tween(300)) + slideOutVertically(tween(300)) { it },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        ) {
            Surface(
                color = Color(0xFF0B1F15).copy(alpha = 0.94f),
                border = BorderStroke(1.dp, GoldPrimary.copy(alpha = 0.35f))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .windowInsetsPadding(
                            WindowInsets.safeDrawing.only(WindowInsetsSides.Bottom + WindowInsetsSides.Horizontal)
                        )
                        .padding(horizontal = 18.dp, vertical = 12.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    if (!isLive && totalDurationMs > 0L) {
                        val sliderVal = if (isDraggingSlider) {
                            sliderDragFraction
                        } else {
                            (currentPosMs.toFloat() / totalDurationMs.toFloat()).coerceIn(0f, 1f)
                        }
                        Slider(
                            value = sliderVal,
                            onValueChange = { frac ->
                                lastInteractionTick++
                                isDraggingSlider = true
                                sliderDragFraction = frac
                            },
                            onValueChangeFinished = {
                                val targetMs = (sliderDragFraction * totalDurationMs).toLong()
                                currentPosMs = targetMs
                                isDraggingSlider = false
                                val sec = targetMs.toDouble() / 1000.0
                                val seekSel = NSSelectorFromString("seekToNumber:")
                                (hostViewRef as? NSObject)?.performSelector(seekSel, withObject = NSNumber(double = sec))
                                if (targetMs > 2000L) {
                                    onSaveProgress(targetMs, totalDurationMs)
                                    onSavePosition(targetMs)
                                }
                                lastInteractionTick++
                            },
                            colors = SliderDefaults.colors(
                                thumbColor = GoldPrimary,
                                activeTrackColor = GoldPrimary,
                                inactiveTrackColor = BetisGreenLeaf.copy(alpha = 0.45f)
                            ),
                            modifier = Modifier.fillMaxWidth().height(26.dp)
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            if (!isLive) {
                                IconButton(
                                    onClick = {
                                        lastInteractionTick++
                                        val target = (currentPosMs - 10_000L).coerceAtLeast(0L)
                                        currentPosMs = target
                                        val sec = target.toDouble() / 1000.0
                                        (hostViewRef as? NSObject)?.performSelector(NSSelectorFromString("seekToNumber:"), withObject = NSNumber(double = sec))
                                        if (target > 2000L) {
                                            onSaveProgress(target, totalDurationMs)
                                            onSavePosition(target)
                                        }
                                    },
                                    modifier = Modifier
                                        .size(38.dp)
                                        .background(SurfaceCard, RoundedCornerShape(10.dp))
                                ) {
                                    Icon(
                                        Icons.Default.Replay10,
                                        contentDescription = "Retroceder 10s",
                                        tint = GoldLight
                                    )
                                }
                            }

                            // Botón principal Reproducir / Pausa
                            IconButton(
                                onClick = {
                                    lastInteractionTick++
                                    val hostView = hostViewRef
                                    if (hostView != null) {
                                        if (isPlaying && !isLive) {
                                            if (currentPosMs > 2000L) {
                                                onSaveProgress(currentPosMs, totalDurationMs)
                                                onSavePosition(currentPosMs)
                                            }
                                        }
                                        val sel = if (isPlaying) NSSelectorFromString("pauseStream") else NSSelectorFromString("resumeStream")
                                        (hostView as? NSObject)?.performSelector(sel)
                                        isPlaying = !isPlaying
                                        statusLabel = if (isPlaying) "VLCKit • Reproduciendo" else "VLCKit • En pausa"
                                    }
                                },
                                modifier = Modifier
                                    .size(44.dp)
                                    .clip(CircleShape)
                                    .background(GreenBetis)
                                    .border(1.5.dp, GoldPrimary, CircleShape)
                            ) {
                                Icon(
                                    imageVector = if (isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                                    contentDescription = if (isPlaying) "Pausar" else "Reproducir",
                                    tint = GoldLight,
                                    modifier = Modifier.size(24.dp)
                                )
                            }

                            if (!isLive) {
                                IconButton(
                                    onClick = {
                                        lastInteractionTick++
                                        val target = if (totalDurationMs > 0) (currentPosMs + 10_000L).coerceAtMost(totalDurationMs) else currentPosMs + 10_000L
                                        currentPosMs = target
                                        val sec = target.toDouble() / 1000.0
                                        (hostViewRef as? NSObject)?.performSelector(NSSelectorFromString("seekToNumber:"), withObject = NSNumber(double = sec))
                                        if (target > 2000L) {
                                            onSaveProgress(target, totalDurationMs)
                                            onSavePosition(target)
                                        }
                                    },
                                    modifier = Modifier
                                        .size(38.dp)
                                        .background(SurfaceCard, RoundedCornerShape(10.dp))
                                ) {
                                    Icon(
                                        Icons.Default.Forward10,
                                        contentDescription = "Adelantar 10s",
                                        tint = GoldLight
                                    )
                                }
                            }
                        }

                        if (!isLive) {
                            Text(
                                text = "${formatIosPlayerTime(currentPosMs)} / ${formatIosPlayerTime(totalDurationMs)}",
                                color = GoldLight,
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold
                            )
                        } else {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Box(
                                    Modifier
                                        .size(8.dp)
                                        .clip(CircleShape)
                                        .background(GoldPrimary)
                                )
                                Text(
                                    text = "EN DIRECTO",
                                    color = GoldPrimary,
                                    style = MaterialTheme.typography.labelMedium,
                                    fontWeight = FontWeight.ExtraBold
                                )
                            }
                        }
                    }
                }
            }
        }

        // Tarjeta de aviso y recuperación si el flujo no se puede reproducir
        if (hasPlaybackError) {
            Surface(
                color = SurfaceCard.copy(alpha = 0.96f),
                shape = RoundedCornerShape(18.dp),
                border = BorderStroke(1.5.dp, GoldPrimary),
                modifier = Modifier
                    .align(Alignment.Center)
                    .windowInsetsPadding(WindowInsets.safeDrawing)
                    .padding(24.dp)
                    .widthIn(max = 440.dp)
            ) {
                Column(
                    modifier = Modifier.padding(22.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        "No se pudo decodificar el stream",
                        color = GoldPrimary,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Text(
                        "El motor interno VLCKit ha intentado procesar el stream en formato MPEG-TS (.ts) y HLS (.m3u8). Si el enlace está caído o protegido, puedes reintentar la conexión o lanzarlo en la app oficial de VLC para iOS.",
                        color = TextMuted,
                        style = MaterialTheme.typography.bodySmall
                    )
                    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        Button(
                            onClick = {
                                candidateIndex = 0
                                reloadSalt += 1
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = GoldPrimary,
                                contentColor = DarkCharcoal
                            )
                        ) {
                            Icon(Icons.Default.PlayArrow, contentDescription = null)
                            Spacer(Modifier.width(6.dp))
                            Text("Reintentar", fontWeight = FontWeight.Bold)
                        }
                        OutlinedButton(
                            onClick = { openStreamInExternalApp(url, title) },
                            border = BorderStroke(1.dp, GoldPrimary)
                        ) {
                            Icon(Icons.AutoMirrored.Filled.OpenInNew, contentDescription = null, tint = GoldPrimary)
                            Spacer(Modifier.width(6.dp))
                            Text("Abrir en VLC", color = GoldPrimary)
                        }
                    }
                }
            }
        }
    }
}
