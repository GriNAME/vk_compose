package ru.griname.coursecompose.ui

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import ru.griname.coursecompose.domain.FeedPost
import ru.griname.coursecompose.domain.StatisticsItem

@Composable
fun MainScreen(
    vkPosts: List<FeedPost>,
    dismissPost: (FeedPost) -> Unit,
    onViewClickListener: (StatisticsItem, FeedPost) -> Unit,
    onShareClickListener: (StatisticsItem, FeedPost) -> Unit,
    onCommentClickListener: (StatisticsItem, FeedPost) -> Unit,
    onLikeClickListener: (StatisticsItem, FeedPost) -> Unit
) {
    Scaffold(
        bottomBar = {
            BottomNavigation {
                val selectedPosition = remember {
                    mutableStateOf(0)
                }

                val items = listOf(
                    NavigationItem.Home,
                    NavigationItem.Favorite,
                    NavigationItem.Profile
                )
                items.forEachIndexed { index, item ->
                    BottomNavigationItem(
                        selected = selectedPosition.value == index,
                        onClick = { selectedPosition.value = index },
                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(text = stringResource(id = item.titleResId))
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        paddingValues

        VkPostList(
            vkPosts = vkPosts,
            dismissPost = dismissPost,
            onViewClickListener = onViewClickListener,
            onShareClickListener = onShareClickListener,
            onCommentClickListener = onCommentClickListener,
            onLikeClickListener = onLikeClickListener
        )
    }
}