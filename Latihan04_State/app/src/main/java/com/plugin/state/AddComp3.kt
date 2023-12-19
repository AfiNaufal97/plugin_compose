package com.plugin.state

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AddComp3() {
    val nilai  =  remember {
        mutableStateOf<Int>(0)
    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column {
            Text("Nilai Saat ini ${nilai.value}")
            Spacer(modifier = Modifier.height(30.dp))
            Button(onClick = {
                nilai.value++;
            }) {
                Text(text = "Add Nilai")
            }
        }

    }
}