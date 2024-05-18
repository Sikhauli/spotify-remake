package com.example.spotifyandroidapp.compose

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.spotifyandroidapp.helpers.Screen
import com.example.spotifyandroidapp.pages.HomeScreen

@Composable
fun BottomNavigationMainScreen() {
  val navController = rememberNavController()
  Scaffold(
    bottomBar = { BottomNavigationBar(navController) }
  ) { innerPadding ->
    NavigationGraph(navController, Modifier.padding(innerPadding))
  }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
  val items = listOf(
    Screen.Home,
    Screen.Search,
    Screen.Library,
    Screen.Profile
  )
  NavigationBar {
    val currentRoute = currentRoute(navController)
    items.forEach { screen ->
      NavigationBarItem(
        icon = { Icon(imageVector = screen.icon, contentDescription = screen.label) },
        label = { Text(screen.label) },
        selected = currentRoute == screen.route,
        onClick = {
          navController.navigate(screen.route) {
            popUpTo(navController.graph.startDestinationRoute!!) {
              saveState = true
            }
            launchSingleTop = true
            restoreState = true
          }
        }
      )
    }
  }
}

@Composable
fun NavigationGraph(navController: NavHostController, padding: Any) {
  NavHost(navController, startDestination = Screen.Home.route) {
    composable(Screen.Home.route) { HomeScreen() }
    composable(Screen.Search.route) { SearchScreen() }
    composable(Screen.Library.route) { LibraryScreen() }
    composable(Screen.Profile.route) { ProfileScreen() }
  }
}

@Composable
fun SearchScreen() {
  // Content for Search Screen
  Text("Search Screen")
}

@Composable
fun LibraryScreen() {
  // Content for Library Screen
  Text("Library Screen")
}

@Composable
fun ProfileScreen() {
  // Content for Library Screen
  Text("Profile Screen")
}

@Composable
fun currentRoute(navController: NavHostController): String? {
  val navBackStackEntry by navController.currentBackStackEntryAsState()
  return navBackStackEntry?.destination?.route
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
  BottomNavigationMainScreen()
}
