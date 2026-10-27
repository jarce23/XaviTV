package com.minuevaapp.tv.shared.platform

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.OpenInNew
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.minuevaapp.tv.shared.ui.DarkCharcoal
import com.minuevaapp.tv.shared.ui.GoldPrimary
import com.minuevaapp.tv.shared.ui.SurfaceCard
import com.minuevaapp.tv.shared.ui.TextMuted
import com.minuevaapp.tv.shared.ui.TextWhite
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.jetbrains.skia.FilterMipmap
import org.jetbrains.skia.FilterMode
import org.jetbrains.skia.Image
import org.jetbrains.skia.MipmapMode
import org.jetbrains.skia.Paint
import org.jetbrains.skia.Rect
import org.jetbrains.skia.SamplingMode
import org.jetbrains.skia.Surface
import java.awt.Desktop
import java.io.File
import java.net.URI
import kotlin.math.max
import kotlin.math.roundToInt

actual object PlatformStorage {
    private val baseDir: File by lazy {
        File(System.getProperty("user.home"), ".xavitv").apply {
            if (!exists()) mkdirs()
        }
    }

    private val storageFile: File by lazy {
        File(baseDir, "xavitv_shared_state.json")
    }

    private val m3uCacheDir: File by lazy {
        File(baseDir, "m3u_cache").apply {
            if (!exists()) mkdirs()
        }
    }

    private fun resolveM3uCacheFile(cacheKey: String): File {
        val safeName = cacheKey.replace(Regex("[^a-zA-Z0-9._-]"), "_")
        return File(m3uCacheDir, "xavitv_m3u_${safeName}.m3u")
    }

    actual fun loadStateJson(): String? {
        return try {
            if (storageFile.exists()) storageFile.readText(Charsets.UTF_8) else null
        } catch (_: Exception) {
            null
        }
    }

    actual fun saveStateJson(json: String) {
        try {
            storageFile.writeText(json, Charsets.UTF_8)
        } catch (_: Exception) {
        }
    }

    actual fun loadCachedM3u(cacheKey: String): String? {
        return try {
            val file = resolveM3uCacheFile(cacheKey)
            if (file.exists()) file.readText(Charsets.UTF_8).takeIf { it.isNotBlank() } else null
        } catch (_: Exception) {
            null
        }
    }

    actual fun saveCachedM3u(cacheKey: String, content: String) {
        if (content.isBlank()) return
        try {
            val file = resolveM3uCacheFile(cacheKey)
            file.writeText(content, Charsets.UTF_8)
        } catch (_: Exception) {
        }
    }
}

actual fun createPlatformHttpClient(): HttpClient {
    return HttpClient(OkHttp) {
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
    System.gc()
}

actual fun openStreamInExternalApp(url: String, title: String): Boolean {
    return try {
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().browse(URI(url.trim()))
            true
        } else {
            false
        }
    } catch (_: Exception) {
        false
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
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            color = SurfaceCard,
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.padding(24.dp).widthIn(max = 460.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(title, color = TextWhite, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                if (subtitle.isNotBlank()) {
                    Text(subtitle, color = GoldPrimary, style = MaterialTheme.typography.bodyMedium)
                }
                Text("Stream URL: $url", color = TextMuted, style = MaterialTheme.typography.bodySmall)
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    Button(
                        onClick = { openStreamInExternalApp(url, title) },
                        colors = ButtonDefaults.buttonColors(containerColor = GoldPrimary, contentColor = DarkCharcoal)
                    ) {
                        Icon(Icons.AutoMirrored.Filled.OpenInNew, contentDescription = null)
                        Spacer(Modifier.width(6.dp))
                        Text("Abrir Stream", fontWeight = FontWeight.Bold)
                    }
                    OutlinedButton(onClick = onClose) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null, tint = GoldPrimary)
                        Spacer(Modifier.width(6.dp))
                        Text("Cerrar", color = GoldPrimary)
                    }
                }
            }
        }
    }
}
