package com.example.composepeliculasapp.data.network


import com.example.composepeliculasapp.data.dto.MovieResultDto
import com.example.composepeliculasapp.utils.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = "en-US"
    ): MovieResultDto
}