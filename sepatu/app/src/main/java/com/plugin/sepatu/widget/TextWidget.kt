package com.plugin.sepatu.widget

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.plugin.sepatu.styles.FontStyles

@Composable
fun TextWidget(
    modifier: Modifier,
    text: String,
    color: Color,
    weight: FontWeight,
    size: Int
) {
    Text(
        modifier = modifier,
        text = text, style = TextStyle(
            fontWeight = weight,
            fontSize = size.sp,
            color = color,
            fontFamily = FontStyles.family
        )
    )
}