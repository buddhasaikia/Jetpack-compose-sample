package com.example.jetpackcomposesample

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CircularProgressBar(
    canvasSize: Dp = 300.dp,
    progressValue: Int = 0,
    maxProgressValue: Int = 100,
    backgroundIndicatorColor: Color = MaterialTheme.colors.onSurface.copy(alpha = .1f),
    backgroundIndicatorStrokeWidth: Float = 30f,
    foregroundIndicatorColor: Color = MaterialTheme.colors.primary,
    foregroundIndicatorStrokeWidth: Float = 30f,
    primaryTextSuffix: String,
    primaryTextColor: Color = MaterialTheme.colors.onSurface,
    secondaryText: String,
    secondaryTextColor: Color = MaterialTheme.typography.subtitle2.color.copy(alpha = .3f)
) {
    var animatedProgressValue by remember { mutableStateOf(0f) }
    var allowedProgressValue by remember { mutableStateOf(maxProgressValue) }
    allowedProgressValue = if (progressValue <= maxProgressValue) {
        progressValue
    } else {
        maxProgressValue
    }
    LaunchedEffect(key1 = allowedProgressValue) {
        animatedProgressValue = allowedProgressValue.toFloat()
    }

    val percentage = (animatedProgressValue / maxProgressValue) * 100
    val sweepAngle by animateFloatAsState(
        targetValue = (2.4 * percentage).toFloat(),
        animationSpec = tween(1000)
    )

    val animatedPrimaryText by animateIntAsState(
        targetValue = allowedProgressValue,
        animationSpec = tween(1000)
    )

    val animatedPrimaryTextColor by animateColorAsState(
        targetValue = when {
            allowedProgressValue == 0 -> {
                MaterialTheme.typography.subtitle1.color.copy(alpha = .3f)
            }
            allowedProgressValue >= 400 -> {
                Color.Red
            }
            else -> {
                primaryTextColor
            }
        },
        animationSpec = tween(1000)
    )

    Column(
        modifier = Modifier
            .size(canvasSize)
            .drawBehind {
                val componentSize = size / 1.25f
                backgroundIndicator(
                    componentSize = componentSize,
                    indicatorColor = backgroundIndicatorColor,
                    indicatorStrokeWidth = backgroundIndicatorStrokeWidth
                )
                foregroundIndicator(
                    componentSize = componentSize,
                    indicatorColor = foregroundIndicatorColor,
                    indicatorStrokeWidth = foregroundIndicatorStrokeWidth,
                    sweepAngle = sweepAngle
                )

            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        DisplayInfo(
            primaryText = animatedPrimaryText.toString(),
            primaryTextSuffix = primaryTextSuffix,
            secondaryText = secondaryText,
            secondaryTextColor = secondaryTextColor,
            animatedPrimaryTextColor = animatedPrimaryTextColor
        )
    }
}

fun DrawScope.foregroundIndicator(
    componentSize: Size,
    indicatorColor: Color,
    indicatorStrokeWidth: Float,
    sweepAngle: Float
) {
    drawArc(
        size = componentSize,
        color = indicatorColor,
        startAngle = 150f,
        sweepAngle = sweepAngle,
        useCenter = false,
        style = Stroke(
            width = indicatorStrokeWidth,
            cap = StrokeCap.Round
        ),
        topLeft = Offset(
            x = (size.width - componentSize.width) / 2f,
            y = (size.height - componentSize.height) / 2f
        )
    )
}

fun DrawScope.backgroundIndicator(
    componentSize: Size,
    indicatorColor: Color,
    indicatorStrokeWidth: Float
) {
    drawArc(
        size = componentSize,
        color = indicatorColor,
        startAngle = 150f,
        sweepAngle = 240f,
        useCenter = false,
        style = Stroke(
            width = indicatorStrokeWidth,
            cap = StrokeCap.Round
        ),
        topLeft = Offset(
            x = (size.width - componentSize.width) / 2f,
            y = (size.height - componentSize.height) / 2f
        )
    )
}

@Composable
fun DisplayInfo(
    primaryText: String,
    primaryTextSuffix: String,
    secondaryText: String,
    secondaryTextColor: Color,
    animatedPrimaryTextColor: Color
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = secondaryText,
            color = secondaryTextColor,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Normal
        )
        Text(
            text = "$primaryText $primaryTextSuffix",
            color = animatedPrimaryTextColor,
            textAlign = TextAlign.Center,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CircularProgressbarPreview() {
    CircularProgressBar(
        backgroundIndicatorStrokeWidth = 50f,
        foregroundIndicatorStrokeWidth = 50f,
        progressValue = 30,
        maxProgressValue = 100,
        primaryTextSuffix = "AQI",
        secondaryText = "Air quality"
    )
}