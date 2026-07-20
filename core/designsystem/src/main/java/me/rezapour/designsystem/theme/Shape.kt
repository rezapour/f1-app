package me.rezapour.designsystem.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

/**
 * Shape tokens for the F1 Companion design system.
 *
 * Source: theme.css
 *   --radius: 0.5rem (= 8dp)
 *   --radius-sm: radius − 4px  → 4dp
 *   --radius-md: radius − 2px  → 6dp
 *   --radius-lg: radius        → 8dp
 *   --radius-xl: radius + 4px  → 12dp
 *
 * extraLarge (16dp) is derived to give bottom sheets / dialogs a
 * sensible Material default; the CSS does not define a value above xl.
 */
val F1Shapes = Shapes(
    extraSmall = RoundedCornerShape(4.dp),   // --radius-sm  (chips, small controls)
    small = RoundedCornerShape(6.dp),        // --radius-md  (buttons, inputs)
    medium = RoundedCornerShape(8.dp),       // --radius-lg  (cards)
    large = RoundedCornerShape(12.dp),       // --radius-xl  (large cards, images)
    extraLarge = RoundedCornerShape(16.dp),  // derived      (sheets, dialogs)
)