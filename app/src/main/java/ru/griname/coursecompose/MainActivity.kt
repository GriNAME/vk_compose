package ru.griname.coursecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.livedata.observeAsState
import ru.griname.coursecompose.ui.MainScreen
import ru.griname.coursecompose.ui.theme.VKComposeTheme

class MainActivity : ComponentActivity() {

    private val vm by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VKComposeTheme {
                val vkPosts = vm.feedPosts.observeAsState(listOf())

                MainScreen(
                    vkPosts = vkPosts.value,
                    dismissPost = vm::remove,
                    onViewClickListener = vm::updateCount,
                    onShareClickListener = vm::updateCount,
                    onCommentClickListener = vm::updateCount,
                    onLikeClickListener = vm::updateCount
                )
            }
        }
    }
}