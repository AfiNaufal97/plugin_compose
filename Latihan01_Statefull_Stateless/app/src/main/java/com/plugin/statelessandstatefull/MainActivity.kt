package com.plugin.statelessandstatefull

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plugin.statelessandstatefull.ui.theme.StatelessAndStatefullTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StatelessAndStatefullTheme {
                // A surface container using the 'background' color from the theme
                MainApps()
            }
        }
    }
}

@Composable
fun MainApps(){
    val nilai = remember {
        mutableStateOf(value = 0)
    }
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        color = MaterialTheme.colors.background
    ) {
        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "$ ${nilai.value}", fontSize = 20.sp)
            Spacer(modifier = Modifier.height(100.dp))
            ContentShow(nilai.value){ it ->
                nilai.value = it
            }
        }
    }
}


@Composable
fun ContentShow(value: Int = 0, function:(Int)->Unit){
    Card(modifier = Modifier
        .width(100.dp)
        .height(100.dp)
        .clickable {
            function(value+ 1)
        },
        backgroundColor = Color.Red,
        shape = CircleShape
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(text = "Click ke $value", color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StatelessAndStatefullTheme {

    }
}