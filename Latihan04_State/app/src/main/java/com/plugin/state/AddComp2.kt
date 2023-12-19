package com.plugin.state.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AddComp2() {
        var nilai by remember {
            mutableStateOf<Int>(0)
        }
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Column {
                Text("Nilai Saat ini $nilai")
                Spacer(modifier = Modifier.height(30.dp))
                Button(onClick = {
                    nilai++;
                }) {
                    Text(text = "Add Nilai")
                }
            }

        }
}