package com.plugin.movie_app.pages.splashpage

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import com.plugin.movie_app.navigation.MovieScreen
import kotlinx.coroutines.*

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SplashPage(navController: NavController) {

    val composableScope = rememberCoroutineScope()

    composableScope.launch {
        delay(3000)
        navController.navigate(MovieScreen.MainScreen.name)
    }



    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
        )

    }

}