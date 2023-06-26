package ru.griname.coursecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import ru.griname.coursecompose.ui.MainScreen
import ru.griname.coursecompose.ui.theme.VKComposeTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VKComposeTheme {
                MainScreen(
                    viewModel = viewModel,
                )
            }
        }
    }
}