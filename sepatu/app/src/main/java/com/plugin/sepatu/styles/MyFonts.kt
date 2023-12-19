package com.plugin.sepatu.styles

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.plugin.sepatu.R

object FontStyles {
     val family = FontFamily(
        listOf(
            Font(R.font.bold, FontWeight.Bold),
            Font(R.font.semi_bold, FontWeight.SemiBold),
            Font(R.font.medium, FontWeight.Medium),
            Font(R.font.regular, FontWeight.Normal),
            Font(R.font.light, FontWeight.Light)
        )
    )
}