package ru.griname.coursecompose.ui.screen.home

import ru.griname.coursecompose.domain.FeedPost

sealed class NewsFeedScreenState {

    object Initial : NewsFeedScreenState()

    data class Posts(val posts: List<FeedPost>) : NewsFeedScreenState()
}
