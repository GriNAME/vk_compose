package ru.griname.vkcompose.ui.screen.profile.profilefour

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileFourViewModel : ViewModel() {

    private val _screenState = MutableLiveData<ProfileFourState>(ProfileFourState.Initial)
    val screenState: LiveData<ProfileFourState> = _screenState

    init {
        loadText()
    }

    private fun loadText() {
        _screenState.value = ProfileFourState.ProfileFour(text = "Profile Four Screen")
    }
}