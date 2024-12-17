package com.example.myapplication.screen

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import androidx.navigation.NavController

@Composable
fun Lab_10_Screen(navController: NavController) {
    var selectedVideoUri by remember { mutableStateOf<Uri?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        VideoPicker(onVideoSelected = { uri ->
            selectedVideoUri = uri
        })

        Spacer(modifier = Modifier.height(16.dp))

        VideoPlayer(videoUri = selectedVideoUri)
    }
}

@Composable
fun VideoPlayer(videoUri: Uri?) {
    val context = LocalContext.current
    val player = remember { ExoPlayer.Builder(context).build() }

    LaunchedEffect(videoUri) {
        videoUri?.let { uri ->
            player.setMediaItem(MediaItem.fromUri(uri))
            player.prepare()
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            player.release()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (videoUri != null) {

            AndroidView(
                factory = { ctx ->
                    PlayerView(ctx).apply {
                        setPlayer(player)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )
        } else {
            Text("Видеофайл не выбран")
        }
    }
}

@Composable
fun VideoPicker(onVideoSelected: (Uri?) -> Unit) {
    val videoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        onVideoSelected(uri)
    }

    Button(
        onClick = {
            videoPickerLauncher.launch("video/*")
        }) {
        Text("Выбрать видеофайл")
    }
}