package com.example.myapplication.screen

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun SunAnimation() {
    var isAnimated by remember { mutableStateOf(false) }

    val rotation by animateFloatAsState(
        targetValue = if (isAnimated) 360f else 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 3000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    val scale by animateFloatAsState(
        targetValue = if (isAnimated) 1.5f else 1f,
        animationSpec = tween(durationMillis = 1000)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier
                .size(200.dp)
                .graphicsLayer(
                    rotationZ = rotation,
                    scaleX = scale,
                    scaleY = scale
                )
        ) {

            val sunRadius = 50.dp.toPx()
            val rayLength = 70.dp.toPx()
            val rayWidth = 10.dp.toPx()

            drawCircle(
                color = Color.Yellow,
                radius = sunRadius
            )

            for (i in 0 until 12) {
                rotate(i * 30f) {
                    drawLine(
                        color = Color.Yellow,
                        start = Offset(sunRadius, 0f),
                        end = Offset(sunRadius + rayLength, 0f),
                        strokeWidth = rayWidth
                    )
                }
            }
        }

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
fun Lab_13_Screen(navController: NavController) {
    SunAnimation()
}