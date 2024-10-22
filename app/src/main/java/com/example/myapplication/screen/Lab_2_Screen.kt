package com.example.myapplication.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Lab_2_Screen(navController: NavHostController) {
    val buttonClickState = remember{ mutableStateOf(false) }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Button(
            onClick = {
                buttonClickState.value = !buttonClickState.value
            },
            modifier = Modifier
                .padding(bottom = 50.dp)
        ) {
            Text(
                text = "Кнопка"
            )
        }
        Text(
            text = "Нажмите кнопку"
        )
        if (buttonClickState.value) {

            Icon(
                imageVector = Icons.Rounded.Done,
                contentDescription = "Done",
                modifier = Modifier
                    .padding(top = 50.dp)
            )
        }
    }
}