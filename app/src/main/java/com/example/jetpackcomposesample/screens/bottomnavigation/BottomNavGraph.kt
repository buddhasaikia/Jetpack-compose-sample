package com.example.jetpackcomposesample.screens.bottomnavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpackcomposesample.nestednavigation.ProfileScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarItem.Home.route
    ) {
        composable(route = BottomBarItem.Home.route) {
            BottomNavigationHomeScreen(navController = navController)
        }
        composable(route = BottomBarItem.Profile.route) {
            ProfileScreen(navController = navController)
        }
        composable(route = BottomBarItem.Settings.route) {
            SettingsScreen(navController = navController)
        }
    }
}