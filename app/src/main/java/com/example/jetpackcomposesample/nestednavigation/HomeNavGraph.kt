package com.example.jetpackcomposesample.nestednavigation

import android.util.Log
import androidx.navigation.*
import androidx.navigation.compose.composable
import com.example.jetpackcomposesample.screens.DetailScreen
import com.example.jetpackcomposesample.screens.HomeScreen

fun NavGraphBuilder.homeNavGraph(navController: NavController) {
    navigation(
        startDestination = Screen.Home.route,
        route = HOME_GRAPH_ROUTE
    ) {
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