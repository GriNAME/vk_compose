package ru.griname.coursecompose.ui.screen.favorite.favoriteone

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FavoriteOneViewModel : ViewModel() {

    private val _screenState = MutableLiveData<FavoriteOneState>(FavoriteOneState.Initial)
    val screenState: LiveData<FavoriteOneState> = _screenState

    init {
        loadText()
    }

    private fun loadText() {
        _screenState.value = FavoriteOneState.FavoriteOne(text = "Favorite One Screen")
    }
}