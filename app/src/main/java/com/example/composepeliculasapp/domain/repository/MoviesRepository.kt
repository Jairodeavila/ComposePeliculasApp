package com.example.composepeliculasapp.domain.repository

import com.example.composepeliculasapp.data.dto.MovieResultDto
import com.example.composepeliculasapp.domain.model.ModelMovies

interface MoviesRepository{
    suspend fun getPopularMovies(): List<ModelMovies>
    suspend fun getTopRatedMovies(): List<ModelMovies>
    suspend fun getUpcomingMovies(): List<ModelMovies>
    suspend fun getNowPlayingMovies(): List<ModelMovies>
    suspend fun getTrendingMovies(): List<ModelMovies>

}

