package ru.griname.vkcompose.ui.screen.favorite.favoritetwo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FavoriteThreeViewModel : ViewModel() {

    private val _screenState = MutableLiveData<FavoriteThreeState>(FavoriteThreeState.Initial)
    val screenState: LiveData<FavoriteThreeState> = _screenState

    init {
        loadText()
    }

    private fun loadText() {
        _screenState.value = FavoriteThreeState.FavoriteThree(text = "Favorite Three Screen")
    }
}