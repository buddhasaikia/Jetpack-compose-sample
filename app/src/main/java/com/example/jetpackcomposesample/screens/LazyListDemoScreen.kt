package com.example.jetpackcomposesample.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposesample.data.Repository
import com.example.jetpackcomposesample.lazylist.EmployeeItem

@Composable
fun LazyListDemoScreen(navHostController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {
        MyAppBar(navHostController = navHostController, title = "Lazy List Demo")
        val repository = Repository()
        val employees = repository.getEmployees()
        LazyColumn(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            itemsIndexed(items = employees) { index, employee ->
                Log.d("index", "$index")
                EmployeeItem(employee = employee)
            }
        }
    }
}

@Preview
@Composable
fun LazyListDemoScreenPreview() {
    LazyListDemoScreen(navHostController = rememberNavController())
}