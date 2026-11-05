package com.minuevaapp.tv.player

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.TextUtils
import android.view.Gravity
import android.view.WindowManager
import android.widget.Button
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.OptIn
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.media3.common.C
import androidx.media3.common.MediaItem
import androidx.media3.common.MediaMetadata
import androidx.media3.common.MimeTypes
import androidx.media3.common.PlaybackException
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.DefaultDataSource
import androidx.media3.datasource.DefaultHttpDataSource
import androidx.media3.exoplayer.DefaultLoadControl
import androidx.media3.exoplayer.DefaultRenderersFactory
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.mediacodec.MediaCodecInfo
import androidx.media3.exoplayer.mediacodec.MediaCodecSelector
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory
import androidx.media3.exoplayer.upstream.DefaultLoadErrorHandlingPolicy
import androidx.media3.extractor.DefaultExtractorsFactory
import androidx.media3.extractor.ts.DefaultTsPayloadReaderFactory
import androidx.media3.ui.PlayerView
import com.minuevaapp.tv.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

/**
 * Reproductor a pantalla completa con Media3 ExoPlayer optimizado para Fire TV (Fire OS MediaTek/Amlogic)
 * y Android TV:
 * 1. Ciclo de vida determinista de ExoPlayer y MediaSource fuera de Compose, invocando setMediaItem() y
 *    prepare() una única vez por arranque de stream sin recreaciones al pasar a STATE_READY.
 * 2. DefaultMediaSourceFactory(dataSourceFactory, extractorsFactory) con DefaultExtractorsFactory y flags
 *    MPEG-TS (FLAG_ALLOW_NON_IDR_KEYFRAMES | FLAG_DETECT_ACCESS_UNITS) para tolerar discontinuidades PTS/PCR.
 * 3. DefaultRenderersFactory(this) con forceDisableMediaCodecAsynchronousQueueing() y
 *    setEnableDecoderFallback(true) para evitar el bloqueo del buffer de salida tras el primer fotograma
 *    en streams entrelazados (1080i/50fps) en Fire OS.
 * 4. PlayerView inflado desde R.layout.activity_player_view con surface_type="texture_view" sin tocar ni
 *    reiniciar el buffer de vídeo desde fuera.
 */
@OptIn(UnstableApi::class)
class PlayerActivity : Activity() {
    private var player: ExoPlayer? = null
    private var playerListener: Player.Listener? = null
    private lateinit var playerView: PlayerView
    private lateinit var topControlsBar: LinearLayout
    private lateinit var decoderButton: Button
    private lateinit var reloadButton: Button

    private val mainHandler = Handler(Looper.getMainLooper())
    private val playerIoScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private var reconnectRunnable: Runnable? = null
    private var progressSaveRunnable: Runnable? = null
    private var reconnectAttempts = 0
    private var lastCommittedPosMs = -1L
    private var lastCommittedDurMs = -1L

    private val prefs by lazy { applicationContext.getSharedPreferences("resume", MODE_PRIVATE) }
    private val url by lazy { intent.getStringExtra(EXTRA_URL).orEmpty() }
    private val streamTitle by lazy { intent.getStringExtra(EXTRA_TITLE).orEmpty() }
    private val isLive by lazy { intent.getBooleanExtra(EXTRA_LIVE, false) }
    private val streamType by lazy { intent.getStringExtra(EXTRA_STREAM_TYPE) ?: if (isLive) "live" else "movie" }
    private val streamId by lazy { intent.getStringExtra(EXTRA_STREAM_ID) }
    private val episodeId by lazy { intent.getStringExtra(EXTRA_EPISODE_ID) }

    private val progressKey: String by lazy {
        val sid = streamId?.takeIf { it.isNotBlank() }
        val eid = episodeId?.takeIf { it.isNotBlank() }
        when {
            eid != null && sid != null -> "series:$sid:ep:$eid"
            eid != null -> "episode:$eid"
            sid != null -> "$streamType:$sid"
            else -> url
        }
    }

    private var forceSoftwareDecoder = false
    private var overrideMimeType: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (url.isBlank()) {
            finish()
            return
        }
        val sId = streamId
        if (!sId.isNullOrBlank()) {
            playerIoScope.launch(Dispatchers.IO) {
                com.minuevaapp.tv.MiTVApp.instance.store.addRecentlyViewed(streamType, sId)
            }
        }

        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window, window.decorView).apply {
            hide(WindowInsetsCompat.Type.systemBars())
            systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }

        val density = resources.displayMetrics.density
        val padH = (14 * density).toInt()
        val padV = (8 * density).toInt()
        val margin = (18 * density).toInt()

        val root = FrameLayout(this).apply {
            setBackgroundColor(0xFF0E1410.toInt())
        }

        // Instanciación pura de PlayerView desde R.layout.activity_player_view (surface_type="texture_view")
        // una única vez en onCreate, sin tocar ni invalidar su buffer desde fuera.
        playerView = (layoutInflater.inflate(R.layout.activity_player_view, root, false) as PlayerView).apply {
            keepScreenOn = true
            setShowBuffering(PlayerView.SHOW_BUFFERING_ALWAYS)
            setControllerVisibilityListener(PlayerView.ControllerVisibilityListener { visibility ->
                topControlsBar.visibility = visibility
            })
        }

        val titleBadge = TextView(this).apply {
            text = if (isLive) "● EN DIRECTO  ·  $streamTitle" else streamTitle
            setTextColor(Color.WHITE)
            textSize = 14f
            typeface = Typeface.DEFAULT_BOLD
            maxLines = 1
            ellipsize = TextUtils.TruncateAt.END
            setPadding(padH, padV, padH, padV)
            background = createTranslucentGoldDrawable(focused = false, isPrimaryGold = false)
            visibility = if (streamTitle.isBlank()) android.view.View.GONE else android.view.View.VISIBLE
        }

        decoderButton = createOverlayButton(padH, padV).apply {
            updateDecoderLabel()
            setOnClickListener {
                val pos = if (isLive) 0L else (player?.currentPosition ?: 0L)
                forceSoftwareDecoder = !forceSoftwareDecoder
                reconnectAttempts = 0
                updateDecoderLabel()
                initPlayer(startPositionMs = pos)
            }
        }

        reloadButton = createOverlayButton(padH, padV).apply {
            text = "↻ Reconectar"
            setTextColor(0xFFE5C158.toInt())
            setOnClickListener {
                val pos = if (isLive) 0L else (player?.currentPosition ?: 0L)
                reconnectAttempts = 0
                overrideMimeType = null
                initPlayer(startPositionMs = pos)
            }
        }

        topControlsBar = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            addView(
                titleBadge,
                LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f).apply {
                    marginEnd = (12 * density).toInt()
                }
            )
            addView(
                reloadButton,
                LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                ).apply { marginEnd = (10 * density).toInt() }
            )
            addView(
                decoderButton,
                LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                )
            )
        }

        root.addView(
            playerView,
            FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT)
        )
        root.addView(
            topControlsBar,
            FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT).apply {
                gravity = Gravity.TOP
                setMargins(margin, margin, margin, margin)
            }
        )
        setContentView(root)

        val initialPosMs = if (isLive) {
            0L
        } else {
            val savedProg = com.minuevaapp.tv.MiTVApp.instance.store.getPlaybackProgress(progressKey)
            when {
                savedProg != null -> savedProg.resumePositionMs
                else -> prefs.getLong(url, 0L)
            }
        }
        initPlayer(startPositionMs = initialPosMs)
        startPeriodicProgressSaver()
        playerView.requestFocus()
    }

    private fun createTranslucentGoldDrawable(focused: Boolean, isPrimaryGold: Boolean): GradientDrawable {
        return GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            cornerRadius = 22f
            val bgColor = when {
                focused -> 0xEE124E31.toInt()
                isPrimaryGold -> 0xE60A3A22.toInt()
                else -> 0xCC0E1410.toInt()
            }
            setColor(bgColor)
            val strokeWidth = if (focused) 4 else 2
            val strokeColor = if (focused) 0xFFE5C158.toInt() else 0xB3D4AF37.toInt()
            setStroke(strokeWidth, strokeColor)
        }
    }

    private fun createOverlayButton(padH: Int, padV: Int): Button {
        return Button(this).apply {
            isAllCaps = false
            setTextColor(Color.WHITE)
            typeface = Typeface.DEFAULT_BOLD
            setPadding(padH, padV, padH, padV)
            isFocusable = true
            isFocusableInTouchMode = false
            background = createTranslucentGoldDrawable(focused = false, isPrimaryGold = true)
            setOnFocusChangeListener { _, hasFocus ->
                background = createTranslucentGoldDrawable(focused = hasFocus, isPrimaryGold = true)
            }
        }
    }

    private fun Button.updateDecoderLabel() {
        text = if (forceSoftwareDecoder) "⚙ Decodificador: SW" else "⚙ Decodificador: HW+SW"
        setTextColor(if (forceSoftwareDecoder) 0xFFE5C158.toInt() else Color.WHITE)
    }

    private fun cancelPendingReconnect() {
        reconnectRunnable?.let { mainHandler.removeCallbacks(it) }
        reconnectRunnable = null
    }

    private fun scheduleReconnect(resumePositionMs: Long, reason: String) {
        if (isFinishing || isDestroyed) return
        if (reconnectAttempts >= MAX_RECONNECT_ATTEMPTS) {
            Toast.makeText(
                this,
                "No se pudo restablecer la conexión ($reason). Pulsa «Reconectar».",
                Toast.LENGTH_LONG
            ).show()
            return
        }
        reconnectAttempts++
        val delayMs = RECONNECT_BASE_DELAY_MS * reconnectAttempts
        Toast.makeText(
            this,
            "Reconectando stream ($reconnectAttempts/$MAX_RECONNECT_ATTEMPTS)…",
            Toast.LENGTH_SHORT
        ).show()
        cancelPendingReconnect()
        val task = Runnable {
            if (!isFinishing && !isDestroyed) {
                initPlayer(startPositionMs = if (isLive) 0L else resumePositionMs)
            }
        }
        reconnectRunnable = task
        mainHandler.postDelayed(task, delayMs)
    }

    private fun releasePlayer() {
        cancelPendingReconnect()
        player?.let { p ->
            playerListener?.let { p.removeListener(it) }
            p.release()
        }
        playerListener = null
        player = null
    }

    private fun initPlayer(startPositionMs: Long) {
        releasePlayer()

        // Configuración de Renderers para Fire TV (MediaTek / Amlogic Fire OS):
        // - forceDisableMediaCodecAsynchronousQueueing(): desactiva las colas asíncronas de MediaCodec
        //   que en Fire OS bloquean el buffer de salida de vídeo tras el primer frame en 1080i/50fps.
        // - setEnableDecoderFallback(true): conmuta al decodificador secundario si el primario falla.
        val renderersFactory = DefaultRenderersFactory(this)
            .forceDisableMediaCodecAsynchronousQueueing()
            .setEnableDecoderFallback(true)
            .setExtensionRendererMode(
                if (forceSoftwareDecoder) DefaultRenderersFactory.EXTENSION_RENDERER_MODE_PREFER
                else DefaultRenderersFactory.EXTENSION_RENDERER_MODE_ON
            )

        if (forceSoftwareDecoder) {
            val swSelector = MediaCodecSelector { mimeType, requiresSecureDecoder, requiresTunnelingDecoder ->
                val infos = MediaCodecUtil.getDecoderInfos(mimeType, requiresSecureDecoder, requiresTunnelingDecoder)
                val swOnly = infos.filter { isSoftwareCodec(it) }
                swOnly.ifEmpty { infos }
            }
            renderersFactory.setMediaCodecSelector(swSelector)
        }

        // Permite HTTP sin cifrar y redirecciones entre HTTP <-> HTTPS habituales en paneles IPTV
        val httpDataSourceFactory = DefaultHttpDataSource.Factory()
            .setAllowCrossProtocolRedirects(true)
            .setConnectTimeoutMs(10_000)
            .setReadTimeoutMs(18_000)
            .setUserAgent("XaviTV/1.0 (ExoPlayer; AndroidTV)")

        val dataSourceFactory = DefaultDataSource.Factory(this, httpDataSourceFactory)
        val errorHandlingPolicy = DefaultLoadErrorHandlingPolicy(/* minimumLoadableRetryCount = */ 5)

        // DefaultExtractorsFactory con flags para MPEG-TS IPTV en directo (tolerancia a non-IDR y AU)
        val extractorsFactory = DefaultExtractorsFactory()
            .setConstantBitrateSeekingEnabled(true)
            .setTsExtractorFlags(
                DefaultTsPayloadReaderFactory.FLAG_ALLOW_NON_IDR_KEYFRAMES or
                    DefaultTsPayloadReaderFactory.FLAG_DETECT_ACCESS_UNITS
            )

        // DefaultMediaSourceFactory limpio con soporte nativo para IPTV TS, HLS y VOD
        val mediaSourceFactory = DefaultMediaSourceFactory(dataSourceFactory, extractorsFactory)
            .setLoadErrorHandlingPolicy(errorHandlingPolicy)

        val loadControl = DefaultLoadControl.Builder()
            .setBufferDurationsMs(
                /* minBufferMs = */ if (isLive) 6_000 else 15_000,
                /* maxBufferMs = */ if (isLive) 20_000 else 40_000,
                /* bufferForPlaybackMs = */ if (isLive) 500 else 1_200,
                /* bufferForPlaybackAfterRebufferMs = */ if (isLive) 1_200 else 2_500,
            )
            .setPrioritizeTimeOverSizeThresholds(true)
            .setTargetBufferBytes(if (isLive) 8 * 1024 * 1024 else 16 * 1024 * 1024)
            .build()

        val mediaItemBuilder = MediaItem.Builder()
            .setUri(url)
            .setMediaMetadata(MediaMetadata.Builder().setTitle(streamTitle).build())

        overrideMimeType?.let { mime ->
            mediaItemBuilder.setMimeType(mime)
        }

        val mediaItem = mediaItemBuilder.build()

        val exoPlayer = ExoPlayer.Builder(this, renderersFactory)
            .setMediaSourceFactory(mediaSourceFactory)
            .setLoadControl(loadControl)
            .setWakeMode(C.WAKE_MODE_NETWORK)
            .build()

        player = exoPlayer
        playerView.player = exoPlayer

        val listener = object : Player.Listener {
            override fun onPlaybackStateChanged(playbackState: Int) {
                if (playbackState == Player.STATE_READY) {
                    reconnectAttempts = 0
                } else if (playbackState == Player.STATE_ENDED) {
                    if (isLive) {
                        scheduleReconnect(0L, "Corte de emisión")
                    } else {
                        val dur = exoPlayer.duration.takeIf { it > 0L && it != C.TIME_UNSET } ?: 0L
                        if (dur > 0L) {
                            playerIoScope.launch(Dispatchers.IO) {
                                com.minuevaapp.tv.MiTVApp.instance.store.savePlaybackProgress(
                                    id = progressKey,
                                    positionMs = dur,
                                    durationMs = dur,
                                    commitSync = false,
                                    notifyUi = true,
                                )
                                prefs.edit().putLong(url, 0L).apply()
                            }
                        }
                    }
                }
            }

            override fun onIsPlayingChanged(isPlaying: Boolean) {
                if (!isPlaying && !isLive && !isFinishing && !isDestroyed) {
                    saveResumePositionPeriodicAsync()
                }
            }

            override fun onPlayerError(error: PlaybackException) {
                val currentPos = exoPlayer.currentPosition

                // 1. Si una URL .m3u8 devuelve flujo MPEG-TS directo (manifest malformed), forzar VIDEO_MP2T
                if (error.errorCode == PlaybackException.ERROR_CODE_PARSING_MANIFEST_MALFORMED &&
                    overrideMimeType != MimeTypes.VIDEO_MP2T
                ) {
                    overrideMimeType = MimeTypes.VIDEO_MP2T
                    initPlayer(startPositionMs = currentPos)
                    return
                }

                // 2. Si una URL sin extensión .m3u8 devuelve un manifiesto HLS de texto, forzar APPLICATION_M3U8
                if (overrideMimeType != MimeTypes.APPLICATION_M3U8 && (
                        error.errorCode == PlaybackException.ERROR_CODE_PARSING_CONTAINER_UNSUPPORTED ||
                            error.errorCode == PlaybackException.ERROR_CODE_PARSING_CONTAINER_MALFORMED
                        )
                ) {
                    overrideMimeType = MimeTypes.APPLICATION_M3U8
                    initPlayer(startPositionMs = currentPos)
                    return
                }

                // 3. Fallback automático de códec Hardware -> Software
                val isCodecError = error.errorCode in listOf(
                    PlaybackException.ERROR_CODE_DECODER_INIT_FAILED,
                    PlaybackException.ERROR_CODE_DECODER_QUERY_FAILED,
                    PlaybackException.ERROR_CODE_DECODING_FAILED,
                    PlaybackException.ERROR_CODE_DECODING_FORMAT_EXCEEDS_CAPABILITIES,
                    PlaybackException.ERROR_CODE_DECODING_FORMAT_UNSUPPORTED,
                )
                if (isCodecError && !forceSoftwareDecoder) {
                    forceSoftwareDecoder = true
                    decoderButton.updateDecoderLabel()
                    Toast.makeText(
                        this@PlayerActivity,
                        "Fallo en códec HW; cambiando a decodificación por software (SW)…",
                        Toast.LENGTH_SHORT
                    ).show()
                    initPlayer(startPositionMs = currentPos)
                    return
                }

                // 4. Errores de red o corte de stream -> reconexión automática
                val isNetworkError = error.errorCode in listOf(
                    PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED,
                    PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT,
                    PlaybackException.ERROR_CODE_IO_BAD_HTTP_STATUS,
                    PlaybackException.ERROR_CODE_IO_INVALID_HTTP_CONTENT_TYPE,
                    PlaybackException.ERROR_CODE_IO_READ_POSITION_OUT_OF_RANGE,
                    PlaybackException.ERROR_CODE_IO_UNSPECIFIED,
                    PlaybackException.ERROR_CODE_BEHIND_LIVE_WINDOW,
                    PlaybackException.ERROR_CODE_TIMEOUT,
                )
                if (isNetworkError) {
                    scheduleReconnect(currentPos, error.errorCodeName)
                } else {
                    Toast.makeText(
                        this@PlayerActivity,
                        "Error de reproducción (${error.errorCodeName})",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
        playerListener = listener
        exoPlayer.addListener(listener)
        if (!isLive && startPositionMs > 0L) {
            exoPlayer.setMediaItem(mediaItem, startPositionMs)
        } else {
            exoPlayer.setMediaItem(mediaItem)
        }
        exoPlayer.prepare()
        exoPlayer.playWhenReady = true
    }

    private fun isSoftwareCodec(info: MediaCodecInfo): Boolean {
        val name = info.name.lowercase()
        return info.softwareOnly ||
            !info.hardwareAccelerated ||
            name.startsWith("omx.google.") ||
            name.startsWith("c2.android.") ||
            name.contains(".sw.")
    }

    private fun startPeriodicProgressSaver() {
        stopPeriodicProgressSaver()
        if (isLive) return
        val task = object : Runnable {
            override fun run() {
                if (!isFinishing && !isDestroyed) {
                    val p = player
                    if (p != null && p.isPlaying) {
                        saveResumePositionPeriodicAsync()
                    }
                    mainHandler.postDelayed(this, 5_000L)
                }
            }
        }
        progressSaveRunnable = task
        mainHandler.postDelayed(task, 5_000L)
    }

    private fun stopPeriodicProgressSaver() {
        progressSaveRunnable?.let { mainHandler.removeCallbacks(it) }
        progressSaveRunnable = null
    }

    /**
     * Guardado periódico cada 5s en segundo plano (Dispatchers.IO) usando .apply() en memoria RAM:
     * Nunca bloquea el hilo principal ni altera el PlayerView.
     */
    private fun saveResumePositionPeriodicAsync() {
        val p = player ?: return
        if (isLive || url.isBlank()) return
        val pos = p.currentPosition.coerceAtLeast(0L)
        val dur = p.duration.takeIf { it > 0L && it != C.TIME_UNSET } ?: 0L
        if (pos <= 0L && dur <= 0L) return
        val key = progressKey
        val targetUrl = url

        playerIoScope.launch(Dispatchers.IO) {
            com.minuevaapp.tv.MiTVApp.instance.store.savePlaybackProgress(
                id = key,
                positionMs = pos,
                durationMs = dur,
                commitSync = false,
                notifyUi = false,
            )
            val nearEnd = dur > 0L && (pos.toFloat() / dur.toFloat()) >= 0.95f
            prefs.edit().putLong(targetUrl, if (nearEnd) 0L else pos).apply()
        }
    }

    /**
     * Guardado síncrono crítico (.commit()) reservado exclusivamente para salida/pausa del ciclo
     * de vida (onPause, onStop, onDestroy), deduplicado para no repetir fsync innecesarios.
     */
    private fun saveResumePositionCriticalSync() {
        val p = player ?: return
        if (isLive || url.isBlank()) return
        val pos = p.currentPosition.coerceAtLeast(0L)
        val dur = p.duration.takeIf { it > 0L && it != C.TIME_UNSET } ?: 0L
        if (pos <= 0L && dur <= 0L) return
        if (pos == lastCommittedPosMs && dur == lastCommittedDurMs) return
        lastCommittedPosMs = pos
        lastCommittedDurMs = dur

        com.minuevaapp.tv.MiTVApp.instance.store.savePlaybackProgress(
            id = progressKey,
            positionMs = pos,
            durationMs = dur,
            commitSync = true,
            notifyUi = true,
        )
        val nearEnd = dur > 0L && (pos.toFloat() / dur.toFloat()) >= 0.95f
        prefs.edit().putLong(url, if (nearEnd) 0L else pos).commit()
    }

    override fun onPause() {
        saveResumePositionCriticalSync()
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
        cancelPendingReconnect()
        stopPeriodicProgressSaver()
        saveResumePositionCriticalSync()
        player?.pause()
    }

    override fun onDestroy() {
        stopPeriodicProgressSaver()
        saveResumePositionCriticalSync()
        playerIoScope.cancel()
        playerView.player = null
        releasePlayer()
        super.onDestroy()
    }

    companion object {
        private const val EXTRA_URL = "url"
        private const val EXTRA_TITLE = "title"
        private const val EXTRA_LIVE = "live"
        private const val EXTRA_STREAM_TYPE = "stream_type"
        private const val EXTRA_STREAM_ID = "stream_id"
        private const val EXTRA_EPISODE_ID = "episode_id"
        private const val MAX_RECONNECT_ATTEMPTS = 5
        private const val RECONNECT_BASE_DELAY_MS = 2_500L

        fun start(
            ctx: Context,
            url: String,
            title: String?,
            live: Boolean = false,
            streamType: String? = null,
            streamId: String? = null,
            episodeId: String? = null,
        ) {
            val resolvedType = streamType ?: if (live) "live" else "movie"
            if (!streamId.isNullOrBlank()) {
                com.minuevaapp.tv.MiTVApp.instance.store.addRecentlyViewed(resolvedType, streamId)
            }
            ctx.startActivity(
                Intent(ctx, PlayerActivity::class.java)
                    .putExtra(EXTRA_URL, url)
                    .putExtra(EXTRA_TITLE, title)
                    .putExtra(EXTRA_LIVE, live)
                    .putExtra(EXTRA_STREAM_TYPE, resolvedType)
                    .putExtra(EXTRA_STREAM_ID, streamId)
                    .putExtra(EXTRA_EPISODE_ID, episodeId)
            )
        }
    }
}
