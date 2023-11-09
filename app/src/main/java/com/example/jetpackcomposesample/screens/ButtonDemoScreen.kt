package com.example.jetpackcomposesample.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposesample.customui.MyAppBar
import com.example.jetpackcomposesample.ui.theme.SublimeLightEnd
import com.example.jetpackcomposesample.ui.theme.SublimeLightStart

@Composable
fun ButtonDemoScreen(navHostController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        MyAppBar(navHostController = navHostController, title = "Button Demo")
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 8.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GradientButton(
                text = "GradientButton",
                textColor = Color.White,
                gradient = Brush.horizontalGradient(
                    colors = listOf(SublimeLightStart, SublimeLightEnd)
                )
            )
        }
    }
}

@Composable
fun GradientButton(text: String, textColor: Color, gradient: Brush) {
    Button(
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
        contentPadding = PaddingValues(),
        onClick = { /*TODO*/ }) {
        Box(
            modifier = Modifier
                .background(gradient)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = text, color = textColor)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonDemoScreenPreview() {
    ButtonDemoScreen(rememberNavController())
}