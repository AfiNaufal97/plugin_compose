package com.plugin.state

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RadioComp() {
//    val isTrue = remember{
//        mutableStateOf<Boolean>(false)
//    }

    var isTrue = false
    Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
        RadioButton(selected = isTrue, onClick = {
            isTrue = !isTrue
        })
        Spacer(modifier = Modifier.width(10.dp))
        Text("Value")
    }
}