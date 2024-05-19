package com.example.spotifyandroidapp.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.spotifyandroidapp.R

@Preview
@Composable
fun ProfileScreen() {
  Box(
    modifier = Modifier
      .fillMaxSize(),
    contentAlignment = Alignment.Center
  ) {
    Image(
      painter = painterResource(R.drawable.lavender_gradient_wallpaper_scaled),
      contentDescription = "login background image",
      contentScale = ContentScale.FillBounds,
      modifier = Modifier.fillMaxSize()
    )
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .align(Alignment.Center)
        .verticalScroll(rememberScrollState()),
    ) {
      Column(
        modifier = Modifier.padding(6.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
      ) {
        GreetingsRow()
        WelcomeText()
        GenreScrollView()
        MadeForYouScrollView()
        AlbumScrollView()
        MusicCategoryRow()
      }
    }
  }
}
