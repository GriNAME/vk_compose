package ru.griname.vkcompose.ui.screen.favorite.favoritethree

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FavoriteTwoViewModel : ViewModel() {

    private val _screenState = MutableLiveData<FavoriteTwoState>(FavoriteTwoState.Initial)
    val screenState: LiveData<FavoriteTwoState> = _screenState

    init {
        loadText()
    }

    private fun loadText() {
        _screenState.value = FavoriteTwoState.FavoriteTwo(text = "Favorite Two Screen")
    }
}