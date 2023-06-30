package ru.griname.coursecompose.ui.screen.profile.profiletwo

sealed class ProfileThreeState {

    object Initial : ProfileThreeState()

    data class ProfileThree(
        val text: String
    ) : ProfileThreeState()
}
