package com.example.jetpackcomposesample.customui

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DividerTransparent() {
    Divider(Modifier.height(8.dp), color = Color.Transparent)
}

@Composable
fun DividerVerticalTransparent() {
    Divider(Modifier.width(8.dp), color = Color.Transparent)
}