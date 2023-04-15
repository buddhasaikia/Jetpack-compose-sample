package com.example.jetpackcomposesample.landing

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposesample.ui.theme.Purple200

@Composable
fun LandingScreen(navHostController: NavHostController) {
    val demoList = listOf(
        DemoItem(screen = Screen.RowDemoScreen, title = "Row Demo"),
        DemoItem(screen = Screen.ColumnDemoScreen, title = "Column Demo"),
        DemoItem(screen = Screen.BoxDemoScreen, title = "Box Demo"),
        DemoItem(screen = Screen.TextModificationDemoScreen, title = "Text Modification Demo"),
        DemoItem(screen = Screen.ExpandableCardDemoScreen, title = "Expandable Card - A Custom UI"),
        DemoItem(screen = Screen.TextFieldDemoScreen, title = "TextField Demo"),
        DemoItem(screen = Screen.ButtonDemoScreen, title = "Button Demo"),
        DemoItem(screen = Screen.CoilImageDemoScreen, title = "Coil Image Demo"),
        DemoItem(screen = Screen.LazyListDemoScreen, title = "Lazy List Demo"),
        DemoItem(screen = Screen.LazyListWithStickyHeaderDemoScreen, title = "Sticky Header Lazy List Demo"),
        DemoItem(screen = Screen.CircularProgressIndicatorDemoScreen, title = "Circular Progress Indicator Demo"),
        DemoItem(screen = Screen.BottomNavigationDemoScreen, title = "Bottom Navigation Demo"),
        DemoItem(screen = null, title = "Exit")
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Text(
            text = "Welcome to\nJetpack Compose Samples",
            fontSize = MaterialTheme.typography.h4.fontSize,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Light
        )
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            itemsIndexed(items = demoList) { _, demoItem ->
                DemoItemUI(
                    screen = demoItem.screen,
                    title = demoItem.title,
                    navHostController = navHostController
                )
            }
        }
    }
}

@Composable
fun DemoItemUI(screen: Screen?, title: String, navHostController: NavHostController) {
    val activity = (LocalContext.current as? Activity)
    Text(
        text = title,
        fontSize = MaterialTheme.typography.h5.fontSize,
        modifier = Modifier
            .fillMaxWidth()
            .background(Purple200)
            .clickable {
                if (screen == null) {
                    activity?.finish()
                    return@clickable
                }
                navHostController.navigate(screen.route) {
                    navHostController.popBackStack()
                }
            }
            .padding(16.dp),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Light,
        color = Color.White
    )
}

@Preview(showBackground = true)
@Composable
fun LandingScreenPreview() {
    LandingScreen(rememberNavController())
}