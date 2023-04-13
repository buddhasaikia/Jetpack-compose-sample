package com.example.jetpackcomposesample.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = HOME_GRAPH_ROUTE, //Landing screen/route
        route = ROOT_GRAPH_ROUTE
    ) {
        authNavGraph(navController)
        homeNavGraph(navController)
    }
}