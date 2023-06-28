package ru.griname.coursecompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import ru.griname.coursecompose.domain.FeedPost

fun NavGraphBuilder.homeScreenNavGraph(
    newsFeedScreenContent: @Composable () -> Unit,
    commentsScreenContent: @Composable (FeedPost) -> Unit
) {
    navigation(
        startDestination = Screen.NewsFeed.route,
        route = Screen.Home.route
    ) {
        composable(Screen.NewsFeed.route) { newsFeedScreenContent() }

        composable(
            route = Screen.Comments.route,
            arguments = listOf(
                navArgument(name = Screen.KEY_FEED_POST_ID) {
                    type = NavType.IntType
                },
                navArgument(name = Screen.KEY_FEED_POST_TEXT) {
                    type = NavType.StringType
                }
            )
        ) { navBackStackEntry ->
            val feedPostId = navBackStackEntry.arguments
                ?.getInt(Screen.KEY_FEED_POST_ID) ?: 0
            val feedPostText = navBackStackEntry.arguments
                ?.getString(Screen.KEY_FEED_POST_TEXT) ?: ""
            commentsScreenContent(FeedPost(id = feedPostId, contentText = feedPostText))
        }
    }
}