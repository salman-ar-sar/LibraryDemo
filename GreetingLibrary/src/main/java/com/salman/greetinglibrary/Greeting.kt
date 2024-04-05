package com.salman.greetinglibrary

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(all = 16.dp)
            .border(width = 1.dp, color = MaterialTheme.colorScheme.secondary)
            .padding(all = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "Hello $name",
            modifier = modifier,
            color = MaterialTheme.colorScheme.tertiary,
            style = MaterialTheme.typography.headlineLarge,
        )
        Spacer(modifier = Modifier.width(16.dp))
        Button(onClick = { println("Button clicked") }) {
            Text(text = "Button")
        }
    }
}