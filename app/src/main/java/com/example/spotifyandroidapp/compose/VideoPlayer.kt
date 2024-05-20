package com.example.spotifyandroidapp.compose

import android.net.Uri
import androidx.annotation.OptIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView

@OptIn(UnstableApi::class)
@Composable
fun VideoPlayer(uri: Uri, modifier: Modifier = Modifier) {
  val context = LocalContext.current

  // Create an ExoPlayer instance
  val exoPlayer = remember {
    ExoPlayer.Builder(context).build().apply {
      setMediaItem(MediaItem.fromUri(uri))
      prepare()
      playWhenReady = true
    }
  }

  // Dispose of the ExoPlayer instance when the composable is disposed
  DisposableEffect(
    AndroidView(
      factory = {
        PlayerView(context).apply {
          player = exoPlayer
          useController = false // Hide controls if desired
          setShutterBackgroundColor(Color.Black.toArgb())
        }
      },
      modifier = modifier
    )
  ) {
    onDispose {
      exoPlayer.release()
    }
  }
}

@Preview
@Composable
fun VideoThumbnail(uri: String) {
  val videoUri = Uri.parse(uri)
  Column(
    modifier = Modifier
      .height(180.dp)
      .width(95.dp)
      .background(color = Color.Transparent)
  ) {
    VideoPlayer(
      uri = videoUri,
      modifier = Modifier
        .height(180.dp)
        .background(shape = RoundedCornerShape(10.dp), color = Color.Transparent)
    )
  }
}


