package com.example.composepeliculasapp.data.network

import android.graphics.Movie
import retrofit2.http.GET

interface ApiService {
    @GET("movie/popular")
    fun getPopularMovies(

    ): List<Movie>
}