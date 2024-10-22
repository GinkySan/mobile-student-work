package com.example.myapplication.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myapplication.R
import com.example.myapplication.navigation.Screen
import com.example.myapplication.ui.theme.Lab_4_Background_Color
import com.example.myapplication.ui.theme.Lab_4_Text_Color

@Composable
fun Lab_1_Screen(navController: NavHostController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = stringResource(R.string.lab_number),
            color = Lab_4_Text_Color,
            modifier = Modifier
                .background(Lab_4_Background_Color)
        )
        Button(
            onClick = {
                navController.navigate(Screen.Lab_3_Screen.route)
            },
            modifier = Modifier
                .padding(50.dp)
        ) {
            Text(
                "На экран с кнопкой"
            )
        }
    }
}