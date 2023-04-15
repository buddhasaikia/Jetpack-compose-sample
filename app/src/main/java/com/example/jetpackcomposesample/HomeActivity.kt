package com.example.jetpackcomposesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposesample.home.HomeNavGraph
import com.example.jetpackcomposesample.home.HomeScreen
import com.example.jetpackcomposesample.ui.theme.JetpackComposeSampleTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeSampleTheme {
                val navHostController = rememberNavController()
                HomeNavGraph(navHostController = navHostController)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LandingActivityPreview() {
    JetpackComposeSampleTheme {
        val navController = rememberNavController()
        HomeScreen(navController)
    }
}