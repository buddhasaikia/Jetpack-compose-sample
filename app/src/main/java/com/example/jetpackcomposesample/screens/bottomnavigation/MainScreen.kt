package com.example.jetpackcomposesample.screens.bottomnavigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposesample.screens.MyAppBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(navHostController: NavHostController) {
    val mainController = rememberNavController()
    Scaffold(
        topBar = {
            MyAppBar(
                navHostController = navHostController,
                title = "Bottom Navigation Screen"
            )
        },
        bottomBar = { BottomBar(navController = mainController) }
    ) {
        BottomNavGraph(navController = mainController)
    }
}

@Composable
fun BottomBar(navController: NavController) {
    val screens = listOf(
        BottomBarItem.Home,
        BottomBarItem.Profile,
        BottomBarItem.Settings
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation {
        screens.forEach {
            AddItem(
                screen = it,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarItem,
    currentDestination: NavDestination?,
    navController: NavController
) {
    BottomNavigationItem(
        label = { Text(text = screen.title) },
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = "navigation icon"
            )
        },
        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen(rememberNavController())
}