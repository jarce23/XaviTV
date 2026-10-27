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
import platform.Foundation.NSData
import platform.Foundation.NSString
import platform.Foundation.NSTemporaryDirectory
import platform.Foundation.NSURL
import platform.Foundation.NSURLCache
import platform.Foundation.NSURLRequestReloadIgnoringLocalCacheData
import platform.Foundation.NSUTF8StringEncoding
import platform.Foundation.NSUserDefaults
import platform.Foundation.create
import platform.Foundation.dataUsingEncoding
import platform.Foundation.writeToFile
import platform.UIKit.UIApplication
import platform.UIKit.UIColor
import kotlin.math.max
import kotlin.math.roundToInt
import kotlin.native.runtime.GC

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
 * Construye la cascada de URLs optimizadas para AVPlayer (AVFoundation) en iOS/iPadOS:
 * Prioriza el manifiesto HLS (.m3u8) para zapping instantáneo y soporta flujos MPEG-TS (.ts)
 * tanto directos como mediante puente HLS local.
 */
private fun buildIosCandidateStreamUrls(originalUrl: String, isLive: Boolean): List<String> {
    val clean = originalUrl.trim()
    val candidates = mutableListOf<String>()

    fun addUnique(u: String) {
        if (u.isNotBlank() && u !in candidates) {
            candidates.add(u)
        }
    }

    val isTsUrl = clean.endsWith(".ts", ignoreCase = true) ||
        clean.contains(".ts?", ignoreCase = true)

    if (isTsUrl) {
        // 1) Variante .m3u8 nativa de servidores Xtream Codes para reproducción inmediata en AVPlayer
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
        // 2) Enlace TS directo
        addUnique(clean)
        // 3) Puente HLS sintético local (.m3u8 en NSTemporaryDirectory)
        createSyntheticHlsWrapperForTs(clean)?.let { addUnique(it) }
    } else if (clean.endsWith(".m3u8", ignoreCase = true) || clean.contains(".m3u8?", ignoreCase = true)) {
        addUnique(clean)
        val tsVariant = clean.replace(Regex("\\.m3u8(\\?.*)?$", RegexOption.IGNORE_CASE), ".ts$1")
        addUnique(tsVariant)
    } else {
        addUnique(clean)
        if (isLive && !clean.endsWith(".mp4", ignoreCase = true)) {
            addUnique("$clean.m3u8")
        }
    }

    return candidates
}

private fun createSyntheticHlsWrapperForTs(tsUrl: String): String? {
    return try {
        val m3u8Content = buildString {
            appendLine("#EXTM3U")
            appendLine("#EXT-X-VERSION:3")
            appendLine("#EXT-X-TARGETDURATION:3600")
            appendLine("#EXT-X-MEDIA-SEQUENCE:0")
            appendLine("#EXTINF:3600.0,Live TS Stream")
            appendLine(tsUrl)
        }
        val tempFile = NSTemporaryDirectory() + "xavitv_ts_bridge.m3u8"
        val nsString = NSString.create(string = m3u8Content)
        val data: NSData? = nsString.dataUsingEncoding(NSUTF8StringEncoding)
        if (data != null && data.writeToFile(tempFile, atomically = true)) {
            NSURL.fileURLWithPath(tempFile).absoluteString
        } else {
            null
        }
    } catch (_: Exception) {
        null
    }
}

/**
 * Crea un AVPlayerItem optimizado con búfer reducido (0.45s en directo) para lograr un zapping casi instantáneo.
 */
private fun createConfiguredPlayerItem(candidateUrl: String, isLive: Boolean): AVPlayerItem? {
    val nsUrl = NSURL.URLWithString(candidateUrl) ?: return null
    val asset = AVURLAsset.URLAssetWithURL(nsUrl, null)
    return AVPlayerItem.playerItemWithAsset(asset).apply {
        preferredForwardBufferDuration = if (isLive) {
            IOS_LIVE_FORWARD_BUFFER_SECONDS
        } else {
            IOS_VOD_FORWARD_BUFFER_SECONDS
        }
        canUseNetworkResourcesForLiveStreamingWhilePaused = true
    }
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
    // Configura la sesión de audio nativa de Apple (AVFAudio / AVFoundation) para PiP y segundo plano
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
    var statusLabel by remember(url) { mutableStateOf("Zapping rápido AVPlayer...") }
    var hasPlaybackError by remember(url) { mutableStateOf(false) }
    var showOverlayBar by remember { mutableStateOf(true) }
    var lastInteractionTick by remember { mutableStateOf(0) }

    val currentStreamUrl = candidates.getOrElse(candidateIndex) { url }

    val avPlayer = remember {
        AVPlayer().apply {
            // Desactiva la espera de pre-búfer largo en canales en directo para arrancar en el primer fotograma
            automaticallyWaitsToMinimizeStalling = !isLive
            allowsExternalPlayback = true
        }
    }

    // Ocultación automática de la barra superior tras 4 segundos para dejar limpio el vídeo y controles PiP/AirPlay
    LaunchedEffect(showOverlayBar, lastInteractionTick, hasPlaybackError) {
        if (showOverlayBar && !hasPlaybackError) {
            delay(4_000L)
            showOverlayBar = false
        }
    }

    // Carga o conmuta la URL candidata en AVPlayer con arranque inmediato
    LaunchedEffect(currentStreamUrl, reloadSalt) {
        hasPlaybackError = false
        showOverlayBar = true
        val formatTag = when {
            currentStreamUrl.contains("xavitv_ts_bridge.m3u8") -> "HLS Bridge (.ts)"
            currentStreamUrl.contains(".m3u8", ignoreCase = true) -> "HLS (.m3u8)"
            currentStreamUrl.contains(".ts", ignoreCase = true) -> "MPEG-TS (.ts)"
            else -> "Direct Stream"
        }
        statusLabel = "Zapping $formatTag..."

        avPlayer.automaticallyWaitsToMinimizeStalling = !isLive
        val item = createConfiguredPlayerItem(currentStreamUrl, isLive)
        if (item != null) {
            avPlayer.replaceCurrentItemWithPlayerItem(item)
            if (!isLive && initialPositionMs > 3_000L) {
                val targetSeconds = initialPositionMs.toDouble() / 1000.0
                avPlayer.seekToTime(CMTimeMakeWithSeconds(targetSeconds, 1000))
            }
            if (isLive) {
                avPlayer.playImmediatelyAtRate(1.0f)
            } else {
                avPlayer.play()
            }
        } else {
            hasPlaybackError = true
            statusLabel = "URL no válida"
        }
    }

    // Supervisión rápida (cada 500ms) para zapping ágil entre variantes HLS y TS si un servidor requiere fallback
    LaunchedEffect(currentStreamUrl, reloadSalt) {
        var halfSecondsWaiting = 0
        while (true) {
            delay(500)
            val item = avPlayer.currentItem
            if (item == null) {
                halfSecondsWaiting++
            } else {
                when (item.status) {
                    AVPlayerItemStatusReadyToPlay -> {
                        hasPlaybackError = false
                        val modeLabel = if (currentStreamUrl.contains(".m3u8", ignoreCase = true)) "HLS" else "TS/MP4"
                        statusLabel = if (isLive) "EN DIRECTO • $modeLabel • PiP Activo" else "VOD • $modeLabel • PiP Activo"
                        if (!isLive) {
                            val sec = CMTimeGetSeconds(avPlayer.currentTime())
                            if (!sec.isNaN() && sec > 2.0) {
                                onSavePosition((sec * 1000.0).toLong())
                            }
                        }
                    }
                    AVPlayerItemStatusFailed -> {
                        if (candidateIndex + 1 < candidates.size) {
                            statusLabel = "Conmutando variante (${candidateIndex + 2}/${candidates.size})..."
                            candidateIndex += 1
                            break
                        } else {
                            hasPlaybackError = true
                            showOverlayBar = true
                            statusLabel = "El canal requiere reconexión o abrir en VLC"
                        }
                    }
                    else -> {
                        halfSecondsWaiting++
                        if (halfSecondsWaiting >= 12 && candidateIndex + 1 < candidates.size) {
                            statusLabel = "Probando variante HLS/TS alternativa..."
                            candidateIndex += 1
                            break
                        }
                    }
                }
            }
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            if (!isLive) {
                val sec = CMTimeGetSeconds(avPlayer.currentTime())
                if (!sec.isNaN() && sec > 2.0) {
                    onSavePosition((sec * 1000.0).toLong())
                }
            }
            avPlayer.pause()
            avPlayer.replaceCurrentItemWithPlayerItem(null)
            trimPlatformMemory()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        // Reproductor nativo AVPlayerViewController con Picture-in-Picture (PiP) automático e inline habilitado
        UIKitView(
            factory = {
                val controller = AVPlayerViewController().apply {
                    player = avPlayer
                    showsPlaybackControls = true
                    allowsPictureInPicturePlayback = true
                    canStartPictureInPictureAutomaticallyFromInline = true
                    updatesNowPlayingInfoCenter = true
                    view.backgroundColor = UIColor.blackColor
                }
                controller.view
            },
            update = { _ -> },
            modifier = Modifier.fillMaxSize()
        )

        // Botón discreto en área segura para volver a mostrar la barra superior cuando está oculta
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
                        contentDescription = "Mostrar barra",
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

        // Barra superior superpuesta respetando las Safe Areas (Notch, Isla Dinámica y esquinas redondeadas)
        AnimatedVisibility(
            visible = showOverlayBar || hasPlaybackError,
            enter = fadeIn(tween(200)) + slideInVertically(tween(200)) { -it },
            exit = fadeOut(tween(280)) + slideOutVertically(tween(280)) { -it },
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth()
        ) {
            Surface(
                color = Color(0xFF0B1F15).copy(alpha = 0.88f),
                border = BorderStroke(1.dp, GoldPrimary.copy(alpha = 0.30f))
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

                    if (candidates.size > 1) {
                        OutlinedButton(
                            onClick = {
                                lastInteractionTick++
                                candidateIndex = (candidateIndex + 1) % candidates.size
                            },
                            border = BorderStroke(1.dp, GoldPrimary),
                            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp)
                        ) {
                            Icon(
                                Icons.Default.Tune,
                                contentDescription = null,
                                tint = GoldPrimary,
                                modifier = Modifier.size(14.dp)
                            )
                            Spacer(Modifier.width(4.dp))
                            Text(
                                "${candidateIndex + 1}/${candidates.size}",
                                color = GoldPrimary,
                                style = MaterialTheme.typography.labelSmall,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

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

                    IconButton(
                        onClick = { openStreamInExternalApp(url, title) },
                        modifier = Modifier
                            .size(38.dp)
                            .background(GreenBetis, RoundedCornerShape(10.dp))
                            .border(1.dp, GoldPrimary.copy(alpha = 0.6f), RoundedCornerShape(10.dp))
                    ) {
                        Icon(
                            Icons.AutoMirrored.Filled.OpenInNew,
                            contentDescription = "Abrir en VLC / Externo",
                            tint = GoldPrimary
                        )
                    }
                }
            }
        }

        // Tarjeta de recuperación rápida si un flujo falla tras probar todas las variantes
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
                        "AVPlayer ha intentado conectar en modo HLS (.m3u8) y MPEG-TS (.ts) con búfer rápido. Puedes reintentar o abrir el flujo en VLC para iPhone/iPad.",
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
