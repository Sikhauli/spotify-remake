package com.example.spotifyandroidapp.ui

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.spotifyandroidapp.pages.HomeScreen
import com.example.spotifyandroidapp.pages.WelcomeScreen

fun NavGraphBuilder.rootNavigation(navController: NavHostController) {
  navigation(startDestination = "welcome", route = "root") {
    composable("welcome") {
      WelcomeScreen(navController = navController)
    }
    composable("home") {
      HomeScreen(onBackPressed = {
        navController.popBackStack()
      })
    }
  }
}
