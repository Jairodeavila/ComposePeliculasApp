package com.example.composepeliculasapp.data.network


import com.example.composepeliculasapp.data.dto.MovieResultDto
import com.example.composepeliculasapp.utils.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "en-ES"
    ): MovieResultDto

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("api_key") apiKey: String = "API_KEY",
        @Query("language") language: String = "es-ES"
    ): MovieResultDto


    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("api_key") apiKey: String = "API_KEY",
        @Query("language") language: String = "es-ES"
    ): MovieResultDto


    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(
        @Query("api_key") apiKey: String = "API_KEY",
        @Query("language") language: String = "es-ES"
    ): MovieResultDto

    @GET("trending/movie/day")
    suspend fun getTrendingMovies(
        @Query("api_key") apiKey: String = "API_KEY",
        @Query("language") language: String = "en-EN"
    ): MovieResultDto


}