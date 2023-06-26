package ru.griname.coursecompose.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.DismissDirection
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.griname.coursecompose.domain.FeedPost
import ru.griname.coursecompose.domain.StatisticsItem

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
fun VkPostList(
    vkPosts: List<FeedPost>,
    dismissPost: (FeedPost) -> Unit,
    onViewClickListener: (StatisticsItem, FeedPost) -> Unit,
    onShareClickListener: (StatisticsItem, FeedPost) -> Unit,
    onCommentClickListener: (StatisticsItem, FeedPost) -> Unit,
    onLikeClickListener: (StatisticsItem, FeedPost) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(
            top = 16.dp,
            start = 8.dp,
            end = 8.dp,
            bottom = 72.dp
        ),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(
            items = vkPosts,
            key = { it.id }
        ) { feedPost ->
            val dismissState = rememberDismissState()

            if (dismissState.isDismissed(DismissDirection.EndToStart)) {
                dismissPost(feedPost)
            }

            SwipeToDismiss(
                modifier = Modifier.animateItemPlacement(),
                state = dismissState,
                background = { VkPostDismissBg() }
            ) {
                VkPost(
                    feedPost = feedPost,
                    onViewClickListener = { onViewClickListener(it, feedPost) },
                    onShareClickListener = { onShareClickListener(it, feedPost) },
                    onCommentClickListener = { onCommentClickListener(it, feedPost) },
                    onLikeClickListener = { onLikeClickListener(it, feedPost) }
                )
            }

        }
    }
}