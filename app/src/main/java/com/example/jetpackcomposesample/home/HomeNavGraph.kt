package com.example.jetpackcomposesample.home

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpackcomposesample.screens.bottomnavigation.MainScreen
import com.example.jetpackcomposesample.screens.*
import com.example.jetpackcomposesample.screens.lazylist.LazyListDemoScreen

@Composable
fun HomeNavGraph(
    navHostController: NavHostController,
    viewModel: ViewModel
) {
    NavHost(navController = navHostController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navHostController)
        }
        composable(route = Screen.RowDemoScreen.route) {
            RowDemoScreen(navHostController)
        }
        composable(route = Screen.ColumnDemoScreen.route) {
            ColumnDemoScreen(navHostController)
        }
        composable(route = Screen.BoxDemoScreen.route) {
            BoxDemoScreen(navHostController = navHostController)
        }
        composable(route = Screen.TextModificationDemoScreen.route) {
            TextModificationScreen(navHostController = navHostController)
        }
        composable(route = Screen.ExpandableCardDemoScreen.route) {
            ExpandableCardScreen(navHostController = navHostController)
        }
        composable(route = Screen.TextFieldDemoScreen.route) {
            TextFieldsScreen(navHostController = navHostController)
        }
        composable(route = Screen.ButtonDemoScreen.route) {
            ButtonDemoScreen(navHostController = navHostController)
        }
        composable(route = Screen.CoilImageDemoScreen.route) {
            CoilImageDemoScreen(navHostController = navHostController)
        }
        composable(route = Screen.LazyListDemoScreen.route) {
            LazyListDemoScreen(navHostController = navHostController)
        }
        composable(route = Screen.LazyListWithStickyHeaderDemoScreen.route) {
            LazyListWithStickyHeaderDemoScreen(navHostController = navHostController)
        }
        composable(route = Screen.CircularProgressIndicatorDemoScreen.route) {
            CircularProgressIndicatorScreen(navHostController = navHostController)
        }
        composable(route = Screen.BottomNavigationDemoScreen.route) {
            MainScreen(navHostController = navHostController)
        }
        composable(route = Screen.SearchBarDemoScreen.route) {
            SearchBarDemoScreen(navHostController = navHostController, viewModel = viewModel)
        }
        composable(route = Screen.ShimmerLoadingDemoScreen.route) {
            ShimmerLoadingScreen(navHostController = navHostController)
        }
    }
}