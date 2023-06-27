package ru.griname.coursecompose.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.DismissDirection
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.griname.coursecompose.MainViewModel
import ru.griname.coursecompose.domain.FeedPost

@Composable
fun HomeScreen(
    viewModel: MainViewModel,
    paddingValues: PaddingValues
) {
    val screenState = viewModel.screenState.observeAsState(HomeScreenState.Initial)

    when (val currentState = screenState.value) {
        is HomeScreenState.Posts -> FeedPosts(
            feedPosts = currentState.posts,
            viewModel = viewModel,
            paddingValues = paddingValues
        )
        is HomeScreenState.Comments -> {
            CommentsScreen(
                feedPost = currentState.feedPost,
                comments = currentState.comments
            ) {
                viewModel.closeComments()
            }
            BackHandler {
                viewModel.closeComments()
            }
        }
        is HomeScreenState.Initial -> {
            // Nothing to do
        }
    }
}

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
private fun FeedPosts(
    viewModel: MainViewModel,
    feedPosts: List<FeedPost>,
    paddingValues: PaddingValues
) {
    LazyColumn(
        modifier = Modifier.padding(paddingValues),
        contentPadding = PaddingValues(
            top = 16.dp,
            start = 8.dp,
            end = 8.dp,
            bottom = 72.dp
        ),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(
            items = feedPosts,
            key = { it.id }
        ) { feedPost ->
            val dismissState = rememberDismissState()

            if (dismissState.isDismissed(DismissDirection.EndToStart)) {
                viewModel.remove(feedPost)
            }

            SwipeToDismiss(
                modifier = Modifier.animateItemPlacement(),
                state = dismissState,
                background = { VkPostDismissBg() }
            ) {
                PostCard(
                    feedPost = feedPost,
                    onViewClickListener = { statisticsItem ->
                        viewModel.updateCount(statisticsItem, feedPost)
                    },
                    onShareClickListener = { statisticsItem ->
                        viewModel.updateCount(statisticsItem, feedPost)
                    },
                    onCommentClickListener = {
                        viewModel.showComments(feedPost)
                    },
                    onLikeClickListener = { statisticsItem ->
                        viewModel.updateCount(statisticsItem, feedPost)
                    }
                )
            }

        }
    }

}