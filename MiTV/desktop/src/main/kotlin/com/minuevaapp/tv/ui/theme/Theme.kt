package com.minuevaapp.tv.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Paleta inspirada en verde bético oscuro, verde hoja secundario y detalles en dorado/champagne
val BetisGreenDark = Color(0xFF0A3A22)
val BetisGreenPrimary = Color(0xFF124E31)
val BetisGreenLeaf = Color(0xFF1D6F47)
val GoldPrimary = Color(0xFFD4AF37)
val GoldLight = Color(0xFFE5C158)
val DarkBackground = Color(0xFF0E1410)
val DarkSurface = Color(0xFF16201B)
val DarkSurfaceVariant = Color(0xFF1F2E26)
val TextPrimaryWhite = Color(0xFFFFFFFF)
val TextSecondaryGray = Color(0xFFB0BEC5)

// Aliases adicionales de la interfaz de escritorio
val GoldAccent = GoldPrimary
val GoldChampagne = GoldLight
val BgDeepCharcoal = DarkBackground
val BgCardSurface = DarkSurface
val BgCardElevated = DarkSurfaceVariant
val BgInputSurface = Color(0xFF121B16)
val TextPureWhite = TextPrimaryWhite
val TextSilverGray = TextSecondaryGray
val TextMutedGreenGray = Color(0xFF7E9489)
val ErrorCrimson = Color(0xFFEF5350)

private val Colors = darkColorScheme(
    primary = BetisGreenPrimary,
    onPrimary = TextPrimaryWhite,
    primaryContainer = BetisGreenDark,
    onPrimaryContainer = GoldLight,
    secondary = GoldPrimary,
    onSecondary = DarkBackground,
    secondaryContainer = Color(0xFF332B12),
    onSecondaryContainer = GoldLight,
    tertiary = BetisGreenLeaf,
    onTertiary = TextPrimaryWhite,
    background = DarkBackground,
    onBackground = TextPrimaryWhite,
    surface = DarkSurface,
    onSurface = TextPrimaryWhite,
    surfaceVariant = DarkSurfaceVariant,
    onSurfaceVariant = TextSecondaryGray,
    outline = TextSecondaryGray,
    outlineVariant = Color(0xFF2C3E35),
    error = ErrorCrimson,
    onError = TextPrimaryWhite,
)

@Composable
fun MiTVTheme(content: @Composable () -> Unit) =
    MaterialTheme(colorScheme = Colors, content = content)
