package com.plugin.dropdown

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.plugin.dropdown.ui.theme.DropdownTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DropdownTheme {
                Menu()
            }
        }
    }
}

@Composable
fun Menu() {
    var state by remember {
        mutableStateOf(false)
    }

    Row(modifier = Modifier.clickable {
        state = !state
    }) {
        Text(text = "Menu")
        Icon(Icons.Default.MoreVert, contentDescription = "")
    }

    DropdownMenu(expanded = state, onDismissRequest = {
        state = false
    }) {
        DropdownMenuItem(onClick = { state = false }) {
            Text(text = "About")
        }
        DropdownMenuItem(onClick = { state = false }) {
            Text(text = "About")
        }
        DropdownMenuItem(onClick = { state = false }) {
            Text(text = "About")
        }

    }

}
