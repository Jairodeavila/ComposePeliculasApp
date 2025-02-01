package com.example.composepeliculasapp.presentation.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.composepeliculasapp.presentation.ui.components.MovieItemLayout
import com.example.composepeliculasapp.presentation.viewmodels.MoviesViewModel

@Composable
fun MoviesScreen(
    navController: NavHostController,
    moviesViewmodel: MoviesViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val movies by moviesViewmodel.moviesState.collectAsState()
    val isLoading by moviesViewmodel.loadingState.collectAsState()

    LaunchedEffect(Unit) {
        moviesViewmodel.getPopularMovies()
    }

    if (isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }

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






