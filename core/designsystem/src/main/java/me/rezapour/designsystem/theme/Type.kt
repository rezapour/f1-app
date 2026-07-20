package me.rezapour.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/**
 * Typography for the F1 Companion design system.
 *
 * Source: theme.css @layer base rules. fonts.css in the Figma Make
 * project is empty, so the design uses the platform default font —
 * hence FontFamily.Default throughout.
 *
 * CSS reference:
 *   --font-size: 16px (base)
 *   --font-weight-medium: 600   ← note: "medium" in the design means SemiBold
 *   --font-weight-normal: 400
 *   h1 = 24px, h2 = 20px, h3 = 18px, h4/label/button = 16px
 *   line-height: 1.5 everywhere
 */

private val DefaultFontFamily = FontFamily.Default
private val DesignMedium = FontWeight.SemiBold   // CSS defines medium as 600
private val DesignNormal = FontWeight.Normal     // 400

val F1Typography = Typography(
    // h1 — screen titles, hero headers (text-2xl)
    headlineSmall = TextStyle(
        fontFamily = DefaultFontFamily,
        fontWeight = DesignMedium,
        fontSize = 24.sp,
        lineHeight = 36.sp,       // 24 × 1.5
        letterSpacing = 0.sp
    ),

    // h2 — section headers (text-xl)
    titleLarge = TextStyle(
        fontFamily = DefaultFontFamily,
        fontWeight = DesignMedium,
        fontSize = 20.sp,
        lineHeight = 30.sp,       // 20 × 1.5
        letterSpacing = 0.sp
    ),

    // h3 — card titles, list item headlines (text-lg)
    titleMedium = TextStyle(
        fontFamily = DefaultFontFamily,
        fontWeight = DesignMedium,
        fontSize = 18.sp,
        lineHeight = 27.sp,       // 18 × 1.5
        letterSpacing = 0.sp
    ),

    // h4 / label — emphasized inline text (text-base, weight 600)
    titleSmall = TextStyle(
        fontFamily = DefaultFontFamily,
        fontWeight = DesignMedium,
        fontSize = 16.sp,
        lineHeight = 24.sp,       // 16 × 1.5
        letterSpacing = 0.sp
    ),

    // p / input — default body text (text-base, weight 400)
    bodyLarge = TextStyle(
        fontFamily = DefaultFontFamily,
        fontWeight = DesignNormal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    ),

    // Secondary body text (text-sm — derived, Tailwind scale)
    bodyMedium = TextStyle(
        fontFamily = DefaultFontFamily,
        fontWeight = DesignNormal,
        fontSize = 14.sp,
        lineHeight = 21.sp,
        letterSpacing = 0.sp
    ),

    // Captions, metadata (text-xs — derived)
    bodySmall = TextStyle(
        fontFamily = DefaultFontFamily,
        fontWeight = DesignNormal,
        fontSize = 12.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.sp
    ),

    // button — Material buttons pull labelLarge
    labelLarge = TextStyle(
        fontFamily = DefaultFontFamily,
        fontWeight = DesignMedium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    ),

    // Chips, small controls (derived)
    labelMedium = TextStyle(
        fontFamily = DefaultFontFamily,
        fontWeight = DesignMedium,
        fontSize = 14.sp,
        lineHeight = 21.sp,
        letterSpacing = 0.sp
    ),

    // Bottom navigation labels, overlines (derived)
    labelSmall = TextStyle(
        fontFamily = DefaultFontFamily,
        fontWeight = DesignMedium,
        fontSize = 12.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.sp
    ),
)