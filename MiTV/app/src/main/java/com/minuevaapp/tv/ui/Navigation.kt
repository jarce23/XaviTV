package com.minuevaapp.tv.ui

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.minuevaapp.tv.MiTVApp

object Routes {
    const val PLAYLISTS = "playlists"
    const val HOME = "home"
    const val CATALOG = "catalog/{type}" // live | movie | series
    const val MOVIE = "movie/{id}"
    const val SERIES = "series/{id}"
    const val SEARCH = "search"

    fun catalog(type: String) = "catalog/${Uri.encode(type)}"
    fun movie(id: String) = "movie/${Uri.encode(id)}"
    fun series(id: String) = "series/${Uri.encode(id)}"
}

/**
 * Flujo de navegación equivalente al de la app original:
 * MainActivity -> ChangePlaylistActivity -> HomeActivity -> Live/Movie/Series -> Info -> Player
 */
@Composable
fun AppNavigation() {
    val nav = rememberNavController()
    val start = if (MiTVApp.instance.repo != null) Routes.HOME else Routes.PLAYLISTS

    NavHost(navController = nav, startDestination = start) {
        composable(Routes.PLAYLISTS) {
            PlaylistsScreen(
                onReady = {
                    nav.navigate(Routes.HOME) {
                        popUpTo(0) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            )
        }
        composable(Routes.HOME) {
            HomeScreen(
                onOpen = { type -> nav.navigate(Routes.catalog(type)) },
                onSearch = { nav.navigate(Routes.SEARCH) },
                onPlaylists = { nav.navigate(Routes.PLAYLISTS) },
            )
        }
        composable(
            route = Routes.CATALOG,
            arguments = listOf(navArgument("type") { type = NavType.StringType }),
        ) { backStackEntry ->
            val type = backStackEntry.arguments?.getString("type") ?: return@composable
            CatalogScreen(
                type = type,
                onMovie = { id -> nav.navigate(Routes.movie(id)) },
                onSeries = { id -> nav.navigate(Routes.series(id)) },
                onBack = { nav.popBackStack() },
            )
        }
        composable(
            route = Routes.MOVIE,
            arguments = listOf(navArgument("id") { type = NavType.StringType }),
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id") ?: return@composable
            MovieDetailScreen(id = id, onBack = { nav.popBackStack() })
        }
        composable(
            route = Routes.SERIES,
            arguments = listOf(navArgument("id") { type = NavType.StringType }),
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id") ?: return@composable
            SeriesDetailScreen(id = id, onBack = { nav.popBackStack() })
        }
        composable(Routes.SEARCH) {
            SearchScreen(
                onMovie = { id -> nav.navigate(Routes.movie(id)) },
                onSeries = { id -> nav.navigate(Routes.series(id)) },
                onBack = { nav.popBackStack() },
            )
        }
    }
}
