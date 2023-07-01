package ru.griname.vkcompose.ui.screen.favorite.favoritefour

sealed class FavoriteFourState {

    object Initial : FavoriteFourState()

    data class FavoriteFour(
        val text: String
    ) : FavoriteFourState()
}
