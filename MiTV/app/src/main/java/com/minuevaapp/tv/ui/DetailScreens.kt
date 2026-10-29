package com.minuevaapp.tv.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material.icons.filled.VideoLibrary
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.minuevaapp.tv.MiTVApp
import com.minuevaapp.tv.player.PlayerActivity
import com.minuevaapp.tv.ui.theme.*

/** Ficha de película (MovieInfoActivity). */
@Composable
fun MovieDetailScreen(id: String, onBack: () -> Unit) {
    val app = MiTVApp.instance
    val repo = app.repo ?: return
    val ctx = LocalContext.current
    val state = rememberLoad(id, repo) { repo.vodInfo(id) }
    var isFav by remember(id) { mutableStateOf(id in app.store.favorites("movie")) }

    AppScaffold(
        title = "Ficha de película",
        onBack = onBack,
        actions = {
            IconButton(onClick = {
                app.store.toggleFavorite("movie", id)
                isFav = id in app.store.favorites("movie")
            }) {
                Icon(
                    imageVector = if (isFav) Icons.Default.Star else Icons.Default.StarBorder,
                    contentDescription = "Favorito",
                    tint = if (isFav) GoldLight else TextSecondaryGray,
                )
            }
        },
    ) { pad ->
        LoadContent(state) { r ->
            val info = r.info
            val backdrop = remember(info) {
                info?.backdrop?.let { el ->
                    when {
                        el.isJsonArray && el.asJsonArray.size() > 0 ->
                            runCatching { el.asJsonArray[0].asString }.getOrNull()
                        el.isJsonPrimitive ->
                            runCatching { el.asString }.getOrNull()
                        else -> null
                    }
                }
            }
            Box(Modifier.padding(pad).fillMaxSize()) {
                if (!backdrop.isNullOrBlank() || !info?.image.isNullOrBlank()) {
                    NetworkImage(
                        url = backdrop ?: info?.image,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop,
                        alpha = 0.25f,
                    )
                    Box(
                        Modifier
                            .fillMaxSize()
                            .background(
                                Brush.verticalGradient(
                                    listOf(
                                        BetisGreenDark.copy(alpha = 0.55f),
                                        DarkBackground.copy(alpha = 0.96f),
                                    )
                                )
                            )
                    )
                }
                Row(Modifier.fillMaxSize().padding(24.dp)) {
                    val posterShape = RoundedCornerShape(14.dp)
                    NetworkImage(
                        url = info?.image,
                        contentDescription = info?.name,
                        modifier = Modifier
                            .width(210.dp)
                            .aspectRatio(2f / 3f)
                            .shadow(10.dp, posterShape)
                            .clip(posterShape)
                            .border(1.5.dp, GoldPrimary.copy(alpha = 0.65f), posterShape),
                        contentScale = ContentScale.Crop,
                    )
                    Spacer(Modifier.width(28.dp))
                    Column(Modifier.weight(1f).verticalScroll(rememberScrollState())) {
                        val title = info?.name?.ifBlank { null } ?: r.movieData?.name.orEmpty()
                        Text(
                            text = title,
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.ExtraBold,
                            color = TextPrimaryWhite,
                        )
                        Spacer(Modifier.height(6.dp))
                        Text(
                            text = listOfNotNull(
                                info?.releaseDate,
                                info?.duration,
                                info?.genre,
                                info?.rating?.takeIf { it != "0" }?.let { "★ $it" },
                            ).filter { it.isNotBlank() }.joinToString("  ·  "),
                            color = GoldLight,
                            fontWeight = FontWeight.Medium,
                            style = MaterialTheme.typography.bodyMedium,
                        )
                        Spacer(Modifier.height(18.dp))
                        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                            Button(
                                onClick = {
                                    val sid = r.movieData?.streamId?.takeIf { it.isNotBlank() } ?: id
                                    app.store.addRecentlyViewed("movie", sid)
                                    PlayerActivity.start(ctx, repo.movieUrl(sid, r.movieData?.extension), title, live = false)
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = GoldPrimary,
                                    contentColor = DarkBackground,
                                ),
                                shape = RoundedCornerShape(10.dp),
                            ) {
                                Icon(Icons.Default.PlayArrow, contentDescription = null)
                                Spacer(Modifier.width(6.dp))
                                Text("Reproducir / Continuar", fontWeight = FontWeight.Bold)
                            }
                            OutlinedButton(
                                onClick = {
                                    app.store.toggleFavorite("movie", id)
                                    isFav = id in app.store.favorites("movie")
                                },
                                shape = RoundedCornerShape(10.dp),
                                colors = ButtonDefaults.outlinedButtonColors(contentColor = GoldLight),
                            ) {
                                Icon(
                                    imageVector = if (isFav) Icons.Default.Star else Icons.Default.StarBorder,
                                    contentDescription = null,
                                    tint = GoldLight,
                                )
                                Spacer(Modifier.width(6.dp))
                                Text(if (isFav) "En favoritos" else "Añadir a favoritos")
                            }
                        }
                        Spacer(Modifier.height(18.dp))
                        info?.plot?.takeIf { it.isNotBlank() }?.let {
                            Text(it, style = MaterialTheme.typography.bodyMedium, color = TextPrimaryWhite)
                            Spacer(Modifier.height(14.dp))
                        }
                        info?.director?.takeIf { it.isNotBlank() }?.let {
                            Text(
                                text = "Dirección: $it",
                                style = MaterialTheme.typography.bodySmall,
                                color = TextSecondaryGray,
                            )
                            Spacer(Modifier.height(4.dp))
                        }
                        info?.cast?.takeIf { it.isNotBlank() }?.let {
                            Text(
                                text = "Reparto: $it",
                                style = MaterialTheme.typography.bodySmall,
                                color = TextSecondaryGray,
                            )
                        }
                    }
                }
            }
        }
    }
}

/** Ficha de serie con temporadas y episodios (SeriesInfoActivity + SeasonActivity). */
@Composable
fun SeriesDetailScreen(id: String, onBack: () -> Unit) {
    val app = MiTVApp.instance
    val repo = app.repo ?: return
    val ctx = LocalContext.current
    val state = rememberLoad(id, repo) { repo.seriesInfo(id) }
    var season by rememberSaveable(id) { mutableStateOf<String?>(null) }
    var isFav by remember(id) { mutableStateOf(id in app.store.favorites("series")) }

    AppScaffold(
        title = "Ficha de serie",
        onBack = onBack,
        actions = {
            IconButton(onClick = {
                app.store.toggleFavorite("series", id)
                isFav = id in app.store.favorites("series")
            }) {
                Icon(
                    imageVector = if (isFav) Icons.Default.Star else Icons.Default.StarBorder,
                    contentDescription = "Favorito",
                    tint = if (isFav) GoldLight else TextSecondaryGray,
                )
            }
        },
    ) { pad ->
        LoadContent(state) { (info, seasons) ->
            val current = season ?: seasons.keys.firstOrNull()
            Column(Modifier.padding(pad).fillMaxSize().padding(18.dp)) {
                Row(verticalAlignment = Alignment.Top) {
                    val coverShape = RoundedCornerShape(12.dp)
                    NetworkImage(
                        url = info?.cover,
                        contentDescription = info?.name,
                        fallbackIcon = Icons.Default.VideoLibrary,
                        modifier = Modifier
                            .width(125.dp)
                            .aspectRatio(2f / 3f)
                            .shadow(8.dp, coverShape)
                            .clip(coverShape)
                            .border(1.5.dp, GoldPrimary.copy(alpha = 0.65f), coverShape),
                        contentScale = ContentScale.Crop,
                    )
                    Spacer(Modifier.width(18.dp))
                    Column(Modifier.weight(1f)) {
                        Text(
                            text = info?.name.orEmpty(),
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.ExtraBold,
                            color = TextPrimaryWhite,
                        )
                        Spacer(Modifier.height(4.dp))
                        Text(
                            text = listOfNotNull(
                                info?.releaseDate,
                                info?.genre,
                                info?.rating?.takeIf { it != "0" }?.let { "★ $it" },
                            ).filter { it.isNotBlank() }.joinToString("  ·  "),
                            color = GoldLight,
                            fontWeight = FontWeight.Medium,
                            style = MaterialTheme.typography.bodySmall,
                        )
                        Spacer(Modifier.height(8.dp))
                        Text(
                            text = info?.plot.orEmpty(),
                            maxLines = 4,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.bodySmall,
                            color = TextSecondaryGray,
                        )
                    }
                }
                Spacer(Modifier.height(14.dp))
                Row(
                    Modifier.horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    seasons.keys.forEach { s ->
                        val isSelected = s == current
                        FilterChip(
                            selected = isSelected,
                            onClick = { season = s },
                            label = {
                                Text(
                                    text = "Temporada $s",
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                )
                            },
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = BetisGreenPrimary,
                                selectedLabelColor = GoldLight,
                                containerColor = DarkSurface,
                                labelColor = TextSecondaryGray,
                            ),
                            border = FilterChipDefaults.filterChipBorder(
                                enabled = true,
                                selected = isSelected,
                                borderColor = GoldPrimary.copy(alpha = 0.30f),
                                selectedBorderColor = GoldLight,
                            ),
                        )
                    }
                }
                Spacer(Modifier.height(10.dp))
                val episodes = seasons[current].orEmpty()
                if (episodes.isEmpty()) {
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text("No hay episodios disponibles.", color = TextSecondaryGray)
                    }
                } else {
                    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        items(episodes, key = { it.id }) { ep ->
                            val epShape = RoundedCornerShape(10.dp)
                            Row(
                                Modifier
                                    .fillMaxWidth()
                                    .tvClickable(
                                        shape = epShape,
                                        idleBorderColor = GoldPrimary.copy(alpha = 0.22f),
                                    ) {
                                        app.store.addRecentlyViewed("series", id)
                                        PlayerActivity.start(ctx, repo.episodeUrl(ep.id, ep.extension), ep.title, live = false)
                                    }
                                    .background(DarkSurface, epShape)
                                    .padding(10.dp),
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                NetworkImage(
                                    url = ep.info?.image ?: info?.cover,
                                    contentDescription = ep.title,
                                    fallbackIcon = Icons.Default.VideoLibrary,
                                    modifier = Modifier
                                        .width(145.dp)
                                        .aspectRatio(16f / 9f)
                                        .clip(RoundedCornerShape(8.dp))
                                        .border(1.dp, GoldPrimary.copy(alpha = 0.30f), RoundedCornerShape(8.dp)),
                                    contentScale = ContentScale.Crop,
                                )
                                Spacer(Modifier.width(14.dp))
                                Column(Modifier.weight(1f)) {
                                    Text(
                                        text = "E${ep.episodeNum.orEmpty()}  ·  ${ep.title?.ifBlank { "Episodio ${ep.episodeNum.orEmpty()}" } ?: "Episodio"}",
                                        fontWeight = FontWeight.SemiBold,
                                        color = TextPrimaryWhite,
                                    )
                                    ep.info?.duration?.takeIf { it.isNotBlank() }?.let {
                                        Text(
                                            text = it,
                                            color = GoldLight,
                                            style = MaterialTheme.typography.labelSmall,
                                            fontWeight = FontWeight.Medium,
                                        )
                                    }
                                    ep.info?.plot?.takeIf { it.isNotBlank() }?.let {
                                        Spacer(Modifier.height(2.dp))
                                        Text(
                                            text = it,
                                            maxLines = 2,
                                            overflow = TextOverflow.Ellipsis,
                                            style = MaterialTheme.typography.bodySmall,
                                            color = TextSecondaryGray,
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

/** Búsqueda global en canales en vivo, películas y series (SearchActivity). */
@Composable
fun SearchScreen(onMovie: (String) -> Unit, onSeries: (String) -> Unit, onBack: () -> Unit) {
    val app = MiTVApp.instance
    val repo = app.repo ?: return
    val ctx = LocalContext.current
    var query by rememberSaveable { mutableStateOf("") }
    val data = rememberLoad(repo) {
        Triple(repo.live().second, repo.vod().second, repo.series().second)
    }
    val favLive = remember { app.store.favorites("live") }
    val favMovies = remember { app.store.favorites("movie") }
    val favSeries = remember { app.store.favorites("series") }

    AppScaffold("Buscar en el catálogo", onBack) { pad ->
        Column(Modifier.padding(pad).padding(16.dp).fillMaxSize()) {
            GoldOutlinedTextField(
                value = query,
                onValueChange = { query = it },
                label = "Buscar canales, películas o series…",
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                modifier = Modifier.fillMaxWidth(),
            )
            Spacer(Modifier.height(14.dp))
            LoadContent(data) { (lives, movies, series) ->
                val q = query.trim().lowercase()
                val results = remember(q, lives, movies, series) {
                    if (q.length < 2) {
                        emptyList()
                    } else {
                        val liveHits = lives.asSequence()
                            .filter { it.name?.lowercase()?.contains(q) == true }
                            .take(60)
                            .map { Triple("l" + it.streamId, it.name, it.icon) }
                        val movieHits = movies.asSequence()
                            .filter { it.name?.lowercase()?.contains(q) == true }
                            .take(100)
                            .map { Triple("m" + it.streamId, it.name, it.icon) }
                        val seriesHits = series.asSequence()
                            .filter { it.name?.lowercase()?.contains(q) == true }
                            .take(100)
                            .map { Triple("s" + it.seriesId, it.name, it.cover) }
                        (liveHits + movieHits + seriesHits).toList()
                    }
                }
                if (q.length >= 2 && results.isEmpty()) {
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text("No se encontraron resultados para «$query».", color = TextSecondaryGray)
                    }
                } else {
                    LazyVerticalGrid(
                        columns = GridCells.Adaptive(140.dp),
                        horizontalArrangement = Arrangement.spacedBy(14.dp),
                        verticalArrangement = Arrangement.spacedBy(14.dp),
                    ) {
                        items(results, key = { it.first }) { (key, name, img) ->
                            val id = key.drop(1)
                            val typeTag = when (key[0]) {
                                'l' -> "En directo"
                                'm' -> "Película"
                                else -> "Serie"
                            }
                            val isFav = when (key[0]) {
                                'l' -> id in favLive
                                'm' -> id in favMovies
                                else -> id in favSeries
                            }
                            PosterCard(
                                title = name,
                                image = img,
                                subtitle = typeTag,
                                isFavorite = isFav,
                            ) {
                                when (key[0]) {
                                    'l' -> {
                                        app.store.addRecentlyViewed("live", id)
                                        PlayerActivity.start(ctx, repo.liveUrl(id), name, live = true)
                                    }
                                    'm' -> {
                                        app.store.addRecentlyViewed("movie", id)
                                        onMovie(id)
                                    }
                                    else -> {
                                        app.store.addRecentlyViewed("series", id)
                                        onSeries(id)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
