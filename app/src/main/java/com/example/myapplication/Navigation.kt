package com.example.myapplication

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val context = LocalContext.current
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Lab_2_Screen.route
    ) {
        composable(route = Screen.Lab_1_Screen.route) {
            Lab_1_Screen(navController = navController)
        }
        composable(route = Screen.Lab_2_Screen.route) {
            Lab_2_Screen(navController = navController)
        }
    }
}