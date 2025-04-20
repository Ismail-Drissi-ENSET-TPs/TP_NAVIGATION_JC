package com.tp.atelier.navig.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

object Gradients {
    val primaryGradient = Brush.linearGradient(
        colors = listOf(
            Color(0xFF435577),
            Color(0xFF435510)
        )
    )

    val backgroundGradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFFFFFFF),
            Color(0xFFF8F8F8)
        )
    )
}
