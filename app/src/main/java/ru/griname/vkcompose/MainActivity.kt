package ru.griname.vkcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.griname.vkcompose.ui.screen.MainScreen
import ru.griname.vkcompose.ui.theme.VKComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VKComposeTheme {
                MainScreen()
            }
        }
    }
}