package com.example.jetpackcomposesample.bottomnavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarItem(
    var route: String,
    var title: String,
    var icon: ImageVector
) {
    object Home : BottomBarItem(
        "home",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Profile : BottomBarItem(
        "profile",
        title = "Profile",
        icon = Icons.Default.Person
    )

    object Settings : BottomBarItem(
        "settings",
        title = "Settings",
        icon = Icons.Default.Settings
    )
}