package com.salman.librarydemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.salman.apiclient.getPost
import com.salman.greetinglibrary.Greeting
import com.salman.greetinglibrary.ImageCard
import com.salman.greetinglibrary.startRegistration
import com.salman.librarydemo.ui.theme.LibraryDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val painter = painterResource(id = R.drawable.flowers)
            val description = "Flowers"
            val title = "Flowers  are beautiful"
            val context = LocalContext.current

            LibraryDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Greeting("World!")
                        Button(onClick = {
                            // Replace with actual required postId
                            getPost(postId = 1, onSuccess = { post ->
                                println(post.toString() + "Post")
                            }, onError = {
                                println("Error ${it.localizedMessage}")
                            })

                            startRegistration(context)
                        }) {
                            Text(text = "Go to registration")
                        }
                        ImageCard(
                            painter = painter,
                            contentDescription = description,
                            title = title
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LibraryDemoTheme {
        Greeting("Android")
    }
}