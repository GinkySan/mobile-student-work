package com.example.myapplication.screen

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun PropertyAnimation() {
    var isAnimated by remember { mutableStateOf(false) }

    val scale by animateFloatAsState(
        targetValue = if (isAnimated) 1.5f else 1f,
        animationSpec = tween(durationMillis = 1000)
    )
    val rotation by animateFloatAsState(
        targetValue = if (isAnimated) 360f else 0f,
        animationSpec = tween(durationMillis = 1000)
    )
    val alpha by animateFloatAsState(
        targetValue = if (isAnimated) 0.5f else 1f,
        animationSpec = tween(durationMillis = 1000)
    )
    val offsetX by animateDpAsState(
        targetValue = if (isAnimated) 100.dp else 0.dp,
        animationSpec = tween(durationMillis = 1000)
    )
    val offsetY by animateDpAsState(
        targetValue = if (isAnimated) 50.dp else 0.dp,
        animationSpec = tween(durationMillis = 1000)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Анимация свойств",
            fontSize = 24.sp,
            color = Color.Blue,
            modifier = Modifier
                .graphicsLayer(
                    scaleX = scale,
                    scaleY = scale,
                    rotationZ = rotation,
                    alpha = alpha,
                    translationX = offsetX.value,
                    translationY = offsetY.value
                )
                .background(Color.LightGray)
                .padding(16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { isAnimated = !isAnimated },
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            Text(if (isAnimated) "Остановить" else "Запустить")
        }
    }
}

@Composable
fun Lab_12_Screen(navController: NavController) {
    PropertyAnimation()
}