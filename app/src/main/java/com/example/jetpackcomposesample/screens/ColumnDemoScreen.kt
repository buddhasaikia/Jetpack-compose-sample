package com.example.jetpackcomposesample.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposesample.customui.MyAppBar

@Composable
fun ColumnDemoScreen(navHostController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        MyAppBar(navHostController = navHostController, title = "Column Demo")
        Column(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 8.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var name by remember { mutableStateOf("") }
            Text(text = "Email")
            OutlinedTextField(
                value = name,
                modifier = Modifier
                    .padding(horizontal = 12.dp),
                label = { Text(text = "Type here") },
                onValueChange = {
                    name = it
                }
            )
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Outlined.Add, contentDescription = "Icon button")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ColumnDemoScreenPreview() {
    ColumnDemoScreen(rememberNavController())
}