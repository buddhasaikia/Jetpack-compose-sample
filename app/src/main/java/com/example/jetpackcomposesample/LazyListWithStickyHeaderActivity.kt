@file:OptIn(ExperimentalFoundationApi::class)

package com.example.jetpackcomposesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposesample.ui.theme.JetpackComposeSampleTheme
import com.example.jetpackcomposesample.ui.theme.Typography

class LazyListWithStickyHeaderActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeSampleTheme {
                val section = listOf("A", "B", "C", "D", "E", "F", "G", "H")
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LazyColumn(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        section.forEach { section ->
                            stickyHeader {
                                Text(
                                    modifier = Modifier
                                        .background(Color.LightGray)
                                        .fillMaxWidth()
                                        .padding(12.dp),
                                    text = "Section $section",
                                    fontSize = Typography.h5.fontSize,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            items(10) {
                                Text(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(Color.White)
                                        .padding(horizontal = 24.dp, vertical = 12.dp),
                                    text = "Item $it",
                                    fontSize = Typography.body1.fontSize,
                                    fontWeight = FontWeight.Normal
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewLazyColumnWithStickyHeader() {
    JetpackComposeSampleTheme {
        val section = listOf("A", "B", "C", "D", "E", "F", "G", "H")
        LazyColumn(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            section.forEach { section ->
                stickyHeader {
                    Text(
                        modifier = Modifier
                            .background(Color.LightGray)
                            .fillMaxWidth()
                            .padding(12.dp),
                        text = "Section $section",
                        fontSize = Typography.h5.fontSize,
                        fontWeight = FontWeight.Bold
                    )
                }
                items(10) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White)
                            .padding(horizontal = 24.dp, vertical = 12.dp),
                        text = "Item $it",
                        fontSize = Typography.body1.fontSize,
                        fontWeight = FontWeight.Normal
                    )
                }
            }
        }
    }
}