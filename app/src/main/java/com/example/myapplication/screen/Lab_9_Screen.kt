package com.example.myapplication.screen

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.OptIn
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
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerControlView
import androidx.navigation.NavController

@Composable
fun Lab_9_Screen(navController: NavController) {
    var selectedAudioUri by remember { mutableStateOf<Uri?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        AudioPicker(onAudioSelected = { uri ->
            selectedAudioUri = uri
        })

        Spacer(modifier = Modifier.height(16.dp))

        AudioPlayer(audioUri = selectedAudioUri)
    }
}

@OptIn(UnstableApi::class)
@Composable
fun AudioPlayer(audioUri: Uri?) {
    val context = LocalContext.current
    val player = remember { ExoPlayer.Builder(context).build() }

    LaunchedEffect(audioUri) {
        audioUri?.let { uri ->
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
        if (audioUri != null) {
            AndroidView(
                factory = { ctx ->
                    PlayerControlView(ctx).apply {
                        player?.let { setPlayer(it) }
                    }
                },
                modifier = Modifier.fillMaxWidth()
            )
        } else {
            Text("Аудиофайл не выбран")
        }
    }
}

@Composable
fun AudioPicker(onAudioSelected: (Uri?) -> Unit) {
    val audioPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        onAudioSelected(uri)
    }

    Button(
        onClick = {
        audioPickerLauncher.launch("audio/*")
    }) {
        Text("Выбрать аудиофайл")
    }
}