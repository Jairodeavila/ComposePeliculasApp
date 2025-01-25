package com.example.composepeliculasapp.presentation.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composepeliculasapp.presentation.ui.components.MovieItem
import com.example.composepeliculasapp.presentation.ui.components.MovieItemLayout
import com.example.composepeliculasapp.presentation.viewmodels.MoviesViewModel

@Composable
fun MoviesScreen(moviesViewmodel: MoviesViewModel = viewModel(), modifier: Modifier = Modifier) {
    val movies by moviesViewmodel.moviesState.collectAsState()
    val isLoading by moviesViewmodel.loadingState.collectAsState()

    LaunchedEffect(Unit) {
        moviesViewmodel.getPopularMovies()
    }

    if (isLoading) {
        CircularProgressIndicator()
    } else {
        LazyColumn(
            modifier = modifier.padding(16.dp)  // Agregar padding a LazyColumn
        ) {
            items(movies) { movie ->
                MovieItemLayout(movie)

            }
        }
    }
}






