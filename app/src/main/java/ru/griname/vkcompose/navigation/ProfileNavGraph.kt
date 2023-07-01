package ru.griname.vkcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.profileNavGraph(
    profileOneScreenContent: @Composable () -> Unit,
    profileTwoScreenContent: @Composable () -> Unit,
    profileThreeScreenContent: @Composable () -> Unit,
    profileFourScreenContent: @Composable () -> Unit,
) {
    navigation(
        startDestination = Screen.ProfileOne.route,
        route = Screen.Profile.route
    ) {
        composable(Screen.ProfileOne.route) {
            profileOneScreenContent()
        }

        composable(Screen.ProfileTwo.route) {
            profileTwoScreenContent()
        }


        composable(Screen.ProfileThree.route) {
            profileThreeScreenContent()
        }

        composable(Screen.ProfileFour.route) {
            profileFourScreenContent()
        }
    }
}