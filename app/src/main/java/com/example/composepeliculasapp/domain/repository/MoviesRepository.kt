package com.example.composepeliculasapp.domain.repository

import com.example.composepeliculasapp.data.dto.MovieResultDto
import com.example.composepeliculasapp.domain.model.ModelMovies

interface MoviesRepository{
    suspend fun getPopularMovies(): List<ModelMovies>
}

