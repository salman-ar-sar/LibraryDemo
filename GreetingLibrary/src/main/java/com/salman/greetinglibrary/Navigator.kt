package com.salman.greetinglibrary

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.salman.greetinglibrary.dialogs.Dialogs
import com.salman.greetinglibrary.dialogs.Settings
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
            Dashboard(navController = navController, name = it.arguments?.getString("name"))
        }
        dialog(route = Dialogs.Settings.route) {
            Settings(
                onDismissRequest = { navController.popBackStack() },
                onConfirmation = { navController.popBackStack() },
                dialogTitle = "Settings",
                dialogText = "This is an example of an alert dialog with buttons.",
                icon = Icons.Default.Info,
            )
        }
    }
}

