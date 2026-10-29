package com.minuevaapp.tv.desktop

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.input.key.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*
import com.minuevaapp.tv.data.Series
import com.minuevaapp.tv.data.VodStream
import com.minuevaapp.tv.player.DesktopPlayerScreen
import com.minuevaapp.tv.ui.*
import com.minuevaapp.tv.ui.theme.MiTVTheme

sealed class DesktopScreen {
    data object Playlists : DesktopScreen()
    data object Home : DesktopScreen()
    data class Catalog(val kind: CatalogKind) : DesktopScreen()
    data class MovieDetail(val movie: VodStream) : DesktopScreen()
    data class SeriesDetail(val series: Series) : DesktopScreen()
    data object Search : DesktopScreen()
    data class Player(
        val url: String,
        val title: String,
        val subtitle: String = "",
        val streamType: String = "live",
        val resumeKey: String = ""
    ) : DesktopScreen()
}

fun main() {
    // Propiedades de aceleración gráfica Direct3D y red para Windows Desktop
    System.setProperty(
        "http.agent",
        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36"
    )
    System.setProperty("sun.java2d.d3d", "true")
    System.setProperty("compose.interop.blending", "true")

    application {
        val appState = remember { DesktopAppState() }
        val windowState = rememberWindowState(
            placement = WindowPlacement.Floating,
            position = WindowPosition.Aligned(Alignment.Center),
            size = DpSize(1280.dp, 800.dp)
        )

        // Arranque instantáneo: renderiza directamente la pantalla principal sin bloquear el hilo UI
        val stack = remember {
            mutableStateListOf<DesktopScreen>(DesktopScreen.Home)
        }

        // Inicialización de base de datos local y precarga M3U (TDTChannels) en segundo plano (Dispatchers.IO)
        LaunchedEffect(Unit) {
            appState.initializeInBackground()
        }

        fun navigate(screen: DesktopScreen) {
            stack.add(screen)
        }

        fun popBack(): Boolean {
            return if (stack.size > 1) {
                stack.removeAt(stack.lastIndex)
                true
            } else {
                false
            }
        }

        fun toggleFullscreen() {
            windowState.placement = if (windowState.placement == WindowPlacement.Fullscreen) {
                WindowPlacement.Floating
            } else {
                WindowPlacement.Fullscreen
            }
        }

        Window(
            onCloseRequest = ::exitApplication,
            state = windowState,
            title = "XaviTV",
            icon = painterResource("app_logo.png"),
            onPreviewKeyEvent = { event ->
                if (event.type == KeyEventType.KeyUp) {
                    when (event.key) {
                        Key.F11 -> {
                            toggleFullscreen()
                            true
                        }
                        Key.Escape -> {
                            if (windowState.placement == WindowPlacement.Fullscreen) {
                                windowState.placement = WindowPlacement.Floating
                                true
                            } else {
                                popBack()
                            }
                        }
                        else -> false
                    }
                } else {
                    false
                }
            }
        ) {
            CompositionLocalProvider(LocalAppState provides appState) {
                MiTVTheme {
                    when (val current = stack.last()) {
                        is DesktopScreen.Playlists -> PlaylistsScreen(
                            onConnected = {
                                stack.clear()
                                stack.add(DesktopScreen.Home)
                            }
                        )
                        is DesktopScreen.Home -> HomeScreen(
                            onOpenLive = { navigate(DesktopScreen.Catalog(CatalogKind.LIVE)) },
                            onOpenMovies = { navigate(DesktopScreen.Catalog(CatalogKind.MOVIES)) },
                            onOpenSeries = { navigate(DesktopScreen.Catalog(CatalogKind.SERIES)) },
                            onOpenFavorites = { navigate(DesktopScreen.Catalog(CatalogKind.FAVORITES)) },
                            onOpenSearch = { navigate(DesktopScreen.Search) },
                            onOpenPlaylists = { navigate(DesktopScreen.Playlists) }
                        )
                        is DesktopScreen.Catalog -> CatalogScreen(
                            kind = current.kind,
                            onBack = { popBack() },
                            onPlayStream = { url, title, subtitle, type, resumeKey ->
                                navigate(
                                    DesktopScreen.Player(
                                        url = url,
                                        title = title,
                                        subtitle = subtitle,
                                        streamType = type,
                                        resumeKey = resumeKey
                                    )
                                )
                            },
                            onOpenMovie = { navigate(DesktopScreen.MovieDetail(it)) },
                            onOpenSeries = { navigate(DesktopScreen.SeriesDetail(it)) }
                        )
                        is DesktopScreen.MovieDetail -> MovieDetailScreen(
                            movie = current.movie,
                            onBack = { popBack() },
                            onPlay = { url, title, resumeKey ->
                                appState.store.addRecentlyViewed("movie", current.movie.streamId)
                                navigate(
                                    DesktopScreen.Player(
                                        url = url,
                                        title = title,
                                        subtitle = "Película",
                                        streamType = "vod",
                                        resumeKey = resumeKey
                                    )
                                )
                            }
                        )
                        is DesktopScreen.SeriesDetail -> SeriesDetailScreen(
                            series = current.series,
                            onBack = { popBack() },
                            onPlayEpisode = { url, title, subtitle, resumeKey ->
                                appState.store.addRecentlyViewed("series", current.series.seriesId)
                                navigate(
                                    DesktopScreen.Player(
                                        url = url,
                                        title = title,
                                        subtitle = subtitle,
                                        streamType = "series",
                                        resumeKey = resumeKey
                                    )
                                )
                            }
                        )
                        is DesktopScreen.Search -> SearchScreen(
                            onBack = { popBack() },
                            onPlayLive = { ch, url ->
                                appState.store.addRecentlyViewed("live", ch.streamId)
                                navigate(
                                    DesktopScreen.Player(
                                        url = url,
                                        title = ch.name ?: "Canal",
                                        subtitle = "TV en directo",
                                        streamType = "live"
                                    )
                                )
                            },
                            onOpenMovie = {
                                appState.store.addRecentlyViewed("movie", it.streamId)
                                navigate(DesktopScreen.MovieDetail(it))
                            },
                            onOpenSeries = {
                                appState.store.addRecentlyViewed("series", it.seriesId)
                                navigate(DesktopScreen.SeriesDetail(it))
                            }
                        )
                        is DesktopScreen.Player -> DesktopPlayerScreen(
                            url = current.url,
                            title = current.title,
                            subtitle = current.subtitle,
                            streamType = current.streamType,
                            resumeKey = current.resumeKey,
                            isFullscreen = windowState.placement == WindowPlacement.Fullscreen,
                            onToggleFullscreen = { toggleFullscreen() },
                            onClose = { popBack() }
                        )
                    }
                }
            }
        }
    }
}
