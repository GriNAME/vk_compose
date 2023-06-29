package ru.griname.coursecompose.ui.screen.favorite.favoritetwo

sealed class FavoriteThreeState {

    object Initial : FavoriteThreeState()

    data class FavoriteThree(
        val text: String
    ) : FavoriteThreeState()
}
