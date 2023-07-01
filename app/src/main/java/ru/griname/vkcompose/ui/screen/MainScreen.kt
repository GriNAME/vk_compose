package ru.griname.vkcompose.ui.screen

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.griname.vkcompose.navigation.AppNavGraph
import ru.griname.vkcompose.navigation.Screen
import ru.griname.vkcompose.navigation.rememberNavigationState
import ru.griname.vkcompose.ui.screen.favorite.favoritefour.FavoriteFour
import ru.griname.vkcompose.ui.screen.favorite.favoriteone.FavoriteOne
import ru.griname.vkcompose.ui.screen.favorite.favoritethree.FavoriteTwo
import ru.griname.vkcompose.ui.screen.favorite.favoritetwo.FavoriteThree
import ru.griname.vkcompose.ui.screen.home.comments.CommentsScreen
import ru.griname.vkcompose.ui.screen.home.newsfeed.NewsFeedScreen
import ru.griname.vkcompose.ui.screen.profile.profilefour.ProfileFour
import ru.griname.vkcompose.ui.screen.profile.profileone.ProfileOne
import ru.griname.vkcompose.ui.screen.profile.profilethree.ProfileTwo
import ru.griname.vkcompose.ui.screen.profile.profiletwo.ProfileThree

@Composable
fun MainScreen() {
    val navigationState = rememberNavigationState()

    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navigationState.navHostController.currentBackStackEntryAsState()
                val items = listOf(
                    NavigationItem.Home,
                    NavigationItem.Favorite,
                    NavigationItem.Profile
                )

                items.forEach { item ->
                    val selected = navBackStackEntry?.destination?.hierarchy?.any { destination ->
                        destination.route == item.screen.route
                    } ?: false

                    BottomNavigationItem(
                        selected = selected,
                        onClick = { navigationState.navigateTo(item.screen.route) },
                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = null
                            )
                        },
                        label = { Text(text = stringResource(id = item.titleResId)) },
                        selectedContentColor = MaterialTheme.colors.onPrimary,
                        unselectedContentColor = MaterialTheme.colors.onSecondary
                    )
                }
            }
        }
    ) { paddingValues ->
        AppNavGraph(
            navHostController = navigationState.navHostController,
            newsFeedScreenContent = {
                NewsFeedScreen(
                    paddingValues = paddingValues,
                    onCommentClickListener = { feedPost ->
                        navigationState.navigate(
                            route = Screen.Comments.getRouteWithArgs(feedPost)
                        )
                    })
            },
            commentsScreenContent = { feedPost ->
                CommentsScreen(
                    feedPost = feedPost,
                    onCommentClickListener = {
                        navigationState.navigate(Screen.FavoriteThree.route)
                    },
                    onBackPressed = {
                        navigationState.navHostController.popBackStack()
                    }
                )
            },
            favoriteOneScreenContent = {
                FavoriteOne {
                    navigationState.navigate(
                        route = Screen.FavoriteTwo.route
                    )
                }
            },
            favoriteTwoScreenContent = {
                FavoriteTwo {
                    navigationState.navigate(
                        route = Screen.FavoriteThree.route
                    )
                }
            },
            favoriteThreeScreenContent = {
                FavoriteThree {
                    navigationState.navigateIgnoringBackStack(
                        route = Screen.FavoriteFour.route,
                        ignoreDestination = Screen.FavoriteThree.route
                    )
                }
            },
            favoriteFourScreenContent = {
                FavoriteFour(
                    onButtonClickListener = {
                        navigationState.navHostController.popBackStack()
                    },
                    onButtonDeepClickListener = {
                        navigationState.navigate(Screen.ProfileThree.route)
                    }
                )

            },
            profileOneScreenContent = {
                ProfileOne {
                    navigationState.navigate(Screen.ProfileTwo.route)
                }
            },
            profileTwoScreenContent = {
                ProfileTwo {
                    navigationState.navigate(Screen.ProfileThree.route)
                }
            },
            profileThreeScreenContent = {
                ProfileThree {
                    navigationState.navigate(Screen.ProfileFour.route)
                }
            },
            profileFourScreenContent = {
                ProfileFour {
                    navigationState.navHostController.popBackStack(
                        route = Screen.ProfileOne.route,
                        inclusive = false,
                        saveState = true
                    )
                }
            }
        )
    }
}