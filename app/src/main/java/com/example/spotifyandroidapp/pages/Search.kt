package com.example.spotifyandroidapp.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.spotifyandroidapp.R
import com.example.spotifyandroidapp.compose.RowAlbumScrollView
import com.example.spotifyandroidapp.data.madeForYouCategories
import com.example.spotifyandroidapp.helpers.BoldText
import com.example.spotifyandroidapp.helpers.IconFun
import com.example.spotifyandroidapp.helpers.SearchTextField

@Preview
@Composable
fun SearchScreen() {
  val query = remember { mutableStateOf(TextFieldValue("")) }
  Box(
    modifier = Modifier
      .fillMaxSize(),
    contentAlignment = Alignment.Center,
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
        .align(Alignment.Center),

    ) {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 16.dp, vertical = 8.dp)
      ) {
        TopRow()
        SearchTextField(
          query = query.value,
          onQueryChange = { query.value = it },
          placeholder = "Search for items...",
          backgroundColor = Color.LightGray,
          placeholderColor = Color.DarkGray,
          focusedBorderColor = Color.Transparent,
          unfocusedBorderColor = Color.DarkGray,
          shape = RoundedCornerShape(8.dp),
          singleLine = true,
          modifier = Modifier
            .padding(vertical = 12.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Column(
          modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .fillMaxHeight()
            .border(2.dp, Color.Red, shape = RectangleShape)
            .verticalScroll(rememberScrollState()),
        ) {
          BoldText("Explore your genre", 16)
          RowAlbumScrollView(
            items = madeForYouCategories,
            maxCharacters = 10,
            modifier = Modifier.fillMaxWidth()
          )
        }
      }
    }
  }
}

@Composable
fun TopRow(){
  Row(
    modifier = Modifier
      .padding(0.dp),
    verticalAlignment = Alignment.CenterVertically
  ) {
    IconFun(R.drawable.icons_spotify_24, 34, 34 )
    Spacer(modifier = Modifier.width(6.dp))
    Column {
      BoldText( "sikhauli" , 22 )
    }
    Spacer(modifier = Modifier.weight(1f))
    IconFun(R.drawable.icons_notification, 24, 24, modifier = Modifier
      .background(Color.LightGray, shape = CircleShape) )
  }
}
