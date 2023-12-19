package com.plugin.movie_app.service

import com.plugin.movie_app.model.MovieObject
import com.plugin.movie_app.utils.Constanta
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface MovieService {
    @GET("movie/550")
    suspend fun getMovie(
        @Query("api_key") api_key: String = Constanta.API_KEY
    ):MovieObject
}