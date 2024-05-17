package com.example.spotifyandroidapp.pages

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.spotifyandroidapp.R

@Preview
@Composable
fun WelcomeScreen(navController: NavHostController) {
  Box(
    modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center
  ) {
    Image(
      painter = painterResource(R.drawable.login),
      contentDescription = "Welcome screen background image",
      contentScale = ContentScale.FillBounds,
      modifier = Modifier.fillMaxSize()
    )

    Box(
      modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .align(Alignment.Center)
    ) {
      Column(
        modifier = Modifier
          .fillMaxHeight(0.5f)
          .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        TextAndImageColumn()
      }
      Spacer(modifier = Modifier.height(0.dp))
      Column(
        modifier = Modifier
          .fillMaxHeight(0.5f)
          .padding(16.dp)
          .align(Alignment.BottomStart),
      ) {
        LoginButton( navController = navController)
        Spacer(modifier = Modifier.height(16.dp))
        RegisterButton( navController = navController)
      }
      Column(
        modifier = Modifier
          .fillMaxHeight()
          .padding(16.dp)
          .align(Alignment.BottomStart),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        TermsAndConditionFunction()
      }
    }
  }
}

@Composable
fun TextAndImageColumn() {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .height(200.dp),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Image(
      painter = painterResource(R.drawable.spotify_logo_black),
      contentDescription = "Sportify logo Image",
      modifier = Modifier
        .padding(bottom = 8.dp)
    )
    BasicText(
      text = "Millions of songs,",
      style = TextStyle(
        color = Color.Black,
        fontFamily = FontFamily.SansSerif,
        fontSize = 32.sp
      )
    )
    BasicText(
      text = "Free on sportify",
      style = TextStyle(
        color = Color.Black,
        fontFamily = FontFamily.SansSerif,
        fontSize = 32.sp
      )
    )
  }
}

@Composable
fun LoginButton(navController: NavHostController) {
  Button(
    onClick = { navController.navigate("home")  },
    modifier = Modifier
      .fillMaxWidth()
      .padding(vertical = 4.dp),
    shape = RoundedCornerShape(8.dp)
  ) {
    Row(verticalAlignment = Alignment.CenterVertically) {
      Icon(
        painter = painterResource(id = R.drawable.icon_google),
        contentDescription = "Google Logo",
        modifier = Modifier
          .width(24.dp)
          .height(24.dp)
      )
      Spacer(modifier = Modifier.width(8.dp))
      BasicText(
        text = "Sign with Google",
        style = TextStyle(
          color = Color.Black,
          fontSize = 20.sp,
          fontWeight = FontWeight.Bold
        ),
        modifier = Modifier.padding(all = 16.dp)
      )
    }
  }
}

@Composable
fun RegisterButton(navController: NavHostController) {
  Button(
    onClick = { navController.navigate("home")  },
    modifier = Modifier
      .fillMaxWidth()
      .padding(vertical = 4.dp),
    shape = RoundedCornerShape(8.dp)
  ) {
    Row(verticalAlignment = Alignment.CenterVertically) {
      Icon(
        painter = painterResource(id = R.drawable.icon_facebook),
        contentDescription = "Google Logo",
        modifier = Modifier
          .width(24.dp)
          .height(24.dp)
      )
      Spacer(modifier = Modifier.width(8.dp))
      BasicText(
        text = "Sign with Facebook",
        style = TextStyle(
          color = Color.Black,
          fontSize = 20.sp,
          fontWeight = FontWeight.Bold
        ),
        modifier = Modifier.padding(all = 16.dp)
      )
    }
  }
}

@Composable
fun TermsAndConditionFunction() {
  Box(
    modifier = Modifier
      .fillMaxWidth()
      .padding(16.dp)
      .padding(16.dp),
    contentAlignment = Alignment.Center
  ) {
    Column(
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      BasicText(
        text = "By clicking on signup, you agree to sportify's terms and conditions",
        style = TextStyle(
          fontSize = 16.sp,
          fontFamily = FontFamily.SansSerif,
          color = Color.Black
        ),
        modifier = Modifier.padding(8.dp)
      )
    }
  }
}
