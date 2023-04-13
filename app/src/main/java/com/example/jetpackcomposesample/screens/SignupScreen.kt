package com.example.jetpackcomposesample.screens

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
import com.example.jetpackcomposesample.navigation.HomeScreen
import com.example.jetpackcomposesample.navigation.Screen

@Composable
fun SignupScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Signup Screen",
            fontSize = 30.sp,
            color = Color.Red,
            modifier = Modifier.clickable {
                navController.navigate(route = Screen.Login.route){
                    navController.popBackStack()
                }
            }
        )
    }
}

@Preview
@Composable
fun SignupScreenScreenPreview() {
    HomeScreen(navController = rememberNavController())
}