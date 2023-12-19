package com.plugin.state

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AddComp() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column {
            Text("Nilai Saat ini 10")
            Spacer(modifier = Modifier.height(30.dp))
            Button(onClick = {

            }) {
                Text(text = "Add Nilai")
            }
        }

    }
}

@Preview(showBackground = true, name = "Stateless")
@Composable
fun ShowStateless(){
    AddComp()
}