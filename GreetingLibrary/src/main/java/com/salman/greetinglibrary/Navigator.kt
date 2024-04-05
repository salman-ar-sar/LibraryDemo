package com.salman.greetinglibrary

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.salman.greetinglibrary.screens.Dashboard
import com.salman.greetinglibrary.screens.Registration
import com.salman.greetinglibrary.screens.Screens

@Composable
fun Navigator() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.Registration.route) {
        composable(route = Screens.Registration.route) {
            Registration(navController = navController)
        }
        composable(
            route = Screens.Dashboard.route + "?name={name}",
            arguments = listOf(
                navArgument(name = "name") {
                    defaultValue = "Guest"
                }
            )
        ) {
            Dashboard(name = it.arguments?.getString("name"))
        }
    }
}

