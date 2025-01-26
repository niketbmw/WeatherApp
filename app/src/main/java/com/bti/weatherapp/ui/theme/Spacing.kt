package com.bti.weatherapp.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

val Spacing = WeatherAppSpacing(
    none = 0.dp,
    tiny = 2.dp,
    extraSmall = 4.dp,
    small = 8.dp,
    medium = 16.dp,
    large = 24.dp,
    extraLarge = 32.dp,
    huge = 64.dp
)

@Immutable
data class WeatherAppSpacing(
    val none: Dp,
    val tiny: Dp,
    val extraSmall: Dp,
    val small: Dp,
    val medium: Dp,
    val large: Dp,
    val extraLarge: Dp,
    val huge: Dp
)

/**
 * CompositionLocal used to specify the default [Spacing] for composables.
 * */
inline val LocalSpacing
    get() = compositionLocalOf { Spacing }

/**
 * Retrieves the current [Spacing] at the call site's position in the hierarchy.
 */
val MaterialTheme.spacing
    @Composable
    @ReadOnlyComposable
    get() = LocalSpacing.current