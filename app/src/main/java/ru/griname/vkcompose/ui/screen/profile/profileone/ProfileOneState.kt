package ru.griname.vkcompose.ui.screen.profile.profileone

sealed class ProfileOneState {

    object Initial : ProfileOneState()

    data class ProfileOne(
        val text: String
    ) : ProfileOneState()
}
