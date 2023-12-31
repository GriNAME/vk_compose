package ru.griname.vkcompose.ui.screen.home.comments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.griname.vkcompose.domain.FeedPost

@Suppress("UNCHECKED_CAST")
class CommentsViewModelFactory(
    private val feedPost: FeedPost
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CommentsViewModel(feedPost) as T
    }
}