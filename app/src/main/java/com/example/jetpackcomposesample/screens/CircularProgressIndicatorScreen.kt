package com.example.jetpackcomposesample.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposesample.customui.CircularProgressBar
import com.example.jetpackcomposesample.customui.MyAppBar

@Composable
fun CircularProgressIndicatorScreen(navHostController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment . CenterHorizontally
    ) {
        MyAppBar(navHostController = navHostController, title = "Circular Progress Indicator Demo")
        var value by remember { mutableIntStateOf(0) }
        CircularProgressBar(
            backgroundIndicatorStrokeWidth = 50f,
            foregroundIndicatorStrokeWidth = 50f,
            progressValue = value,
            maxProgressValue = 500,
            primaryTextSuffix = "AQI",
            secondaryText = "Air quality"
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp),
            value = "$value",
            label = { Text(text = "Enter progress value") },
            onValueChange = {
                if (it.isNotBlank()) {
                    value = it.toInt()
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CircularProgressActivityPreview() {
    CircularProgressIndicatorScreen(rememberNavController())
}