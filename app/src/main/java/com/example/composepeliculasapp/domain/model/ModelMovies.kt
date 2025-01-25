package com.example.composepeliculasapp.domain.model

data class ModelMovies(
    val id: Int,
    val title: String,
    val overview: String,
    val posterPath: String?,
    val releaseDate: String?,
    val voteAverage: Double,
    val adult: Boolean,
    val popularity: Double,

)

