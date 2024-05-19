package com.example.spotifyandroidapp.helpers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
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

@Preview(showBackground = true)
@Composable
fun PreviewSearchTextField() {
  val query = remember { mutableStateOf(TextFieldValue("")) }
  SearchTextField(
    query = query.value,
    onQueryChange = { query.value = it }
  )
}
