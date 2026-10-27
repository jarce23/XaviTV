package com.minuevaapp.tv

import android.app.Application
import android.content.ComponentCallbacks2
import android.graphics.Bitmap
import coil.Coil
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.disk.DiskCache
import coil.memory.MemoryCache
import coil.size.Precision
import com.minuevaapp.tv.data.PlaylistStore
import com.minuevaapp.tv.data.XtreamRepository
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

class MiTVApp : Application(), ImageLoaderFactory {
    lateinit var store: PlaylistStore
        private set

    lateinit var okHttpClient: OkHttpClient
        private set

    @Volatile
    var repo: XtreamRepository? = null

    override fun onCreate() {
        super.onCreate()
        instance = this
        okHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(45, TimeUnit.SECONDS)
            .followRedirects(true)
            .followSslRedirects(true)
            .connectionPool(ConnectionPool(5, 5, TimeUnit.MINUTES))
            .build()

        store = PlaylistStore(this)
        store.active()?.let { repo = XtreamRepository(it, okHttpClient) }
    }

    override fun newImageLoader(): ImageLoader {
        // Detectar límite de RAM del dispositivo (Fire TV / Android TV suelen tener 1 GB - 2 GB)
        val maxHeapBytes = Runtime.getRuntime().maxMemory()
        val strictMaxCacheBytes = (maxHeapBytes / 10).coerceAtMost(24L * 1024 * 1024).toInt()

        return ImageLoader.Builder(this)
            .okHttpClient(okHttpClient)
            .precision(Precision.INEXACT)
            .bitmapConfig(Bitmap.Config.RGB_565)
            .allowRgb565(true)
            .allowHardware(true)
            .crossfade(150)
            .respectCacheHeaders(false)
            .memoryCache {
                MemoryCache.Builder(this)
                    .maxSizeBytes(strictMaxCacheBytes)
                    .strongReferencesEnabled(true)
                    .weakReferencesEnabled(false)
                    .build()
            }
            .diskCache {
                DiskCache.Builder()
                    .directory(cacheDir.resolve("image_cache"))
                    .maxSizeBytes(32L * 1024 * 1024) // 32 MB
                    .build()
            }
            .build()
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        if (level >= ComponentCallbacks2.TRIM_MEMORY_RUNNING_LOW ||
            level >= ComponentCallbacks2.TRIM_MEMORY_BACKGROUND
        ) {
            runCatching { Coil.imageLoader(this).memoryCache?.clear() }
        }
    }

    override fun onLowMemory() {
        super.onLowMemory()
        runCatching { Coil.imageLoader(this).memoryCache?.clear() }
    }

    companion object {
        lateinit var instance: MiTVApp
            private set
    }
}
