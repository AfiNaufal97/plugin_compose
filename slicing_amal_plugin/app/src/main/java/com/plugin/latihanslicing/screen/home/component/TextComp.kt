package com.plugin.latihanslicing.screen.home.component

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

import com.plugin.latihanslicing.utils.Fonts

@Composable
fun TextComp(text:String, color: Color, fontWeight: FontWeight, fontSize:TextUnit) {
    Text(text = text, style = TextStyle(
        fontFamily = Fonts.fonts,
        color=color,
        fontWeight = fontWeight,
        fontSize = fontSize
    ))
}