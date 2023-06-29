package ru.griname.coursecompose.ui.screen.favorite.favoritefour

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FavoriteFourViewModel : ViewModel() {

    private val _screenState = MutableLiveData<FavoriteFourState>(FavoriteFourState.Initial)
    val screenState: LiveData<FavoriteFourState> = _screenState

    init {
        loadText()
    }

    private fun loadText() {
        _screenState.value = FavoriteFourState.FavoriteFour(text = "Favorite Four Screen")
    }
}