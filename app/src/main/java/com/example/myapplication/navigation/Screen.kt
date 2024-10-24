package com.example.myapplication.navigation

sealed class Screen(val route: String) {
    data object Lab_1_Screen : Screen("lab_1_screen")
    data object Lab_2_Screen : Screen("lab_2_screen")
    data object Lab_3_Screen : Screen("lab_3_screen")
    data object Lab_6_Screen_1 : Screen("lab_6_Screen_1")
    data object Lab_6_Screen_2 : Screen("lab_6_Screen_2")
    data object Lab_7_Screen_1 : Screen("lab_7_Screen_1")
    data object Lab_7_Screen_2 : Screen("lab_7_Screen_2")
}