package com.example.jetpackcomposesample.screens

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposesample.home.Screen
import com.example.jetpackcomposesample.screens.lazylist.LazyListViewModel
import com.example.jetpackcomposesample.screens.lazylist.SearchWidgetState

@Composable
fun SearchBarDemoScreen(navHostController: NavHostController, viewModel: ViewModel) {
    val lazyListViewModel = viewModel as LazyListViewModel
    val searchWidgetState by lazyListViewModel.searchWidgetState
    val searchTextState by lazyListViewModel.searchTextState

    Scaffold(
        topBar = {
            MainAppBar(
                title = "Lazy List Demo",
                navHostController = navHostController,
                searchWidgetState = searchWidgetState,
                searchTextState = searchTextState,
                onTextChange = {
                    lazyListViewModel.updateSearchTextState(newValue = it)
                },
                onCloseClicked = {
                    lazyListViewModel.updateSearchWidgetState(newValue = SearchWidgetState.CLOSED)
                },
                onSearchClicked = {
                    Log.d("Searched Text", it)
                },
                onSearchTriggered = {
                    lazyListViewModel.updateSearchWidgetState(newValue = SearchWidgetState.OPENED)
                }
            )
        }
    ) {
        Text(
            text = "Content area",
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun MainAppBar(
    title: String,
    navHostController: NavHostController,
    searchWidgetState: SearchWidgetState,
    searchTextState: String,
    onTextChange: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchClicked: (String) -> Unit,
    onSearchTriggered: () -> Unit
) {
    when (searchWidgetState) {
        SearchWidgetState.CLOSED -> {
            DefaultAppBar(
                onSearchClicked = onSearchTriggered,
                navHostController = navHostController,
                title = title
            )
        }
        SearchWidgetState.OPENED -> {
            SearchAppBar(
                text = searchTextState,
                onTextChange = onTextChange,
                onCloseClicked = onCloseClicked,
                onSearchClicked = onSearchClicked
            )
        }
    }
}

@Composable
fun DefaultAppBar(
    navHostController: NavHostController,
    title: String,
    onSearchClicked: () -> Unit
) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            IconButton(onClick = {
                navHostController.navigate(Screen.HomeScreen.route) {
                    navHostController.popBackStack()
                }
            }) {
                Icon(imageVector = Icons.AutoMirrored.Outlined.ArrowBack, contentDescription = "Back arrow")
            }
        },
        actions = {
            IconButton(onClick = { onSearchClicked() }) {
                Icon(imageVector = Icons.Outlined.Search, contentDescription = "Search")
            }
        }
    )
}

@Composable
fun SearchAppBar(
    text: String,
    onTextChange: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchClicked: (String) -> Unit,
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        elevation = AppBarDefaults.TopAppBarElevation,
        color = MaterialTheme.colors.primary
    ) {
        TextField(modifier = Modifier
            .fillMaxWidth(),
            value = text,
            onValueChange = {
                onTextChange(it)
            },
            placeholder = {
                Text(
                    modifier = Modifier
                        .alpha(ContentAlpha.medium),
                    text = "Search here...",
                    color = Color.White
                )
            },
            textStyle = TextStyle(
                fontSize = MaterialTheme.typography.subtitle1.fontSize
            ),
            singleLine = true,
            leadingIcon = {
                IconButton(
                    modifier = Modifier
                        .alpha(ContentAlpha.medium),
                    onClick = {}
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search Icon",
                        tint = Color.White
                    )
                }
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        if (text.isNotEmpty()) {
                            onTextChange("")
                        } else {
                            onCloseClicked()
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close Icon",
                        tint = Color.White
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearchClicked(text)
                }
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                cursorColor = Color.White.copy(alpha = ContentAlpha.medium)
            ))
    }
}

@Preview
@Composable
fun SearchBarDemoScreenPreview() {
    SearchBarDemoScreen(
        navHostController = rememberNavController(),
        viewModel = LazyListViewModel()
    )
}