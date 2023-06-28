package ru.griname.coursecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.griname.coursecompose.ui.screen.MainScreen
import ru.griname.coursecompose.ui.theme.VKComposeTheme

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