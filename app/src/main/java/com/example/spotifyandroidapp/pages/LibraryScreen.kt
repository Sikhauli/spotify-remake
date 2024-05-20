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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spotifyandroidapp.R
import com.example.spotifyandroidapp.data.browseAll
import com.example.spotifyandroidapp.helpers.BoldText
import com.example.spotifyandroidapp.helpers.GridFunction
import com.example.spotifyandroidapp.helpers.IconFun
import com.example.spotifyandroidapp.helpers.ToggleIconFun

@Preview
@Composable
fun LibraryScreen() {
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
        TopRowFunction()
        GenreScrollViewFunction()
        Spacer(modifier = Modifier.height(0.dp))
        Column(
          modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(rememberScrollState()),
        ) {
          Spacer(modifier = Modifier.height(6.dp))
          Column(
            modifier = Modifier
              .fillMaxWidth()
              .fillMaxHeight()
          ) {
            LibraryRows()
          }
        }
      }
    }
  }
}

@Composable
fun TopRowFunction(){
  Row(
    modifier = Modifier
      .padding(0.dp),
    verticalAlignment = Alignment.CenterVertically
  ) {
    IconFun(R.drawable.icons_spotify_24, 34, 34 )
    Spacer(modifier = Modifier.width(6.dp))
    Column {
      BoldText( "Your Library" , 22 )
    }
    Spacer(modifier = Modifier.weight(1f))
    IconFun(R.drawable.icons_search, 24, 24, modifier = Modifier
      .background(Color.LightGray, shape = CircleShape) )
    Spacer(modifier = Modifier.width(16.dp))
    IconFun(R.drawable.icons_add, 24, 24, modifier = Modifier
      .background(Color.LightGray, shape = CircleShape) )
  }
}

@Composable
fun GenreScrollViewFunction() {
  val categories = listOf("Artist", "Album", "Playlist")
  Row(
    modifier = Modifier
      .padding(horizontal = 10.dp, vertical = 16.dp)
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
fun LibraryRows() {

  var gridValue by remember { mutableIntStateOf(1) }

  Column(
    modifier = Modifier
      .fillMaxWidth()
  ) {

    Row(
      modifier = Modifier
        .padding(0.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      IconFun(R.drawable.icons_sorting_arrows, 18, 18 )
      Spacer(modifier = Modifier.width(6.dp))
      Column {
        BoldText( "Recents" , 16 )
      }
      Spacer(modifier = Modifier.weight(1f))
      ToggleIconFun(
        imageDrawable = painterResource(id = R.drawable.icons_adjust),
        width = 18,
        height = 18,
        onClick = {
          gridValue = if (gridValue == 1) 3 else 1
        }
      )
    }
    Row(
      modifier = Modifier
        .fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween
    ) {
      GridFunction(items = browseAll, itemsPerRow = gridValue)
    }
  }
}



@Preview(showBackground = true)
@Composable
fun PreviewGridExamples() {
  LibraryRows()
}