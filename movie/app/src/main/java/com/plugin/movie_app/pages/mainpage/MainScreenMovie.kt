package com.plugin.movie_app.pages
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.plugin.movie_app.data.DataOrException
import com.plugin.movie_app.model.MovieObject
import com.plugin.movie_app.pages.mainpage.MainMovieViewModel

@Composable
fun MainScreenMovie(navController: NavController, mainMovieViewModel: MainMovieViewModel = hiltViewModel()) {
    val product = produceState<DataOrException<MovieObject, Boolean, Exception>>(initialValue = DataOrException(loading = mainMovieViewModel.movies.value.loading) ){
       value = mainMovieViewModel.movies.value
    }.value

    Log.d("main", product.data.toString())

      Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text(text = "MainScreen", color = Color.White)
      }

}