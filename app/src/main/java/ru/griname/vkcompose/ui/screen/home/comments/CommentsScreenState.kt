package ru.griname.vkcompose.ui.screen.home.comments

import ru.griname.vkcompose.domain.FeedPost
import ru.griname.vkcompose.domain.CommentPost

sealed class CommentsScreenState {

    object Initial : CommentsScreenState()

    data class Comments(
        val feedPost: FeedPost,
        val comments: List<CommentPost>
    ) : CommentsScreenState()
}
