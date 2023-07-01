package ru.griname.vkcompose.ui.screen.profile.profiletwo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.griname.vkcompose.ui.component.CountText

@Composable
fun ProfileThree(
    onButtonClickListener: () -> Unit
) {
    val viewModel: ProfileThreeViewModel = viewModel()
    val screenState = viewModel.screenState.observeAsState(ProfileThreeState.Initial)
    val currentState = screenState.value

    if (currentState is ProfileThreeState.ProfileThree) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CountText(text = currentState.text)

                Button(
                    onClick = { onButtonClickListener() }
                ) {
                    Text(text = "To ProfileFour Without Backstack")
                }
            }
        }
    }
}