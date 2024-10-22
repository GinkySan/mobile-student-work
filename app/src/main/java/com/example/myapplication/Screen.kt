package com.example.myapplication

sealed class Screen(val route: String) {
    data object Lab_1_Screen : Screen ("lab_1_screen")
    data object Lab_2_Screen : Screen ("lab_2_screen")
}