package com.example.jetpackcomposesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposesample.ui.theme.JetpackComposeSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeSampleTheme {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .background(Color.Black),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CustomItem1(weight = 1f, color = Color.Red)
                        CustomItem1(weight = 1f, color = MaterialTheme.colors.secondary)
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .background(Color.Cyan),
                        verticalAlignment = Alignment.Bottom
                    ) {
                        CustomItem2(weight = 1f)
                        CustomItem2(weight = 1f, color = Color.Magenta)
                    }

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .background(Color.Blue),
                        contentAlignment = Alignment.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .width(100.dp)
                                .height(100.dp)
                                .background(Color.Green)
                        )
                        Text(
                            modifier = Modifier
                                .width(360.dp)
                                .background(Color.Gray)
                                .padding(16.dp),
                            text = stringResource(id = R.string.app_name),
                            fontStyle = FontStyle.Italic,
                            fontSize = 20.sp,
                            textAlign = TextAlign.End,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun ColumnScope.CustomItem1(weight: Float, color: Color = MaterialTheme.colors.primary) {
    Surface(
        modifier = Modifier
            .width(200.dp)
            .weight(weight),
        color = color
    ) {
        Greeting(name = "Buddha")
    }
}

@Composable
fun RowScope.CustomItem2(weight: Float, color: Color = MaterialTheme.colors.primary) {
    Surface(
        modifier = Modifier
            .fillMaxHeight()
            .weight(weight),
        color = color
    ) {
        CustomText3()
    }
}

@Composable
fun CustomText1() {
    Text(
        modifier = Modifier
            .width(360.dp)
            .background(Color.Gray)
            .padding(16.dp),
        text = stringResource(id = R.string.app_name),
        fontStyle = FontStyle.Italic,
        fontSize = 20.sp,
        textAlign = TextAlign.End,
        color = Color.White
    )
}

@Composable
fun CustomText2() {
    Text(
        text = buildAnnotatedString {
            withStyle(style = ParagraphStyle(textAlign = TextAlign.Center)) {
                withStyle(
                    style = SpanStyle(
                        color = Color.Magenta,
                        fontSize = 40.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                ) {
                    append("A")
                }
                append("B")
                append("C")
                append("D")
            }
        }, color = Color.White, modifier = Modifier
            .background(Color.LightGray)
            .padding(8.dp)
    )
}

@Composable
fun CustomText3() {
    Text(text = "Hello World!".repeat(20), maxLines = 2, overflow = TextOverflow.Ellipsis)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeSampleTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .background(Color.Black),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CustomItem1(weight = 1f, color = Color.Red)
                CustomItem1(weight = 1f, color = MaterialTheme.colors.secondary)
                CustomText2()
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(Color.Cyan),
                verticalAlignment = Alignment.Bottom
            ) {
                CustomItem2(weight = 1f)
                CustomItem2(weight = 1f, color = Color.Magenta)
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .background(Color.Blue),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .background(Color.Green)
                )
                CustomText1()
            }
        }
    }
}