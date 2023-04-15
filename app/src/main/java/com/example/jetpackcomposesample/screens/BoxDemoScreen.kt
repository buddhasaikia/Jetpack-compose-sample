package com.example.jetpackcomposesample.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun BoxDemoScreen(navHostController: NavHostController) {
    Surface(color = Color.LightGray) {
        MyAppBar(navHostController = navHostController, title = "Box Demo")
        Box(
            modifier = Modifier
                .padding(start = 24.dp, top = 80.dp, end = 24.dp, bottom = 24.dp)
                .fillMaxSize()
                .background(Color.Yellow),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)
                    .background(Color.Green)
            )
            ItalicTextFromStringResource()
        }
    }
}

@Preview
@Composable
fun BoxDemoScreenPreview() {
    BoxDemoScreen(navHostController = rememberNavController())
}