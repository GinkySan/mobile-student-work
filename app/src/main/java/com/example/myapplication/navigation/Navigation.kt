package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.screen.Lab_10_Screen
import com.example.myapplication.screen.Lab_11_Screen
import com.example.myapplication.screen.Lab_12_Screen
import com.example.myapplication.screen.Lab_13_Screen
import com.example.myapplication.screen.Lab_1_Screen
import com.example.myapplication.screen.Lab_2_Screen
import com.example.myapplication.screen.Lab_3_Screen
import com.example.myapplication.screen.Lab_6_Screen_1
import com.example.myapplication.screen.Lab_6_Screen_2
import com.example.myapplication.screen.Lab_7_Screen_1
import com.example.myapplication.screen.Lab_7_Screen_2
import com.example.myapplication.screen.Lab_8_Screen
import com.example.myapplication.screen.Lab_9_Screen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Lab_13_Screen.route
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
        composable(route = Screen.Lab_6_Screen_1.route) {
            Lab_6_Screen_1(navController = navController)
        }
        composable(route = Screen.Lab_8_Screen.route) {
            Lab_8_Screen(navController = navController)
        }
        composable(route = Screen.Lab_9_Screen.route) {
            Lab_9_Screen(navController = navController)
        }
        composable(route = Screen.Lab_10_Screen.route) {
            Lab_10_Screen(navController = navController)
        }
        composable(route = Screen.Lab_11_Screen.route) {
            Lab_11_Screen(navController = navController)
        }
        composable(route = Screen.Lab_12_Screen.route) {
            Lab_12_Screen(navController = navController)
        }
        composable(route = Screen.Lab_13_Screen.route) {
            Lab_13_Screen(navController = navController)
        }
        composable(
            route = Screen.Lab_6_Screen_2.route + "/{name}/{lastName}/{group}/{age}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                },
                navArgument("lastName") {
                    type = NavType.StringType
                },
                navArgument("age") {
                    type = NavType.StringType
                },
                navArgument("group") {
                    type = NavType.StringType
                }
            )
        ) {
            val name = it.arguments?.getString("name")
            val lastName = it.arguments?.getString("lastName")
            val age = it.arguments?.getString("age")
            val group = it.arguments?.getString("group")
            Lab_6_Screen_2(
                navController = navController,
                name = name ?: "Не указано",
                lastName = lastName ?: "Не указана",
                age = age ?: "Не указан",
                group = group ?: "Не указана",
            )
        }
        composable(
            route = Screen.Lab_7_Screen_1.route + "/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                }
            )
        ) {
            val name = it.arguments?.getString("name")
            Lab_7_Screen_1(
                navController = navController,
                name = name ?: "Не указано"
            )
        }
        composable(
            route = Screen.Lab_7_Screen_2.route + "/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                }
            )
        ) {
            val name = it.arguments?.getString("name")
            Lab_7_Screen_2(
                navController = navController,
                name = name ?: "Не указано"
            )
        }
    }
}