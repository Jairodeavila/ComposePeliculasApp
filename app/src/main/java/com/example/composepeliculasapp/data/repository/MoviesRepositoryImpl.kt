package com.example.composepeliculasapp.data.repository

import com.example.composepeliculasapp.data.dto.MovieResultDto
import com.example.composepeliculasapp.data.network.ApiService
import com.example.composepeliculasapp.domain.mappers.toDomainModel
import com.example.composepeliculasapp.domain.model.ModelMovies
import com.example.composepeliculasapp.domain.repository.MoviesRepository
import com.example.composepeliculasapp.utils.API_KEY
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): MoviesRepository{
    override suspend fun getPopularMovies(): List<ModelMovies> {
        val responseMovies = apiService.getPopularMovies(API_KEY)
        return responseMovies.results.toDomainModel()
    }
}


