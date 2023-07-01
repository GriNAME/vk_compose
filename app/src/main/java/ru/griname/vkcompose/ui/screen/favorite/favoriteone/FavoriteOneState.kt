package ru.griname.vkcompose.ui.screen.favorite.favoriteone

sealed class FavoriteOneState {

    object Initial : FavoriteOneState()

    data class FavoriteOne(
        val text: String
    ) : FavoriteOneState()
}
