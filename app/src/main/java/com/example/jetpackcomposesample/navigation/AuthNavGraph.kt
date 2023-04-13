package com.example.jetpackcomposesample.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.jetpackcomposesample.screens.LoginScreen
import com.example.jetpackcomposesample.screens.SignupScreen

fun NavGraphBuilder.authNavGraph(navController: NavController) {
    navigation(
        startDestination = Screen.Signup.route,
        route = AUTH_GRAPH_ROUTE
    ) {
        composable(route = Screen.Signup.route) {
            SignupScreen(navController = navController)
        }
        composable(route = Screen.Login.route) {
            LoginScreen(navController = navController)
        }
    }
}