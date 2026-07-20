package me.rezapour.designsystem.theme

import androidx.compose.ui.graphics.Color

/**
 * Raw color palette for the F1 Companion design system.
 * Source of truth: Figma Make design (theme.css, :root block).
 *
 * These values should not be used directly in feature code.
 * Always go through MaterialTheme.colorScheme so light/dark
 * resolution happens automatically.
 */

// ── Brand ────────────────────────────────────────────────────────────────
val F1Red = Color(0xFFE10600)          // --f1-red
val F1White = Color(0xFFFFFFFF)        // --f1-white

// ── Dark palette (faithful to the Figma design) ─────────────────────────
val F1DarkBg = Color(0xFF15151E)       // --f1-dark-bg   → background/surface
val F1DarkerBg = Color(0xFF0D0D14)     // --f1-darker-bg → lowest surface container
val F1CardBg = Color(0xFF1C1C28)       // --f1-card-bg   → cards, popovers, nav bar
val F1Grey = Color(0xFF38383F)         // --f1-grey      → borders, inputs, secondary
val F1LightGrey = Color(0xFF8E8E93)    // --f1-light-grey→ muted/secondary text

// ── Semantic ────────────────────────────────────────────────────────────
val F1Error = Color(0xFFD4183D)        // --destructive

// ── Light palette (derived — the Figma design is dark-only) ─────────────
val F1LightBg = Color(0xFFF6F6F9)      // soft off-white, cool tint to match brand
val F1LightSurfaceLow = Color(0xFFEDEDF2)
val F1LightCard = Color(0xFFFFFFFF)
val F1LightBorder = Color(0xFFDADAE2)
val F1LightMutedText = Color(0xFF6C6C76)
val F1InkText = Color(0xFF15151E)      // reuse of F1DarkBg hue as text color