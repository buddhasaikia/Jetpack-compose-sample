package com.example.jetpackcomposesample.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposesample.customui.MyAppBar
import com.example.jetpackcomposesample.customui.ShimmerLoadingProgressbar

@Composable
fun ShimmerLoadingScreen(navHostController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {
        MyAppBar(navHostController = navHostController, title = "Shimmer Loading Progress Demo")
        repeat(8) {
            ShimmerLoadingProgressbar()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShimmerLoadingProgressScreenPreview() {
    ShimmerLoadingScreen(rememberNavController())
}