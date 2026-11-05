package com.minuevaapp.tv.player

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.os.Build
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
import androidx.media3.common.PlaybackException
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.DefaultDataSource
import androidx.media3.datasource.DefaultHttpDataSource
import androidx.media3.exoplayer.DefaultLoadControl
import androidx.media3.exoplayer.DefaultRenderersFactory
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.analytics.AnalyticsListener
import androidx.media3.exoplayer.hls.HlsMediaSource
import androidx.media3.exoplayer.mediacodec.MediaCodecInfo
import androidx.media3.exoplayer.mediacodec.MediaCodecSelector
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil
import androidx.media3.exoplayer.source.MediaSource
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector
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
 * Reproductor a pantalla completa con Media3 ExoPlayer optimizado para Fire TV, Android TV,
 * emuladores Android TV y móviles/tablets:
 * - DefaultRenderersFactory con setEnableDecoderFallback(true) y EXTENSION_RENDERER_MODE_PREFER.
 * - PlayerView sobre TextureView (app:surface_type="texture_view") para evitar congelación del primer
 *   fotograma por conflictos de Hardware Composer con overlays y streams H.264/HEVC entrelazados.
 * - DefaultTrackSelector con setExceedRendererCapabilitiesIfNecessary(true) y
 *   setExceedVideoConstraintsIfNecessary(true) para que ningún canal FHD/HEVC pause el renderizador.
 * - Watchdog de fotogramas congelados y AnalyticsListener (onVideoCodecError / onDroppedVideoFrames)
 *   que reinician el renderizador de vídeo o conmutan automáticamente a decodificación por software.
 */
@OptIn(UnstableApi::class)
class PlayerActivity : Activity() {
    private var player: ExoPlayer? = null
    private var trackSelector: DefaultTrackSelector? = null
    private var playerListener: Player.Listener? = null
    private var analyticsListener: AnalyticsListener? = null
    private lateinit var playerView: PlayerView
    private lateinit var topControlsBar: LinearLayout
    private lateinit var decoderButton: Button
    private lateinit var reloadButton: Button

    private val mainHandler = Handler(Looper.getMainLooper())
    private val playerIoScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
    private var reconnectRunnable: Runnable? = null
    private var progressSaveRunnable: Runnable? = null
    private var videoWatchdogRunnable: Runnable? = null
    private var reconnectAttempts = 0

    private var lastRenderedFrameCount = -1
    private var frozenFrameStallTicks = 0
    private var videoRendererResetAttempted = false
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
    private var useHlsFallback = false

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
        // Si la URL apunta explícitamente a un manifiesto .m3u8 (ej. TDTChannels), iniciamos con HLS
        // y mantenemos el fallback automático a ProgressiveMediaSource si fuese un flujo TS crudo.
        useHlsFallback = url.substringBefore('?').endsWith(".m3u8", ignoreCase = true)

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

        // Inflamos PlayerView con app:surface_type="texture_view" desde XML para garantizar
        // renderizado por TextureView sin bloqueos de Hardware Composer en Fire TV y emuladores.
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
                videoRendererResetAttempted = false
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
                videoRendererResetAttempted = false
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
        startVideoFreezeWatchdog()
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

    /**
     * Reinicia en caliente el renderizador de vídeo de ExoPlayer (deshabilitando y rehabilitando
     * el renderer de vídeo tras un pulso de reloj) o conmuta al decodificador por software si persiste.
     */
    private fun restartVideoRendererOrFallback(reason: String) {
        if (isFinishing || isDestroyed) return
        val p = player ?: return
        val selector = trackSelector
        val currentPos = if (isLive) 0L else p.currentPosition

        if (!videoRendererResetAttempted && selector != null) {
            videoRendererResetAttempted = true
            var videoRendererIndex = -1
            for (i in 0 until p.rendererCount) {
                if (p.getRendererType(i) == C.TRACK_TYPE_VIDEO) {
                    videoRendererIndex = i
                    break
                }
            }
            if (videoRendererIndex >= 0) {
                val idx = videoRendererIndex
                selector.setParameters(
                    selector.buildUponParameters().setRendererDisabled(idx, true)
                )
                mainHandler.postDelayed({
                    if (!isFinishing && !isDestroyed && player === p) {
                        selector.setParameters(
                            selector.buildUponParameters().setRendererDisabled(idx, false)
                        )
                        if (isLive) {
                            p.seekToDefaultPosition()
                        } else if (currentPos > 0L) {
                            p.seekTo(currentPos)
                        }
                    }
                }, 120L)
                return
            }
        }

        if (!forceSoftwareDecoder) {
            forceSoftwareDecoder = true
            decoderButton.updateDecoderLabel()
            initPlayer(startPositionMs = currentPos)
        } else {
            videoRendererResetAttempted = false
            initPlayer(startPositionMs = currentPos)
        }
    }

    private fun releasePlayer() {
        cancelPendingReconnect()
        player?.let { p ->
            playerListener?.let { p.removeListener(it) }
            analyticsListener?.let { p.removeAnalyticsListener(it) }
            p.release()
        }
        playerListener = null
        analyticsListener = null
        trackSelector = null
        player = null
    }

    private fun initPlayer(startPositionMs: Long) {
        releasePlayer()
        lastRenderedFrameCount = -1
        frozenFrameStallTicks = 0

        // Selector de códecs:
        // - Por defecto prioriza decodificación por Hardware (MediaCodec HW) para 1080p/50fps fluido
        //   con fallback automático (setEnableDecoderFallback(true)) si un perfil falla.
        // - Solo fuerza decodificadores por software (c2.android / omx.google) si el usuario lo activa
        //   manualmente o tras un error real irrecuperable de inicialización del códec HW.
        val codecSelector = MediaCodecSelector { mimeType, requiresSecureDecoder, requiresTunnelingDecoder ->
            val infos = MediaCodecUtil.getDecoderInfos(mimeType, requiresSecureDecoder, requiresTunnelingDecoder)
            if (forceSoftwareDecoder) {
                val swFirst = infos.sortedWith(
                    compareByDescending<MediaCodecInfo> { isReliableSoftwareCodec(it) }
                        .thenByDescending { isSoftwareCodec(it) }
                )
                swFirst.ifEmpty { infos }
            } else {
                val hwFirst = infos.sortedWith(
                    compareBy<MediaCodecInfo> { isSoftwareCodec(it) }
                )
                hwFirst.ifEmpty { infos }
            }
        }

        // DefaultRenderersFactory con fallback de decodificador y EXTENSION_RENDERER_MODE_PREFER
        val renderersFactory = DefaultRenderersFactory(applicationContext)
            .setEnableDecoderFallback(true)
            .setExtensionRendererMode(DefaultRenderersFactory.EXTENSION_RENDERER_MODE_PREFER)
            .setAllowedVideoJoiningTimeMs(5_000L)
            .setMediaCodecSelector(codecSelector)

        // DefaultTrackSelector configurado para no pausar ni descartar pistas de vídeo FHD / HEVC
        // que superen las capacidades nominales reportadas por Fire TV o el emulador de Android TV.
        val selector = DefaultTrackSelector(applicationContext).apply {
            setParameters(
                buildUponParameters()
                    .setExceedRendererCapabilitiesIfNecessary(true)
                    .setExceedVideoConstraintsIfNecessary(true)
                    .setExceedAudioConstraintsIfNecessary(true)
                    .setAllowVideoMixedMimeTypeAdaptiveness(true)
                    .setAllowVideoNonSeamlessAdaptiveness(true)
                    .clearVideoSizeConstraints()
            )
        }
        trackSelector = selector

        // Permite HTTP sin cifrar y redirecciones entre HTTP <-> HTTPS habituales en paneles IPTV
        val httpDataSourceFactory = DefaultHttpDataSource.Factory()
            .setAllowCrossProtocolRedirects(true)
            .setConnectTimeoutMs(12_000)
            .setReadTimeoutMs(20_000)
            .setUserAgent("XaviTV/1.0 (ExoPlayer; AndroidTV)")

        val dataSourceFactory = DefaultDataSource.Factory(applicationContext, httpDataSourceFactory)
        val errorHandlingPolicy = DefaultLoadErrorHandlingPolicy(/* minimumLoadableRetryCount = */ 5)

        // Extractores tolerantes a flujos MPEG-TS directos de Xtream Codes con arranque rápido
        val extractorsFactory = DefaultExtractorsFactory()
            .setConstantBitrateSeekingEnabled(true)
            .setTsExtractorFlags(
                DefaultTsPayloadReaderFactory.FLAG_ALLOW_NON_IDR_KEYFRAMES or
                    DefaultTsPayloadReaderFactory.FLAG_DETECT_ACCESS_UNITS or
                    DefaultTsPayloadReaderFactory.FLAG_ENABLE_HDMV_DTS_AUDIO_STREAMS
            )

        // Factoría principal: ProgressiveMediaSource.Factory para evitar ERROR_CODE_PARSING_MANIFEST_MALFORMED
        val progressiveFactory = ProgressiveMediaSource.Factory(dataSourceFactory, extractorsFactory)
            .setLoadErrorHandlingPolicy(errorHandlingPolicy)

        val mediaSourceFactory: MediaSource.Factory = if (useHlsFallback) {
            HlsMediaSource.Factory(dataSourceFactory)
                .setAllowChunklessPreparation(true)
                .setLoadErrorHandlingPolicy(errorHandlingPolicy)
        } else {
            progressiveFactory
        }

        // DefaultLoadControl optimizado para IPTV en directo y VOD sin inanición del decoder de vídeo
        val loadControl = DefaultLoadControl.Builder()
            .setBufferDurationsMs(
                /* minBufferMs = */ if (isLive) 10_000 else 18_000,
                /* maxBufferMs = */ if (isLive) 30_000 else 45_000,
                /* bufferForPlaybackMs = */ if (isLive) 1_000 else 1_500,
                /* bufferForPlaybackAfterRebufferMs = */ if (isLive) 2_000 else 3_000,
            )
            .setPrioritizeTimeOverSizeThresholds(true)
            .setTargetBufferBytes(if (isLive) 12 * 1024 * 1024 else 20 * 1024 * 1024)
            .build()

        val mediaItem = MediaItem.Builder()
            .setUri(url)
            .setMediaMetadata(MediaMetadata.Builder().setTitle(streamTitle).build())
            .build()

        val mediaSource = mediaSourceFactory.createMediaSource(mediaItem)

        player = ExoPlayer.Builder(applicationContext, renderersFactory)
            .setTrackSelector(selector)
            .setMediaSourceFactory(mediaSourceFactory)
            .setLoadControl(loadControl)
            .setWakeMode(C.WAKE_MODE_NETWORK)
            .build()
            .also { p ->
                playerView.player = p

                val analytics = object : AnalyticsListener {
                    override fun onVideoCodecError(
                        eventTime: AnalyticsListener.EventTime,
                        videoCodecError: Exception
                    ) {
                        mainHandler.post {
                            restartVideoRendererOrFallback("onVideoCodecError")
                        }
                    }

                    override fun onDroppedVideoFrames(
                        eventTime: AnalyticsListener.EventTime,
                        droppedFrames: Int,
                        elapsedMs: Long
                    ) {
                        // Solo reiniciamos si ningún fotograma llegó jamás a renderizarse pese a recibir paquetes
                        val rendered = p.videoDecoderCounters?.renderedOutputBufferCount ?: 0
                        if (droppedFrames >= 120 && rendered == 0) {
                            mainHandler.post {
                                restartVideoRendererOrFallback("onDroppedVideoFrames")
                            }
                        }
                    }
                }
                analyticsListener = analytics
                p.addAnalyticsListener(analytics)

                val listener = object : Player.Listener {
                    override fun onPlaybackStateChanged(playbackState: Int) {
                        if (playbackState == Player.STATE_READY) {
                            reconnectAttempts = 0
                        } else if (playbackState == Player.STATE_ENDED) {
                            if (isLive) {
                                scheduleReconnect(0L, "Corte de emisión")
                            } else {
                                val dur = p.duration.takeIf { it > 0L && it != C.TIME_UNSET } ?: 0L
                                if (dur > 0L) {
                                    playerIoScope.launch(Dispatchers.IO) {
                                        com.minuevaapp.tv.MiTVApp.instance.store.savePlaybackProgress(
                                            id = progressKey,
                                            positionMs = dur,
                                            durationMs = dur,
                                            commitSync = false,
                                            notifyUi = true
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
                        val currentPos = p.currentPosition

                        // 1. Si estaba en modo HLS y dio error de manifiesto, volver a ProgressiveMediaSource
                        if (error.errorCode == PlaybackException.ERROR_CODE_PARSING_MANIFEST_MALFORMED && useHlsFallback) {
                            useHlsFallback = false
                            initPlayer(startPositionMs = currentPos)
                            return
                        }

                        // 2. Si ProgressiveMediaSource detecta que la respuesta es un manifiesto M3U8 de texto
                        if (!useHlsFallback && (
                                error.errorCode == PlaybackException.ERROR_CODE_PARSING_CONTAINER_UNSUPPORTED ||
                                    error.errorCode == PlaybackException.ERROR_CODE_PARSING_CONTAINER_MALFORMED
                                )
                        ) {
                            useHlsFallback = true
                            initPlayer(startPositionMs = currentPos)
                            return
                        }

                        // 3. Fallback automático de códec Hardware -> Software o reinicio de renderizador
                        val isCodecError = error.errorCode in listOf(
                            PlaybackException.ERROR_CODE_DECODER_INIT_FAILED,
                            PlaybackException.ERROR_CODE_DECODER_QUERY_FAILED,
                            PlaybackException.ERROR_CODE_DECODING_FAILED,
                            PlaybackException.ERROR_CODE_DECODING_FORMAT_EXCEEDS_CAPABILITIES,
                            PlaybackException.ERROR_CODE_DECODING_FORMAT_UNSUPPORTED,
                        )
                        if (isCodecError) {
                            if (!forceSoftwareDecoder) {
                                forceSoftwareDecoder = true
                                decoderButton.updateDecoderLabel()
                                Toast.makeText(
                                    this@PlayerActivity,
                                    "Fallo en códec HW; cambiando a decodificación por software (SW)…",
                                    Toast.LENGTH_SHORT
                                ).show()
                                initPlayer(startPositionMs = currentPos)
                            } else {
                                restartVideoRendererOrFallback(error.errorCodeName)
                            }
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
                p.addListener(listener)
                p.setMediaSource(mediaSource)
                if (!isLive && startPositionMs > 0L) p.seekTo(startPositionMs)
                p.prepare()
                p.playWhenReady = true
            }
    }

    /**
     * Supervisa cada 2s que el decodificador de vídeo no haya quedado totalmente mudo al arrancar
     * (0 fotogramas renderizados pese a haber encolado >90 paquetes durante más de 8 segundos).
     * Evita falsos positivos durante la espera normal del primer keyframe IDR en MPEG-TS.
     */
    private fun startVideoFreezeWatchdog() {
        stopVideoFreezeWatchdog()
        val task = object : Runnable {
            override fun run() {
                if (!isFinishing && !isDestroyed) {
                    val p = player
                    if (p != null && p.isPlaying && p.playbackState == Player.STATE_READY && p.videoFormat != null) {
                        val counters = p.videoDecoderCounters
                        val rendered = counters?.renderedOutputBufferCount ?: 0
                        val queued = counters?.queuedInputBufferCount ?: 0
                        val dropped = counters?.droppedBufferCount ?: 0
                        if (rendered == 0 && queued > 90 && dropped == 0) {
                            frozenFrameStallTicks++
                            if (frozenFrameStallTicks >= 4) {
                                frozenFrameStallTicks = 0
                                restartVideoRendererOrFallback("DeadHardwareDecoderWatchdog")
                            }
                        } else {
                            frozenFrameStallTicks = 0
                        }
                        lastRenderedFrameCount = rendered
                    } else {
                        frozenFrameStallTicks = 0
                    }
                    mainHandler.postDelayed(this, 2_000L)
                }
            }
        }
        videoWatchdogRunnable = task
        mainHandler.postDelayed(task, 2_000L)
    }

    private fun stopVideoFreezeWatchdog() {
        videoWatchdogRunnable?.let { mainHandler.removeCallbacks(it) }
        videoWatchdogRunnable = null
    }

    private fun isReliableSoftwareCodec(info: MediaCodecInfo): Boolean {
        val name = info.name.lowercase()
        return name.startsWith("c2.android.") || name.startsWith("omx.google.")
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
     * Nunca bloquea el hilo principal (UI / TextureView) ni provoca recomposiciones de UI.
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

    override fun onResume() {
        super.onResume()
        playerView.onResume()
        player?.let { p ->
            if (isLive && !p.isPlaying && p.playbackState == Player.STATE_READY) {
                p.play()
            }
        }
    }

    override fun onPause() {
        saveResumePositionCriticalSync()
        playerView.onPause()
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
        cancelPendingReconnect()
        stopPeriodicProgressSaver()
        stopVideoFreezeWatchdog()
        saveResumePositionCriticalSync()
        player?.pause()
    }

    override fun onDestroy() {
        stopPeriodicProgressSaver()
        stopVideoFreezeWatchdog()
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
