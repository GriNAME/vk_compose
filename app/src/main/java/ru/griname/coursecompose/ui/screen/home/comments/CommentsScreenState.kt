package ru.griname.coursecompose.ui.screen.home.comments

import ru.griname.coursecompose.domain.FeedPost
import ru.griname.coursecompose.domain.CommentPost

sealed class CommentsScreenState {

    object Initial : CommentsScreenState()

    data class Comments(
        val feedPost: FeedPost,
        val comments: List<CommentPost>
    ) : CommentsScreenState()
}
