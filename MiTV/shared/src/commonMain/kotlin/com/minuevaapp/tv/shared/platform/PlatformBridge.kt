package com.minuevaapp.tv.shared.platform

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap
import io.ktor.client.HttpClient

/**
 * Almacenamiento persistente multiplataforma (NSUserDefaults + Documents en iOS / archivos en Desktop).
 * Incluye soporte para caché local de respaldo de listas M3U extensas (ej. TDTChannels) para modo offline.
 */
expect object PlatformStorage {
    fun loadStateJson(): String?
    fun saveStateJson(json: String)
    fun loadCachedM3u(cacheKey: String): String?
    fun saveCachedM3u(cacheKey: String, content: String)
}

/**
 * Factoría de cliente HTTP nativo (Darwin NSURLSession con caché acotada en iOS / OkHttp en JVM).
 */
expect fun createPlatformHttpClient(): HttpClient

/**
 * Decodificador nativo de bytes de imagen con submuestreo/escalado máximo (maxDimension)
 * para reducir drásticamente el consumo de memoria RAM en dispositivos iPhone e iPad.
 */
expect fun decodeImageBytes(bytes: ByteArray, maxDimension: Int = 320): ImageBitmap?

/**
 * Solicita al recolector de basura nativo (Kotlin/Native GC en iOS) liberar memoria no referenciada
 * ante avisos de presión de memoria o cambio de catálogo.
 */
expect fun trimPlatformMemory()

/**
 * Reproductor de vídeo nativo multiplataforma mediante expect/actual:
 * - En iOS utiliza AVFoundation (AVPlayer + AVPlayerViewController) con búfer ultrarreducido
 *   para zapping instantáneo, soporte Picture-in-Picture (PiP), reproducción en segundo plano,
 *   AirPlay y adaptación automática de flujos HLS (.m3u8) y MPEG-TS (.ts).
 */
@Composable
expect fun NativeVideoPlayer(
    url: String,
    title: String,
    subtitle: String = "",
    isLive: Boolean = true,
    resumeKey: String = "",
    initialPositionMs: Long = 0L,
    onSavePosition: (Long) -> Unit = {},
    onClose: () -> Unit
)

/**
 * Abre la URL del stream en una app reproductora externa (ej. VLC para iOS mediante esquema vlc-x-callback://).
 */
expect fun openStreamInExternalApp(url: String, title: String): Boolean
