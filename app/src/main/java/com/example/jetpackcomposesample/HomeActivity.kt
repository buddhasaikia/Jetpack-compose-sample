package com.example.jetpackcomposesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposesample.navigation.SetupNavGraph
import com.example.jetpackcomposesample.ui.theme.JetpackComposeSampleTheme

class HomeActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeSampleTheme {
                navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    JetpackComposeSampleTheme {

    }
}