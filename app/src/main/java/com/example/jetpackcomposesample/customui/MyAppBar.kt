package com.example.jetpackcomposesample.screens

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.jetpackcomposesample.landing.Screen

@Composable
fun MyAppBar(navHostController: NavHostController, title: String) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            IconButton(onClick = {
                navHostController.navigate(Screen.LandingScreen.route) {
                    navHostController.popBackStack()
                }
            }) {
                Icon(imageVector = Icons.Outlined.ArrowBack, contentDescription = "Back arrow")
            }
        }
    )
}