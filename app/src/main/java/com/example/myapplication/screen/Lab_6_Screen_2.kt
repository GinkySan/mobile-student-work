package com.example.myapplication.screen

import Student
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
fun Lab_6_Screen_2(
    navController: NavHostController,
    name: String,
    lastName: String,
    age: String,
    group: String
) {

    val context = LocalContext.current

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {

        Text(
            text = "Имя: $name $lastName\nВозраст: $age\nГруппа: $group"
        )
        Button(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier
                .padding(50.dp)
        ) {
            Text(
                "На предыдущий экран"
            )
        }
    }
}