package com.example.composepeliculasapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composepeliculasapp.domain.model.ModelMovies
import com.example.composepeliculasapp.domain.usecase.GetPopularMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
): ViewModel() {

    private val _moviesState = MutableStateFlow<List<ModelMovies>>(emptyList())
    val moviesState: StateFlow<List<ModelMovies>> get() = _moviesState

    private val _isLoading = MutableStateFlow(false)
    val loadingState: StateFlow<Boolean> get() = _isLoading

    init {
        getPopularMovies()
    }

    fun getPopularMovies() {
        viewModelScope.launch {
            _isLoading.value = true

            val movies = getPopularMoviesUseCase.execute()

            _moviesState.value = movies

            _isLoading.value = false

        }
    }

}