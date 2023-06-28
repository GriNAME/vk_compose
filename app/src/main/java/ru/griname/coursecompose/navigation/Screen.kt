package ru.griname.coursecompose.navigation

import android.net.Uri
import ru.griname.coursecompose.domain.FeedPost

sealed class Screen(
    val route: String
) {
    object Home : Screen(ROUTE_HOME)
    object NewsFeed : Screen(ROUTE_NEWS_FEED)
    object Comments : Screen(ROUTE_COMMENTS) {
        private const val ROUTE_FOR_ARGS = "ROUTE_COMMENTS"

        fun getRouteWithArgs(feedPost: FeedPost): String{
            return "$ROUTE_FOR_ARGS/${feedPost.id}/${feedPost.contentText.encode()}"
        }
    }
    object Favorite : Screen(ROUTE_FAVORITE)
    object Profile : Screen(ROUTE_PROFILE)

    companion object {

        const val KEY_FEED_POST_ID = "KEY_FEED_POST_ID"
        const val KEY_FEED_POST_TEXT = "KEY_FEED_POST_TEXT"

        private const val ROUTE_HOME = "ROUTE_HOME"
        private const val ROUTE_COMMENTS = "ROUTE_COMMENTS" +
            "/{$KEY_FEED_POST_ID}" +
            "/{$KEY_FEED_POST_TEXT}"
        private const val ROUTE_NEWS_FEED = "ROUTE_NEWS_FEED"
        private const val ROUTE_FAVORITE = "ROUTE_FAVORITE"
        private const val ROUTE_PROFILE = "ROUTE_PROFILE"
    }
}

fun String.encode(): String {
    return Uri.encode(this)
}