package ru.griname.coursecompose.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.griname.coursecompose.navigation.AppNavGraph
import ru.griname.coursecompose.navigation.Screen
import ru.griname.coursecompose.navigation.rememberNavigationState
import ru.griname.coursecompose.ui.screen.favorite.favoritefour.FavoriteFour
import ru.griname.coursecompose.ui.screen.favorite.favoriteone.FavoriteOne
import ru.griname.coursecompose.ui.screen.favorite.favoritethree.FavoriteTwo
import ru.griname.coursecompose.ui.screen.favorite.favoritetwo.FavoriteThree
import ru.griname.coursecompose.ui.screen.home.comments.CommentsScreen
import ru.griname.coursecompose.ui.screen.home.newsfeed.NewsFeedScreen

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
                        navigationState.navigate(Screen.FavoriteFour.route)
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
                    navigationState.navigateWithoutBackStack(
                        route = Screen.FavoriteFour.route,
                        ignoreDestination = Screen.FavoriteThree.route
                    )
                }
            },
            favoriteFourScreenContent = {
                FavoriteFour {
                    navigationState.navHostController.popBackStack()
                }
            },
            profileScreenContent = { CountText(text = "Profile") }
        )
    }
}

@Composable
private fun CountText(text: String) {
    var count by rememberSaveable { mutableStateOf(0) }
    Text(
        modifier = Modifier.clickable { count++ },
        text = "$text Count: $count"
    )
}