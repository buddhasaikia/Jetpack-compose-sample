package com.example.jetpackcomposesample.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposesample.DividerTransparent
import com.example.jetpackcomposesample.R

@Composable
fun TextModificationScreen(navHostController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        MyAppBar(navHostController = navHostController, title = "Text Modification Demo")
        Row {
            Column(modifier = Modifier.padding(10.dp)) {
                BaselineShiftText(
                    "Hello",
                    28.sp,
                    "World",
                    14.sp,
                    superFontWeight = FontWeight.ExtraLight,
                    baselineShift = BaselineShift.Subscript
                )
                BaselineShiftText(
                    normalText = "X",
                    30.sp,
                    superText = "2",
                    16.sp,
                    superFontWeight = FontWeight.Light
                )
            }
        }
        ItalicTextFromStringResource()
        DividerTransparent()
        TextSelectionAndDisabledText()
        DividerTransparent()
        TwoLineTextWithEllipsizeEnd()
    }
}

/*Subscript and superscript text*/
@Composable
fun BaselineShiftText(
    normalText: String,
    normalFontSize: TextUnit = MaterialTheme.typography.subtitle1.fontSize,
    superText: String,
    superFontSize: TextUnit = MaterialTheme.typography.overline.fontSize,
    superFontWeight: FontWeight = FontWeight.Normal,
    baselineShift: BaselineShift = BaselineShift.Superscript
) {
    Text(text = buildAnnotatedString {
        withStyle(style = SpanStyle(fontSize = normalFontSize)) {
            append(normalText)
        }
        withStyle(
            style = SpanStyle(
                fontSize = superFontSize,
                fontWeight = superFontWeight,
                baselineShift = baselineShift
            )
        ) {
            append(superText)
        }
    })
}

/*Italic text from string resource file*/
@Composable
fun ItalicTextFromStringResource() {
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

/*Text selection with disabled selection text in between*/
@Composable
fun TextSelectionAndDisabledText() {
    SelectionContainer {
        Column {
            Text(text = "Hello World!")
            DisableSelection {
                Text(text = "Hello World! - Disabled selection")
            }
            Text(text = "Hello World!")
        }
    }
}

/*Two line text with ellipsize at the end*/
@Composable
fun TwoLineTextWithEllipsizeEnd() {
    Text(
        text = "Two Line Text With Ellipsize End".repeat(20),
        maxLines = 2,
        overflow = TextOverflow.Ellipsis
    )
}

@Preview(showBackground = true)
@Composable
fun TextModificationPreview() {
    TextModificationScreen(navHostController = rememberNavController())
}