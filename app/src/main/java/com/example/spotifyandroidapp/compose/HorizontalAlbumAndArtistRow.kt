package com.example.spotifyandroidapp.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.spotifyandroidapp.data.CategoryData
import com.example.spotifyandroidapp.helpers.LimitedText
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil.CoilImage

@Preview
@Composable
fun RowAlbumItems(
  modifier: Modifier = Modifier,
  item: CategoryData,
  maxCharacters: Int = 10,
) {
  Box(
    modifier = modifier
      .width(120.dp)
      .padding(4.dp)
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 8.dp),
      verticalArrangement = Arrangement.Top,
    ) {

      Image(
        painter = rememberImagePainter(data = item.img),
        contentDescription = "Album",
        contentScale = ContentScale.Crop,
        modifier = Modifier
          .size(120.dp)
          .background(shape = CircleShape, color = Color.Black)
      )

      LimitedText(
        text = item.artist,
        maxCharacters = maxCharacters
      )
      Text(
        text = item.album,
        fontSize = 12.sp,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily.SansSerif
      )
    }
  }
}

@Composable
fun RowAlbumScrollView(
  modifier: Modifier = Modifier,
  items: List<CategoryData>,
  maxCharacters: Int = 10,
) {
  Row(
    modifier = modifier
      .padding(horizontal = 10.dp)
      .horizontalScroll(rememberScrollState()),
    horizontalArrangement = Arrangement.spacedBy(8.dp),
  ) {
    items.forEach { item ->
      RowAlbumItems(
        item = item,
        maxCharacters = maxCharacters
      )
    }
  }
}
