package com.example.myapplication.navigation

sealed class Screen(val route: String) {
    data object Lab_1_Screen : Screen("lab_1_screen")
    data object Lab_2_Screen : Screen("lab_2_screen")
    data object Lab_3_Screen : Screen("lab_3_screen")
}