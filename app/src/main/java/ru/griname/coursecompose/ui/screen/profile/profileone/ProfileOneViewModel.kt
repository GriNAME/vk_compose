package ru.griname.coursecompose.ui.screen.profile.profileone

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileOneViewModel : ViewModel() {

    private val _screenState = MutableLiveData<ProfileOneState>(ProfileOneState.Initial)
    val screenState: LiveData<ProfileOneState> = _screenState

    init {
        loadText()
    }

    private fun loadText() {
        _screenState.value = ProfileOneState.ProfileOne(text = "Profile One Screen")
    }
}