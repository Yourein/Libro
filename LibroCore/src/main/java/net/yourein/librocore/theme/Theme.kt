package net.yourein.librocore.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.TextStyle
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = LibroPrimary,
    secondary = LibroSecondary,
    tertiary = Pink80,
    background = LibroBackground,
    onSurface = LibroPrimary,
    surface = LibroBackground,
    error = LibroError,
    onError = LibroError,
    onSecondaryContainer = LibroPrimary,
    secondaryContainer = LibroTransparent,
)

private val LightColorScheme = lightColorScheme(
    primary = LibroPrimary,
    secondary = LibroSecondary,
    tertiary = Pink40,
    background = LibroBackground,
    onSurface = LibroPrimary,
    surface = LibroBackground,
    error = LibroError,
    onError = LibroError,
    onSecondaryContainer = LibroPrimary,
    secondaryContainer = LibroTransparent,
)

@Composable
fun LibroTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
//        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//            val context = LocalContext.current
//            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
//        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.background.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = {
            ProvideTextStyle(
                value = TextStyle(color = LibroPrimary),
                content = content
            )
        }
    )
}