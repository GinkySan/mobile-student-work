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
fun Lab_6_Screen_1(navController: NavHostController) {

    val context = LocalContext.current
    val nameState = remember { mutableStateOf("") }
    val lastNameState = remember { mutableStateOf("") }
    val groupState = remember { mutableStateOf("") }
    val ageState = remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {

        Text(
            text = "Имя"
        )
        TextField(
            value = nameState.value,
            onValueChange = { nameState.value = it},
        )
        Text(
            text = "Фамилия"
        )
        TextField(
            value = lastNameState.value,
            onValueChange = { lastNameState.value = it},
        )
        Text(
            text = "Группа"
        )
        TextField(
            value = groupState.value,
            onValueChange = { groupState.value = it},
        )
        Text(
            text = "Возраст"
        )
        TextField(
            value = ageState.value,
            onValueChange = { ageState.value = it},
        )
        Button(
            onClick = {
                val student = Student(nameState.value, lastNameState.value, ageState.value, groupState.value)

                navController.navigate(Screen.Lab_6_Screen_2.route + "/${student.firstName}/${student.lastName}/${student.group}/${student.age}")
            },
            modifier = Modifier
                .padding(50.dp)
        ) {
            Text(
                "На следующий экран"
            )
        }
    }
}