package ru.griname.vkcompose.ui.screen.home.newsfeed

import ru.griname.vkcompose.domain.FeedPost

sealed class NewsFeedScreenState {

    object Initial : NewsFeedScreenState()

    data class Posts(val posts: List<FeedPost>) : NewsFeedScreenState()
}
