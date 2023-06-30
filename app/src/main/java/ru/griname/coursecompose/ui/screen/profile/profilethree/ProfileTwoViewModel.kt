package ru.griname.coursecompose.ui.screen.profile.profilethree

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileTwoViewModel : ViewModel() {

    private val _screenState = MutableLiveData<ProfileTwoState>(ProfileTwoState.Initial)
    val screenState: LiveData<ProfileTwoState> = _screenState

    init {
        loadText()
    }

    private fun loadText() {
        _screenState.value = ProfileTwoState.ProfileTwo(text = "Profile Two Screen")
    }
}