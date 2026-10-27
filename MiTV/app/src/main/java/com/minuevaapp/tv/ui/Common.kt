package com.minuevaapp.tv.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.BrokenImage
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.key.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import coil.size.Precision
import coil.size.Size
import com.minuevaapp.tv.MiTVApp
import com.minuevaapp.tv.R
import com.minuevaapp.tv.data.XtreamRepository
import com.minuevaapp.tv.ui.theme.*
import kotlinx.coroutines.CancellationException

/** Estado de carga genérico con soporte de reintento. */
sealed interface Load<out T> {
    data object Loading : Load<Nothing>
    data class Ok<T>(val data: T) : Load<T>
    data class Error(val msg: String, val retry: () -> Unit) : Load<Nothing>
}

@Composable
fun <T> rememberLoad(vararg keys: Any?, block: suspend () -> T): Load<T> {
    var retryToken by remember { mutableIntStateOf(0) }
    val retry: () -> Unit = remember { { retryToken++ } }
    val state by produceState<Load<T>>(Load.Loading, *keys, retryToken) {
        value = Load.Loading
        value = try {
            Load.Ok(block())
        } catch (ce: CancellationException) {
            throw ce
        } catch (e: Exception) {
            val playlist = MiTVApp.instance.repo?.playlist
            Load.Error(XtreamRepository.sanitizeError(e, playlist), retry)
        }
    }
    return state
}

@Composable
fun <T> LoadContent(state: Load<T>, content: @Composable (T) -> Unit) {
    when (state) {
        Load.Loading -> Box(Modifier.fillMaxSize(), Alignment.Center) {
            CircularProgressIndicator(color = GoldPrimary, strokeWidth = 3.dp)
        }
        is Load.Error -> Box(Modifier.fillMaxSize().padding(24.dp), Alignment.Center) {
            Column(
                modifier = Modifier
                    .background(DarkSurface, RoundedCornerShape(14.dp))
                    .border(1.dp, GoldPrimary.copy(alpha = 0.35f), RoundedCornerShape(14.dp))
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(14.dp),
            ) {
                Text(
                    text = "Error: ${state.msg}",
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium,
                )
                Button(
                    onClick = state.retry,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = GoldPrimary,
                        contentColor = DarkBackground,
                    ),
                    shape = RoundedCornerShape(10.dp),
                ) {
                    Icon(Icons.Default.Refresh, contentDescription = null)
                    Spacer(Modifier.width(8.dp))
                    Text("Reintentar", fontWeight = FontWeight.Bold)
                }
            }
        }
        is Load.Ok -> content(state.data)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScaffold(
    title: String,
    onBack: (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
    content: @Composable (PaddingValues) -> Unit,
) {
    Scaffold(
        containerColor = DarkBackground,
        contentWindowInsets = WindowInsets.safeDrawing,
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF0B1F15))
            ) {
                TopAppBar(
                    windowInsets = WindowInsets.safeDrawing.only(
                        WindowInsetsSides.Top + WindowInsetsSides.Horizontal
                    ),
                    title = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(id = R.drawable.app_logo),
                                contentDescription = "XaviTV",
                                modifier = Modifier
                                    .size(30.dp)
                                    .clip(CircleShape)
                                    .background(Color.White, CircleShape)
                                    .padding(2.dp),
                            )
                            Spacer(Modifier.width(10.dp))
                            Text(
                                text = title,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                fontWeight = FontWeight.Bold,
                                color = TextPrimaryWhite,
                            )
                        }
                    },
                    navigationIcon = {
                        if (onBack != null) {
                            IconButton(onClick = onBack) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "Atrás",
                                    tint = GoldLight,
                                )
                            }
                        }
                    },
                    actions = actions,
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color(0xFF0B1F15),
                        titleContentColor = TextPrimaryWhite,
                        actionIconContentColor = GoldLight,
                    ),
                )
                HorizontalDivider(thickness = 1.dp, color = GoldPrimary.copy(alpha = 0.25f))
            }
        },
    ) { pad ->
        Box(
            Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            BetisGreenDark.copy(alpha = 0.38f),
                            DarkBackground,
                            DarkBackground,
                        )
                    )
                )
                .windowInsetsPadding(
                    WindowInsets.safeDrawing.only(WindowInsetsSides.Horizontal + WindowInsetsSides.Bottom)
                )
        ) {
            content(pad)
        }
    }
}

/**
 * Campo de texto estilizado con bordes redondeados y foco en dorado/champagne.
 */
@Composable
fun GoldOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        singleLine = true,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = GoldLight,
            unfocusedBorderColor = GoldPrimary.copy(alpha = 0.30f),
            focusedLabelColor = GoldLight,
            unfocusedLabelColor = TextSecondaryGray,
            cursorColor = GoldLight,
            focusedTextColor = TextPrimaryWhite,
            unfocusedTextColor = TextPrimaryWhite,
            focusedContainerColor = DarkSurface,
            unfocusedContainerColor = DarkSurface.copy(alpha = 0.85f),
            focusedLeadingIconColor = GoldLight,
            unfocusedLeadingIconColor = TextSecondaryGray,
        ),
        modifier = modifier,
    )
}

/**
 * Modificador clicable optimizado para móvil (táctil), emulador (ratón) y Android TV (mando D-pad).
 * Muestra un borde dorado/champagne de alto contraste al recibir foco y responde a DPAD_CENTER / ENTER.
 */
@Composable
fun Modifier.tvClickable(
    shape: Shape = RoundedCornerShape(12.dp),
    borderWidth: Dp = 2.5.dp,
    idleBorderColor: Color = GoldPrimary.copy(alpha = 0.18f),
    onFocused: (() -> Unit)? = null,
    onClick: () -> Unit,
): Modifier {
    var focused by remember { mutableStateOf(false) }
    return this
        .clip(shape)
        .onFocusChanged {
            focused = it.isFocused
            if (it.isFocused) onFocused?.invoke()
        }
        .border(
            width = if (focused) borderWidth else 1.dp,
            color = if (focused) GoldLight else idleBorderColor,
            shape = shape,
        )
        .onKeyEvent { event ->
            if (event.type == KeyEventType.KeyUp &&
                (event.key == Key.DirectionCenter || event.key == Key.Enter || event.key == Key.NumPadEnter)
            ) {
                onClick()
                true
            } else {
                false
            }
        }
        .focusable()
        .clickable(onClick = onClick)
}

/**
 * Imagen de red con Coil y placeholders de carga y de error integrados en tonos verdes y dorados.
 */
@Composable
fun NetworkImage(
    url: String?,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop,
    fallbackIcon: ImageVector = Icons.Default.Movie,
    alpha: Float = 1f,
) {
    val cleanUrl = url?.trim()?.takeIf { it.isNotEmpty() }
    if (cleanUrl == null) {
        Box(
            modifier = modifier.background(DarkSurfaceVariant),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                imageVector = fallbackIcon,
                contentDescription = contentDescription,
                tint = GoldPrimary.copy(alpha = 0.45f),
                modifier = Modifier.size(34.dp),
            )
        }
        return
    }

    val context = LocalContext.current
    val request = remember(cleanUrl) {
        ImageRequest.Builder(context)
            .data(cleanUrl)
            .size(240, 360)
            .precision(Precision.INEXACT)
            .allowRgb565(true)
            .memoryCachePolicy(CachePolicy.ENABLED)
            .diskCachePolicy(CachePolicy.ENABLED)
            .crossfade(true)
            .build()
    }

    SubcomposeAsyncImage(
        model = request,
        contentDescription = contentDescription,
        contentScale = contentScale,
        alpha = alpha,
        modifier = modifier.background(DarkSurfaceVariant),
        loading = {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(
                    modifier = Modifier.size(22.dp),
                    strokeWidth = 2.dp,
                    color = GoldPrimary.copy(alpha = 0.65f),
                )
            }
        },
        error = {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Icon(
                    imageVector = Icons.Default.BrokenImage,
                    contentDescription = contentDescription,
                    tint = GoldPrimary.copy(alpha = 0.45f),
                    modifier = Modifier.size(28.dp),
                )
            }
        },
    )
}

/**
 * Tarjeta de cartel (Película / Serie / Canal) con marco elegante, sombra suave e indicador dorado de favorito.
 */
@Composable
fun PosterCard(
    title: String?,
    image: String?,
    subtitle: String? = null,
    isFavorite: Boolean = false,
    onClick: () -> Unit,
) {
    val cardShape = RoundedCornerShape(12.dp)
    Column(
        Modifier
            .width(140.dp)
            .shadow(elevation = 6.dp, shape = cardShape)
            .tvClickable(
                shape = cardShape,
                idleBorderColor = if (isFavorite) GoldPrimary.copy(alpha = 0.55f) else GoldPrimary.copy(alpha = 0.22f),
                onClick = onClick,
            )
            .background(DarkSurface)
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .aspectRatio(2f / 3f)
        ) {
            NetworkImage(
                url = image,
                contentDescription = title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(),
            )
            // Sombra degradada inferior para dar profundidad al cartel
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(44.dp)
                    .align(Alignment.BottomCenter)
                    .background(
                        Brush.verticalGradient(
                            listOf(Color.Transparent, DarkSurface.copy(alpha = 0.92f))
                        )
                    )
            )
            if (isFavorite) {
                Box(
                    Modifier
                        .align(Alignment.TopEnd)
                        .padding(6.dp)
                        .size(26.dp)
                        .background(DarkBackground.copy(alpha = 0.85f), CircleShape)
                        .border(1.dp, GoldLight, CircleShape),
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Favorito",
                        tint = GoldLight,
                        modifier = Modifier.size(16.dp),
                    )
                }
            }
            if (!subtitle.isNullOrBlank()) {
                Box(
                    Modifier
                        .align(Alignment.BottomStart)
                        .padding(6.dp)
                        .background(BetisGreenDark.copy(alpha = 0.90f), RoundedCornerShape(6.dp))
                        .border(0.8.dp, GoldPrimary.copy(alpha = 0.55f), RoundedCornerShape(6.dp))
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = subtitle,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.labelSmall,
                        color = GoldLight,
                        fontWeight = FontWeight.SemiBold,
                    )
                }
            }
        }
        Text(
            text = title?.ifBlank { "Sin título" } ?: "Sin título",
            maxLines = 2,
            minLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Medium,
            color = TextPrimaryWhite,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
        )
    }
}
