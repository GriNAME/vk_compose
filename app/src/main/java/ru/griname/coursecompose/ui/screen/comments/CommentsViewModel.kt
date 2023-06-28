package ru.griname.coursecompose.ui.screen.comments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.griname.coursecompose.domain.CommentPost
import ru.griname.coursecompose.domain.FeedPost

class CommentsViewModel(
    feedPost: FeedPost
) : ViewModel() {

    private val _screenState = MutableLiveData<CommentsScreenState>(CommentsScreenState.Initial)
    val screenState: LiveData<CommentsScreenState> = _screenState

    init {
        loadComments(feedPost)
    }

    fun loadComments(feedPost: FeedPost) {
        val comments = mutableListOf<CommentPost>().apply {
            repeat(10) {
                add(CommentPost(id = it))
            }
        }

        _screenState.value = CommentsScreenState.Comments(feedPost, comments)
    }
}