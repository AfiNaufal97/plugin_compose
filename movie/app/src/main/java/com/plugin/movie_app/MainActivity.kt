package com.plugin.movie_app

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.plugin.movie_app.navigation.MovieNavigation
import com.plugin.movie_app.ui.theme.Movie_appTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Movie_appTheme {
                MyApp()
            }
        }
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun MyApp(){
    Surface(modifier = Modifier.fillMaxSize(), color = Color.Black) {
        MovieNavigation()
    }
}

