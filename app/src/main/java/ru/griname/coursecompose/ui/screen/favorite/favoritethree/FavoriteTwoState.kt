package ru.griname.coursecompose.ui.screen.favorite.favoritethree

sealed class FavoriteTwoState {

    object Initial : FavoriteTwoState()

    data class FavoriteTwo(
        val text: String
    ) : FavoriteTwoState()
}
