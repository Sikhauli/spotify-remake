package com.example.spotifyandroidapp.helpers

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun LimitedText(text: String, maxCharacters: Int = 10) {
  val displayedText = if (text.length > maxCharacters) {
    text.take(maxCharacters) + "..."
  } else {
    text
  }
  Text(
    text = displayedText,
    fontSize = 16.sp,
    textAlign = TextAlign.Center,
    fontWeight = FontWeight.Bold,
    fontFamily = FontFamily.SansSerif,
    color = Color.Black
  )
}


sealed class Screen(val route: String, val label: String, val icon: ImageVector) {
  data object Home : Screen("home", "Home", Icons.Default.Home)
  data object Search : Screen("search", "Search", Icons.Default.Search)
  data object Library : Screen("library", "Library", Icons.Default.Home)
  data object Profile : Screen("profile", "Profile", Icons.Default.Search)
}
