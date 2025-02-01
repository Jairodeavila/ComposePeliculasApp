package com.example.composepeliculasapp.presentation.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composepeliculasapp.presentation.ui.components.BottomAppBarExample
import com.example.composepeliculasapp.presentation.ui.screens.MoviesScreen

@Composable
fun MyApp() {
    val navController = rememberNavController()
    Scaffold(bottomBar = { BottomAppBarExample(navController) }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(paddingValues)
        ) {
            composable("movies") { MoviesScreen(navController) }
            composable("home") { HomeScreen(navController) }
            composable("profile") { ProfileScreen(navController) }
            composable("favorites") { FavoritesScreen(navController) }
        }
    }
    }




@Composable
fun FavoritesScreen(navController: NavHostController) {
    // Simple placeholder for now
    Text(text = "Favorites Screen - Under Construction")
}

@Composable
fun ProfileScreen(navController: NavHostController) {
    // Simple placeholder for now
    Text(text = "Profile Screen - Under Construction")
}

@Composable
fun HomeScreen(navController: NavHostController) {
    // Simple placeholder for now
    Text(text = "Home Screen - Under Construction")
}
