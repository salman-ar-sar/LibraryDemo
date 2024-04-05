package com.salman.greetinglibrary.screens

sealed class Screens(val route: String) {
    data object Registration : Screens("Registration")
    data object Dashboard : Screens("Dashboard")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}