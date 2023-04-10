package com.example.jetpackcomposesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
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
import com.example.jetpackcomposesample.ui.theme.JetpackComposeSampleTheme

class CircularProgressActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeSampleTheme {
                Column(
                    modifier = Modifier.padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    var value by remember { mutableStateOf(0) }

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
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CircularProgressActivityPreview() {
    JetpackComposeSampleTheme {
        CircularProgressBar(
            backgroundIndicatorStrokeWidth = 50f,
            foregroundIndicatorStrokeWidth = 50f,
            progressValue = 70,
            maxProgressValue = 100,
            primaryTextSuffix = "AQI",
            secondaryText = "Air quality"
        )
    }
}