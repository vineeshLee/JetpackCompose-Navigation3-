package com.vineesh.myapplication.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed class Screen: NavKey {
    @Serializable
    data object LoginScreen : Screen()

    @Serializable
    data object NestedGraph : Screen()

    @Serializable
    data object Profile : Screen()
}
