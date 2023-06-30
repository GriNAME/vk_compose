package ru.griname.coursecompose.ui.screen.profile.profiletwo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileThreeViewModel : ViewModel() {

    private val _screenState = MutableLiveData<ProfileThreeState>(ProfileThreeState.Initial)
    val screenState: LiveData<ProfileThreeState> = _screenState

    init {
        loadText()
    }

    private fun loadText() {
        _screenState.value = ProfileThreeState.ProfileThree(text = "Profile Three Screen")
    }
}