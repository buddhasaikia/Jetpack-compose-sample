package com.example.jetpackcomposesample.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Email
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposesample.R
import com.example.jetpackcomposesample.customui.DividerTransparent
import com.example.jetpackcomposesample.customui.MyAppBar

@Composable
fun TextFieldsScreen(navHostController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyAppBar(navHostController = navHostController, title = "TextField Demo")
        PasswordTextField()
        DividerTransparent()
        TextFieldInputWithLeadingIcon(leadingIcon = Icons.Outlined.Email)
        DividerTransparent()
        OutlinedTextFieldWithTrailingIcon(trailingIcon = Icons.Outlined.AccountBox)
        DividerTransparent()
        BasicTextFieldInput()
    }
}

@Composable
fun PasswordTextField() {
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    val icon =
        if (passwordVisibility) painterResource(R.drawable.eye_regular) else painterResource(R.drawable.eye_slash_regular)

    OutlinedTextField(
        value = password, onValueChange = { password = it },
        //placeholder = { Text(text = "Password") },
        label = { Text(text = "Password") },
        trailingIcon = {
            IconButton(modifier = Modifier.size(24.dp), onClick = {
                passwordVisibility = !passwordVisibility
            }) {
                Icon(
                    painter = icon,
                    contentDescription = "Show password"
                )
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = if (passwordVisibility)
            VisualTransformation.None
        else
            PasswordVisualTransformation()
    )
}

@Composable
fun TextFieldInputWithLeadingIcon(leadingIcon: ImageVector) {
    var text by rememberSaveable { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { text = it },
        enabled = true,
        readOnly = false,
        label = { Text(text = "TextField") }, //Similar to hint
        singleLine = true,
        leadingIcon = {
            IconButton(onClick = {}) {
                Icon(imageVector = leadingIcon, contentDescription = "")
            }
        }
    )
}

@Composable
fun BasicTextFieldInput() {
    var text by remember { mutableStateOf("Basic text field") }
    BasicTextField(
        value = text,
        modifier = Modifier
            .background(Color.Gray)
            .padding(16.dp),
        onValueChange = { text = it },
        singleLine = true
    )
}

@Composable
fun OutlinedTextFieldWithTrailingIcon(
    trailingIcon: ImageVector = Icons.Filled.Close,
    label: String = "OutlinedTextField with character limit"
) {
    var text by remember { mutableStateOf("") }
    val maxChar = 10
    OutlinedTextField(
        value = text,
        onValueChange = {
            if (it.length <= maxChar) {
                text = it
            }
        },
        enabled = true,
        readOnly = false,
        label = { Text(text = label) }, //Similar to hint
        singleLine = true,
        trailingIcon = {
            if (text.isNotBlank()) {
                IconButton(onClick = { text = "" }) {
                    Icon(imageVector = trailingIcon, contentDescription = "")
                }
            }
        },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Search,
            keyboardType = KeyboardType.Email
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                Log.d("InputWithTrailingIcon", "Keyboard Search icon pressed!")
            }
        )
    )
}

@Preview(showBackground = true)
@Composable
fun TextFieldsScreenPreview() {
    TextFieldsScreen(navHostController = rememberNavController())
}