package com.plugin.sepatu.widget

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CircleColorWidget(
    state: MutableState<Color>,
    color: Color,
    clicColor: (Color) -> Unit = {}
) {
    Surface(
        modifier = Modifier
            .size(50.dp)
            .padding(5.dp)
            .clickable {
                clicColor(color)
            },
        shape = CircleShape,
        border = if (state.value == color) BorderStroke(3.dp, Color.Gray) else BorderStroke(
            3.dp,
            Color.Transparent
        )
    ) {
        Box(
            Modifier
                .background(color = color)
        ) {

        }
    }
}