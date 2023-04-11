package com.example.jetpackcomposesample.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(
            route = Screen.Home.route,
            arguments = listOf(
                navArgument(HOME_ARGUMENT_KEY1) {
                    type = NavType.IntType
                    defaultValue = -1
                },
                navArgument(HOME_ARGUMENT_KEY2) {
                    type = NavType.StringType
                    defaultValue = "data missing"
                }
            )
        ) {
            Log.d("args:", "${it.arguments?.getInt(HOME_ARGUMENT_KEY1)}")
            Log.d("args:", "${it.arguments?.getString(HOME_ARGUMENT_KEY2)}")
            HomeScreen(navController)
        }
        composable(
            route = Screen.Detail.route,
            arguments = listOf(
                navArgument(DETAIL_ARGUMENT_KEY) {
                    type = NavType.IntType
                },
                navArgument(DETAIL_ARGUMENT_KEY2) {
                    type = NavType.StringType
                }
            )
        ) {
            Log.d("args:", "${it.arguments?.getInt(DETAIL_ARGUMENT_KEY)}")
            Log.d("args:", "${it.arguments?.getString(DETAIL_ARGUMENT_KEY2)}")
            DetailScreen(navController)
        }
    }
}