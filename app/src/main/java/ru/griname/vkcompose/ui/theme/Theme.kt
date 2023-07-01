package ru.griname.vkcompose.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@SuppressLint("ConflictingOnColor")
private val DarkColorScheme = darkColors(
    primary = Color.Black,
    secondary = Color.Gray,
    background = Color.Black,
    surface = Color.Black,
    onPrimary = Color.White,
    onSecondary = Black500,
    onBackground = Color.White,
    onSurface = Color.White
)

@SuppressLint("ConflictingOnColor")
private val LightColorScheme = lightColors(
    primary = Color.White,
    secondary = Color.Gray,
    background = Color.White,
    surface = Color.White,
    onPrimary = Black900,
    onSecondary = Black500,
    onBackground = Color.Black,
    onSurface = Color.Black
)

@Composable
fun VKComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme
    else LightColorScheme

    MaterialTheme(
        colors = colorScheme,
        typography = Typography,
        content = content
    )
}
