package com.plugin.movie_app.repository

import com.plugin.movie_app.data.DataOrException
import com.plugin.movie_app.model.MovieObject
import com.plugin.movie_app.service.MovieService
import javax.inject.Inject


class MovieRepository @Inject constructor(private val movieService: MovieService) {
  suspend fun getMovie():DataOrException<MovieObject, Boolean, Exception>{
      val response = try{
          movieService.getMovie()
      }catch(e:Exception){
          return DataOrException(exception = e)
      }
      return DataOrException(data = response)
  }


}