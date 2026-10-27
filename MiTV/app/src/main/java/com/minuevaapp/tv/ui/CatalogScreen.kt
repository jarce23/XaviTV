package com.minuevaapp.tv.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.History
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.minuevaapp.tv.MiTVApp
import com.minuevaapp.tv.data.Category
import com.minuevaapp.tv.data.XtreamRepository
import com.minuevaapp.tv.player.PlayerActivity
import com.minuevaapp.tv.ui.theme.*

private const val ALL = "__all"
private const val FAV = "__fav"

/** Elemento genérico para la parrilla de cualquier tipo de contenido. */
private data class CatalogItem(
    val id: String,
    val name: String?,
    val image: String?,
    val categoryId: String?,
    val extra: String?,
)

/**
 * Pantalla de catálogo: categorías a la izquierda y contenido con buscador rápido en tiempo real a la derecha.
 * Sustituye a LiveActivity, MovieActivity, SeriesActivity y CategoryActivity.
 */
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

    val state = rememberLoad(type, repo) {
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
    var selected by rememberSaveable(type) { mutableStateOf(ALL) }
    var searchQuery by rememberSaveable(type) { mutableStateOf("") }
    var favs by remember(type) { mutableStateOf(app.store.favorites(type)) }
    val ctx = LocalContext.current

    AppScaffold(title, onBack) { pad ->
        LoadContent(state) { (categories, items) ->
            val cats = remember(categories) {
                listOf(Category(ALL, "Todas"), Category(FAV, "★ Favoritos")) + categories
            }
            val shown = remember(selected, items, favs, searchQuery) {
                val q = searchQuery.trim()
                val baseList = when {
                    selected == FAV -> items.filter { it.id in favs }
                    // Si el usuario escribe en el buscador rápido, busca en toda la sección sin obligar a cambiar de categoría
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
            Row(Modifier.padding(pad).fillMaxSize()) {
                // Panel lateral de categorías con acentos en verde oscuro y dorado
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
                                ) { selected = c.id }
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

                // Panel derecho: Barra de búsqueda rápida en la parte superior + contenido filtrado en tiempo real
                Column(Modifier.weight(1f).fillMaxHeight()) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(DarkSurface.copy(alpha = 0.65f))
                            .padding(horizontal = 14.dp, vertical = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
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
                    HorizontalDivider(thickness = 1.dp, color = GoldPrimary.copy(alpha = 0.18f))

                    if (shown.isEmpty()) {
                        Box(Modifier.weight(1f).fillMaxWidth(), contentAlignment = Alignment.Center) {
                            Text(
                                text = if (searchQuery.isNotBlank()) {
                                    "No se encontraron resultados para «$searchQuery» en $title."
                                } else {
                                    "No hay elementos en esta categoría."
                                },
                                color = TextSecondaryGray,
                            )
                        }
                    } else if (type == "live") {
                        LiveList(
                            repo = repo,
                            items = shown,
                            favs = favs,
                            onToggleFav = { id ->
                                app.store.toggleFavorite(type, id)
                                favs = app.store.favorites(type)
                            },
                            onPlay = { item ->
                                PlayerActivity.start(ctx, repo.liveUrl(item.id), item.name, live = true)
                            },
                            modifier = Modifier.weight(1f).fillMaxWidth(),
                        )
                    } else {
                        LazyVerticalGrid(
                            columns = GridCells.Adaptive(140.dp),
                            modifier = Modifier.weight(1f).fillMaxWidth().padding(14.dp),
                            horizontalArrangement = Arrangement.spacedBy(14.dp),
                            verticalArrangement = Arrangement.spacedBy(14.dp),
                        ) {
                            items(shown, key = { it.id }) { item ->
                                val badge = item.extra?.takeIf { it.isNotBlank() && it != "0" }?.let { "★ $it" }
                                PosterCard(
                                    title = item.name,
                                    image = item.image,
                                    subtitle = badge,
                                    isFavorite = item.id in favs,
                                ) {
                                    if (type == "movie") onMovie(item.id) else onSeries(item.id)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

/** Lista de canales con vista previa de la guía (EPG corta), como LiveChannelActivity. */
@Composable
private fun LiveList(
    repo: XtreamRepository,
    items: List<CatalogItem>,
    favs: Set<String>,
    onToggleFav: (String) -> Unit,
    onPlay: (CatalogItem) -> Unit,
    modifier: Modifier = Modifier,
) {
    var focusedId by rememberSaveable { mutableStateOf<String?>(null) }
    val epg = rememberLoad(focusedId) { focusedId?.let { repo.shortEpg(it) }.orEmpty() }

    Row(modifier) {
        LazyColumn(
            modifier = Modifier.weight(1f).fillMaxHeight().padding(horizontal = 10.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp),
        ) {
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
                            onFocused = { focusedId = item.id },
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
                        modifier = Modifier
                            .size(48.dp)
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
                    TextButton(
                        onClick = { focusedId = item.id },
                        colors = ButtonDefaults.textButtonColors(contentColor = GoldLight),
                    ) {
                        Text("Guía", fontWeight = FontWeight.SemiBold)
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
        VerticalDivider(thickness = 1.dp, color = GoldPrimary.copy(alpha = 0.22f))
        Column(
            Modifier
                .width(310.dp)
                .fillMaxHeight()
                .background(DarkSurface)
                .padding(14.dp)
        ) {
            Text(
                text = "Guía de programación (EPG)",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleSmall,
                color = GoldLight,
            )
            Spacer(Modifier.height(10.dp))
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
}
