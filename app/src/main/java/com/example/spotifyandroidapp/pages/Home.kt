package com.example.spotifyandroidapp.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spotifyandroidapp.R
import com.example.spotifyandroidapp.compose.RowAlbumScrollView
import com.example.spotifyandroidapp.compose.RowScrollView
import com.example.spotifyandroidapp.data.madeForYouCategories
import com.example.spotifyandroidapp.data.sampleMusicCategories


@Composable
fun HomeScreen() {
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
  @Composable
  fun GreetingsRow(){
    Row(
      modifier = Modifier
        .padding(10.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      Icon(
        painter = painterResource(id = R.drawable.icons_spotify_24),
        contentDescription = "Spotify Logo",
        modifier = Modifier
          .width(34.dp)
          .height(34.dp)
      )
      Spacer(modifier = Modifier.width(8.dp))
      Column {
        BasicText(
          text = "Good Morning!",
          style = TextStyle(
            color = Color.Black,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
          ),
          modifier = Modifier.padding(bottom = 0.dp)
        )
        BasicText(
          text = "Sikhauli",
          style = TextStyle(
            color = Color.Black,
            fontSize = 10.sp,
            fontWeight = FontWeight.Normal
          )
        )
      }
      Spacer(modifier = Modifier.weight(1f))
      Icon(
        painter = painterResource(id = R.drawable.icons_notification),
        contentDescription = "Notification Icon",
        modifier = Modifier
          .background(Color.LightGray, shape = CircleShape)
          .width(24.dp)
          .height(24.dp)

      )
    }
  }

  @Composable
  fun WelcomeText(){
    Column(
      modifier = Modifier.padding(10.dp),
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Text(
        text = "Welcome to Spotify, World of music",
        style = TextStyle(
          color = Color.Black,
          fontSize = 34.sp,
          fontWeight = FontWeight.Bold,
          fontFamily = FontFamily.SansSerif,
        )
      )
    }
  }


@Composable
fun GenreScrollView() {
  val categories = listOf("All", "Music", "Podcast", "Radio", "R&B", "Rap", "Soul", "Jazz", "Gospel")
  Row(
    modifier = Modifier
      .padding(horizontal = 10.dp)
      .horizontalScroll(rememberScrollState()),
    horizontalArrangement = Arrangement.spacedBy(8.dp),
    verticalAlignment = Alignment.CenterVertically,

  )
  {
    categories.forEach { category ->
      Text(
        text = category,
        modifier = Modifier
          .padding(horizontal = 0.dp, vertical = 8.dp)
          .background(Color.LightGray, shape = RoundedCornerShape(6.dp))
          .padding(8.dp)
          .width(width = 60.dp)
          .height(height = 22.dp),
        style = TextStyle(
          color = Color.Black,
          fontSize = 16.sp,
          fontWeight = FontWeight.Normal
        ),
         textAlign = TextAlign.Center
      )
    }
  }
}

@Composable
fun MadeForYouText(text : String ){
  Row(
    modifier = Modifier
      .padding(vertical = 6.dp, horizontal = 10.dp)
      .fillMaxWidth()
      .wrapContentHeight(),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    Text(
      text = text,
      fontSize = 18.sp,
      textAlign = TextAlign.Center,
      fontWeight = FontWeight.Bold,
      fontFamily = FontFamily.SansSerif,
      color = Color.Black,
    )
  }
}
//RowAlbumScrollView
@Composable
fun MadeForYouScrollView() {
  MadeForYouText("Made for you")
  RowScrollView(
    items = madeForYouCategories,
    maxCharacters = 10,
    modifier = Modifier.fillMaxWidth()
  )
}

@Composable
fun AlbumScrollView() {
  MadeForYouText("Album for you")
  RowAlbumScrollView(
    items = madeForYouCategories,
    maxCharacters = 10,
    modifier = Modifier.fillMaxWidth()
  )
}

@Composable
fun MusicCategoryRow() {
  MadeForYouText("Made for me")
  RowScrollView(
    items = sampleMusicCategories,
    maxCharacters = 10,
    modifier = Modifier.fillMaxWidth()
  )
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
  HomeScreen()
}
