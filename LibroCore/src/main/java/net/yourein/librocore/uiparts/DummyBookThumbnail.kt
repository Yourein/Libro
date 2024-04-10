package net.yourein.librocore.uiparts

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import net.yourein.librocore.theme.LibroSecondary

@Composable
fun DummyBookThumbnail(
    modifier: Modifier = Modifier
) {
    Canvas(modifier = modifier) {
        drawRoundRect(
            color = LibroSecondary,
            cornerRadius = CornerRadius(12F, 12F)
        )
    }
}