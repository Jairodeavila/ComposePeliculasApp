package com.example.composepeliculasapp.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.composepeliculasapp.domain.model.ModelMovies

@Composable
fun MovieItem(movie: ModelMovies, modifier: Modifier) {
    Row(modifier = Modifier.padding(16.dp)) {

        Column {
            Text(text = movie.title, style = MaterialTheme.typography.titleMedium)
            Text(text = "Popularidad: ${movie.popularity}", style = MaterialTheme.typography.bodyMedium)
            movie.releaseDate?.let { Text(text = it, style = MaterialTheme.typography.bodyMedium) }

        }

        Spacer(modifier = Modifier.height(8.dp))
        movie.posterPath?.let {
            val imageUrl = "https://image.tmdb.org/t/p/w500$it"
            Image(
                painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(imageUrl)
                        .crossfade(true)
                        .build()
                ),
                contentDescription = "Movie Poster",
                modifier = Modifier.width(100.dp).fillMaxHeight(),
                Alignment.CenterStart
            )
        }
    }
}