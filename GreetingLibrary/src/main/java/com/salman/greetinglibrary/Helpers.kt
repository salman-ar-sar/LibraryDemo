package com.salman.greetinglibrary

import android.content.Context
import android.content.Intent

fun print() {
    println("Hello from Helpers.kt")
}

fun startRegistration(context: Context) {
    val intent = Intent(context, RegistrationActivity::class.java)
    context.startActivity(intent)
}