package com.plugin.movieapps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.plugin.movieapps.navigator.ScreenNavigator
import com.plugin.movieapps.navigator.ScreenPages
import com.plugin.movieapps.ui.theme.MovieAppsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                ScreenNavigator()
            }
        }
    }
}

@Composable
fun MyApp(content:@Composable ()->Unit){
    MovieAppsTheme {
        content()
    }
}




