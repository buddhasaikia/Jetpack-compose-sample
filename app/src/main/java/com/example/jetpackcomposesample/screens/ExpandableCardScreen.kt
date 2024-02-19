package com.example.jetpackcomposesample.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposesample.R
import com.example.jetpackcomposesample.customui.DividerTransparent
import com.example.jetpackcomposesample.customui.ExpandableCard
import com.example.jetpackcomposesample.customui.MyAppBar

@Composable
fun ExpandableCardScreen(navHostController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {
        MyAppBar(
            navHostController = navHostController,
            title = "ExpandableCard - A Custom UI",
        )
        ExpandableCard(
            title = "My Title 1",
            description = stringResource(R.string.lorem_ipsum),
        )
        DividerTransparent()
        ExpandableCard(
            title = "My Title 2",
            description = stringResource(id = R.string.lorem_ipsum),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ExpandableCardScreenPreview() {
    ExpandableCardScreen(navHostController = rememberNavController())
}
