package com.example.jetpackcomposesample.screens.bottomnavigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposesample.nestednavigation.Screen

@Composable
fun BottomNavigationHomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = "Home",
            fontSize = MaterialTheme.typography.h3.fontSize,
            color = Color.White,
            modifier = Modifier.clickable {
                navController.navigate(route = Screen.Detail.passNameAndId(10, "buddha"))
            }
        )
    }
}

@Preview
@Composable
fun BottomNavigationHomeScreenPreview() {
    BottomNavigationHomeScreen(navController = rememberNavController())
}