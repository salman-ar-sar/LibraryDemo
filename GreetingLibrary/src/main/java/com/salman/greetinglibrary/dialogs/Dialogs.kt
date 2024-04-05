package com.salman.greetinglibrary.dialogs

sealed class Dialogs(val route: String) {
    data object Settings : Dialogs("Settings")
}
