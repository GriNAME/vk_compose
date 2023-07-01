package ru.griname.vkcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import ru.griname.vkcompose.domain.FeedPost

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    newsFeedScreenContent: @Composable () -> Unit,
    commentsScreenContent: @Composable (FeedPost) -> Unit,
    favoriteOneScreenContent: @Composable () -> Unit,
    favoriteTwoScreenContent: @Composable () -> Unit,
    favoriteThreeScreenContent: @Composable () -> Unit,
    favoriteFourScreenContent: @Composable () -> Unit,
    profileOneScreenContent: @Composable () -> Unit,
    profileTwoScreenContent: @Composable () -> Unit,
    profileThreeScreenContent: @Composable () -> Unit,
    profileFourScreenContent: @Composable () -> Unit,
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

        profileNavGraph(
            profileOneScreenContent = profileOneScreenContent,
            profileTwoScreenContent = profileTwoScreenContent,
            profileThreeScreenContent = profileThreeScreenContent,
            profileFourScreenContent = profileFourScreenContent
        )
    }
}