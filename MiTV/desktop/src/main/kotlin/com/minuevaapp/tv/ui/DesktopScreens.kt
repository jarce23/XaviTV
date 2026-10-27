package com.minuevaapp.tv.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.minuevaapp.tv.data.*
import com.minuevaapp.tv.ui.theme.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.awt.Cursor
import java.text.SimpleDateFormat
import java.util.*

// ─── 1. LOGIN & PLAYLIST MANAGER SCREEN ──────────────────────────────
@Composable
fun PlaylistsScreen(onConnected: () -> Unit) {
    val appState = LocalAppState.current
    val store = remember { appState.store }
    val storeVersion = store.stateVersion
    var saved by remember(storeVersion) { mutableStateOf(store.all()) }
    var activeName by remember(storeVersion) { mutableStateOf(store.activeName) }

    var editingOriginal by remember { mutableStateOf<Playlist?>(null) }
    var selectedType by remember { mutableStateOf(Playlist.TYPE_XTREAM) }

    var name by remember { mutableStateOf("") }
    var host by remember { mutableStateOf("") }
    var user by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }
    var m3uUrl by remember { mutableStateOf("") }

    var showPassword by remember { mutableStateOf(false) }
    var loading by remember { mutableStateOf(false) }
    var error by remember { mutableStateOf<String?>(null) }
    val scope = rememberCoroutineScope()

    fun resetFormFields() {
        editingOriginal = null
        name = ""
        host = ""
        user = ""
        pass = ""
        m3uUrl = ""
        showPassword = false
        error = null
    }

    fun loadPlaylistIntoForm(pl: Playlist) {
        editingOriginal = pl
        error = null
        if (pl.isM3u) {
            selectedType = Playlist.TYPE_M3U
            name = pl.name
            m3uUrl = pl.effectiveM3uUrl
            host = ""
            user = ""
            pass = ""
        } else {
            selectedType = Playlist.TYPE_XTREAM
            name = pl.name
            host = pl.serverUrl
            user = pl.username
            pass = pl.password
            m3uUrl = ""
        }
    }

    fun connectAndSave(p: Playlist, originalToUpdate: Playlist? = null, clearFormOnSuccess: Boolean = false) {
        loading = true
        error = null
        scope.launch {
            runCatching {
                val testRepo = appState.createRepo(p)
                testRepo.login()
            }.onSuccess { resp ->
                val authOk = p.isM3u ||
                    resp.userInfo?.auth == "1" ||
                    resp.userInfo?.status.equals("Active", ignoreCase = true)
                if (!authOk) {
                    error = "Cuenta no activa (${resp.userInfo?.status ?: "Sin autorización"})"
                    loading = false
                } else {
                    if (originalToUpdate != null) {
                        store.update(originalToUpdate, p)
                    } else {
                        store.add(p)
                    }
                    store.activeName = p.name
                    appState.invalidateRepo()
                    saved = store.all()
                    activeName = store.activeName
                    if (clearFormOnSuccess) {
                        resetFormFields()
                    }
                    loading = false
                    onConnected()
                }
            }.onFailure { e ->
                error = XtreamRepository.sanitizeError(e, p)
                loading = false
            }
        }
    }

    Box(
        Modifier
            .fillMaxSize()
            .background(
                Brush.radialGradient(
                    colors = listOf(
                        BetisGreenPrimary.copy(alpha = 0.55f),
                        BetisGreenDark.copy(alpha = 0.35f),
                        BgDeepCharcoal
                    ),
                    radius = 1200f
                )
            )
    ) {
        Row(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 36.dp, vertical = 28.dp),
            horizontalArrangement = Arrangement.spacedBy(28.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Panel izquierdo: Identidad visual + Listas guardadas
            Column(
                Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column(Modifier.weight(1f)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            Modifier
                                .size(56.dp)
                                .clip(RoundedCornerShape(16.dp))
                                .background(
                                    Brush.linearGradient(
                                        listOf(BetisGreenPrimary, BetisGreenLeaf)
                                    )
                                )
                                .border(2.dp, GoldAccent, RoundedCornerShape(16.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource("app_logo.png"),
                                contentDescription = "XaviTV Logo",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                        Spacer(Modifier.width(16.dp))
                        Column {
                            Text(
                                text = "XaviTV",
                                style = MaterialTheme.typography.headlineLarge,
                                fontWeight = FontWeight.ExtraBold,
                                color = TextPureWhite
                            )
                            Text(
                                text = "EDICIÓN WINDOWS DESKTOP · XTREAM & M3U",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                letterSpacing = 1.6.sp,
                                color = GoldAccent
                            )
                        }
                    }

                    Spacer(Modifier.height(22.dp))

                    Text(
                        text = "Listas guardadas",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = GoldChampagne
                    )
                    Spacer(Modifier.height(10.dp))

                    if (saved.isEmpty()) {
                        Box(
                            Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(16.dp))
                                .background(BgCardSurface.copy(alpha = 0.85f))
                                .border(1.dp, BetisGreenLeaf.copy(alpha = 0.4f), RoundedCornerShape(16.dp))
                                .padding(20.dp)
                        ) {
                            Column {
                                Text(
                                    "Aún no hay listas registradas",
                                    fontWeight = FontWeight.SemiBold,
                                    color = TextPureWhite
                                )
                                Spacer(Modifier.height(4.dp))
                                Text(
                                    "Introduce tus datos de Xtream Codes o añade una URL M3U en el panel derecho para comenzar.",
                                    fontSize = 13.sp,
                                    color = TextSilverGray
                                )
                            }
                        }
                    } else {
                        LazyColumn(
                            verticalArrangement = Arrangement.spacedBy(10.dp),
                            modifier = Modifier.fillMaxWidth().weight(1f)
                        ) {
                            items(saved, key = { "${it.playlistType}:${it.name}" }) { pl ->
                                val isCurrent = activeName == pl.name
                                val isBeingEdited = editingOriginal?.name == pl.name &&
                                    editingOriginal?.playlistType == pl.playlistType
                                Row(
                                    Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(14.dp))
                                        .background(
                                            when {
                                                isBeingEdited -> BetisGreenLeaf.copy(alpha = 0.42f)
                                                isCurrent -> BetisGreenPrimary.copy(alpha = 0.55f)
                                                else -> BgCardSurface
                                            }
                                        )
                                        .tvClickable(
                                            shape = RoundedCornerShape(14.dp),
                                            idleBorderColor = if (isCurrent || isBeingEdited) GoldAccent else BetisGreenLeaf.copy(alpha = 0.35f)
                                        ) {
                                            store.activeName = pl.name
                                            appState.invalidateRepo()
                                            activeName = pl.name
                                            onConnected()
                                        }
                                        .padding(14.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Box(
                                        Modifier
                                            .size(40.dp)
                                            .clip(CircleShape)
                                            .background(if (isCurrent) GoldAccent else BetisGreenPrimary),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Icon(
                                            if (pl.isM3u) Icons.Default.PlaylistPlay else Icons.Default.Tv,
                                            contentDescription = null,
                                            tint = if (isCurrent) BgDeepCharcoal else GoldChampagne,
                                            modifier = Modifier.size(20.dp)
                                        )
                                    }
                                    Spacer(Modifier.width(12.dp))
                                    Column(Modifier.weight(1f)) {
                                        Row(verticalAlignment = Alignment.CenterVertically) {
                                            Text(
                                                pl.name,
                                                fontWeight = FontWeight.Bold,
                                                color = TextPureWhite,
                                                maxLines = 1,
                                                overflow = TextOverflow.Ellipsis
                                            )
                                            Spacer(Modifier.width(8.dp))
                                            Box(
                                                Modifier
                                                    .clip(RoundedCornerShape(6.dp))
                                                    .background(BetisGreenDark)
                                                    .border(1.dp, GoldAccent.copy(alpha = 0.6f), RoundedCornerShape(6.dp))
                                                    .padding(horizontal = 6.dp, vertical = 1.dp)
                                            ) {
                                                Text(
                                                    if (pl.isM3u) "M3U" else "XTREAM",
                                                    fontSize = 9.sp,
                                                    fontWeight = FontWeight.Bold,
                                                    color = GoldChampagne
                                                )
                                            }
                                        }
                                        val subText = if (pl.isM3u) {
                                            pl.effectiveM3uUrl
                                        } else {
                                            "${pl.username} · ${pl.serverUrl}"
                                        }
                                        Text(
                                            subText,
                                            fontSize = 12.sp,
                                            color = if (isCurrent) GoldChampagne else TextSilverGray,
                                            maxLines = 1,
                                            overflow = TextOverflow.Ellipsis
                                        )
                                    }
                                    IconButton(
                                        onClick = { loadPlaylistIntoForm(pl) },
                                        modifier = Modifier.pointerHoverIcon(PointerIcon(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)))
                                    ) {
                                        Icon(
                                            Icons.Default.Edit,
                                            contentDescription = "Editar lista",
                                            tint = if (isBeingEdited) GoldAccent else GoldChampagne
                                        )
                                    }
                                    IconButton(
                                        onClick = {
                                            if (editingOriginal?.name == pl.name) {
                                                resetFormFields()
                                            }
                                            store.remove(pl)
                                            appState.invalidateRepo()
                                            saved = store.all()
                                            activeName = store.activeName
                                        },
                                        modifier = Modifier.pointerHoverIcon(PointerIcon(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)))
                                    ) {
                                        Icon(
                                            Icons.Default.Delete,
                                            contentDescription = "Eliminar lista",
                                            tint = TextSilverGray
                                        )
                                    }
                                }
                            }
                        }
                    }
                }

                Spacer(Modifier.height(10.dp))
                Text(
                    text = "Soporte nativo Windows Desktop · HLS (.m3u8) · MPEG-TS · Reproductor HW/SW integrado",
                    fontSize = 11.sp,
                    color = TextMutedGreenGray
                )
            }

            // Panel derecho: Formulario de nueva lista o edición (Xtream Codes | Lista M3U)
            Surface(
                modifier = Modifier
                    .weight(1.1f)
                    .fillMaxHeight(),
                shape = RoundedCornerShape(20.dp),
                color = BgCardSurface.copy(alpha = 0.95f),
                tonalElevation = 8.dp,
                shadowElevation = 12.dp,
                border = BorderStroke(1.5.dp, GoldAccent.copy(alpha = 0.65f))
            ) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(horizontal = 26.dp, vertical = 22.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Row(
                        Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(Modifier.weight(1f)) {
                            Text(
                                text = if (editingOriginal != null) "Editar lista guardada" else "Añadir lista a XaviTV",
                                style = MaterialTheme.typography.headlineSmall,
                                fontWeight = FontWeight.Bold,
                                color = TextPureWhite
                            )
                            Spacer(Modifier.height(2.dp))
                            Text(
                                text = if (editingOriginal != null)
                                    "Modifica los campos que necesites y pulsa Actualizar"
                                else
                                    "Elige entre servidor Xtream Codes o enlace directo de lista M3U",
                                fontSize = 13.sp,
                                color = GoldChampagne
                            )
                        }
                        if (editingOriginal != null) {
                            TextButton(
                                onClick = { resetFormFields() },
                                colors = ButtonDefaults.textButtonColors(contentColor = GoldChampagne)
                            ) {
                                Icon(
                                    Icons.Default.Close,
                                    contentDescription = "Cancelar edición",
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(Modifier.width(4.dp))
                                Text("Cancelar", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                            }
                        }
                    }

                    Spacer(Modifier.height(14.dp))

                    // Selector de pestañas Xtream Codes / Lista M3U
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .background(BgDeepCharcoal)
                            .border(1.dp, BetisGreenLeaf.copy(alpha = 0.5f), RoundedCornerShape(12.dp))
                            .padding(4.dp),
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        val isXtream = selectedType == Playlist.TYPE_XTREAM
                        Box(
                            Modifier
                                .weight(1f)
                                .clip(RoundedCornerShape(9.dp))
                                .background(if (isXtream) GoldAccent else Color.Transparent)
                                .tvClickable(RoundedCornerShape(9.dp)) {
                                    selectedType = Playlist.TYPE_XTREAM
                                    error = null
                                }
                                .padding(vertical = 10.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    Icons.Default.Dns,
                                    contentDescription = null,
                                    tint = if (isXtream) BgDeepCharcoal else GoldChampagne,
                                    modifier = Modifier.size(16.dp)
                                )
                                Spacer(Modifier.width(6.dp))
                                Text(
                                    "Xtream Codes",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,
                                    color = if (isXtream) BgDeepCharcoal else TextPureWhite
                                )
                            }
                        }

                        val isM3u = selectedType == Playlist.TYPE_M3U
                        Box(
                            Modifier
                                .weight(1f)
                                .clip(RoundedCornerShape(9.dp))
                                .background(if (isM3u) GoldAccent else Color.Transparent)
                                .tvClickable(RoundedCornerShape(9.dp)) {
                                    selectedType = Playlist.TYPE_M3U
                                    error = null
                                }
                                .padding(vertical = 10.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    Icons.Default.PlaylistPlay,
                                    contentDescription = null,
                                    tint = if (isM3u) BgDeepCharcoal else GoldChampagne,
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(Modifier.width(6.dp))
                                Text(
                                    "Lista M3U",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 13.sp,
                                    color = if (isM3u) BgDeepCharcoal else TextPureWhite
                                )
                            }
                        }
                    }

                    Spacer(Modifier.height(14.dp))

                    GoldOutlinedTextField(
                        value = name,
                        onValueChange = { name = it },
                        label = "Nombre de la lista (ej. Salón Principal)",
                        leadingIcon = { Icon(Icons.Default.Label, contentDescription = null) },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(Modifier.height(10.dp))

                    if (selectedType == Playlist.TYPE_XTREAM) {
                        GoldOutlinedTextField(
                            value = host,
                            onValueChange = { host = it },
                            label = "URL del servidor (http://servidor:puerto)",
                            leadingIcon = { Icon(Icons.Default.Language, contentDescription = null) },
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(Modifier.height(10.dp))

                        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                            GoldOutlinedTextField(
                                value = user,
                                onValueChange = { user = it },
                                label = "Usuario",
                                leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
                                modifier = Modifier.weight(1f)
                            )
                            GoldOutlinedTextField(
                                value = pass,
                                onValueChange = { pass = it },
                                label = "Contraseña",
                                leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
                                trailingIcon = {
                                    IconButton(onClick = { showPassword = !showPassword }) {
                                        Icon(
                                            if (showPassword) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                                            contentDescription = "Mostrar contraseña"
                                        )
                                    }
                                },
                                visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                                modifier = Modifier.weight(1f)
                            )
                        }
                    } else {
                        GoldOutlinedTextField(
                            value = m3uUrl,
                            onValueChange = { m3uUrl = it },
                            label = "URL de la lista (.m3u o .m3u8)",
                            leadingIcon = { Icon(Icons.Default.Link, contentDescription = null) },
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(Modifier.height(8.dp))
                        Text(
                            "Analiza automáticamente las etiquetas #EXTINF, clasificando canales en directo, películas y series por grupos.",
                            fontSize = 12.sp,
                            color = TextSilverGray
                        )
                    }

                    error?.let {
                        Spacer(Modifier.height(12.dp))
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .background(ErrorCrimson.copy(alpha = 0.16f))
                                .border(1.dp, ErrorCrimson, RoundedCornerShape(10.dp))
                                .padding(horizontal = 12.dp, vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                Icons.Default.ErrorOutline,
                                contentDescription = null,
                                tint = ErrorCrimson,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(Modifier.width(8.dp))
                            Text(it, color = TextPureWhite, fontSize = 12.sp)
                        }
                    }

                    Spacer(Modifier.height(18.dp))

                    val isFormValid = if (selectedType == Playlist.TYPE_XTREAM) {
                        host.isNotBlank() && user.isNotBlank() && pass.isNotBlank()
                    } else {
                        m3uUrl.isNotBlank()
                    }

                    Button(
                        onClick = {
                            val newPlaylist = if (selectedType == Playlist.TYPE_XTREAM) {
                                val normalizedHost = host.trim().let {
                                    if (!it.startsWith("http://", true) && !it.startsWith("https://", true)) "http://$it" else it
                                }.trimEnd('/')
                                Playlist(
                                    name = name.trim().ifBlank { "Servidor Xtream" },
                                    serverUrl = normalizedHost,
                                    username = user.trim(),
                                    password = pass.trim(),
                                    type = Playlist.TYPE_XTREAM,
                                    m3uUrl = ""
                                )
                            } else {
                                val cleanUrl = m3uUrl.trim()
                                Playlist(
                                    name = name.trim().ifBlank { "Lista M3U" },
                                    serverUrl = cleanUrl,
                                    username = "",
                                    password = "",
                                    type = Playlist.TYPE_M3U,
                                    m3uUrl = cleanUrl
                                )
                            }
                            connectAndSave(
                                p = newPlaylist,
                                originalToUpdate = editingOriginal,
                                clearFormOnSuccess = true
                            )
                        },
                        enabled = !loading && isFormValid,
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = GoldAccent,
                            contentColor = BgDeepCharcoal,
                            disabledContainerColor = BetisGreenPrimary.copy(alpha = 0.4f),
                            disabledContentColor = TextSilverGray
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .pointerHoverIcon(PointerIcon(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)))
                    ) {
                        if (loading) {
                            CircularProgressIndicator(
                                Modifier.size(22.dp),
                                strokeWidth = 2.5.dp,
                                color = BgDeepCharcoal
                            )
                            Spacer(Modifier.width(10.dp))
                            Text("Verificando lista...", fontWeight = FontWeight.Bold)
                        } else {
                            Icon(
                                if (editingOriginal != null) Icons.Default.Save else Icons.Default.PlayArrow,
                                contentDescription = null
                            )
                            Spacer(Modifier.width(8.dp))
                            Text(
                                text = when {
                                    editingOriginal != null -> "Actualizar y guardar cambios"
                                    selectedType == Playlist.TYPE_M3U -> "Cargar y guardar lista M3U"
                                    else -> "Conectar y guardar servidor"
                                },
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 15.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

// ─── 2. HOME DASHBOARD SCREEN ────────────────────────────────────────
@Composable
fun HomeScreen(
    onOpenLive: () -> Unit,
    onOpenMovies: () -> Unit,
    onOpenSeries: () -> Unit,
    onOpenFavorites: () -> Unit,
    onOpenSearch: () -> Unit,
    onOpenPlaylists: () -> Unit
) {
    val appState = LocalAppState.current
    val active = remember(appState.store.stateVersion) { appState.store.active() }
    var clock by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        val fmt = SimpleDateFormat("HH:mm · EEE d MMM", Locale("es", "ES"))
        while (true) {
            clock = fmt.format(Date())
            delay(15_000)
        }
    }

    val subtitleText = if (active.isM3u) {
        "${active.name} · Lista M3U"
    } else {
        "${active.name} · ${active.username}"
    }

    AppScaffold(
        title = "XaviTV",
        subtitle = subtitleText,
        actions = {
            Text(
                clock,
                color = GoldChampagne,
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(end = 8.dp)
            )
            OutlinedButton(
                onClick = onOpenSearch,
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(1.dp, GoldAccent),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = GoldChampagne),
                modifier = Modifier.pointerHoverIcon(PointerIcon(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)))
            ) {
                Icon(Icons.Default.Search, contentDescription = null, modifier = Modifier.size(18.dp))
                Spacer(Modifier.width(6.dp))
                Text("Buscar")
            }
            Spacer(Modifier.width(8.dp))
            OutlinedButton(
                onClick = onOpenPlaylists,
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(1.dp, BetisGreenLeaf),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = TextPureWhite),
                modifier = Modifier.pointerHoverIcon(PointerIcon(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)))
            ) {
                Icon(Icons.Default.SwitchAccount, contentDescription = null, modifier = Modifier.size(18.dp))
                Spacer(Modifier.width(6.dp))
                Text("Listas")
            }
            Spacer(Modifier.width(8.dp))
        }
    ) { pad ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(pad)
                .padding(horizontal = 32.dp, vertical = 24.dp),
            verticalArrangement = Arrangement.spacedBy(22.dp)
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .weight(1.35f),
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                HomeBigTile(
                    title = "TV en directo",
                    subtitle = "Canales en vivo, TDT y guía EPG",
                    badge = "LIVE TV",
                    icon = Icons.Default.LiveTv,
                    gradient = listOf(BetisGreenDark, BetisGreenPrimary, BetisGreenLeaf),
                    onClick = onOpenLive,
                    modifier = Modifier.weight(1f).fillMaxHeight()
                )
                HomeBigTile(
                    title = "Películas",
                    subtitle = "Catálogo VOD bajo demanda en alta definición",
                    badge = "CINE & VOD",
                    icon = Icons.Default.Movie,
                    gradient = listOf(BetisGreenDark, Color(0xFF15452D), BetisGreenPrimary),
                    onClick = onOpenMovies,
                    modifier = Modifier.weight(1f).fillMaxHeight()
                )
                HomeBigTile(
                    title = "Series",
                    subtitle = "Temporadas completas organizadas por episodios",
                    badge = "SERIES",
                    icon = Icons.Default.VideoLibrary,
                    gradient = listOf(Color(0xFF0C3320), BetisGreenPrimary, Color(0xFF1F6642)),
                    onClick = onOpenSeries,
                    modifier = Modifier.weight(1f).fillMaxHeight()
                )
            }

            Row(
                Modifier
                    .fillMaxWidth()
                    .height(82.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                HomeActionPill(
                    title = "Mis Favoritos",
                    subtitle = "Canales, películas y series destacadas con estrella dorada",
                    icon = Icons.Default.Star,
                    onClick = onOpenFavorites,
                    modifier = Modifier.weight(1f).fillMaxHeight()
                )
                HomeActionPill(
                    title = "Búsqueda Global",
                    subtitle = "Encuentra cualquier canal, película o serie al instante",
                    icon = Icons.Default.Search,
                    onClick = onOpenSearch,
                    modifier = Modifier.weight(1f).fillMaxHeight()
                )
                HomeActionPill(
                    title = "Gestionar Listas",
                    subtitle = "Cambiar entre servidores Xtream Codes o listas M3U",
                    icon = Icons.Default.PlaylistPlay,
                    onClick = onOpenPlaylists,
                    modifier = Modifier.weight(1f).fillMaxHeight()
                )
            }
        }
    }
}

@Composable
private fun HomeBigTile(
    title: String,
    subtitle: String,
    badge: String,
    icon: ImageVector,
    gradient: List<Color>,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val shape = RoundedCornerShape(22.dp)
    Box(
        modifier
            .clip(shape)
            .background(Brush.linearGradient(gradient))
            .tvClickable(shape = shape, onClick = onClick)
            .padding(26.dp)
    ) {
        Box(
            Modifier
                .align(Alignment.TopEnd)
                .clip(RoundedCornerShape(8.dp))
                .background(BgDeepCharcoal.copy(alpha = 0.65f))
                .border(1.dp, GoldAccent, RoundedCornerShape(8.dp))
                .padding(horizontal = 10.dp, vertical = 4.dp)
        ) {
            Text(
                text = badge,
                fontSize = 10.sp,
                fontWeight = FontWeight.ExtraBold,
                letterSpacing = 1.2.sp,
                color = GoldChampagne
            )
        }

        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(18.dp))
                    .background(GoldAccent.copy(alpha = 0.18f))
                    .border(1.5.dp, GoldAccent, RoundedCornerShape(18.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    icon,
                    contentDescription = title,
                    tint = GoldChampagne,
                    modifier = Modifier.size(36.dp)
                )
            }
            Column {
                Text(
                    title,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = TextPureWhite
                )
                Spacer(Modifier.height(6.dp))
                Text(
                    subtitle,
                    fontSize = 13.sp,
                    color = TextSilverGray,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
private fun HomeActionPill(
    title: String,
    subtitle: String,
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val shape = RoundedCornerShape(16.dp)
    Row(
        modifier
            .clip(shape)
            .background(BgCardSurface)
            .tvClickable(shape = shape, onClick = onClick)
            .padding(horizontal = 20.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            Modifier
                .size(46.dp)
                .clip(CircleShape)
                .background(BetisGreenPrimary)
                .border(1.dp, GoldAccent, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(icon, contentDescription = title, tint = GoldAccent, modifier = Modifier.size(22.dp))
        }
        Spacer(Modifier.width(14.dp))
        Column(Modifier.weight(1f)) {
            Text(
                title,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = TextPureWhite,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                subtitle,
                fontSize = 12.sp,
                color = TextSilverGray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

// ─── 3. CATALOG SCREEN (LIVE / MOVIES / SERIES / FAVORITES) ──────────
enum class CatalogKind { LIVE, MOVIES, SERIES, FAVORITES }

@Composable
fun CatalogScreen(
    kind: CatalogKind,
    onBack: () -> Unit,
    onPlayStream: (url: String, title: String, subtitle: String, type: String, resumeKey: String) -> Unit,
    onOpenMovie: (VodStream) -> Unit,
    onOpenSeries: (Series) -> Unit
) {
    val appState = LocalAppState.current
    val repo = remember(appState.store.stateVersion) { appState.repo() }
    val store = remember { appState.store }

    var categories by remember { mutableStateOf<List<Category>>(emptyList()) }
    var selectedCategory by remember { mutableStateOf("ALL") }
    var searchQuery by remember { mutableStateOf("") }
    var loading by remember { mutableStateOf(true) }
    var error by remember { mutableStateOf<String?>(null) }
    var reloadTrigger by remember { mutableIntStateOf(0) }

    var liveItems by remember { mutableStateOf<List<LiveStream>>(emptyList()) }
    var movieItems by remember { mutableStateOf<List<VodStream>>(emptyList()) }
    var seriesItems by remember { mutableStateOf<List<Series>>(emptyList()) }

    var selectedLive by remember { mutableStateOf<LiveStream?>(null) }
    var epgList by remember { mutableStateOf<List<EpgListing>>(emptyList()) }
    var favRefresh by remember { mutableIntStateOf(0) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(kind, reloadTrigger) {
        loading = true
        error = null
        val allCat = Category("ALL", "Todos")
        runCatching {
            when (kind) {
                CatalogKind.LIVE -> {
                    val (cats, items) = repo.live(forceRefresh = reloadTrigger > 0)
                    categories = listOf(allCat) + cats
                    liveItems = items
                }
                CatalogKind.MOVIES -> {
                    val (cats, items) = repo.vod(forceRefresh = reloadTrigger > 0)
                    categories = listOf(allCat) + cats
                    movieItems = items
                }
                CatalogKind.SERIES -> {
                    val (cats, items) = repo.series(forceRefresh = reloadTrigger > 0)
                    categories = listOf(allCat) + cats
                    seriesItems = items
                }
                CatalogKind.FAVORITES -> {
                    val (_, l) = runCatching { repo.live() }.getOrDefault(emptyList<Category>() to emptyList())
                    val (_, v) = runCatching { repo.vod() }.getOrDefault(emptyList<Category>() to emptyList())
                    val (_, s) = runCatching { repo.series() }.getOrDefault(emptyList<Category>() to emptyList())
                    liveItems = l
                    movieItems = v
                    seriesItems = s
                }
            }
        }.onFailure { e ->
            error = XtreamRepository.sanitizeError(e, repo.playlist)
        }
        loading = false
    }

    val filteredLiveItems = remember(liveItems, selectedCategory, searchQuery) {
        val byCat = if (selectedCategory == "ALL") liveItems else liveItems.filter { it.categoryId == selectedCategory }
        val q = searchQuery.trim()
        if (q.isEmpty()) byCat else byCat.filter { it.name?.contains(q, ignoreCase = true) == true }
    }

    val filteredMovieItems = remember(movieItems, selectedCategory, searchQuery) {
        val byCat = if (selectedCategory == "ALL") movieItems else movieItems.filter { it.categoryId == selectedCategory }
        val q = searchQuery.trim()
        if (q.isEmpty()) byCat else byCat.filter { it.name?.contains(q, ignoreCase = true) == true }
    }

    val filteredSeriesItems = remember(seriesItems, selectedCategory, searchQuery) {
        val byCat = if (selectedCategory == "ALL") seriesItems else seriesItems.filter { it.categoryId == selectedCategory }
        val q = searchQuery.trim()
        if (q.isEmpty()) byCat else byCat.filter { it.name?.contains(q, ignoreCase = true) == true }
    }

    val title = when (kind) {
        CatalogKind.LIVE -> "TV en directo"
        CatalogKind.MOVIES -> "Películas"
        CatalogKind.SERIES -> "Series"
        CatalogKind.FAVORITES -> "Mis Favoritos"
    }

    val searchPlaceholder = when (kind) {
        CatalogKind.LIVE -> "Buscar canal en TV en directo..."
        CatalogKind.MOVIES -> "Buscar película por título..."
        CatalogKind.SERIES -> "Buscar serie por título..."
        CatalogKind.FAVORITES -> "Filtrar en mis favoritos..."
    }

    AppScaffold(
        title = title,
        subtitle = categories.firstOrNull { it.id == selectedCategory }?.name,
        onBack = onBack
    ) { pad ->
        Column(Modifier.fillMaxSize().padding(pad)) {
            // Barra de búsqueda rápida en tiempo real
            Box(
                Modifier
                    .fillMaxWidth()
                    .background(BgCardSurface.copy(alpha = 0.7f))
                    .padding(horizontal = 20.dp, vertical = 10.dp)
            ) {
                GoldOutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    label = searchPlaceholder,
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                    trailingIcon = {
                        if (searchQuery.isNotEmpty()) {
                            IconButton(onClick = { searchQuery = "" }) {
                                Icon(
                                    Icons.Default.Clear,
                                    contentDescription = "Limpiar búsqueda",
                                    tint = GoldChampagne
                                )
                            }
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Row(Modifier.fillMaxSize()) {
                // Barra lateral de categorías
                if (kind != CatalogKind.FAVORITES) {
                    LazyColumn(
                        Modifier
                            .width(240.dp)
                            .fillMaxHeight()
                            .background(BgCardSurface.copy(alpha = 0.85f))
                            .border(BorderStroke(1.dp, BetisGreenLeaf.copy(alpha = 0.25f)))
                            .padding(10.dp),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        items(categories, key = { it.id }) { cat ->
                            val selected = cat.id == selectedCategory
                            Row(
                                Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(
                                        if (selected) BetisGreenPrimary else Color.Transparent
                                    )
                                    .tvClickable(RoundedCornerShape(10.dp)) {
                                        selectedCategory = cat.id
                                    }
                                    .padding(horizontal = 12.dp, vertical = 10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                if (selected) {
                                    Box(
                                        Modifier
                                            .width(4.dp)
                                            .height(18.dp)
                                            .clip(RoundedCornerShape(2.dp))
                                            .background(GoldAccent)
                                    )
                                    Spacer(Modifier.width(8.dp))
                                }
                                Text(
                                    text = cat.name ?: "Sin nombre",
                                    color = if (selected) GoldChampagne else TextPureWhite,
                                    fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                    fontSize = 13.sp
                                )
                            }
                        }
                    }
                }

                // Contenido principal
                Box(Modifier.weight(1f).fillMaxHeight()) {
                    when {
                        loading -> CircularProgressIndicator(
                            Modifier.align(Alignment.Center),
                            color = GoldAccent
                        )
                        error != null -> Column(
                            Modifier.align(Alignment.Center).padding(24.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                Icons.Default.CloudOff,
                                contentDescription = null,
                                tint = GoldAccent,
                                modifier = Modifier.size(42.dp)
                            )
                            Spacer(Modifier.height(10.dp))
                            Text(
                                "Error al cargar el catálogo",
                                fontWeight = FontWeight.Bold,
                                color = TextPureWhite
                            )
                            Text(error ?: "", color = TextSilverGray, fontSize = 13.sp)
                            Spacer(Modifier.height(14.dp))
                            Button(
                                onClick = { reloadTrigger++ },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = GoldAccent,
                                    contentColor = BgDeepCharcoal
                                )
                            ) {
                                Icon(Icons.Default.Refresh, contentDescription = null)
                                Spacer(Modifier.width(6.dp))
                                Text("Reintentar", fontWeight = FontWeight.Bold)
                            }
                        }
                        kind == CatalogKind.LIVE -> LiveChannelsView(
                            channels = filteredLiveItems,
                            selected = selectedLive,
                            epg = epgList,
                            store = store,
                            onSelect = { ch ->
                                selectedLive = ch
                                scope.launch {
                                    epgList = repo.shortEpg(ch.streamId)
                                }
                            },
                            onPlay = { ch ->
                                val url = ch.directUrl?.takeIf { it.isNotBlank() }
                                    ?: repo.liveUrl(ch.streamId, "ts")
                                onPlayStream(
                                    url,
                                    ch.name ?: "Canal #${ch.streamId}",
                                    "TV en directo",
                                    "live",
                                    ""
                                )
                            }
                        )
                        kind == CatalogKind.MOVIES -> {
                            val favVodIds = remember(favRefresh) { store.favorites("vod") }
                            if (filteredMovieItems.isEmpty()) {
                                EmptySearchMessage(searchQuery)
                            } else {
                                LazyVerticalGrid(
                                    columns = GridCells.Adaptive(156.dp),
                                    contentPadding = PaddingValues(18.dp),
                                    horizontalArrangement = Arrangement.spacedBy(14.dp),
                                    verticalArrangement = Arrangement.spacedBy(14.dp)
                                ) {
                                    items(
                                        filteredMovieItems,
                                        key = { it.streamId }
                                    ) { m ->
                                        PosterCard(
                                            title = m.name ?: "Película",
                                            image = m.icon,
                                            subtitle = m.rating?.takeIf { it.isNotBlank() && it != "0" }?.let { "★ $it" }
                                                ?: m.extension?.uppercase(),
                                            isFavorite = favVodIds.contains(m.streamId),
                                            onClick = { onOpenMovie(m) }
                                        )
                                    }
                                }
                            }
                        }
                        kind == CatalogKind.SERIES -> {
                            val favSeriesIds = remember(favRefresh) { store.favorites("series") }
                            if (filteredSeriesItems.isEmpty()) {
                                EmptySearchMessage(searchQuery)
                            } else {
                                LazyVerticalGrid(
                                    columns = GridCells.Adaptive(156.dp),
                                    contentPadding = PaddingValues(18.dp),
                                    horizontalArrangement = Arrangement.spacedBy(14.dp),
                                    verticalArrangement = Arrangement.spacedBy(14.dp)
                                ) {
                                    items(
                                        filteredSeriesItems,
                                        key = { it.seriesId }
                                    ) { s ->
                                        PosterCard(
                                            title = s.name ?: "Serie",
                                            image = s.cover,
                                            subtitle = s.rating?.takeIf { it.isNotBlank() && it != "0" }?.let { "★ $it" }
                                                ?: s.genre,
                                            isFavorite = favSeriesIds.contains(s.seriesId),
                                            onClick = { onOpenSeries(s) }
                                        )
                                    }
                                }
                            }
                        }
                        kind == CatalogKind.FAVORITES -> {
                            val favLiveSet = remember(favRefresh) { store.favorites("live") }
                            val favVodSet = remember(favRefresh) { store.favorites("vod") }
                            val favSeriesSet = remember(favRefresh) { store.favorites("series") }

                            val favLive = remember(filteredLiveItems, favLiveSet) {
                                filteredLiveItems.filter { favLiveSet.contains(it.streamId) }
                            }
                            val favVod = remember(filteredMovieItems, favVodSet) {
                                filteredMovieItems.filter { favVodSet.contains(it.streamId) }
                            }
                            val favSeries = remember(filteredSeriesItems, favSeriesSet) {
                                filteredSeriesItems.filter { favSeriesSet.contains(it.seriesId) }
                            }

                            FavoritesView(
                                favLive = favLive,
                                favVod = favVod,
                                favSeries = favSeries,
                                onPlayLive = { ch ->
                                    val url = ch.directUrl?.takeIf { it.isNotBlank() }
                                        ?: repo.liveUrl(ch.streamId, "ts")
                                    onPlayStream(url, ch.name ?: "Canal", "Favorito · TV en directo", "live", "")
                                },
                                onOpenMovie = onOpenMovie,
                                onOpenSeries = onOpenSeries
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun BoxScope.EmptySearchMessage(query: String) {
    Column(
        Modifier.align(Alignment.Center).padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            Icons.Default.SearchOff,
            contentDescription = null,
            tint = GoldAccent.copy(alpha = 0.65f),
            modifier = Modifier.size(44.dp)
        )
        Spacer(Modifier.height(10.dp))
        Text(
            if (query.isNotBlank()) "No se encontraron resultados para \"$query\""
            else "No hay elementos en esta categoría",
            color = TextPureWhite,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
private fun LiveChannelsView(
    channels: List<LiveStream>,
    selected: LiveStream?,
    epg: List<EpgListing>,
    store: PlaylistStore,
    onSelect: (LiveStream) -> Unit,
    onPlay: (LiveStream) -> Unit
) {
    var favRefresh by remember { mutableIntStateOf(0) }
    val favLiveIds = remember(favRefresh) { store.favorites("live") }

    if (channels.isEmpty()) {
        Box(Modifier.fillMaxSize()) {
            EmptySearchMessage("")
        }
        return
    }

    Row(Modifier.fillMaxSize()) {
        LazyColumn(
            Modifier
                .weight(1.25f)
                .fillMaxHeight()
                .padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(channels, key = { it.streamId }) { ch ->
                val isSel = selected?.streamId == ch.streamId
                val isFav = favLiveIds.contains(ch.streamId)

                Row(
                    Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(
                            if (isSel) BetisGreenPrimary.copy(alpha = 0.7f) else BgCardSurface
                        )
                        .tvClickable(RoundedCornerShape(12.dp)) {
                            if (isSel) onPlay(ch) else onSelect(ch)
                        }
                        .padding(horizontal = 12.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    NetworkImage(
                        url = ch.icon,
                        contentDescription = ch.name,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(46.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(BgDeepCharcoal)
                    )
                    Spacer(Modifier.width(12.dp))
                    Column(Modifier.weight(1f)) {
                        Text(
                            ch.name ?: "Canal",
                            fontWeight = FontWeight.SemiBold,
                            color = TextPureWhite,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            if (isSel) "Pulsa de nuevo para reproducir"
                            else "Canal #${ch.num ?: ch.streamId}",
                            fontSize = 11.sp,
                            color = if (isSel) GoldChampagne else TextSilverGray
                        )
                    }
                    IconButton(
                        onClick = {
                            store.toggleFavorite("live", ch.streamId)
                            favRefresh++
                        },
                        modifier = Modifier.pointerHoverIcon(PointerIcon(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)))
                    ) {
                        Icon(
                            if (isFav) Icons.Default.Star else Icons.Default.StarBorder,
                            contentDescription = "Favorito",
                            tint = if (isFav) GoldAccent else TextSilverGray
                        )
                    }
                    IconButton(
                        onClick = { onPlay(ch) },
                        modifier = Modifier
                            .size(36.dp)
                            .clip(CircleShape)
                            .background(GoldAccent)
                            .pointerHoverIcon(PointerIcon(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)))
                    ) {
                        Icon(
                            Icons.Default.PlayArrow,
                            contentDescription = "Reproducir",
                            tint = BgDeepCharcoal
                        )
                    }
                }
            }
        }

        // Panel derecho de detalles del canal + Guía EPG
        Column(
            Modifier
                .weight(0.95f)
                .fillMaxHeight()
                .background(BgCardSurface.copy(alpha = 0.9f))
                .border(BorderStroke(1.dp, BetisGreenLeaf.copy(alpha = 0.3f)))
                .padding(20.dp)
        ) {
            if (selected == null) {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            Icons.Default.LiveTv,
                            contentDescription = null,
                            tint = GoldAccent.copy(alpha = 0.55f),
                            modifier = Modifier.size(48.dp)
                        )
                        Spacer(Modifier.height(10.dp))
                        Text(
                            "Selecciona un canal para consultar su programación EPG",
                            color = TextSilverGray,
                            fontSize = 13.sp
                        )
                    }
                }
            } else {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    NetworkImage(
                        url = selected.icon,
                        contentDescription = selected.name,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(56.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(BgDeepCharcoal)
                    )
                    Spacer(Modifier.width(12.dp))
                    Column(Modifier.weight(1f)) {
                        Text(
                            selected.name ?: "",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = TextPureWhite
                        )
                        Text(
                            "ID Stream: ${selected.streamId}",
                            fontSize = 12.sp,
                            color = GoldChampagne
                        )
                    }
                }
                Spacer(Modifier.height(14.dp))
                Button(
                    onClick = { onPlay(selected) },
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = GoldAccent,
                        contentColor = BgDeepCharcoal
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(46.dp)
                        .pointerHoverIcon(PointerIcon(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)))
                ) {
                    Icon(Icons.Default.PlayArrow, contentDescription = null)
                    Spacer(Modifier.width(6.dp))
                    Text("Ver ahora en directo", fontWeight = FontWeight.ExtraBold)
                }
                Spacer(Modifier.height(18.dp))
                Text(
                    "Guía de programación (EPG)",
                    fontWeight = FontWeight.Bold,
                    color = GoldChampagne,
                    fontSize = 14.sp
                )
                Spacer(Modifier.height(10.dp))
                if (epg.isEmpty()) {
                    Text(
                        "Sin información EPG disponible para este canal.",
                        color = TextSilverGray,
                        fontSize = 12.sp
                    )
                } else {
                    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        items(epg.take(8)) { item ->
                            Column(
                                Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(BgCardElevated)
                                    .border(1.dp, BetisGreenLeaf.copy(alpha = 0.35f), RoundedCornerShape(10.dp))
                                    .padding(12.dp)
                            ) {
                                Text(
                                    XtreamRepository.decodeB64(item.title),
                                    fontWeight = FontWeight.SemiBold,
                                    color = TextPureWhite,
                                    fontSize = 13.sp
                                )
                                Text(
                                    "${item.start ?: ""} → ${item.end ?: ""}",
                                    fontSize = 11.sp,
                                    color = GoldChampagne
                                )
                                val desc = XtreamRepository.decodeB64(item.description)
                                if (desc.isNotBlank()) {
                                    Spacer(Modifier.height(4.dp))
                                    Text(
                                        desc,
                                        fontSize = 11.sp,
                                        color = TextSilverGray,
                                        maxLines = 2,
                                        overflow = TextOverflow.Ellipsis
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

@Composable
private fun FavoritesView(
    favLive: List<LiveStream>,
    favVod: List<VodStream>,
    favSeries: List<Series>,
    onPlayLive: (LiveStream) -> Unit,
    onOpenMovie: (VodStream) -> Unit,
    onOpenSeries: (Series) -> Unit
) {
    if (favLive.isEmpty() && favVod.isEmpty() && favSeries.isEmpty()) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    Icons.Default.StarBorder,
                    contentDescription = null,
                    tint = GoldAccent,
                    modifier = Modifier.size(48.dp)
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    "Todavía no tienes favoritos guardados",
                    color = TextPureWhite,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    "Marca cualquier canal, película o serie con la estrella dorada ★",
                    color = TextSilverGray,
                    fontSize = 12.sp
                )
            }
        }
    } else {
        LazyColumn(
            contentPadding = PaddingValues(18.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            if (favLive.isNotEmpty()) {
                item {
                    Text("Canales en directo (${favLive.size})", fontWeight = FontWeight.Bold, color = GoldChampagne)
                    Spacer(Modifier.height(10.dp))
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        items(favLive, key = { it.streamId }) { ch ->
                            PosterCard(
                                title = ch.name,
                                image = ch.icon,
                                subtitle = "LIVE",
                                isFavorite = true,
                                onClick = { onPlayLive(ch) }
                            )
                        }
                    }
                }
            }
            if (favVod.isNotEmpty()) {
                item {
                    Text("Películas (${favVod.size})", fontWeight = FontWeight.Bold, color = GoldChampagne)
                    Spacer(Modifier.height(10.dp))
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        items(favVod, key = { it.streamId }) { m ->
                            PosterCard(
                                title = m.name,
                                image = m.icon,
                                subtitle = m.rating,
                                isFavorite = true,
                                onClick = { onOpenMovie(m) }
                            )
                        }
                    }
                }
            }
            if (favSeries.isNotEmpty()) {
                item {
                    Text("Series (${favSeries.size})", fontWeight = FontWeight.Bold, color = GoldChampagne)
                    Spacer(Modifier.height(10.dp))
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        items(favSeries, key = { it.seriesId }) { s ->
                            PosterCard(
                                title = s.name,
                                image = s.cover,
                                subtitle = s.rating,
                                isFavorite = true,
                                onClick = { onOpenSeries(s) }
                            )
                        }
                    }
                }
            }
        }
    }
}

// ─── 4. MOVIE DETAIL SCREEN ──────────────────────────────────────────
@Composable
fun MovieDetailScreen(
    movie: VodStream,
    onBack: () -> Unit,
    onPlay: (url: String, title: String, resumeKey: String) -> Unit
) {
    val appState = LocalAppState.current
    val repo = remember(appState.store.stateVersion) { appState.repo() }
    val store = remember { appState.store }
    var info by remember { mutableStateOf<VodInfoResponse?>(null) }
    var isFav by remember { mutableStateOf(store.favorites("vod").contains(movie.streamId)) }
    val resumeKey = "vod:${movie.streamId}"
    val savedPos = remember { store.getResumePosition(resumeKey) }

    LaunchedEffect(movie.streamId) {
        runCatching { repo.vodInfo(movie.streamId) }.onSuccess { info = it }
    }

    val ext = info?.movieData?.extension ?: movie.extension ?: "mp4"
    val streamUrl = remember(movie, ext) {
        movie.directUrl?.takeIf { it.isNotBlank() } ?: repo.movieUrl(movie.streamId, ext)
    }

    AppScaffold(
        title = movie.name ?: "Película",
        subtitle = info?.info?.genre ?: "Cine bajo demanda",
        onBack = onBack
    ) { pad ->
        Row(
            Modifier
                .fillMaxSize()
                .padding(pad)
                .padding(28.dp),
            horizontalArrangement = Arrangement.spacedBy(28.dp)
        ) {
            NetworkImage(
                url = info?.info?.image ?: movie.icon,
                contentDescription = movie.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(230.dp)
                    .height(330.dp)
                    .clip(RoundedCornerShape(18.dp))
                    .border(1.5.dp, GoldAccent, RoundedCornerShape(18.dp))
            )
            Column(
                Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    movie.name ?: "",
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.ExtraBold,
                    color = TextPureWhite
                )
                val meta = listOfNotNull(
                    info?.info?.releaseDate?.takeIf { it.isNotBlank() },
                    info?.info?.duration?.takeIf { it.isNotBlank() },
                    info?.info?.rating?.takeIf { it.isNotBlank() }?.let { "★ $it" }
                ).joinToString("  ·  ")
                if (meta.isNotBlank()) {
                    Text(meta, color = GoldChampagne, fontWeight = FontWeight.SemiBold)
                }
                Text(
                    info?.info?.plot?.takeIf { it.isNotBlank() } ?: "Sin sinopsis disponible.",
                    color = TextSilverGray,
                    fontSize = 14.sp
                )
                if (!info?.info?.cast.isNullOrBlank()) {
                    Text("Reparto: ${info?.info?.cast}", fontSize = 12.sp, color = TextSilverGray)
                }
                Spacer(Modifier.height(10.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    Button(
                        onClick = {
                            if (streamUrl.isNotBlank()) {
                                onPlay(streamUrl, movie.name ?: "Película", resumeKey)
                            }
                        },
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = GoldAccent,
                            contentColor = BgDeepCharcoal
                        ),
                        modifier = Modifier.pointerHoverIcon(PointerIcon(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)))
                    ) {
                        Icon(Icons.Default.PlayArrow, contentDescription = null)
                        Spacer(Modifier.width(6.dp))
                        Text(
                            if (savedPos > 15_000L) "Continuar (${savedPos / 60000} min)" else "Reproducir",
                            fontWeight = FontWeight.ExtraBold
                        )
                    }
                    if (savedPos > 15_000L) {
                        OutlinedButton(
                            onClick = {
                                store.saveResumePosition(resumeKey, 0L)
                                if (streamUrl.isNotBlank()) {
                                    onPlay(streamUrl, movie.name ?: "Película", resumeKey)
                                }
                            },
                            shape = RoundedCornerShape(12.dp),
                            border = BorderStroke(1.dp, GoldAccent),
                            colors = ButtonDefaults.outlinedButtonColors(contentColor = GoldChampagne),
                            modifier = Modifier.pointerHoverIcon(PointerIcon(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)))
                        ) {
                            Text("Desde el principio")
                        }
                    }
                    OutlinedButton(
                        onClick = {
                            store.toggleFavorite("vod", movie.streamId)
                            isFav = store.favorites("vod").contains(movie.streamId)
                        },
                        shape = RoundedCornerShape(12.dp),
                        border = BorderStroke(1.dp, GoldAccent),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = GoldChampagne),
                        modifier = Modifier.pointerHoverIcon(PointerIcon(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)))
                    ) {
                        Icon(
                            if (isFav) Icons.Default.Star else Icons.Default.StarBorder,
                            contentDescription = null,
                            tint = GoldAccent
                        )
                        Spacer(Modifier.width(6.dp))
                        Text(if (isFav) "En Favoritos" else "Añadir a Favoritos")
                    }
                }
            }
        }
    }
}

// ─── 5. SERIES DETAIL SCREEN ─────────────────────────────────────────
@Composable
fun SeriesDetailScreen(
    series: Series,
    onBack: () -> Unit,
    onPlayEpisode: (url: String, title: String, subtitle: String, resumeKey: String) -> Unit
) {
    val appState = LocalAppState.current
    val repo = remember(appState.store.stateVersion) { appState.repo() }
    val store = remember { appState.store }
    var details by remember { mutableStateOf<SeriesDetails?>(null) }
    var episodesBySeason by remember { mutableStateOf<Map<String, List<Episode>>>(emptyMap()) }
    var selectedSeason by remember { mutableStateOf<String?>(null) }
    var isFav by remember { mutableStateOf(store.favorites("series").contains(series.seriesId)) }

    LaunchedEffect(series.seriesId) {
        runCatching { repo.seriesInfo(series.seriesId) }.onSuccess { (info, map) ->
            details = info
            episodesBySeason = map
            selectedSeason = map.keys.firstOrNull()
        }
    }

    val seasons = episodesBySeason.keys.sortedBy { it.toIntOrNull() ?: 0 }
    val episodes = selectedSeason?.let { episodesBySeason[it] }.orEmpty()

    AppScaffold(
        title = series.name ?: "Serie",
        subtitle = series.genre,
        onBack = onBack,
        actions = {
            OutlinedButton(
                onClick = {
                    store.toggleFavorite("series", series.seriesId)
                    isFav = store.favorites("series").contains(series.seriesId)
                },
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(1.dp, GoldAccent),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = GoldChampagne),
                modifier = Modifier.pointerHoverIcon(PointerIcon(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)))
            ) {
                Icon(
                    if (isFav) Icons.Default.Star else Icons.Default.StarBorder,
                    contentDescription = null,
                    tint = GoldAccent
                )
                Spacer(Modifier.width(6.dp))
                Text(if (isFav) "Favorito" else "Favoritos")
            }
            Spacer(Modifier.width(8.dp))
        }
    ) { pad ->
        Column(Modifier.fillMaxSize().padding(pad).padding(22.dp)) {
            Text(
                details?.plot ?: series.plot ?: "",
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = TextSilverGray,
                fontSize = 13.sp
            )
            Spacer(Modifier.height(14.dp))

            LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                items(seasons) { s ->
                    val sel = s == selectedSeason
                    Box(
                        Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .background(if (sel) GoldAccent else BgCardSurface)
                            .tvClickable(RoundedCornerShape(10.dp)) { selectedSeason = s }
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                    ) {
                        Text(
                            "Temporada $s",
                            color = if (sel) BgDeepCharcoal else TextPureWhite,
                            fontWeight = FontWeight.Bold,
                            fontSize = 13.sp
                        )
                    }
                }
            }

            Spacer(Modifier.height(14.dp))

            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                items(episodes, key = { it.id }) { ep ->
                    val ext = ep.extension ?: "mp4"
                    val resumeKey = "series:${ep.id}"
                    val savedPos = store.getResumePosition(resumeKey)
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .background(BgCardSurface)
                            .tvClickable(RoundedCornerShape(12.dp)) {
                                val url = ep.directUrl?.takeIf { it.isNotBlank() }
                                    ?: repo.episodeUrl(ep.id, ext)
                                onPlayEpisode(
                                    url,
                                    "${series.name} · T${selectedSeason}E${ep.episodeNum ?: ""}",
                                    ep.title ?: "",
                                    resumeKey
                                )
                            }
                            .padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            Modifier
                                .size(38.dp)
                                .clip(CircleShape)
                                .background(GoldAccent),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(Icons.Default.PlayArrow, contentDescription = null, tint = BgDeepCharcoal)
                        }
                        Spacer(Modifier.width(14.dp))
                        Column(Modifier.weight(1f)) {
                            Text(
                                "${ep.episodeNum ?: "-"}. ${ep.title ?: "Episodio"}",
                                fontWeight = FontWeight.SemiBold,
                                color = TextPureWhite
                            )
                            if (!ep.info?.plot.isNullOrBlank()) {
                                Text(
                                    ep.info?.plot ?: "",
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                    fontSize = 12.sp,
                                    color = TextSilverGray
                                )
                            }
                        }
                        if (savedPos > 15_000L) {
                            Text(
                                "${savedPos / 60000} min vistos",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = GoldChampagne
                            )
                        }
                    }
                }
            }
        }
    }
}

// ─── 6. GLOBAL SEARCH SCREEN ─────────────────────────────────────────
@Composable
fun SearchScreen(
    onBack: () -> Unit,
    onPlayLive: (LiveStream, String) -> Unit,
    onOpenMovie: (VodStream) -> Unit,
    onOpenSeries: (Series) -> Unit
) {
    val appState = LocalAppState.current
    val repo = remember { appState.repo() }
    var query by remember { mutableStateOf("") }
    var liveAll by remember { mutableStateOf<List<LiveStream>>(emptyList()) }
    var vodAll by remember { mutableStateOf<List<VodStream>>(emptyList()) }
    var seriesAll by remember { mutableStateOf<List<Series>>(emptyList()) }
    var loading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        runCatching { repo.live() }.onSuccess { liveAll = it.second }
        runCatching { repo.vod() }.onSuccess { vodAll = it.second }
        runCatching { repo.series() }.onSuccess { seriesAll = it.second }
        loading = false
    }

    val q = query.trim()
    val liveMatches = remember(q, liveAll) {
        if (q.length < 2) emptyList() else liveAll.filter { it.name?.contains(q, true) == true }.take(30)
    }
    val vodMatches = remember(q, vodAll) {
        if (q.length < 2) emptyList() else vodAll.filter { it.name?.contains(q, true) == true }.take(30)
    }
    val seriesMatches = remember(q, seriesAll) {
        if (q.length < 2) emptyList() else seriesAll.filter { it.name?.contains(q, true) == true }.take(30)
    }

    AppScaffold(title = "Búsqueda Global", onBack = onBack) { pad ->
        Column(Modifier.fillMaxSize().padding(pad).padding(20.dp)) {
            GoldOutlinedTextField(
                value = query,
                onValueChange = { query = it },
                label = "Buscar canales en directo, películas o series...",
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.height(16.dp))
            if (loading) {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(color = GoldAccent)
                }
            } else {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(18.dp)) {
                    if (liveMatches.isNotEmpty()) {
                        item {
                            Text(
                                "Canales en directo (${liveMatches.size})",
                                fontWeight = FontWeight.Bold,
                                color = GoldChampagne
                            )
                            Spacer(Modifier.height(8.dp))
                            LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                                items(liveMatches, key = { it.streamId }) { ch ->
                                    PosterCard(
                                        title = ch.name ?: "Canal",
                                        image = ch.icon,
                                        subtitle = "LIVE",
                                        onClick = {
                                            val url = ch.directUrl?.takeIf { it.isNotBlank() }
                                                ?: repo.liveUrl(ch.streamId, "ts")
                                            onPlayLive(ch, url)
                                        }
                                    )
                                }
                            }
                        }
                    }
                    if (vodMatches.isNotEmpty()) {
                        item {
                            Text(
                                "Películas (${vodMatches.size})",
                                fontWeight = FontWeight.Bold,
                                color = GoldChampagne
                            )
                            Spacer(Modifier.height(8.dp))
                            LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                                items(vodMatches, key = { it.streamId }) { m ->
                                    PosterCard(
                                        title = m.name ?: "Película",
                                        image = m.icon,
                                        subtitle = m.rating,
                                        onClick = { onOpenMovie(m) }
                                    )
                                }
                            }
                        }
                    }
                    if (seriesMatches.isNotEmpty()) {
                        item {
                            Text(
                                "Series (${seriesMatches.size})",
                                fontWeight = FontWeight.Bold,
                                color = GoldChampagne
                            )
                            Spacer(Modifier.height(8.dp))
                            LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                                items(seriesMatches, key = { it.seriesId }) { s ->
                                    PosterCard(
                                        title = s.name ?: "Serie",
                                        image = s.cover,
                                        subtitle = s.rating,
                                        onClick = { onOpenSeries(s) }
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
