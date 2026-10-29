package com.minuevaapp.tv.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.PlaylistPlay
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Dns
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Link
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.material.icons.filled.Tv
import androidx.compose.material.icons.filled.VideoLibrary
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.minuevaapp.tv.MiTVApp
import com.minuevaapp.tv.R
import com.minuevaapp.tv.data.Playlist
import com.minuevaapp.tv.data.XtreamRepository
import com.minuevaapp.tv.ui.theme.*
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/** Equivalente a ChangePlaylistActivity + AddGroupActivity: añadir, editar, elegir y borrar listas Xtream Codes o M3U. */
@Composable
fun PlaylistsScreen(onReady: () -> Unit) {
    val app = MiTVApp.instance
    var list by remember { mutableStateOf(app.store.all()) }
    var selectedType by rememberSaveable { mutableStateOf(Playlist.TYPE_XTREAM) }
    var editingPlaylist by remember { mutableStateOf<Playlist?>(null) }

    // Campos Xtream Codes (inician vacíos/limpios)
    var xtreamName by rememberSaveable { mutableStateOf("") }
    var xtreamUrl by rememberSaveable { mutableStateOf("") }
    var xtreamUser by rememberSaveable { mutableStateOf("") }
    var xtreamPass by rememberSaveable { mutableStateOf("") }

    // Campos Lista M3U (inician vacíos/limpios)
    var m3uName by rememberSaveable { mutableStateOf("") }
    var m3uUrl by rememberSaveable { mutableStateOf("") }

    var isRefreshingList by remember { mutableStateOf(false) }
    var refreshStatus by remember { mutableStateOf<String?>(null) }
    var busy by remember { mutableStateOf(false) }
    var errorMsg by remember { mutableStateOf<String?>(null) }
    val scope = rememberCoroutineScope()

    val handleRefreshPlaylist: (Playlist) -> Unit = { p ->
        if (!isRefreshingList) {
            isRefreshingList = true
            refreshStatus = "Actualizando catálogo de ${p.name}..."
            scope.launch {
                val targetRepo = if (p.name == app.store.active().name && app.repo != null) {
                    app.repo!!
                } else {
                    XtreamRepository(p, app.okHttpClient)
                }
                val res = targetRepo.refreshAllXtream()
                isRefreshingList = false
                refreshStatus = if (res.success) {
                    if (p.isM3u) "Lista M3U actualizada (${res.liveCount} canales)"
                    else "Lista actualizada (${res.liveCount} TV, ${res.vodCount} Películas, ${res.seriesCount} Series)"
                } else {
                    res.error ?: "Error al actualizar la lista"
                }
            }
        }
    }

    // Garantiza que al abrir la pantalla siempre esté sincronizada la lista inyectada por defecto
    LaunchedEffect(Unit) {
        list = app.store.all()
    }

    fun clearFormFields() {
        editingPlaylist = null
        xtreamName = ""
        xtreamUrl = ""
        xtreamUser = ""
        xtreamPass = ""
        m3uName = ""
        m3uUrl = ""
        errorMsg = null
    }

    fun startEditing(p: Playlist) {
        editingPlaylist = p
        errorMsg = null
        selectedType = p.playlistType
        if (p.isM3u) {
            m3uName = p.name
            m3uUrl = p.effectiveM3uUrl
            xtreamName = ""
            xtreamUrl = ""
            xtreamUser = ""
            xtreamPass = ""
        } else {
            xtreamName = p.name
            xtreamUrl = p.serverUrl
            xtreamUser = p.username
            xtreamPass = p.password
            m3uName = ""
            m3uUrl = ""
        }
    }

    fun connect(p: Playlist) {
        if (busy) return
        busy = true
        errorMsg = null
        scope.launch {
            try {
                val repo = XtreamRepository(p, app.okHttpClient)
                val r = repo.login()
                if (r.userInfo?.auth != "1") {
                    throw IllegalStateException("Credenciales o lista no válidas (${r.userInfo?.status ?: "sin respuesta"})")
                }
                app.store.activeName = p.name
                app.repo = repo
                onReady()
            } catch (ce: CancellationException) {
                throw ce
            } catch (e: Exception) {
                errorMsg = XtreamRepository.sanitizeError(e, p)
            } finally {
                busy = false
            }
        }
    }

    AppScaffold(
        title = "XaviTV  ·  Acceso y listas IPTV",
        actions = {
            IconButton(
                onClick = {
                    val activePl = app.store.active()
                    if (!isRefreshingList) {
                        isRefreshingList = true
                        refreshStatus = "Actualizando catálogo de ${activePl.name}..."
                        scope.launch {
                            val activeRepo = app.repo ?: XtreamRepository(activePl, app.okHttpClient)
                            val res = activeRepo.refreshAllXtream()
                            isRefreshingList = false
                            refreshStatus = if (res.success) {
                                if (activePl.isM3u) "Lista M3U actualizada (${res.liveCount} canales)"
                                else "Lista actualizada (${res.liveCount} TV, ${res.vodCount} Películas, ${res.seriesCount} Series)"
                            } else {
                                res.error ?: "Error al actualizar la lista"
                            }
                        }
                    }
                },
                enabled = !isRefreshingList
            ) {
                if (isRefreshingList) {
                    CircularProgressIndicator(modifier = Modifier.size(20.dp), strokeWidth = 2.dp, color = GoldLight)
                } else {
                    Icon(Icons.Default.Refresh, contentDescription = "Actualizar lista activa", tint = GoldLight)
                }
            }
        }
    ) { pad ->
        BoxWithConstraints(
            Modifier
                .padding(pad)
                .fillMaxSize()
                .background(
                    Brush.radialGradient(
                        colors = listOf(
                            BetisGreenPrimary.copy(alpha = 0.35f),
                            BetisGreenDark.copy(alpha = 0.20f),
                            DarkBackground,
                        )
                    )
                )
                .padding(horizontal = 24.dp, vertical = 14.dp)
        ) {
            val isWide = maxWidth >= 640.dp
            Column(Modifier.fillMaxSize()) {
                if (refreshStatus != null) {
                    Surface(
                        color = DarkSurface,
                        border = BorderStroke(1.dp, GoldPrimary.copy(alpha = 0.5f)),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp)
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            if (isRefreshingList) {
                                CircularProgressIndicator(Modifier.size(16.dp), color = GoldLight, strokeWidth = 2.dp)
                            } else {
                                Icon(Icons.Default.CheckCircle, contentDescription = null, tint = GoldLight, modifier = Modifier.size(18.dp))
                            }
                            Text(
                                text = refreshStatus ?: "",
                                style = MaterialTheme.typography.bodySmall,
                                color = GoldLight,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                }
                // Cabecera con el logo oficial de XaviTV en verde y dorado
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(bottom = 14.dp),
                ) {
                    Box(
                        Modifier
                            .size(52.dp)
                            .clip(CircleShape)
                            .background(Color.White)
                            .border(2.dp, GoldLight, CircleShape)
                            .padding(4.dp),
                        contentAlignment = Alignment.Center,
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.app_logo),
                            contentDescription = "XaviTV",
                            modifier = Modifier.fillMaxSize(),
                        )
                    }
                    Spacer(Modifier.width(14.dp))
                    Column {
                        Text(
                            text = buildAnnotatedString {
                                withStyle(SpanStyle(color = TextPrimaryWhite, fontWeight = FontWeight.ExtraBold)) {
                                    append("Xavi")
                                }
                                withStyle(SpanStyle(color = GoldLight, fontWeight = FontWeight.ExtraBold)) {
                                    append("TV")
                                }
                                withStyle(SpanStyle(color = TextSecondaryGray, fontWeight = FontWeight.Normal)) {
                                    append("  ·  Xtream Codes & M3U")
                                }
                            },
                            style = MaterialTheme.typography.titleLarge,
                        )
                        Text(
                            text = "Selecciona o edita una lista guardada a la izquierda, o añade una nueva a la derecha",
                            style = MaterialTheme.typography.bodySmall,
                            color = TextSecondaryGray,
                        )
                    }
                }

                val handleSaveXtream = {
                    val rawUrl = xtreamUrl.trim().let {
                        if (!it.startsWith("http://", true) && !it.startsWith("https://", true)) "http://$it" else it
                    }
                    val targetPlaylist = Playlist(
                        name = xtreamName.trim().ifBlank { xtreamUser.trim() },
                        serverUrl = rawUrl,
                        username = xtreamUser.trim(),
                        password = xtreamPass,
                        type = Playlist.TYPE_XTREAM,
                    )
                    val currentEditing = editingPlaylist
                    if (currentEditing != null) {
                        app.store.update(currentEditing, targetPlaylist)
                    } else {
                        app.store.add(targetPlaylist)
                    }
                    list = app.store.all()
                    clearFormFields()
                    connect(targetPlaylist)
                }

                val handleSaveM3u = {
                    val cleanUrl = m3uUrl.trim().let {
                        if (!it.startsWith("http://", true) && !it.startsWith("https://", true)) "https://$it" else it
                    }
                    val defaultName = cleanUrl.substringAfterLast('/').substringBefore('?').ifBlank { "Lista M3U" }
                    val targetPlaylist = Playlist(
                        name = m3uName.trim().ifBlank { defaultName },
                        serverUrl = cleanUrl,
                        type = Playlist.TYPE_M3U,
                        m3uUrl = cleanUrl,
                    )
                    val currentEditing = editingPlaylist
                    if (currentEditing != null) {
                        app.store.update(currentEditing, targetPlaylist)
                    } else {
                        app.store.add(targetPlaylist)
                    }
                    list = app.store.all()
                    clearFormFields()
                    connect(targetPlaylist)
                }

                if (isWide) {
                    Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.spacedBy(24.dp)) {
                        SavedPlaylistsColumn(
                            list = list,
                            activeName = app.store.activeName,
                            editingPlaylist = editingPlaylist,
                            busy = busy,
                            onSelect = ::connect,
                            onEdit = ::startEditing,
                            onRefresh = handleRefreshPlaylist,
                            onDelete = { p ->
                                if (editingPlaylist?.name == p.name) clearFormFields()
                                app.store.remove(p)
                                list = app.store.all()
                            },
                            modifier = Modifier.weight(1f),
                        )
                        AddPlaylistPanel(
                            selectedType = selectedType,
                            onTypeChange = {
                                selectedType = it
                                errorMsg = null
                            },
                            editingPlaylist = editingPlaylist,
                            onCancelEdit = ::clearFormFields,
                            xtreamName = xtreamName,
                            onXtreamNameChange = { xtreamName = it },
                            xtreamUrl = xtreamUrl,
                            onXtreamUrlChange = { xtreamUrl = it },
                            xtreamUser = xtreamUser,
                            onXtreamUserChange = { xtreamUser = it },
                            xtreamPass = xtreamPass,
                            onXtreamPassChange = { xtreamPass = it },
                            m3uName = m3uName,
                            onM3uNameChange = { m3uName = it },
                            m3uUrl = m3uUrl,
                            onM3uUrlChange = { m3uUrl = it },
                            busy = busy,
                            errorMsg = errorMsg,
                            onSubmitXtream = handleSaveXtream,
                            onSubmitM3u = handleSaveM3u,
                            modifier = Modifier.weight(1.15f).verticalScroll(rememberScrollState()),
                        )
                    }
                } else {
                    Column(
                        Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.spacedBy(20.dp),
                    ) {
                        if (list.isNotEmpty()) {
                            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                Text(
                                    text = "Listas guardadas",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = GoldLight,
                                )
                                list.forEach { p ->
                                    PlaylistRowItem(
                                        playlist = p,
                                        isActive = p.name == app.store.activeName,
                                        isEditing = editingPlaylist?.name == p.name && editingPlaylist?.playlistType == p.playlistType,
                                        enabled = !busy,
                                        onSelect = { connect(p) },
                                        onEdit = { startEditing(p) },
                                        onRefresh = { handleRefreshPlaylist(p) },
                                        onDelete = {
                                            if (editingPlaylist?.name == p.name) clearFormFields()
                                            app.store.remove(p)
                                            list = app.store.all()
                                        },
                                    )
                                }
                            }
                        }
                        AddPlaylistPanel(
                            selectedType = selectedType,
                            onTypeChange = {
                                selectedType = it
                                errorMsg = null
                            },
                            editingPlaylist = editingPlaylist,
                            onCancelEdit = ::clearFormFields,
                            xtreamName = xtreamName,
                            onXtreamNameChange = { xtreamName = it },
                            xtreamUrl = xtreamUrl,
                            onXtreamUrlChange = { xtreamUrl = it },
                            xtreamUser = xtreamUser,
                            onXtreamUserChange = { xtreamUser = it },
                            xtreamPass = xtreamPass,
                            onXtreamPassChange = { xtreamPass = it },
                            m3uName = m3uName,
                            onM3uNameChange = { m3uName = it },
                            m3uUrl = m3uUrl,
                            onM3uUrlChange = { m3uUrl = it },
                            busy = busy,
                            errorMsg = errorMsg,
                            onSubmitXtream = handleSaveXtream,
                            onSubmitM3u = handleSaveM3u,
                            modifier = Modifier.fillMaxWidth(),
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun SavedPlaylistsColumn(
    list: List<Playlist>,
    activeName: String?,
    editingPlaylist: Playlist?,
    busy: Boolean,
    onSelect: (Playlist) -> Unit,
    onEdit: (Playlist) -> Unit,
    onRefresh: (Playlist) -> Unit,
    onDelete: (Playlist) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .background(DarkSurface.copy(alpha = 0.85f), RoundedCornerShape(16.dp))
            .border(1.dp, GoldPrimary.copy(alpha = 0.25f), RoundedCornerShape(16.dp))
            .padding(16.dp)
    ) {
        Text(
            text = "Listas guardadas",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = GoldLight,
        )
        Spacer(Modifier.height(10.dp))
        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(list, key = { "${it.playlistType}_${it.name}" }) { p ->
                PlaylistRowItem(
                    playlist = p,
                    isActive = p.name == activeName,
                    isEditing = editingPlaylist?.name == p.name && editingPlaylist?.playlistType == p.playlistType,
                    enabled = !busy,
                    onSelect = { onSelect(p) },
                    onEdit = { onEdit(p) },
                    onRefresh = { onRefresh(p) },
                    onDelete = { onDelete(p) },
                )
            }
        }
    }
}

@Composable
private fun PlaylistRowItem(
    playlist: Playlist,
    isActive: Boolean,
    isEditing: Boolean,
    enabled: Boolean,
    onSelect: () -> Unit,
    onEdit: () -> Unit,
    onRefresh: () -> Unit,
    onDelete: () -> Unit,
) {
    val shape = RoundedCornerShape(12.dp)
    Row(
        Modifier
            .fillMaxWidth()
            .tvClickable(
                shape = shape,
                idleBorderColor = when {
                    isEditing -> GoldLight
                    isActive -> GoldPrimary.copy(alpha = 0.65f)
                    else -> GoldPrimary.copy(alpha = 0.20f)
                },
                onClick = { if (enabled) onSelect() },
            )
            .background(
                when {
                    isEditing -> BetisGreenPrimary.copy(alpha = 0.65f)
                    isActive -> BetisGreenDark.copy(alpha = 0.55f)
                    else -> DarkSurfaceVariant.copy(alpha = 0.7f)
                },
                shape,
            )
            .padding(start = 14.dp, end = 6.dp, top = 10.dp, bottom = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = when {
                isActive -> Icons.Default.CheckCircle
                playlist.isM3u -> Icons.AutoMirrored.Filled.PlaylistPlay
                else -> Icons.Default.Tv
            },
            contentDescription = null,
            tint = if (isActive || isEditing) GoldLight else TextSecondaryGray,
            modifier = Modifier.size(22.dp),
        )
        Spacer(Modifier.width(12.dp))
        Column(Modifier.weight(1f)) {
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    text = playlist.name,
                    fontWeight = FontWeight.SemiBold,
                    color = TextPrimaryWhite,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Box(
                    Modifier
                        .background(BetisGreenPrimary, RoundedCornerShape(4.dp))
                        .border(0.8.dp, GoldPrimary.copy(alpha = 0.6f), RoundedCornerShape(4.dp))
                        .padding(horizontal = 6.dp, vertical = 1.dp)
                ) {
                    Text(
                        text = if (playlist.isM3u) "M3U" else "XTREAM",
                        style = MaterialTheme.typography.labelSmall,
                        color = GoldLight,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
            Text(
                text = if (playlist.isM3u) {
                    playlist.effectiveM3uUrl
                } else {
                    "${playlist.serverUrl}  ·  ${playlist.username}"
                },
                style = MaterialTheme.typography.labelSmall,
                color = TextSecondaryGray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
        IconButton(onClick = onEdit, enabled = enabled) {
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "Editar lista",
                tint = GoldLight,
            )
        }
        IconButton(onClick = onRefresh, enabled = enabled) {
            Icon(
                imageVector = Icons.Default.Refresh,
                contentDescription = "Actualizar lista",
                tint = GoldLight,
            )
        }
        IconButton(onClick = onDelete, enabled = enabled) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Borrar lista",
                tint = TextSecondaryGray,
            )
        }
    }
}

@Composable
private fun AddPlaylistPanel(
    selectedType: String,
    onTypeChange: (String) -> Unit,
    editingPlaylist: Playlist?,
    onCancelEdit: () -> Unit,
    xtreamName: String,
    onXtreamNameChange: (String) -> Unit,
    xtreamUrl: String,
    onXtreamUrlChange: (String) -> Unit,
    xtreamUser: String,
    onXtreamUserChange: (String) -> Unit,
    xtreamPass: String,
    onXtreamPassChange: (String) -> Unit,
    m3uName: String,
    onM3uNameChange: (String) -> Unit,
    m3uUrl: String,
    onM3uUrlChange: (String) -> Unit,
    busy: Boolean,
    errorMsg: String?,
    onSubmitXtream: () -> Unit,
    onSubmitM3u: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val isM3uTab = selectedType == Playlist.TYPE_M3U
    val isEditing = editingPlaylist != null

    Column(
        modifier = modifier
            .background(DarkSurface.copy(alpha = 0.90f), RoundedCornerShape(16.dp))
            .border(1.dp, if (isEditing) GoldLight else GoldPrimary.copy(alpha = 0.30f), RoundedCornerShape(16.dp))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        if (editingPlaylist != null) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(BetisGreenDark.copy(alpha = 0.75f), RoundedCornerShape(10.dp))
                    .border(1.dp, GoldPrimary.copy(alpha = 0.55f), RoundedCornerShape(10.dp))
                    .padding(horizontal = 12.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(Icons.Default.Edit, contentDescription = null, tint = GoldLight, modifier = Modifier.size(18.dp))
                Spacer(Modifier.width(8.dp))
                Text(
                    text = "Editando: ${editingPlaylist.name}",
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold,
                    color = GoldLight,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f),
                )
                TextButton(
                    onClick = onCancelEdit,
                    colors = ButtonDefaults.textButtonColors(contentColor = TextPrimaryWhite),
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp),
                ) {
                    Icon(Icons.Default.Close, contentDescription = null, modifier = Modifier.size(16.dp))
                    Spacer(Modifier.width(4.dp))
                    Text("Cancelar", style = MaterialTheme.typography.labelSmall)
                }
            }
        }

        // Selector de pestañas: Xtream Codes vs Lista M3U
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(DarkBackground, RoundedCornerShape(12.dp))
                .border(1.dp, GoldPrimary.copy(alpha = 0.28f), RoundedCornerShape(12.dp))
                .padding(4.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
        ) {
            PlaylistTypeTab(
                title = "Xtream Codes",
                selected = !isM3uTab,
                onClick = { onTypeChange(Playlist.TYPE_XTREAM) },
                modifier = Modifier.weight(1f),
            )
            PlaylistTypeTab(
                title = "Lista M3U",
                selected = isM3uTab,
                onClick = { onTypeChange(Playlist.TYPE_M3U) },
                modifier = Modifier.weight(1f),
            )
        }

        if (!isM3uTab) {
            GoldOutlinedTextField(
                value = xtreamName,
                onValueChange = onXtreamNameChange,
                label = "Nombre de la lista (opcional)",
                leadingIcon = { Icon(Icons.Default.Badge, contentDescription = null) },
                modifier = Modifier.fillMaxWidth(),
            )
            GoldOutlinedTextField(
                value = xtreamUrl,
                onValueChange = onXtreamUrlChange,
                label = "URL del servidor (ej. http://host:puerto)",
                leadingIcon = { Icon(Icons.Default.Dns, contentDescription = null) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Uri),
                modifier = Modifier.fillMaxWidth(),
            )
            GoldOutlinedTextField(
                value = xtreamUser,
                onValueChange = onXtreamUserChange,
                label = "Usuario",
                leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
                modifier = Modifier.fillMaxWidth(),
            )
            GoldOutlinedTextField(
                value = xtreamPass,
                onValueChange = onXtreamPassChange,
                label = "Contraseña",
                leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.fillMaxWidth(),
            )
            errorMsg?.let {
                Text(it, color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodySmall)
            }
            Spacer(Modifier.height(2.dp))
            Button(
                enabled = !busy && xtreamUrl.trim().length > 4 && xtreamUser.isNotBlank() && xtreamPass.isNotBlank(),
                onClick = onSubmitXtream,
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = GoldPrimary,
                    contentColor = DarkBackground,
                    disabledContainerColor = DarkSurfaceVariant,
                    disabledContentColor = TextSecondaryGray.copy(alpha = 0.5f),
                ),
                modifier = Modifier.fillMaxWidth().height(48.dp),
            ) {
                if (busy) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(18.dp),
                        strokeWidth = 2.dp,
                        color = DarkBackground,
                    )
                    Spacer(Modifier.width(8.dp))
                    Text("Guardando y conectando…", fontWeight = FontWeight.Bold)
                } else {
                    Text(
                        text = if (isEditing) "Actualizar y conectar (Xtream)" else "Guardar y conectar (Xtream)",
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
        } else {
            GoldOutlinedTextField(
                value = m3uName,
                onValueChange = onM3uNameChange,
                label = "Nombre identificativo de la lista",
                leadingIcon = { Icon(Icons.Default.Badge, contentDescription = null) },
                modifier = Modifier.fillMaxWidth(),
            )
            GoldOutlinedTextField(
                value = m3uUrl,
                onValueChange = onM3uUrlChange,
                label = "URL de la lista (.m3u / .m3u8)",
                leadingIcon = { Icon(Icons.Default.Link, contentDescription = null) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Uri),
                modifier = Modifier.fillMaxWidth(),
            )
            Text(
                text = "Se analizarán las etiquetas #EXTINF y se clasificarán automáticamente los canales en directo, películas y series.",
                style = MaterialTheme.typography.labelSmall,
                color = TextSecondaryGray,
            )
            errorMsg?.let {
                Text(it, color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodySmall)
            }
            Spacer(Modifier.height(4.dp))
            Button(
                enabled = !busy && m3uUrl.trim().length > 6,
                onClick = onSubmitM3u,
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = GoldPrimary,
                    contentColor = DarkBackground,
                    disabledContainerColor = DarkSurfaceVariant,
                    disabledContentColor = TextSecondaryGray.copy(alpha = 0.5f),
                ),
                modifier = Modifier.fillMaxWidth().height(48.dp),
            ) {
                if (busy) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(18.dp),
                        strokeWidth = 2.dp,
                        color = DarkBackground,
                    )
                    Spacer(Modifier.width(8.dp))
                    Text("Guardando y analizando M3U…", fontWeight = FontWeight.Bold)
                } else {
                    Text(
                        text = if (isEditing) "Actualizar y cargar lista M3U" else "Guardar y cargar lista M3U",
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
        }
    }
}

@Composable
private fun PlaylistTypeTab(
    title: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val shape = RoundedCornerShape(9.dp)
    Box(
        modifier = modifier
            .tvClickable(
                shape = shape,
                idleBorderColor = if (selected) GoldPrimary.copy(alpha = 0.7f) else Color.Transparent,
                onClick = onClick,
            )
            .background(
                if (selected) BetisGreenPrimary else Color.Transparent,
                shape,
            )
            .padding(vertical = 10.dp, horizontal = 12.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = title,
            fontWeight = if (selected) FontWeight.Bold else FontWeight.Medium,
            color = if (selected) GoldLight else TextSecondaryGray,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}

/** Equivalente a HomeActivity: accesos a TV en directo, Películas y Series + información de la cuenta o lista M3U. */
@Composable
fun HomeScreen(onOpen: (String) -> Unit, onSearch: () -> Unit, onPlaylists: () -> Unit) {
    val repo = MiTVApp.instance.repo ?: return
    var isRefreshing by remember { mutableStateOf(false) }
    var refreshFeedback by remember { mutableStateOf<String?>(null) }
    var refreshKey by remember { mutableIntStateOf(0) }
    val scope = rememberCoroutineScope()
    val account = rememberLoad(repo, refreshKey) { repo.login().userInfo }

    AppScaffold(
        title = "XaviTV  ·  ${repo.playlist.name}",
        actions = {
            IconButton(
                onClick = {
                    if (!isRefreshing) {
                        isRefreshing = true
                        refreshFeedback = "Actualizando catálogo de ${repo.playlist.name}..."
                        scope.launch {
                            val res = repo.refreshAllXtream()
                            isRefreshing = false
                            refreshKey++
                            refreshFeedback = if (res.success) {
                                if (repo.playlist.isM3u) "Lista M3U actualizada (${res.liveCount} canales)"
                                else "Lista actualizada (${res.liveCount} TV, ${res.vodCount} Películas, ${res.seriesCount} Series)"
                            } else {
                                res.error ?: "Error al actualizar la lista"
                            }
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
            IconButton(onClick = onSearch) {
                Icon(Icons.Default.Search, contentDescription = "Buscar", tint = GoldLight)
            }
            IconButton(onClick = onPlaylists) {
                Icon(Icons.Default.SwapHoriz, contentDescription = "Cambiar lista", tint = GoldLight)
            }
        },
    ) { pad ->
        Column(
            Modifier
                .padding(pad)
                .fillMaxSize()
                .background(
                    Brush.radialGradient(
                        colors = listOf(
                            BetisGreenPrimary.copy(alpha = 0.30f),
                            DarkBackground,
                        )
                    )
                )
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            if (refreshFeedback != null) {
                Surface(
                    color = DarkSurface,
                    border = BorderStroke(1.dp, GoldPrimary.copy(alpha = 0.5f)),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.padding(bottom = 16.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        if (isRefreshing) {
                            CircularProgressIndicator(Modifier.size(16.dp), color = GoldLight, strokeWidth = 2.dp)
                        } else {
                            Icon(Icons.Default.CheckCircle, contentDescription = null, tint = GoldLight, modifier = Modifier.size(18.dp))
                        }
                        Text(
                            text = refreshFeedback ?: "",
                            style = MaterialTheme.typography.bodySmall,
                            color = GoldLight,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }

            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(22.dp)) {
                HomeTile(
                    title = "TV en directo",
                    subtitle = "Canales y guía EPG",
                    icon = Icons.Default.Tv,
                    modifier = Modifier.weight(1f),
                ) { onOpen("live") }
                HomeTile(
                    title = "Películas",
                    subtitle = "Catálogo de cine VOD",
                    icon = Icons.Default.Movie,
                    modifier = Modifier.weight(1f),
                ) { onOpen("movie") }
                HomeTile(
                    title = "Series",
                    subtitle = "Temporadas y episodios",
                    icon = Icons.Default.VideoLibrary,
                    modifier = Modifier.weight(1f),
                ) { onOpen("series") }
            }
            Spacer(Modifier.height(20.dp))
            Button(
                onClick = {
                    if (!isRefreshing) {
                        isRefreshing = true
                        refreshFeedback = "Actualizando catálogo de ${repo.playlist.name}..."
                        scope.launch {
                            val res = repo.refreshAllXtream()
                            isRefreshing = false
                            refreshKey++
                            refreshFeedback = if (res.success) {
                                if (repo.playlist.isM3u) "Lista M3U actualizada (${res.liveCount} canales)"
                                else "Lista actualizada (${res.liveCount} TV, ${res.vodCount} Películas, ${res.seriesCount} Series)"
                            } else {
                                res.error ?: "Error al actualizar la lista"
                            }
                        }
                    }
                },
                enabled = !isRefreshing,
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = BetisGreenDark,
                    contentColor = GoldLight
                ),
                border = BorderStroke(1.dp, GoldPrimary.copy(alpha = 0.55f)),
                modifier = Modifier.height(44.dp)
            ) {
                if (isRefreshing) {
                    CircularProgressIndicator(Modifier.size(16.dp), color = GoldLight, strokeWidth = 2.dp)
                    Spacer(Modifier.width(8.dp))
                    Text("Actualizando catálogo…", fontWeight = FontWeight.Bold)
                } else {
                    Icon(Icons.Default.Refresh, contentDescription = null, tint = GoldLight)
                    Spacer(Modifier.width(8.dp))
                    Text("Actualizar lista Xtream / M3U", fontWeight = FontWeight.Bold)
                }
            }
            Spacer(Modifier.height(18.dp))
            (account as? Load.Ok)?.data?.let { u ->
                Row(
                    modifier = Modifier
                        .background(DarkSurface, RoundedCornerShape(12.dp))
                        .border(1.dp, GoldPrimary.copy(alpha = 0.35f), RoundedCornerShape(12.dp))
                        .padding(horizontal = 20.dp, vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    if (repo.playlist.isM3u) {
                        AccountStatItem("Lista", u.username ?: repo.playlist.name)
                        Text("·", color = GoldPrimary, fontWeight = FontWeight.Bold)
                        AccountStatItem("Resumen", u.status ?: "M3U activa")
                    } else {
                        val exp = u.expDate?.toLongOrNull()?.let {
                            SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date(it * 1000))
                        } ?: "Ilimitado"
                        AccountStatItem("Usuario", u.username ?: "-")
                        Text("·", color = GoldPrimary, fontWeight = FontWeight.Bold)
                        AccountStatItem("Estado", u.status ?: "-")
                        Text("·", color = GoldPrimary, fontWeight = FontWeight.Bold)
                        AccountStatItem("Caducidad", exp)
                        Text("·", color = GoldPrimary, fontWeight = FontWeight.Bold)
                        AccountStatItem("Conexiones", "${u.activeConnections ?: "0"}/${u.maxConnections ?: "-"}")
                    }
                }
            }
        }
    }
}

@Composable
private fun AccountStatItem(label: String, value: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = "$label: ",
            style = MaterialTheme.typography.bodySmall,
            color = TextSecondaryGray,
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodySmall,
            color = GoldLight,
            fontWeight = FontWeight.SemiBold,
        )
    }
}

@Composable
private fun HomeTile(
    title: String,
    subtitle: String,
    icon: ImageVector,
    modifier: Modifier,
    onClick: () -> Unit,
) {
    var focused by remember { mutableStateOf(false) }
    val shape = RoundedCornerShape(18.dp)
    Column(
        modifier = modifier
            .height(195.dp)
            .shadow(elevation = if (focused) 14.dp else 6.dp, shape = shape)
            .onFocusChanged { focused = it.isFocused }
            .tvClickable(
                shape = shape,
                borderWidth = 3.dp,
                idleBorderColor = GoldPrimary.copy(alpha = 0.40f),
                onClick = onClick,
            )
            .background(
                Brush.verticalGradient(
                    colors = if (focused) {
                        listOf(BetisGreenLeaf, BetisGreenPrimary, BetisGreenDark)
                    } else {
                        listOf(BetisGreenPrimary, BetisGreenDark, DarkSurface)
                    }
                ),
                shape = shape,
            )
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Box(
            modifier = Modifier
                .size(66.dp)
                .clip(CircleShape)
                .background(DarkBackground.copy(alpha = 0.45f))
                .border(1.5.dp, if (focused) GoldLight else GoldPrimary.copy(alpha = 0.65f), CircleShape),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                tint = GoldLight,
                modifier = Modifier.size(34.dp),
            )
        }
        Spacer(Modifier.height(14.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            color = TextPrimaryWhite,
            fontWeight = FontWeight.Bold,
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = subtitle,
            style = MaterialTheme.typography.labelSmall,
            color = if (focused) GoldLight else TextSecondaryGray,
        )
    }
}
