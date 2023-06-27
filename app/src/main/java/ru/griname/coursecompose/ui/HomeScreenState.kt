package ru.griname.coursecompose.ui

import ru.griname.coursecompose.domain.FeedPost
import ru.griname.coursecompose.domain.PostComment

sealed class HomeScreenState {

    object Initial : HomeScreenState()

    data class Posts(val posts: List<FeedPost>) : HomeScreenState()

    data class Comments(
        val feedPost: FeedPost,
        val comments: List<PostComment>
    ) : HomeScreenState()
}
