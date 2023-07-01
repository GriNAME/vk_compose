package ru.griname.vkcompose.ui.screen.favorite.favoritethree

sealed class FavoriteTwoState {

    object Initial : FavoriteTwoState()

    data class FavoriteTwo(
        val text: String
    ) : FavoriteTwoState()
}
