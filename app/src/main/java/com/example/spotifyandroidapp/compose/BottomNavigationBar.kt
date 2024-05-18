//package com.example.spotifyandroidapp.compose
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Icon
//import androidx.compose.material3.NavigationBar
//import androidx.compose.material3.NavigationBarItem
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.runtime.*
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.*
//import com.example.spotifyandroidapp.helpers.Screen
//import com.example.spotifyandroidapp.pages.HomeScreen
//
//@Composable
//fun BottomNavigationMainScreen() {
//  val navController = rememberNavController()
//  Scaffold(
//    bottomBar = {
//      BottomNavigationBar(
//        navController = navController,
//        modifier = Modifier
//          .padding(10.dp)
//          .clip(RoundedCornerShape(20.dp))
//          .border(width = 1.dp, color = Color.Transparent, shape = RoundedCornerShape(20.dp))
//          .background(Color.Transparent)
//      )
//    }
//  ) { innerPadding ->
//    NavigationGraph(navController, Modifier.padding(innerPadding))
//  }
//}
//
//@Composable
//fun BottomNavigationBar(navController: NavHostController, modifier: Modifier = Modifier) {
//  val items = listOf(
//    Screen.Home,
//    Screen.Search,
//    Screen.Library,
//    Screen.Profile
//  )
//  NavigationBar(
//    modifier = modifier
//      .background(Color.Transparent)
//  ) {
//    val currentRoute = currentRoute(navController)
//    items.forEach { screen ->
//      NavigationBarItem(
//        icon = {
//          Icon(imageVector = screen.icon, contentDescription = screen.label)
//        },
//        label = { Text(screen.label) },
//        selected = currentRoute == screen.route,
//        onClick = {
//          navController.navigate(screen.route) {
//            popUpTo(navController.graph.startDestinationRoute!!) {
//              saveState = true
//            }
//            launchSingleTop = true
//            restoreState = true
//          }
//        }
//      )
//    }
//  }
//}
//
//@Composable
//fun NavigationGraph(navController: NavHostController, modifier: Modifier) {
//  NavHost(navController, startDestination = Screen.Home.route) {
//    composable(Screen.Home.route) { HomeScreen() }
//    composable(Screen.Search.route) { SearchScreen() }
//    composable(Screen.Library.route) { LibraryScreen() }
//    composable(Screen.Profile.route) { ProfileScreen() }
//  }
//}
//
//@Composable
//fun SearchScreen() {
//  // Content for Search Screen
//  Text("Search Screen")
//}
//
//@Composable
//fun LibraryScreen() {
//  // Content for Library Screen
//  Text("Library Screen")
//}
//
//@Composable
//fun ProfileScreen() {
//  // Content for Profile Screen
//  Text("Profile Screen")
//}
//
//@Composable
//fun currentRoute(navController: NavHostController): String? {
//  val navBackStackEntry by navController.currentBackStackEntryAsState()
//  return navBackStackEntry?.destination?.route
//}
//
//@Preview(showBackground = true)
//@Composable
//fun PreviewMainScreen() {
//  BottomNavigationMainScreen()
//}
//




package com.example.spotifyandroidapp.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.spotifyandroidapp.helpers.Screen
import com.example.spotifyandroidapp.pages.HomeScreen
import kotlin.math.roundToInt

@Composable
fun BottomNavigationMainScreen() {
  val navController = rememberNavController()

  // Define bottom bar height and scroll related variables
  val bottomBarHeight = 76.dp
  val bottomBarHeightPx = with(LocalDensity.current) { bottomBarHeight.roundToPx().toFloat() }
  val bottomBarOffsetHeightPx = remember { mutableFloatStateOf(0f) }

  // Connection to the nested scroll system
  val nestedScrollConnection = remember {
    object : NestedScrollConnection {
      override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
        val delta = available.y
        val newOffset = bottomBarOffsetHeightPx.floatValue + delta
        bottomBarOffsetHeightPx.floatValue = newOffset.coerceIn(-bottomBarHeightPx, 0f)
        return Offset.Zero
      }
    }
  }

  Scaffold(
    modifier = Modifier
      .nestedScroll(nestedScrollConnection),
    bottomBar = {
      BottomAppBar(
        modifier = Modifier
          .padding(horizontal = 8.dp, vertical = 8.dp)
          .height(bottomBarHeight)
          .offset { IntOffset(x = 0, y = -bottomBarOffsetHeightPx.floatValue.roundToInt()) }
          .clip(RoundedCornerShape(20.dp))
          .border(width = 2.dp, color = Color.Transparent, shape = RoundedCornerShape(20.dp))
      ) {
        BottomNavigationBar(
          navController = navController,
        )
      }
    },
    content = { innerPadding ->
      NavigationGraph(navController = navController, modifier = Modifier.padding(innerPadding))
    }
  )
}

@Composable
fun BottomNavigationBar(navController: NavHostController, modifier: Modifier = Modifier) {
  val items = listOf(
    Screen.Home,
    Screen.Search,
    Screen.Library,
    Screen.Profile
  )

  NavigationBar(modifier = modifier
    .background(Color.Transparent)
  ) {
    val currentRoute = currentRoute(navController)
    items.forEach { screen ->
      NavigationBarItem(
        icon = {
          Icon(imageVector = screen.icon, contentDescription = screen.label)
        },
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
fun NavigationGraph(navController: NavHostController, modifier: Modifier) {
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
  // Content for Profile Screen
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
