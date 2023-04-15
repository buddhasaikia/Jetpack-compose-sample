package com.example.jetpackcomposesample.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.jetpackcomposesample.R

@Composable
fun CoilImageDemoScreen(navHostController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        MyAppBar(navHostController = navHostController, title = "Coil Image Demo")
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 8.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CoilImageViewer()
        }
    }
}

@Composable
fun CoilImageViewer() {
    Box(
        modifier = Modifier
            .width(200.dp)
            .height(200.dp),
        contentAlignment = Alignment.Center
    ) {
        val painter =
            rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://avatars.githubusercontent.com/u/13464551?v=4")
                    .transformations(CircleCropTransformation())
                    .crossfade(1000)
                    .build(),
                placeholder = painterResource(R.drawable.image_placeholder),
                error = painterResource(R.drawable.person_falling_burst_solid)
            )
        val painterState = painter.state
        Image(
            painter = painter,
            contentDescription = "Coil Image",
            modifier = Modifier.padding(20.dp)
        )
        if (painterState is AsyncImagePainter.State.Loading) {
            CircularProgressIndicator()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CoilImageDemoScreenPreview() {
    CoilImageDemoScreen(rememberNavController())
}