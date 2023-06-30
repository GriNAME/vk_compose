package ru.griname.coursecompose.ui.screen.profile.profilethree

sealed class ProfileTwoState {

    object Initial : ProfileTwoState()

    data class ProfileTwo(
        val text: String
    ) : ProfileTwoState()
}
