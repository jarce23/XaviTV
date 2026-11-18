package com.minuevaapp.tv.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material.icons.filled.Tv
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.minuevaapp.tv.MiTVApp
import com.minuevaapp.tv.data.Category
import com.minuevaapp.tv.data.XtreamRepository
import com.minuevaapp.tv.player.PlayerActivity
import com.minuevaapp.tv.ui.theme.*
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

private const val ALL = "__all"
private const val RECENT = "__recent"
private const val FAV = "__fav"

/** Elemento genérico para la parrilla de cualquier tipo de contenido. */
@Immutable
private data class CatalogItem(
    val id: String,
    val name: String?,
    val image: String?,
    val categoryId: String?,
    val extra: String?,
)

@Composable
private fun RecentChannelChip(
    item: CatalogItem,
    onPlay: () -> Unit,
) {
    val shape = RoundedCornerShape(10.dp)
    Row(
        modifier = Modifier
            .width(200.dp)
            .tvClickable(
                shape = shape,
                idleBorderColor = GoldPrimary.copy(alpha = 0.45f),
                onClick = onPlay,
            )
            .background(DarkSurface, shape)
            .padding(horizontal = 8.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        NetworkImage(
            url = item.image,
            contentDescription = item.name,
            fallbackIcon = Icons.Default.Tv,
            contentScale = ContentScale.Fit,
            targetWidthPx = 96,
            targetHeightPx = 96,
            modifier = Modifier
                .size(36.dp)
                .clip(RoundedCornerShape(6.dp))
                .border(0.8.dp, GoldPrimary.copy(alpha = 0.3f), RoundedCornerShape(6.dp))
                .padding(2.dp),
        )
        Spacer(Modifier.width(8.dp))
        Column(Modifier.weight(1f)) {
            Text(
                text = item.name?.ifBlank { "Canal" } ?: "Canal",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.SemiBold,
                color = TextPrimaryWhite,
                style = MaterialTheme.typography.bodySmall,
            )
            Text(
                text = "Visto reciente",
                style = MaterialTheme.typography.labelSmall,
                color = GoldLight,
            )
        }
        Icon(
            imageVector = Icons.Default.PlayArrow,
            contentDescription = null,
            tint = GoldLight,
            modifier = Modifier.size(18.dp),
        )
    }
}

/**
 * Pantalla de catálogo responsive y optimizada para Fire TV / Android TV y Android móvil:
 * - En pantallas anchas (TV / Tablet / Landscape): panel lateral de categorías + contenido + EPG lateral.
 * - En pantallas compactas (móvil vertical): chips horizontales de categorías + EPG desplegable bajo demanda.
 */
@OptIn(FlowPreview::class)
@Composable
fun CatalogScreen(
    type: String,
    onMovie: (String) -> Unit,
    onSeries: (String) -> Unit,
    onBack: () -> Unit,
) {
    val app = MiTVApp.instance
    val repo = app.repo ?: return
    val title = when (type) {
        "live" -> "TV en directo"
        "movie" -> "Películas"
        else -> "Series"
    }

    var refreshVersion by remember { mutableIntStateOf(0) }
    var isRefreshing by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    val state = rememberLoad(type, repo, refreshVersion) {
        when (type) {
            "live" -> repo.live().let { (c, s) ->
                c to s.map { CatalogItem(it.streamId, it.name, it.icon, it.categoryId, it.tvArchive) }
            }
            "movie" -> repo.vod().let { (c, s) ->
                c to s.map { CatalogItem(it.streamId, it.name, it.icon, it.categoryId, it.rating) }
            }
            else -> repo.series().let { (c, s) ->
                c to s.map { CatalogItem(it.seriesId, it.name, it.cover, it.categoryId, it.rating) }
            }
        }
    }
    var selected by remember(type) { mutableStateOf(app.store.getSelectedCategory(type)) }
    var searchQuery by rememberSaveable(type) { mutableStateOf("") }
    var debouncedQuery by remember(type) { mutableStateOf(searchQuery) }
    LaunchedEffect(searchQuery) {
        if (searchQuery.isBlank()) {
            debouncedQuery = ""
        } else {
            delay(150L)
            debouncedQuery = searchQuery
        }
    }

    var favs by remember(type) { mutableStateOf(app.store.favorites(type)) }
    var recentRefresh by remember { mutableIntStateOf(0) }
    val storeRecentVersion by app.store.recentUpdates.collectAsState()
    val progressMap by app.store.playbackProgressFlow.collectAsState()
    val ctx = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    DisposableEffect(lifecycleOwner, type) {
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_RESUME) {
                recentRefresh++
                favs = app.store.favorites(type)
            }
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    AppScaffold(
        title = title,
        onBack = onBack,
        actions = {
            IconButton(
                onClick = {
                    if (!isRefreshing) {
                        isRefreshing = true
                        scope.launch {
                            repo.refreshAllXtream()
                            isRefreshing = false
                            refreshVersion++
                        }
                    }
                },
                enabled = !isRefreshing
            ) {
                if (isRefreshing) {
                    CircularProgressIndicator(modifier = Modifier.size(20.dp), strokeWidth = 2.dp, color = GoldLight)
                } else {
                    Icon(Icons.Default.Refresh, contentDescription = "Actualizar lista", tint = GoldLight)
                }
            }
        }
    ) { pad ->
        LoadContent(state) { (categories, items) ->
            val cats = remember(categories) {
                listOf(
                    Category(ALL, "Todas"),
                    Category(RECENT, "⭐ Vistos recientemente"),
                    Category(FAV, "★ Favoritos")
                ) + categories
            }

            LaunchedEffect(categories) {
                if (categories.isNotEmpty() && selected != ALL && selected != RECENT && selected != FAV && categories.none { it.id == selected }) {
                    selected = ALL
                    app.store.setSelectedCategory(type, ALL)
                }
            }

            val recentIds = remember(recentRefresh, storeRecentVersion, type) { app.store.getRecentlyViewed(type) }
            val recentItems = remember(items, recentIds) {
                if (recentIds.isEmpty()) emptyList()
                else {
                    val map = items.associateBy { it.id }
                    recentIds.mapNotNull { map[it] }
                }
            }
            val shown = remember(selected, items, favs, debouncedQuery, recentItems) {
                val q = debouncedQuery.trim()
                val baseList = when {
                    selected == FAV -> items.filter { it.id in favs }
                    selected == RECENT -> recentItems
                    q.isNotEmpty() -> items
                    selected == ALL -> items
                    else -> items.filter { it.categoryId == selected }
                }
                if (q.isEmpty()) {
                    baseList
                } else {
                    baseList.filter { it.name?.contains(q, ignoreCase = true) == true }
                }
            }

            BoxWithConstraints(Modifier.padding(pad).fillMaxSize()) {
                val isCompact = maxWidth < 600.dp

                val contentBody: @Composable (Modifier) -> Unit = { bodyModifier ->
                    Column(bodyModifier) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(DarkSurface.copy(alpha = 0.65f))
                                .padding(horizontal = if (isCompact) 10.dp else 14.dp, vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                        ) {
                            GoldOutlinedTextField(
                                value = searchQuery,
                                onValueChange = { searchQuery = it },
                                label = "Buscar en $title…",
                                leadingIcon = {
                                    Icon(Icons.Default.Search, contentDescription = "Buscar", tint = GoldLight)
                                },
                                trailingIcon = {
                                    if (searchQuery.isNotEmpty()) {
                                        IconButton(onClick = { searchQuery = "" }) {
                                            Icon(
                                                imageVector = Icons.Default.Clear,
                                                contentDescription = "Limpiar búsqueda",
                                                tint = GoldLight,
                                            )
                                        }
                                    }
                                },
                                modifier = Modifier.weight(1f),
                            )
                            Box(
                                Modifier
                                    .background(BetisGreenDark, RoundedCornerShape(10.dp))
                                    .border(1.dp, GoldPrimary.copy(alpha = 0.45f), RoundedCornerShape(10.dp))
                                    .padding(horizontal = 12.dp, vertical = 10.dp)
                            ) {
                                Text(
                                    text = "${shown.size}",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = GoldLight,
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                        }

                        if (isCompact) {
                            LazyRow(
                                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 6.dp),
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                modifier = Modifier.fillMaxWidth().background(DarkSurface.copy(alpha = 0.45f))
                            ) {
                                items(cats, key = { it.id }) { c ->
                                    val sel = c.id == selected
                                    val chipShape = RoundedCornerShape(10.dp)
                                    Box(
                                        modifier = Modifier
                                            .tvClickable(
                                                shape = chipShape,
                                                idleBorderColor = if (sel) GoldLight else GoldPrimary.copy(alpha = 0.25f),
                                            ) {
                                                selected = c.id
                                                app.store.setSelectedCategory(type, c.id)
                                            }
                                            .background(if (sel) BetisGreenPrimary else DarkSurface, chipShape)
                                            .padding(horizontal = 12.dp, vertical = 8.dp),
                                    ) {
                                        Text(
                                            text = c.name?.ifBlank { "Sin nombre" } ?: "Sin nombre",
                                            maxLines = 1,
                                            overflow = TextOverflow.Ellipsis,
                                            fontWeight = if (sel) FontWeight.Bold else FontWeight.Medium,
                                            color = if (sel) GoldLight else TextPrimaryWhite,
                                            style = MaterialTheme.typography.labelMedium,
                                        )
                                    }
                                }
                            }
                        }
                        HorizontalDivider(thickness = 1.dp, color = GoldPrimary.copy(alpha = 0.18f))

                        val scrollKey = remember(type, selected) { "${type}_$selected" }
                        val savedScroll = remember(scrollKey) { app.store.getScrollPosition(scrollKey) }

                        if (shown.isEmpty()) {
                            Box(Modifier.weight(1f).fillMaxWidth(), contentAlignment = Alignment.Center) {
                                Text(
                                    text = if (searchQuery.isNotBlank()) {
                                        "No se encontraron resultados para «$searchQuery» en $title."
                                    } else if (selected == RECENT) {
                                        "No has visto ningún contenido recientemente.\nLos contenidos que reproduzcas aparecerán aquí automáticamente."
                                    } else {
                                        "No hay elementos en esta categoría."
                                    },
                                    textAlign = TextAlign.Center,
                                    color = TextSecondaryGray,
                                    modifier = Modifier.padding(24.dp),
                                )
                            }
                        } else if (type == "live") {
                            key(type, selected) {
                                val listState = rememberLazyListState(
                                    initialFirstVisibleItemIndex = savedScroll.first,
                                    initialFirstVisibleItemScrollOffset = savedScroll.second
                                )
                                LaunchedEffect(listState, scrollKey) {
                                    snapshotFlow { listState.firstVisibleItemIndex to listState.firstVisibleItemScrollOffset }
                                        .distinctUntilChanged()
                                        .debounce(400L)
                                        .collect { (idx, off) ->
                                            app.store.saveScrollPosition(scrollKey, idx, off)
                                        }
                                }
                                LiveList(
                                    repo = repo,
                                    items = shown,
                                    favs = favs,
                                    listState = listState,
                                    isCompact = isCompact,
                                    recentItems = if (selected == ALL && debouncedQuery.isEmpty()) recentItems else emptyList(),
                                    onPlayRecent = { ch ->
                                        PlayerActivity.start(ctx, repo.liveUrl(ch.id), ch.name, live = true, streamType = type, streamId = ch.id)
                                    },
                                    onToggleFav = { id ->
                                        app.store.toggleFavorite(type, id)
                                        favs = app.store.favorites(type)
                                    },
                                    onPlay = { item ->
                                        PlayerActivity.start(ctx, repo.liveUrl(item.id), item.name, live = true, streamType = type, streamId = item.id)
                                    },
                                    modifier = Modifier.weight(1f).fillMaxWidth(),
                                )
                            }
                        } else {
                            key(type, selected) {
                                val gridState = rememberLazyGridState(
                                    initialFirstVisibleItemIndex = savedScroll.first,
                                    initialFirstVisibleItemScrollOffset = savedScroll.second
                                )
                                LaunchedEffect(gridState, scrollKey) {
                                    snapshotFlow { gridState.firstVisibleItemIndex to gridState.firstVisibleItemScrollOffset }
                                        .distinctUntilChanged()
                                        .debounce(400L)
                                        .collect { (idx, off) ->
                                            app.store.saveScrollPosition(scrollKey, idx, off)
                                        }
                                }
                                LazyVerticalGrid(
                                    state = gridState,
                                    columns = GridCells.Adaptive(if (isCompact) 118.dp else 140.dp),
                                    modifier = Modifier.weight(1f).fillMaxWidth().padding(if (isCompact) 10.dp else 14.dp),
                                    horizontalArrangement = Arrangement.spacedBy(if (isCompact) 10.dp else 14.dp),
                                    verticalArrangement = Arrangement.spacedBy(if (isCompact) 10.dp else 14.dp),
                                ) {
                                    if (selected == ALL && debouncedQuery.isEmpty() && recentItems.isNotEmpty()) {
                                        item(span = { GridItemSpan(maxLineSpan) }, key = "header_recent_vod") {
                                            Column(Modifier.fillMaxWidth().padding(bottom = 12.dp)) {
                                                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(bottom = 6.dp)) {
                                                    Icon(Icons.Default.History, contentDescription = null, tint = GoldLight, modifier = Modifier.size(18.dp))
                                                    Spacer(Modifier.width(6.dp))
                                                    Text(
                                                        text = if (type == "movie") "Películas vistas recientemente" else "Series vistas recientemente",
                                                        fontWeight = FontWeight.Bold,
                                                        style = MaterialTheme.typography.bodyMedium,
                                                        color = GoldLight,
                                                    )
                                                }
                                                LazyRow(
                                                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                                                    contentPadding = PaddingValues(vertical = 4.dp),
                                                ) {
                                                    items(recentItems, key = { "rec_row_${it.id}" }) { item ->
                                                        val badge = item.extra?.takeIf { it.isNotBlank() && it != "0" }?.let { "★ $it" }
                                                        val itemProg = if (type == "movie") {
                                                            resolveMovieProgressFraction(progressMap, item.id)
                                                        } else {
                                                            resolveSeriesProgressFraction(progressMap, item.id)
                                                        }
                                                        PosterCard(
                                                            title = item.name,
                                                            image = item.image,
                                                            subtitle = badge,
                                                            isFavorite = item.id in favs,
                                                            progress = itemProg,
                                                            modifier = Modifier.width(115.dp),
                                                        ) {
                                                            app.store.addRecentlyViewed(type, item.id)
                                                            recentRefresh++
                                                            if (type == "movie") onMovie(item.id) else onSeries(item.id)
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    items(shown, key = { it.id }) { item ->
                                        val badge = item.extra?.takeIf { it.isNotBlank() && it != "0" }?.let { "★ $it" }
                                        val itemProg = if (type == "movie") {
                                            resolveMovieProgressFraction(progressMap, item.id)
                                        } else {
                                            resolveSeriesProgressFraction(progressMap, item.id)
                                        }
                                        PosterCard(
                                            title = item.name,
                                            image = item.image,
                                            subtitle = badge,
                                            isFavorite = item.id in favs,
                                            progress = itemProg,
                                            modifier = Modifier.fillMaxWidth(),
                                        ) {
                                            app.store.addRecentlyViewed(type, item.id)
                                            recentRefresh++
                                            if (type == "movie") onMovie(item.id) else onSeries(item.id)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                if (isCompact) {
                    contentBody(Modifier.fillMaxSize())
                } else {
                    Row(Modifier.fillMaxSize()) {
                        LazyColumn(
                            Modifier
                                .width(230.dp)
                                .fillMaxHeight()
                                .background(DarkSurface)
                                .padding(vertical = 8.dp)
                        ) {
                            items(cats, key = { it.id }) { c ->
                                val sel = c.id == selected
                                val rowShape = RoundedCornerShape(10.dp)
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 8.dp, vertical = 3.dp)
                                        .tvClickable(
                                            shape = rowShape,
                                            idleBorderColor = if (sel) GoldPrimary.copy(alpha = 0.55f) else GoldPrimary.copy(alpha = 0.08f),
                                        ) {
                                            selected = c.id
                                            app.store.setSelectedCategory(type, c.id)
                                        }
                                        .background(
                                            if (sel) BetisGreenDark else DarkSurface,
                                            rowShape,
                                        )
                                        .padding(horizontal = 12.dp, vertical = 10.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                ) {
                                    if (sel) {
                                        Box(
                                            Modifier
                                                .width(4.dp)
                                                .height(18.dp)
                                                .clip(RoundedCornerShape(2.dp))
                                                .background(GoldLight)
                                        )
                                        Spacer(Modifier.width(8.dp))
                                    }
                                    Text(
                                        text = c.name?.ifBlank { "Sin nombre" } ?: "Sin nombre",
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis,
                                        fontWeight = if (sel) FontWeight.Bold else FontWeight.Normal,
                                        color = if (sel) GoldLight else TextPrimaryWhite,
                                        style = MaterialTheme.typography.bodyMedium,
                                    )
                                }
                            }
                        }
                        VerticalDivider(thickness = 1.dp, color = GoldPrimary.copy(alpha = 0.22f))
                        contentBody(Modifier.weight(1f).fillMaxHeight())
                    }
                }
            }
        }
    }
}

/** Lista de canales con vista previa de la guía (EPG corta) con debounce D-Pad y soporte móvil compacto. */
@Composable
private fun LiveList(
    repo: XtreamRepository,
    items: List<CatalogItem>,
    favs: Set<String>,
    listState: LazyListState,
    isCompact: Boolean,
    recentItems: List<CatalogItem> = emptyList(),
    onPlayRecent: (CatalogItem) -> Unit = {},
    onToggleFav: (String) -> Unit,
    onPlay: (CatalogItem) -> Unit,
    modifier: Modifier = Modifier,
) {
    var focusedId by rememberSaveable { mutableStateOf<String?>(null) }
    var debouncedEpgId by remember { mutableStateOf<String?>(null) }
    LaunchedEffect(focusedId) {
        val target = focusedId
        if (target == null) {
            debouncedEpgId = null
        } else {
            // Evita tormenta de peticiones EPG al desplazarse rápido con el mando D-Pad en Fire TV / Android TV
            delay(350L)
            debouncedEpgId = target
        }
    }
    val epg = rememberLoad(debouncedEpgId) { debouncedEpgId?.let { repo.shortEpg(it) }.orEmpty() }

    val channelListContent: @Composable (Modifier) -> Unit = { listMod ->
        LazyColumn(
            state = listState,
            modifier = listMod.padding(horizontal = 10.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp),
        ) {
            if (recentItems.isNotEmpty()) {
                item(key = "header_recent_live") {
                    Column(Modifier.fillMaxWidth().padding(bottom = 8.dp)) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(horizontal = 4.dp, vertical = 6.dp)
                        ) {
                            Icon(Icons.Default.History, contentDescription = null, tint = GoldLight, modifier = Modifier.size(18.dp))
                            Spacer(Modifier.width(6.dp))
                            Text("Vistos recientemente", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.bodyMedium, color = GoldLight)
                        }
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            contentPadding = PaddingValues(horizontal = 4.dp, vertical = 4.dp)
                        ) {
                            items(recentItems, key = { "recent_live_${it.id}" }) { ch ->
                                RecentChannelChip(
                                    item = ch,
                                    onPlay = { onPlayRecent(ch) }
                                )
                            }
                        }
                    }
                }
            }
            items(items, key = { it.id }) { item ->
                val isSelected = focusedId == item.id
                val isFav = item.id in favs
                val rowShape = RoundedCornerShape(10.dp)
                Row(
                    Modifier
                        .fillMaxWidth()
                        .tvClickable(
                            shape = rowShape,
                            idleBorderColor = if (isSelected) GoldPrimary.copy(alpha = 0.65f) else GoldPrimary.copy(alpha = 0.16f),
                            onFocused = { if (!isCompact) focusedId = item.id },
                            onClick = {
                                focusedId = item.id
                                onPlay(item)
                            },
                        )
                        .background(
                            if (isSelected) BetisGreenDark.copy(alpha = 0.70f) else DarkSurface,
                            rowShape,
                        )
                        .padding(horizontal = 12.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    NetworkImage(
                        url = item.image,
                        contentDescription = item.name,
                        fallbackIcon = Icons.Default.Tv,
                        contentScale = ContentScale.Fit,
                        targetWidthPx = 96,
                        targetHeightPx = 96,
                        modifier = Modifier
                            .size(46.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .border(1.dp, GoldPrimary.copy(alpha = 0.25f), RoundedCornerShape(8.dp))
                            .padding(4.dp),
                    )
                    Spacer(Modifier.width(12.dp))
                    Text(
                        text = item.name?.ifBlank { "Canal ${item.id}" } ?: "Canal ${item.id}",
                        modifier = Modifier.weight(1f),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontWeight = FontWeight.SemiBold,
                        color = TextPrimaryWhite,
                    )
                    if (item.extra == "1") {
                        Icon(
                            imageVector = Icons.Default.History,
                            contentDescription = "Archivo TV disponible",
                            tint = GoldLight,
                            modifier = Modifier.size(18.dp).padding(end = 4.dp),
                        )
                    }
                    if (!repo.playlist.isM3u) {
                        TextButton(
                            onClick = { focusedId = if (isCompact && focusedId == item.id) null else item.id },
                            colors = ButtonDefaults.textButtonColors(contentColor = GoldLight),
                            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
                        ) {
                            Text("Guía", fontWeight = FontWeight.SemiBold)
                        }
                    }
                    IconButton(onClick = { onToggleFav(item.id) }) {
                        Icon(
                            imageVector = if (isFav) Icons.Default.Star else Icons.Default.StarBorder,
                            contentDescription = "Favorito",
                            tint = if (isFav) GoldLight else TextSecondaryGray,
                        )
                    }
                }
            }
        }
    }

    val epgPanelContent: @Composable (Modifier, Boolean) -> Unit = { panelMod, showClose ->
        Column(
            panelMod
                .background(DarkSurface)
                .padding(14.dp)
        ) {
            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "Guía de programación (EPG)",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleSmall,
                    color = GoldLight,
                )
                if (showClose) {
                    IconButton(
                        onClick = { focusedId = null },
                        modifier = Modifier.size(28.dp),
                    ) {
                        Icon(Icons.Default.Close, contentDescription = "Cerrar guía", tint = GoldLight, modifier = Modifier.size(18.dp))
                    }
                }
            }
            Spacer(Modifier.height(8.dp))
            if (focusedId == null) {
                Text(
                    text = "Selecciona o pulsa «Guía» en un canal para consultar su emisión actual.",
                    color = TextSecondaryGray,
                    style = MaterialTheme.typography.bodySmall,
                )
            } else {
                LoadContent(epg) { list ->
                    if (list.isEmpty()) {
                        Text(
                            text = "Sin datos de programación disponibles para este canal.",
                            color = TextSecondaryGray,
                            style = MaterialTheme.typography.bodySmall,
                        )
                    } else {
                        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            items(list) { e ->
                                Column(
                                    Modifier
                                        .fillMaxWidth()
                                        .background(DarkSurfaceVariant, RoundedCornerShape(8.dp))
                                        .border(1.dp, GoldPrimary.copy(alpha = 0.22f), RoundedCornerShape(8.dp))
                                        .padding(10.dp)
                                ) {
                                    Text(
                                        text = "${e.start?.takeLast(8)?.take(5).orEmpty()}  ${XtreamRepository.decodeB64(e.title)}",
                                        fontWeight = FontWeight.Bold,
                                        style = MaterialTheme.typography.bodySmall,
                                        color = GoldLight,
                                    )
                                    val desc = XtreamRepository.decodeB64(e.description)
                                    if (desc.isNotBlank()) {
                                        Spacer(Modifier.height(4.dp))
                                        Text(
                                            text = desc,
                                            maxLines = 3,
                                            overflow = TextOverflow.Ellipsis,
                                            style = MaterialTheme.typography.labelSmall,
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

    if (isCompact) {
        Column(modifier) {
            channelListContent(Modifier.weight(1f).fillMaxWidth())
            if (focusedId != null && !repo.playlist.isM3u) {
                HorizontalDivider(thickness = 1.dp, color = GoldPrimary.copy(alpha = 0.35f))
                epgPanelContent(Modifier.fillMaxWidth().heightIn(min = 140.dp, max = 230.dp), true)
            }
        }
    } else {
        Row(modifier) {
            channelListContent(Modifier.weight(1f).fillMaxHeight())
            VerticalDivider(thickness = 1.dp, color = GoldPrimary.copy(alpha = 0.22f))
            epgPanelContent(Modifier.width(310.dp).fillMaxHeight(), false)
        }
    }
}
