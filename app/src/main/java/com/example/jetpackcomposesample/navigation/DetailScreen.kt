package com.example.jetpackcomposesample.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun DetailScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Detail Screen",
            fontSize = 30.sp,
            color = Color.Blue,
            modifier = Modifier.clickable {
                //Simply navigate to home screen keeping detail screen in backstack
                //navController.navigate(Screen.Home.route)

                //Simply navigate to home screen and remove detail screen from backstack
                //navController.popBackStack()

                //Navigate to home screen (you can pass argument to home from detail screen, also remove detail screen from backstack
                navController.navigate(Screen.Home.route) {
                    popUpTo(Screen.Home.route) {
                        inclusive = true
                    }
                }
            }
        )
    }
}

@Preview
@Composable
fun DetailScreenPreview() {
    DetailScreen(navController = rememberNavController())
}