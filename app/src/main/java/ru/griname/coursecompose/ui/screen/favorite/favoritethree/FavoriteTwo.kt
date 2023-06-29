package ru.griname.coursecompose.ui.screen.favorite.favoritethree

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

@Composable
fun FavoriteTwo(
    onButtonClickListener: () -> Unit
) {
    val viewModel: FavoriteTwoViewModel = viewModel()
    val screenState = viewModel.screenState.observeAsState(FavoriteTwoState.Initial)
    val currentState = screenState.value

    if (currentState is FavoriteTwoState.FavoriteTwo) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = currentState.text)

                Button(onClick = { onButtonClickListener() }) {
                    Text(text = "To FavoriteThree")
                }
            }
        }
    }
}