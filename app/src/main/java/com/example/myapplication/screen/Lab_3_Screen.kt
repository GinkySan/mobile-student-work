package com.example.myapplication.screen

import android.widget.Toast
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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myapplication.navigation.Screen

@Composable
fun Lab_3_Screen(navController: NavHostController) {
    val buttonClickState = remember{ mutableIntStateOf(0) }
    val context = LocalContext.current
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Button(
            onClick = {
                buttonClickState.intValue ++
                Toast.makeText(context,"Безумие, +1 нажатие", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier
                .padding(bottom = 50.dp)
        ) {
            Text(
                text = "Прибавить +1"
            )
        }
        Text(
            text = "Нажатий -> ${buttonClickState.intValue}"
        )
        Button(
            onClick = {
                navController.navigate(Screen.Lab_1_Screen.route)
            },
            modifier = Modifier
                .padding(50.dp)
        ) {
            Text(
                "На начальный экран"
            )
        }
    }
}