package com.plugin.movie_app.pages.mainpage

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plugin.movie_app.data.DataOrException
import com.plugin.movie_app.model.MovieObject
import com.plugin.movie_app.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainMovieViewModel @Inject constructor(private val repository: MovieRepository):ViewModel() {

    val movies = mutableStateOf<DataOrException<MovieObject, Boolean, Exception>>(
        DataOrException(null, null, Exception(""))
    )

    init {
        getMovie()
    }

    private fun getMovie(){
        viewModelScope.launch {
            if(movies.value.data.toString().isEmpty()) movies.value.loading = true
            movies.value = repository.getMovie()
            if(movies.value.data.toString().isNotEmpty()) movies.value.loading = false
            Log.d("A", movies.value.data.toString())
        }

    }
}