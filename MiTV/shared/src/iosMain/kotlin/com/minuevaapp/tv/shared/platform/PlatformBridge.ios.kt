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
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.OpenInNew
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
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

private const val PREFS_STATE_KEY = "xavitv_ios_local_state_v1"
private const val PREFS_M3U_FALLBACK_PREFIX = "xavitv_ios_m3u_cache_"

// Búfer ultrarreducido (0.45 segundos) para zapping instantáneo en canales en directo con AVPlayer
private const val IOS_LIVE_FORWARD_BUFFER_SECONDS = 0.45
private const val IOS_VOD_FORWARD_BUFFER_SECONDS = 2.0

actual object PlatformStorage {
    actual fun loadStateJson(): String? {
        return NSUserDefaults.standardUserDefaults.stringForKey(PREFS_STATE_KEY)
    }

    actual fun saveStateJson(json: String) {
        NSUserDefaults.standardUserDefaults.setObject(json, forKey = PREFS_STATE_KEY)
        NSUserDefaults.standardUserDefaults.synchronize()
    }

    actual fun loadCachedM3u(cacheKey: String): String? {
        return runCatching {
            NSUserDefaults.standardUserDefaults.stringForKey(PREFS_M3U_FALLBACK_PREFIX + cacheKey)
        }.getOrNull()
    }

    actual fun saveCachedM3u(cacheKey: String, content: String) {
        if (content.isBlank()) return
        runCatching {
            NSUserDefaults.standardUserDefaults.setObject(
                content,
                forKey = PREFS_M3U_FALLBACK_PREFIX + cacheKey
            )
            NSUserDefaults.standardUserDefaults.synchronize()
        }
    }
}

actual fun createPlatformHttpClient(): HttpClient {
    // Limita la caché en memoria de NSURLCache en iOS para evitar picos de RAM en iPhone/iPad
    runCatching {
        NSURLCache.sharedURLCache.setMemoryCapacity(4UL * 1024UL * 1024UL) // Máx 4 MB RAM en NSURLCache
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

/**
 * Decodifica y submuestrea la imagen a una dimensión máxima (maxDimension) liberando
 * de inmediato el buffer nativo original de Skia para evitar cierres por falta de memoria (OOM)
 * en iPhone e iPad al recorrer catálogos extensos.
 */
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

/**
 * Construye la lista de URLs candidatas para el motor multimedia VLCKit / AVPlayer en iOS/iPadOS:
 * Prioriza la reproducción directa de flujos MPEG-TS (.ts) y HLS (.m3u8), soportando además
 * conversiones automáticas entre formatos para servidores Xtream Codes.
 */
private fun buildIosCandidateStreamUrls(originalUrl: String, isLive: Boolean): List<String> {
    val clean = originalUrl.trim()
    val candidates = mutableListOf<String>()

    fun addUnique(u: String) {
        if (u.isNotBlank() && u !in candidates) {
            candidates.add(u)
        }
    }

    // 1) Flujo original directo (máxima compatibilidad nativa con VLCKit)
    addUnique(clean)

    val isTsUrl = clean.endsWith(".ts", ignoreCase = true) || clean.contains(".ts?", ignoreCase = true)
    if (isTsUrl) {
        // Variante .m3u8 para servidores Xtream Codes
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
actual fun NativeVideoPlayer(
    url: String,
    title: String,
    subtitle: String,
    isLive: Boolean,
    resumeKey: String,
    initialPositionMs: Long,
    onSavePosition: (Long) -> Unit,
    onClose: () -> Unit
) {
    // Configura la sesión de audio nativa de Apple para reproducción continua, en segundo plano y AirPlay
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
    var statusLabel by remember(url) { mutableStateOf("VLCKit • Iniciando decodificador de baja latencia...") }
    var hasPlaybackError by remember(url) { mutableStateOf(false) }
    var showOverlayBar by remember { mutableStateOf(true) }
    var lastInteractionTick by remember { mutableStateOf(0) }
    var hostViewRef by remember { mutableStateOf<UIView?>(null) }

    val currentStreamUrl = candidates.getOrElse(candidateIndex) { url }

    // Ocultación automática de la barra de controles tras 4 segundos sin interacción
    LaunchedEffect(showOverlayBar, lastInteractionTick, hasPlaybackError) {
        if (showOverlayBar && !hasPlaybackError) {
            delay(4_000L)
            showOverlayBar = false
        }
    }

    // Carga o reinicia el flujo en el motor interno VLCKit (con fallback AVPlayer si la librería no está enlazada)
    LaunchedEffect(currentStreamUrl, reloadSalt, hostViewRef) {
        val hostView = hostViewRef ?: return@LaunchedEffect
        hasPlaybackError = false
        isPlaying = true
        showOverlayBar = true

        val formatTag = when {
            currentStreamUrl.contains(".ts", ignoreCase = true) -> "MPEG-TS (.ts)"
            currentStreamUrl.contains(".m3u8", ignoreCase = true) -> "HLS (.m3u8)"
            else -> "Stream directo"
        }
        statusLabel = "VLCKit • Conectando $formatTag..."

        val playSel = if (isLive) NSSelectorFromString("playStreamUrl:") else NSSelectorFromString("playVodUrl:")
        val nsUrl = NSString.create(string = currentStreamUrl)
        (hostView as? NSObject)?.performSelector(playSel, withObject = nsUrl)

        if (!isLive && initialPositionMs > 3_000L) {
            val sec = initialPositionMs.toDouble() / 1000.0
            val seekSel = NSSelectorFromString("seekToNumber:")
            val nsSec = NSNumber(double = sec)
            (hostView as? NSObject)?.performSelector(seekSel, withObject = nsSec)
        }

        // Aplica relación de aspecto actual
        val aspectSel = NSSelectorFromString("setAspectRatio:")
        val nsRatio = NSString.create(string = aspectRatios[currentAspectIndex])
        (hostView as? NSObject)?.performSelector(aspectSel, withObject = nsRatio)
    }

    // Supervisión periódica (cada 1s) para telemetría de estado y detección de fallos de reproducción
    LaunchedEffect(currentStreamUrl, reloadSalt, hostViewRef) {
        val hostView = hostViewRef ?: return@LaunchedEffect
        while (true) {
            delay(1000L)
            val msg = (hostView as? NSObject)?.valueForKey("currentStatusMessage") as? String
            if (!msg.isNullOrBlank()) {
                statusLabel = msg
            }
            val hasErr = ((hostView as? NSObject)?.valueForKey("currentHasError") as? NSNumber)?.boolValue ?: false
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
            }
            if (!isLive) {
                val timeSel = NSSelectorFromString("getPlaybackTimeMs")
                val timeNum = (hostView as? NSObject)?.performSelector(timeSel) as? NSNumber
                val timeMs = timeNum?.longLongValue ?: 0L
                if (timeMs > 2000L) {
                    onSavePosition(timeMs)
                }
            }
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            (hostViewRef as? NSObject)?.performSelector(NSSelectorFromString("stopStream"))
            hostViewRef = null
            trimPlatformMemory()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .clickable {
                showOverlayBar = !showOverlayBar
                lastInteractionTick++
            }
    ) {
        // Vista nativa UIKit alojada: VLCPlayerHostView con decodificador MobileVLCKit / LibVLC
        UIKitView(
            factory = {
                val rawClass = NSClassFromString("VLCPlayerHostView") ?: NSClassFromString("iosApp.VLCPlayerHostView")
                val classAsObj = rawClass as? NSObject
                val view = vlcPlayerViewFactory?.invoke()
                    ?: (classAsObj?.performSelector(NSSelectorFromString("new")) as? UIView)
                    ?: UIView().apply { backgroundColor = UIColor.blackColor }
                hostViewRef = view
                view
            },
            update = { _ -> },
            modifier = Modifier.fillMaxSize()
        )

        // Botón flotante para restaurar controles cuando la barra superior se oculta
        if (!showOverlayBar && !hasPlaybackError) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .windowInsetsPadding(
                        WindowInsets.safeDrawing.only(WindowInsetsSides.Top + WindowInsetsSides.Horizontal)
                    )
                    .padding(start = 14.dp, top = 10.dp)
                    .clip(CircleShape)
                    .background(DarkCharcoal.copy(alpha = 0.65f))
                    .border(1.dp, GoldPrimary.copy(alpha = 0.65f), CircleShape)
                    .clickable {
                        showOverlayBar = true
                        lastInteractionTick++
                    }
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Icon(
                        Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Mostrar controles",
                        tint = GoldPrimary,
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = title,
                        color = TextWhite,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.widthIn(max = 180.dp)
                    )
                }
            }
        }

        // Barra superior de controles superpuesta con soporte de Safe Area
        AnimatedVisibility(
            visible = showOverlayBar || hasPlaybackError,
            enter = fadeIn(tween(200)) + slideInVertically(tween(200)) { -it },
            exit = fadeOut(tween(280)) + slideOutVertically(tween(280)) { -it },
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth()
        ) {
            Surface(
                color = Color(0xFF0B1F15).copy(alpha = 0.90f),
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
                        modifier = Modifier
                            .weight(1f)
                            .clickable {
                                showOverlayBar = false
                            }
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

                    // Selector de relación de aspecto (DEFAULT, 16:9, 4:3, FILL)
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

                    // Botón Reproducir / Pausa
                    IconButton(
                        onClick = {
                            lastInteractionTick++
                            val hostView = hostViewRef
                            if (hostView != null) {
                                val sel = if (isPlaying) {
                                    NSSelectorFromString("pauseStream")
                                } else {
                                    NSSelectorFromString("resumeStream")
                                }
                                (hostView as? NSObject)?.performSelector(sel)
                                isPlaying = !isPlaying
                            }
                        },
                        modifier = Modifier
                            .size(38.dp)
                            .background(SurfaceCard, RoundedCornerShape(10.dp))
                    ) {
                        Icon(
                            imageVector = if (isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                            contentDescription = if (isPlaying) "Pausar" else "Reproducir",
                            tint = GoldPrimary
                        )
                    }

                    if (candidates.size > 1) {
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

                    // Botón Recargar stream
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

                    // Botón Abrir en VLC externo
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
