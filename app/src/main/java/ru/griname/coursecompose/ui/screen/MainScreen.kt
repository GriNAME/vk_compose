package ru.griname.coursecompose.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.griname.coursecompose.domain.FeedPost
import ru.griname.coursecompose.navigation.AppNavGraph
import ru.griname.coursecompose.navigation.Screen
import ru.griname.coursecompose.navigation.rememberNavigationState
import ru.griname.coursecompose.ui.screen.comments.CommentsScreen
import ru.griname.coursecompose.ui.screen.home.HomeScreen

@Composable
fun MainScreen() {
    val navigationState = rememberNavigationState()

    val commentsToPost: MutableState<FeedPost?> = remember {
        mutableStateOf(null)
    }

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
                HomeScreen(
                    paddingValues = paddingValues,
                    onCommentClickListener = { feedPost ->
                        commentsToPost.value = feedPost
                        navigationState.navigateIntoNestedGraph(Screen.Comments.route)
                    })
            },
            commentsScreenContent = {
                CommentsScreen(
                    feedPost = commentsToPost.value!!,
                    onBackPressed = {
                        navigationState.navHostController.popBackStack()
                    }
                )
            },
            favoriteScreenContent = { CountText(text = "Favorite") },
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