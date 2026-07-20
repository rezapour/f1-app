package me.rezapour.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

/**
 * F1 Companion theme.
 *
 * The dark scheme is a faithful translation of the Figma Make design
 * (theme.css :root block). The light scheme is derived from the same
 * palette, since the design itself is dark-only.
 *
 * Dynamic (wallpaper) color is intentionally disabled by default so the
 * racing-red brand identity is never overridden by Material You.
 */

private val DarkColorScheme = darkColorScheme(
    // Brand
    primary = F1Red,                        // --primary
    onPrimary = F1White,                    // --primary-foreground
    primaryContainer = F1Red,
    onPrimaryContainer = F1White,

    secondary = F1Grey,                     // --secondary
    onSecondary = F1White,                  // --secondary-foreground
    secondaryContainer = F1Grey,
    onSecondaryContainer = F1White,

    tertiary = F1LightGrey,
    onTertiary = F1DarkBg,

    // Surfaces
    background = F1DarkBg,                  // --background
    onBackground = F1White,                 // --foreground
    surface = F1DarkBg,
    onSurface = F1White,
    surfaceVariant = F1CardBg,
    onSurfaceVariant = F1LightGrey,         // --muted-foreground

    // M3 tonal surface containers: Cards, NavigationBar, BottomSheets,
    // Menus etc. resolve their container color from these slots.
    surfaceContainerLowest = F1DarkerBg,    // --f1-darker-bg
    surfaceContainerLow = F1CardBg,         // ElevatedCard
    surfaceContainer = F1CardBg,            // NavigationBar, Menus
    surfaceContainerHigh = F1CardBg,        // Dialogs
    surfaceContainerHighest = F1CardBg,     // Filled Card, TextField container

    // Borders & focus
    outline = F1Grey,                       // --border / --input
    outlineVariant = F1CardBg,

    // Feedback
    error = F1Error,                        // --destructive
    onError = F1White,                      // --destructive-foreground

    inverseSurface = F1White,
    inverseOnSurface = F1DarkBg,
    inversePrimary = F1Red,
)

private val LightColorScheme = lightColorScheme(
    // Brand — the red stays identical across themes
    primary = F1Red,
    onPrimary = F1White,
    primaryContainer = F1Red,
    onPrimaryContainer = F1White,

    secondary = F1Grey,
    onSecondary = F1White,
    secondaryContainer = F1LightSurfaceLow,
    onSecondaryContainer = F1InkText,

    tertiary = F1LightMutedText,
    onTertiary = F1White,

    // Surfaces (inverted)
    background = F1LightBg,
    onBackground = F1InkText,
    surface = F1LightBg,
    onSurface = F1InkText,
    surfaceVariant = F1LightSurfaceLow,
    onSurfaceVariant = F1LightMutedText,

    surfaceContainerLowest = F1LightCard,
    surfaceContainerLow = F1LightCard,
    surfaceContainer = F1LightCard,
    surfaceContainerHigh = F1LightCard,
    surfaceContainerHighest = F1LightSurfaceLow,

    outline = F1LightBorder,
    outlineVariant = F1LightSurfaceLow,

    error = F1Error,
    onError = F1White,

    inverseSurface = F1DarkBg,
    inverseOnSurface = F1White,
    inversePrimary = F1Red,
)

@Composable
fun SpaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = F1Typography,
        shapes = F1Shapes,
        content = content
    )
}

object SpaTheme {
    val colorScheme: ColorScheme
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.colorScheme

    val typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.typography

    val shapes: Shapes
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.shapes
}