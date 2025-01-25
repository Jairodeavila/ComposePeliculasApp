package com.example.composepeliculasapp.domain.usecase

import com.example.composepeliculasapp.domain.model.ModelMovies
import com.example.composepeliculasapp.domain.repository.MoviesRepository
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(
    private val moviesRepository: MoviesRepository
) {
    suspend fun execute(): List<ModelMovies> {
        val movieResultDto = moviesRepository.getPopularMovies()
        return moviesRepository.getPopularMovies()
    }
}
