package com.example.jetpackcomposesample.customui

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ShimmerLoadingProgressbar() {
    val shimmerColors = listOf(
        Color.LightGray.copy(alpha = .2f),
        Color.LightGray.copy(alpha = .6f),
        Color.LightGray.copy(alpha = .4f)
    )
    val transition = rememberInfiniteTransition(label = "")

    val translateAnimation = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset.Zero,
        end = Offset(x = translateAnimation.value, y = translateAnimation.value)
    )

    ShimmerListItem(brush = brush)
}

@Composable
fun ShimmerListItem(brush: Brush) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .background(brush)
        )
        Column(modifier = Modifier.padding(start = 10.dp)) {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth(fraction = .7f)
                    .clip(CircleShape)
                    .height(16.dp)
                    .background(brush)
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth(fraction = .9f)
                    .clip(CircleShape)
                    .height(16.dp)
                    .background(brush)
            )
        }
    }
}