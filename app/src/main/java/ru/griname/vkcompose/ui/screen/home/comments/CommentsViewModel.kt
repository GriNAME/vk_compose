package ru.griname.vkcompose.ui.screen.home.comments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.griname.vkcompose.domain.CommentPost
import ru.griname.vkcompose.domain.FeedPost

class CommentsViewModel(
    feedPost: FeedPost
) : ViewModel() {

    private val _screenState = MutableLiveData<CommentsScreenState>(CommentsScreenState.Initial)
    val screenState: LiveData<CommentsScreenState> = _screenState

    init {
        loadComments(feedPost)
    }

    private fun loadComments(feedPost: FeedPost) {
        val comments = mutableListOf<CommentPost>().apply {
            repeat(10) {
                add(CommentPost(id = it))
            }
        }

        _screenState.value = CommentsScreenState.Comments(feedPost, comments)
    }
}