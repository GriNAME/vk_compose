package ru.griname.vkcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.favoriteNavGraph(
    favoriteOneScreenContent: @Composable () -> Unit,
    favoriteTwoScreenContent: @Composable () -> Unit,
    favoriteThreeScreenContent: @Composable () -> Unit,
    favoriteFourScreenContent: @Composable () -> Unit
) {
    navigation(
        startDestination = Screen.FavoriteOne.route,
        route = Screen.Favorite.route
    ) {
        composable(Screen.FavoriteOne.route) { favoriteOneScreenContent() }

        composable(Screen.FavoriteTwo.route) { favoriteTwoScreenContent() }

        composable(Screen.FavoriteThree.route) { favoriteThreeScreenContent() }

        composable(Screen.FavoriteFour.route) { favoriteFourScreenContent() }
    }
}