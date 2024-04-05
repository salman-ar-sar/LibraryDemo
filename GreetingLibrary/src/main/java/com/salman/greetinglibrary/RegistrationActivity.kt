package com.salman.greetinglibrary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class RegistrationActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Navigator()
        }
    }
}