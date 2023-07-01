package ru.griname.vkcompose.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun CountText(text: String) {
    var count by rememberSaveable { mutableStateOf(0) }
    Text(
        modifier = Modifier.clickable { count++ },
        text = "$text. Count: $count"
    )
}