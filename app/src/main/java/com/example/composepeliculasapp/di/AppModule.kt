package com.example.composepeliculasapp.di

import com.example.composepeliculasapp.data.network.ApiService
import com.example.composepeliculasapp.data.repository.MoviesRepositoryImpl
import com.example.composepeliculasapp.domain.repository.MoviesRepository
import com.example.composepeliculasapp.domain.usecase.GetPopularMoviesUseCase

import com.example.composepeliculasapp.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideWeatherApi(): ApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

    }

    @Provides
    fun provideRepository(api: ApiService): MoviesRepository {
        return MoviesRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideGetMoviesUseCase(repository: MoviesRepository): GetPopularMoviesUseCase {
        return GetPopularMoviesUseCase(repository)
    }
}
