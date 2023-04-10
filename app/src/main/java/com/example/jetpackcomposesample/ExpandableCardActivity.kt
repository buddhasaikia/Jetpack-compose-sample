package com.example.jetpackcomposesample

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.jetpackcomposesample.ui.theme.SublimeLightEnd
import com.example.jetpackcomposesample.ui.theme.SublimeLightStart

class ExpandableCardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.LightGray)
                    .padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ExpandableCard(
                    title = "My Title 1",
                    description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
                )
                DividerTransparent()
                ExpandableCard(
                    title = "My Title 2",
                    description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
                )
                DividerTransparent()
                PasswordTextField()
                DividerTransparent()
                TextFieldInputWithLeadingIcon(leadingIcon = Icons.Outlined.Email)
                DividerTransparent()
                OutlinedTextFieldWithTrailingIcon(trailingIcon = Icons.Filled.Close)
                DividerTransparent()
                Row {
                    BasicTextFieldInput()
                    DividerVerticalTransparent()
                    GradientButton(
                        text = "GradientButton",
                        textColor = Color.White,
                        gradient = Brush.horizontalGradient(
                            colors = listOf(SublimeLightStart, SublimeLightEnd)
                        )
                    )
                }
                CoilImageViewer()
            }
        }
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
fun CoilImageViewer() {
    Box(
        modifier = Modifier
            .width(200.dp)
            .height(200.dp),
        contentAlignment = Alignment.Center
    ) {
        val painter =
            rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://avatars.githubusercontent.com/u/13464551?v=4")
                    .transformations(CircleCropTransformation())
                    .crossfade(1000)
                    .build(),
                placeholder = painterResource(R.drawable.image_placeholder),
                error = painterResource(R.drawable.person_falling_burst_solid)
            )
        val painterState = painter.state
        Image(
            painter = painter,
            contentDescription = "Coil Image",
            modifier = Modifier.padding(20.dp)
        )
        if (painterState is AsyncImagePainter.State.Loading) {
            CircularProgressIndicator()
        }
    }
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
fun GradientButton(text: String, textColor: Color, gradient: Brush) {
    Button(
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
        contentPadding = PaddingValues(),
        onClick = { /*TODO*/ }) {
        Box(
            modifier = Modifier
                .background(gradient)
                .padding(horizontal = 16.dp, vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = text, color = textColor)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewExpandableCardActivity() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray)
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ExpandableCard(
            title = "My Title 1",
            description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
        )
        DividerTransparent()
        ExpandableCard(
            title = "My Title 2",
            description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
        )
        DividerTransparent()
        PasswordTextField()
        DividerTransparent()
        TextFieldInputWithLeadingIcon(leadingIcon = Icons.Outlined.Email)
        DividerTransparent()
        OutlinedTextFieldWithTrailingIcon(trailingIcon = Icons.Outlined.AccountBox)
        DividerTransparent()
        Row {
            BasicTextFieldInput()
            DividerVerticalTransparent()
            GradientButton(
                text = "GradientButton",
                textColor = Color.White,
                gradient = Brush.horizontalGradient(
                    colors = listOf(SublimeLightStart, SublimeLightEnd)
                )
            )
        }
        DividerTransparent()
        CoilImageViewer()
    }
}