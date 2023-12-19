package com.plugin.movie_app.navigation
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.plugin.movie_app.pages.mainpage.MainMovieViewModel
import com.plugin.movie_app.pages.MainScreenMovie
import com.plugin.movie_app.pages.splashpage.SplashPage

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MovieScreen.SplashScreen.name ){
        composable(MovieScreen.SplashScreen.name){
            SplashPage(navController = navController)
        }

        composable(MovieScreen.MainScreen.name){
            val viewModel = hiltViewModel<MainMovieViewModel>()
            MainScreenMovie(navController = navController, viewModel)
        }
    }
}