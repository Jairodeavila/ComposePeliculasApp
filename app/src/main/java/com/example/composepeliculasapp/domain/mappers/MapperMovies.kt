package com.example.composepeliculasapp.domain.mappers

import com.example.composepeliculasapp.data.dto.MovieDTO
import com.example.composepeliculasapp.domain.model.ModelMovies

fun List<MovieDTO>.toDomainModel(): List<ModelMovies> {
    return this.map { dto ->
        ModelMovies(
            id = dto.id,
            title = dto.title,
            overview = dto.overview,
            posterPath = dto.posterPath,
            releaseDate = dto.releaseDate,
            voteAverage = dto.voteAverage,
            adult = dto.adult,
            popularity = dto.popularity
        )
    }
}


