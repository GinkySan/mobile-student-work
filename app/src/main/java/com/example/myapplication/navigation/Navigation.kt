package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.screen.Lab_1_Screen
import com.example.myapplication.screen.Lab_2_Screen
import com.example.myapplication.screen.Lab_3_Screen

@Composable
fun Navigation() {
    val context = LocalContext.current
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Lab_1_Screen.route
    ) {
        composable(route = Screen.Lab_1_Screen.route) {
            Lab_1_Screen(navController = navController)
        }
        composable(route = Screen.Lab_2_Screen.route) {
            Lab_2_Screen(navController = navController)
        }
        composable(route = Screen.Lab_3_Screen.route) {
            Lab_3_Screen(navController = navController)
        }
    }
}