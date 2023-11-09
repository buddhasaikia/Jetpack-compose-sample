package com.example.jetpackcomposesample.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposesample.customui.DividerTransparent
import com.example.jetpackcomposesample.customui.ExpandableCard
import com.example.jetpackcomposesample.customui.MyAppBar

@Composable
fun ExpandableCardScreen(navHostController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {
        MyAppBar(
            navHostController = navHostController,
            title = "ExpandableCard - A Custom UI"
        )
        ExpandableCard(
            title = "My Title 1",
            description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
        )
        DividerTransparent()
        ExpandableCard(
            title = "My Title 2",
            description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ExpandableCardScreenPreview() {
    ExpandableCardScreen(navHostController = rememberNavController())
}