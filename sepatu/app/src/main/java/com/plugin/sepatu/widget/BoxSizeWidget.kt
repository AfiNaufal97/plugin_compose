package com.plugin.sepatu.widget

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun BoxSizeWidget(
    state: MutableState<Int>,
    text: Int,
    modifier: Modifier,
    color: Color,
    weight: FontWeight,
    fontSize: Int,
    size: (Int) -> Unit = {},
) {
    Surface(
        modifier = Modifier
            .width(47.dp)
            .height(47.dp)
            .padding(end = 10.dp)
            .clickable {
                size(text)
            },
        shape = RoundedCornerShape(10.dp),
        color = if (state.value == text) Color.White else Color.Transparent,
        border = if (state.value == text) BorderStroke(1.dp, Color.Gray) else BorderStroke(
            1.dp,
            Color.Transparent
        ),

        ) {
        Box(contentAlignment = Alignment.Center) {
            TextWidget(
                modifier = modifier,
                text = text.toString(),
                color = color,
                weight = weight,
                size = fontSize
            )
        }

    }
}