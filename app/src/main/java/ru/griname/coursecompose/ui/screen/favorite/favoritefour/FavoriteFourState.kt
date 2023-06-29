package ru.griname.coursecompose.ui.screen.favorite.favoritefour

sealed class FavoriteFourState {

    object Initial : FavoriteFourState()

    data class FavoriteFour(
        val text: String
    ) : FavoriteFourState()
}
