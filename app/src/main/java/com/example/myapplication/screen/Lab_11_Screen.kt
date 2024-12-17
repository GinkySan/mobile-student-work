package com.example.myapplication.screen

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.R

@Composable
fun FrameAnimation(frames: List<Int>, frameDuration: Int = 100) {
    val infiniteTransition = rememberInfiniteTransition()
    val frameIndex by infiniteTransition.animateValue(
        initialValue = 0,
        targetValue = frames.size - 1,
        typeConverter = Int.VectorConverter,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = frames.size * frameDuration,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Restart
        )
    )

    Image(
        painter = painterResource(id = frames[frameIndex]),
        contentDescription = "Frame Animation",
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
fun Lab_11_Screen(navController: NavController) {
    var isPlaying by remember { mutableStateOf(true) }

    val frames = listOf(
        R.drawable.cadr1,
        R.drawable.cadr2,
        R.drawable.cadr3,
        R.drawable.cadr4,
        R.drawable.cadr5,
        R.drawable.cadr6,
        R.drawable.cadr7,
        R.drawable.cadr8,
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        if (isPlaying) {
            FrameAnimation(frames = frames, frameDuration = 100)
        } else {
            Text(
                "Анимация остановлена",
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }

        Button(
            onClick = { isPlaying = !isPlaying },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)
        ) {
            Text(if (isPlaying) "Остановить" else "Запустить")
        }
    }
}