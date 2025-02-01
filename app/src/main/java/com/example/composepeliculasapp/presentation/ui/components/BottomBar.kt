package com.example.composepeliculasapp.presentation.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController



@Composable
fun BottomAppBarExample(navController: NavHostController) {
    BottomAppBar(modifier = Modifier.fillMaxWidth(), containerColor = Color.White,) {
        IconButton(
            onClick = {navController.navigate("home")}, modifier = Modifier.weight(1f)) {
            Icon(Icons.Filled.Home, contentDescription = "Build Description",
                tint = Color.Black)
        }

        IconButton(onClick = { navController.navigate("movies") }, modifier = Modifier.weight(1f)) {
            Icon(Icons.Filled.Search, contentDescription = "Menu Description",
                tint = Color.DarkGray,
                modifier = Modifier.weight(1f))
        }
        IconButton(onClick = { navController.navigate("favorites") }, modifier = Modifier.weight(1f)) {
            Icon(Icons.Filled.Star, contentDescription = "Favorite Description",
                tint = Color.Yellow,
                modifier = Modifier.weight(1f))
        }

        IconButton(onClick = { navController.navigate("profile") }, modifier = Modifier.weight(1f)) {
            Icon(Icons.Filled.Person, contentDescription = "Favorite Description",
                tint = Color.Black,
                modifier = Modifier.weight(1f))
        }

    }
}