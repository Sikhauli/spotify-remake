package com.example.spotifyandroidapp.helpers

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.spotifyandroidapp.data.LibraryData

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

@Composable
fun BoldText(text: String, fontSize: Int){
      Text(
      text = text,
      style = TextStyle(
      color = Color.Black,
      fontSize = fontSize.sp,
      fontWeight = FontWeight.Bold
    )
  )
}

@Composable
fun IconFun(iconResId: Int, width: Int, height: Int, modifier: Modifier = Modifier) {
  Icon(
    painter = painterResource(id = iconResId),
    contentDescription = null,
    modifier = Modifier
      .width(width.dp)
      .height(height.dp)
  )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTextField(
  modifier: Modifier = Modifier,
  query: TextFieldValue,
  onQueryChange: (TextFieldValue) -> Unit,
  placeholder: String = "Search...",
  backgroundColor: Color = Color.White,
  placeholderColor: Color = Color.Gray,
  focusedBorderColor: Color = MaterialTheme.colorScheme.primary,
  unfocusedBorderColor: Color = Color.Gray,
  shape : Shape = CircleShape,
  singleLine: Boolean = true,
) {
  OutlinedTextField(
    value = query,
    onValueChange = onQueryChange,
    modifier = modifier
      .fillMaxWidth()
      .padding(8.dp)
      .background(backgroundColor, shape = shape),
    placeholder = { Text(text = placeholder, color = placeholderColor) },
    maxLines = if (singleLine) 1 else Int.MAX_VALUE,
    singleLine = singleLine,
    shape = shape,
    colors = TextFieldDefaults.outlinedTextFieldColors(
      focusedBorderColor = focusedBorderColor,
      unfocusedBorderColor = unfocusedBorderColor,
    )
  )
}

@Composable
fun GridFunction(items: List<LibraryData>, itemsPerRow: Int) {
  Column(
    modifier = Modifier.fillMaxWidth()
  ) {
    items.chunked(itemsPerRow).forEach { rowItems ->
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
      ) {
        rowItems.forEach { item ->
          Box(
            modifier = Modifier
              .weight(1f)
              .padding(4.dp)
          ) {
            GridItem(
              imageUrl = item.img,
              albumName = item.album,
              type = item.type,
              itemsPerRow = itemsPerRow
            )
          }
        }
        repeat(itemsPerRow - rowItems.size) {
          Spacer(modifier = Modifier.weight(1f).padding(4.dp))
        }
      }
    }
  }
}

@Composable
fun GridItem(imageUrl: String, albumName: String, type: String, itemsPerRow: Int) {
  when (itemsPerRow) {
    1 -> {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .background(Color.Gray)
          .padding(8.dp)
      ) {
        Image(
          painter = rememberImagePainter(data = imageUrl),
          contentDescription = null,
          modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(Color.LightGray),
          contentScale = ContentScale.Crop
        )

        Text(
          text = albumName,
          color = Color.White,
          modifier = Modifier.padding(top = 8.dp, start = 8.dp),
          maxLines = 1,
          overflow = TextOverflow.Ellipsis,
          fontWeight = FontWeight.Bold,
          fontFamily = FontFamily.SansSerif,
        )

        Text(
          text = type,
          color = Color.White,
          modifier = Modifier.padding(start = 8.dp),
          maxLines = 1,
          overflow = TextOverflow.Ellipsis,
          fontWeight = FontWeight.Thin,
          fontFamily = FontFamily.SansSerif,
        )
      }
    }
    3 -> {
      Box(
        modifier = Modifier
          .fillMaxWidth()
          .background(Color.Gray)
          .aspectRatio(1f)
      ) {
        Image(
          painter = rememberImagePainter(data = imageUrl),
          contentDescription = null,
          modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.Transparent, shape = RoundedCornerShape(16.dp)),
          contentScale = ContentScale.Crop
        )

        Text(
          text = albumName,
          color = Color.White,
          modifier = Modifier.padding(top = 8.dp, start = 8.dp),
          maxLines = 1,
          overflow = TextOverflow.Ellipsis,
          fontWeight = FontWeight.Bold,
          fontFamily = FontFamily.SansSerif,
        )

        Text(
          text = type,
          color = Color.White,
          modifier = Modifier.padding(start = 8.dp),
          maxLines = 1,
          overflow = TextOverflow.Ellipsis,
          fontWeight = FontWeight.Thin,
          fontFamily = FontFamily.SansSerif,
        )
      }
    }
    else -> {
      Box(
        modifier = Modifier
          .fillMaxWidth()
          .background(Color.Gray)
          .aspectRatio(1f)
      ) {
        Image(
          painter = rememberImagePainter(data = imageUrl),
          contentDescription = null,
          modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.Transparent, shape = RoundedCornerShape(16.dp)),
          contentScale = ContentScale.Crop
        )

        Text(
          text = type,
          color = Color.White,
          modifier = Modifier
            .align(Alignment.TopStart)
            .padding(8.dp),
          textAlign = TextAlign.Start,
          fontFamily = FontFamily.SansSerif,
          fontWeight = FontWeight.Thin,
        )
      }
    }
  }
}

@Composable
fun ToggleIconFun(
  imageDrawable: Painter,
  width: Int,
  height: Int,
  onClick: () -> Unit,
  modifier: Modifier = Modifier
) {
  Icon(
    painter = imageDrawable,
    contentDescription = null,
    modifier = modifier
      .size(width.dp, height.dp)
      .clickable(onClick = onClick)
  )
}