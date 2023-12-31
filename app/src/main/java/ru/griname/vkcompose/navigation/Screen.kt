package ru.griname.vkcompose.navigation

import android.net.Uri
import com.google.gson.Gson
import ru.griname.vkcompose.domain.FeedPost

sealed class Screen(
    val route: String
) {
    object Home : Screen(ROUTE_HOME)
    object NewsFeed : Screen(ROUTE_NEWS_FEED)
    object Comments : Screen(ROUTE_COMMENTS) {
        private const val ROUTE_FOR_ARGS = "ROUTE_COMMENTS"

        fun getRouteWithArgs(feedPost: FeedPost): String{
            val feedPostJson = Gson().toJson(feedPost)
            return "$ROUTE_FOR_ARGS/${feedPostJson.encode()}"
        }
    }

    object Favorite : Screen(ROUTE_FAVORITE)

    object FavoriteOne : Screen(ROUTE_FAVORITE_ONE)
    object FavoriteTwo : Screen(ROUTE_FAVORITE_TWO)
    object FavoriteThree : Screen(ROUTE_FAVORITE_THREE)
    object FavoriteFour : Screen(ROUTE_FAVORITE_FOUR)

    object Profile : Screen(ROUTE_PROFILE)

    object ProfileOne : Screen(ROUTE_PROFILE_ONE)
    object ProfileTwo : Screen(ROUTE_PROFILE_TWO)
    object ProfileThree : Screen(ROUTE_PROFILE_THREE)
    object ProfileFour : Screen(ROUTE_PROFILE_FOUR)

    companion object {

        const val KEY_FEED_POST = "KEY_FEED_POST"

        private const val ROUTE_HOME = "ROUTE_HOME"
        private const val ROUTE_COMMENTS = "ROUTE_COMMENTS" +
            "/{$KEY_FEED_POST}"
        private const val ROUTE_NEWS_FEED = "ROUTE_NEWS_FEED"

        private const val ROUTE_FAVORITE = "ROUTE_FAVORITE"
        private const val ROUTE_FAVORITE_ONE = "ROUTE_FAVORITE_ONE"
        private const val ROUTE_FAVORITE_TWO = "ROUTE_FAVORITE_TWO"
        private const val ROUTE_FAVORITE_THREE = "ROUTE_FAVORITE_THREE"
        private const val ROUTE_FAVORITE_FOUR = "ROUTE_FAVORITE_FOUR"

        private const val ROUTE_PROFILE = "ROUTE_PROFILE"
        private const val ROUTE_PROFILE_ONE = "ROUTE_PROFILE_ONE"
        private const val ROUTE_PROFILE_TWO = "ROUTE_PROFILE_TWO"
        private const val ROUTE_PROFILE_THREE = "ROUTE_PROFILE_THREE"
        private const val ROUTE_PROFILE_FOUR = "ROUTE_PROFILE_FOUR"
    }
}

fun String.encode(): String {
    return Uri.encode(this)
}