package ru.griname.coursecompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.griname.coursecompose.domain.FeedPost

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    newsFeedScreenContent: @Composable () -> Unit,
    commentsScreenContent: @Composable (FeedPost) -> Unit,
    favoriteOneScreenContent: @Composable () -> Unit,
    favoriteTwoScreenContent: @Composable () -> Unit,
    favoriteThreeScreenContent: @Composable () -> Unit,
    favoriteFourScreenContent: @Composable () -> Unit,
    profileScreenContent: @Composable () -> Unit
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Home.route
    ) {
        homeScreenNavGraph(
            newsFeedScreenContent = newsFeedScreenContent,
            commentsScreenContent = commentsScreenContent
        )

        favoriteNavGraph(
            favoriteOneScreenContent = favoriteOneScreenContent,
            favoriteTwoScreenContent = favoriteTwoScreenContent,
            favoriteThreeScreenContent = favoriteThreeScreenContent,
            favoriteFourScreenContent = favoriteFourScreenContent,
        )

        composable(Screen.Profile.route) { profileScreenContent() }
    }
}