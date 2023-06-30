package ru.griname.coursecompose.ui.screen.profile.profilefour

sealed class ProfileFourState {

    object Initial : ProfileFourState()

    data class ProfileFour(
        val text: String
    ) : ProfileFourState()
}
