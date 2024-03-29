package com.example.jetpackcomposesample.customui

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.jetpackcomposesample.home.Screen

@Composable
fun MyAppBar(navHostController: NavHostController, title: String) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            IconButton(onClick = {
                navHostController.navigate(Screen.HomeScreen.route) {
                    navHostController.popBackStack()
                }
            }) {
                Icon(imageVector = Icons.AutoMirrored.Outlined.ArrowBack, contentDescription = "Back arrow")
            }
        }
    )
}