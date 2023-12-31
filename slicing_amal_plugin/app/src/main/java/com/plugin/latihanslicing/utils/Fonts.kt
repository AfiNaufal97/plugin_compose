package com.plugin.latihanslicing.utils

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.plugin.latihanslicing.R

object Fonts {
    val fonts = FontFamily(
        Font(R.font.poppins_regular, weight = FontWeight.Normal),
        Font(R.font.poppins_bold, weight = FontWeight.Bold),
        Font(R.font.poppins_semibold, weight = FontWeight.SemiBold)
    )
}