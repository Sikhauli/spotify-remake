package com.example.spotifyandroidapp.helpers

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
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
