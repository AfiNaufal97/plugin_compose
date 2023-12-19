package com.plugin.movie_app.di

import com.plugin.movie_app.service.MovieService
import com.plugin.movie_app.utils.Constanta
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun providesMovieService():MovieService{
        return Retrofit.Builder()
            .baseUrl(Constanta.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieService::class.java)
    }

}