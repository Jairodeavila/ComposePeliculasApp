package com.example.composepeliculasapp.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.composepeliculasapp.domain.model.ModelMovies


@Composable
fun MovieItemLayout(movie: ModelMovies, modifier: Modifier = Modifier) {

    ConstraintLayout(
        modifier = modifier
            .padding(16.dp)
            .fillMaxHeight()
    ) {
        val (tittle,  popularity, poster) = createRefs()

        Text(
            text = movie.title,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.constrainAs(tittle) {
                top.linkTo(parent.top)
                start.linkTo(poster.end, margin = 5.dp)
            })
        Text(
            text = "Popularidad: ${movie.popularity}",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.constrainAs(popularity){
                top.linkTo(tittle.bottom)
                start.linkTo(poster.end, margin = 5.dp)
            })
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
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(150.dp)
                    .height(200.dp)
                    .constrainAs(poster){
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }

            )
        }

    }
}