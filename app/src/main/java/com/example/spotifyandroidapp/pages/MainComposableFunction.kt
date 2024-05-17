package com.example.spotifyandroidapp.pages

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.spotifyandroidapp.ui.rootNavigation

@Composable
fun MainComposableFunction(navController: NavHostController) {
  NavHost(navController, startDestination = "root") {
    rootNavigation(navController = navController)
  }
}
