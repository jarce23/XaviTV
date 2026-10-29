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
import androidx.media3.common.PlaybackException
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.DefaultDataSource
import androidx.media3.datasource.DefaultHttpDataSource
import androidx.media3.exoplayer.DefaultLoadControl
import androidx.media3.exoplayer.DefaultRenderersFactory
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.hls.HlsMediaSource
import androidx.media3.exoplayer.mediacodec.MediaCodecInfo
import androidx.media3.exoplayer.mediacodec.MediaCodecSelector
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil
import androidx.media3.exoplayer.source.MediaSource
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import androidx.media3.exoplayer.upstream.DefaultLoadErrorHandlingPolicy
import androidx.media3.extractor.DefaultExtractorsFactory
import androidx.media3.extractor.ts.DefaultTsPayloadReaderFactory
import androidx.media3.ui.PlayerView

/**
 * Reproductor a pantalla completa con Media3 ExoPlayer y diseño en tonos oscuros, verde bético y dorado.
 * Incluye:
 * - Uso de ProgressiveMediaSource.Factory por defecto para enlaces directos de Xtream Codes (.ts, .mp4, .mkv),
 *   evitando ERROR_CODE_PARSING_MANIFEST_MALFORMED, con fallback a HLS sólo si el contenedor es un manifiesto M3U8 real.
 * - Soporte completo para HTTP sin cifrar y redirecciones HTTP <-> HTTPS (allowCrossProtocolRedirects).
 * - Reconexión automática ante cortes de red o caídas del stream en directo.
 * - Fallback automático y conmutador manual fluido entre decodificación por Hardware (HW+SW) y Software (SW).
 * - Controles translúcidos oscuros con detalles en dorado/champagne y blanco.
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
    private var reconnectRunnable: Runnable? = null
    private var reconnectAttempts = 0

    private val prefs by lazy { applicationContext.getSharedPreferences("resume", MODE_PRIVATE) }
    private val url by lazy { intent.getStringExtra(EXTRA_URL).orEmpty() }
    private val streamTitle by lazy { intent.getStringExtra(EXTRA_TITLE).orEmpty() }
    private val isLive by lazy { intent.getBooleanExtra(EXTRA_LIVE, false) }

    private var forceSoftwareDecoder = false
    private var useHlsFallback = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (url.isBlank()) {
            finish()
            return
        }
        val sType = intent.getStringExtra(EXTRA_STREAM_TYPE) ?: if (isLive) "live" else "movie"
        val sId = intent.getStringExtra(EXTRA_STREAM_ID)
        if (!sId.isNullOrBlank()) {
            com.minuevaapp.tv.MiTVApp.instance.store.addRecentlyViewed(sType, sId)
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

        playerView = PlayerView(this).apply {
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
                val pos = player?.currentPosition ?: 0L
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

        initPlayer(startPositionMs = if (isLive) 0L else prefs.getLong(url, 0L))
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

        // Selector de códecs optimizado para Fire TV / Android TV:
        // Por defecto prioriza estrictamente los decodificadores por hardware nativos del televisor
        // y deja los decodificadores por software como respaldo final.
        val codecSelector = MediaCodecSelector { mimeType, requiresSecureDecoder, requiresTunnelingDecoder ->
            val infos = MediaCodecUtil.getDecoderInfos(mimeType, requiresSecureDecoder, requiresTunnelingDecoder)
            if (forceSoftwareDecoder) {
                val swOnly = infos.filter { isSoftwareCodec(it) }
                swOnly.ifEmpty { infos }
            } else {
                val hwFirst = infos.sortedBy { isSoftwareCodec(it) }
                hwFirst.ifEmpty { infos }
            }
        }

        val renderersFactory = DefaultRenderersFactory(applicationContext)
            .setEnableDecoderFallback(true)
            .setExtensionRendererMode(
                if (forceSoftwareDecoder) DefaultRenderersFactory.EXTENSION_RENDERER_MODE_PREFER
                else DefaultRenderersFactory.EXTENSION_RENDERER_MODE_ON
            )
            .setMediaCodecSelector(codecSelector)

        // Permite HTTP sin cifrar y redirecciones entre HTTP <-> HTTPS habituales en paneles IPTV
        val httpDataSourceFactory = DefaultHttpDataSource.Factory()
            .setAllowCrossProtocolRedirects(true)
            .setConnectTimeoutMs(10_000)
            .setReadTimeoutMs(18_000)
            .setUserAgent("XaviTV/1.0 (ExoPlayer; AndroidTV)")

        val dataSourceFactory = DefaultDataSource.Factory(applicationContext, httpDataSourceFactory)
        val errorHandlingPolicy = DefaultLoadErrorHandlingPolicy(/* minimumLoadableRetryCount = */ 5)

        // Extractores tolerantes a flujos MPEG-TS directos de Xtream Codes con arranque rápido
        val extractorsFactory = DefaultExtractorsFactory()
            .setConstantBitrateSeekingEnabled(true)
            .setTsExtractorFlags(
                DefaultTsPayloadReaderFactory.FLAG_ALLOW_NON_IDR_KEYFRAMES or
                    DefaultTsPayloadReaderFactory.FLAG_DETECT_ACCESS_UNITS
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

        // Búfer inicial reducido en canales en directo para lograr Zapping Rápido en Fire TV / Android TV
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

        val mediaItem = MediaItem.Builder()
            .setUri(url)
            .setMediaMetadata(MediaMetadata.Builder().setTitle(streamTitle).build())
            .build()

        val mediaSource = mediaSourceFactory.createMediaSource(mediaItem)

        player = ExoPlayer.Builder(applicationContext, renderersFactory)
            .setMediaSourceFactory(mediaSourceFactory)
            .setLoadControl(loadControl)
            .setWakeMode(C.WAKE_MODE_NETWORK)
            .build()
            .also { p ->
                playerView.player = p
                val listener = object : Player.Listener {
                    override fun onPlaybackStateChanged(playbackState: Int) {
                        if (playbackState == Player.STATE_READY) {
                            reconnectAttempts = 0
                        } else if (playbackState == Player.STATE_ENDED && isLive) {
                            scheduleReconnect(0L, "Corte de emisión")
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
                p.addListener(listener)
                p.setMediaSource(mediaSource)
                if (!isLive && startPositionMs > 0L) p.seekTo(startPositionMs)
                p.prepare()
                p.playWhenReady = true
            }
    }

    private fun isSoftwareCodec(info: MediaCodecInfo): Boolean {
        val name = info.name.lowercase()
        return info.softwareOnly ||
            !info.hardwareAccelerated ||
            name.startsWith("omx.google.") ||
            name.startsWith("c2.android.") ||
            name.contains(".sw.")
    }

    private fun saveResumePosition() {
        player?.let { p ->
            if (!isLive && url.isNotBlank()) {
                val nearEnd = p.duration > 0 && p.currentPosition > p.duration - 30_000
                prefs.edit().putLong(url, if (nearEnd) 0L else p.currentPosition).apply()
            }
        }
    }

    override fun onStop() {
        super.onStop()
        cancelPendingReconnect()
        saveResumePosition()
        player?.pause()
    }

    override fun onDestroy() {
        saveResumePosition()
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
        private const val MAX_RECONNECT_ATTEMPTS = 5
        private const val RECONNECT_BASE_DELAY_MS = 2_500L

        fun start(
            ctx: Context,
            url: String,
            title: String?,
            live: Boolean = false,
            streamType: String? = null,
            streamId: String? = null
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
            )
        }
    }
}
