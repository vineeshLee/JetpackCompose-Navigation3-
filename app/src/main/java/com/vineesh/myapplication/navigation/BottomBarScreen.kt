package com.vineesh.myapplication.navigation

import androidx.compose.runtime.saveable.Saver
import androidx.navigation3.runtime.NavKey
import com.vineesh.myapplication.R
import kotlinx.serialization.Serializable

val bottomBarItems = listOf<BottomBarScreen>(
    BottomBarScreen.Home,
    BottomBarScreen.Search,
    BottomBarScreen.Profile
)

@Serializable
sealed class BottomBarScreen(
    val icon: Int,
    val title: String,
): NavKey {
    @Serializable
    data object Home : BottomBarScreen(
        icon = R.drawable.ic_home,
        title = "Home"
    )

    @Serializable
    data object Search : BottomBarScreen(
        icon = R.drawable.ic_search,
        title = "Search"
    )

    @Serializable
    data object Profile : BottomBarScreen(
        icon = R.drawable.i_person,
        title = "Profile"
    )
}

val BottomBarScreenSaver = Saver<BottomBarScreen, String>(
    save = { it::class.simpleName ?: "Unknown" },
    restore = {
        when (it) {
            BottomBarScreen.Home::class.simpleName -> BottomBarScreen.Home
            BottomBarScreen.Search::class.simpleName -> BottomBarScreen.Search
            BottomBarScreen.Profile::class.simpleName -> BottomBarScreen.Profile
            else -> BottomBarScreen.Home
        }
    }
)