package com.wantech.gmailui.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = PrimaryDark,
    primaryVariant = PrimaryDark,
    secondary = SecondaryColor,
    background = SurfaceNight,
    surface = SurfaceNight,
    onPrimary = OnPrimaryNight,
    onSecondary = Color.Black,
    onBackground = OnSurfaceNight,
    onSurface = OnSurfaceNight,
)

private val LightColorPalette = lightColors(
    primary = PrimaryLight,
    primaryVariant = PrimaryDark,
    secondary = SecondaryColor,

    background = SurfaceLight,
    surface = SurfaceLight,
    onPrimary = OnPrimaryLight,
    onSecondary = Color.Black,
    onBackground = OnSurfaceLight,
    onSurface = OnSurfaceLight,

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun GmailUiTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}