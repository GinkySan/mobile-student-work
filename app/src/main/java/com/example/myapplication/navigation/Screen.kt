package com.example.myapplication.navigation

sealed class Screen(val route: String) {
    data object Lab_1_Screen : Screen("lab_1_screen")
    data object Lab_2_Screen : Screen("lab_2_screen")
    data object Lab_3_Screen : Screen("lab_3_screen")
    data object Lab_8_Screen : Screen("lab_8_screen")
    data object Lab_9_Screen : Screen("lab_9_screen")
    data object Lab_10_Screen : Screen("lab_10_screen")
    data object Lab_11_Screen : Screen("lab_11_screen")
    data object Lab_12_Screen : Screen("lab_12_screen")
    data object Lab_13_Screen : Screen("lab_13_screen")
    data object Lab_6_Screen_1 : Screen("lab_6_Screen_1")
    data object Lab_6_Screen_2 : Screen("lab_6_Screen_2")
    data object Lab_7_Screen_1 : Screen("lab_7_Screen_1")
    data object Lab_7_Screen_2 : Screen("lab_7_Screen_2")
}