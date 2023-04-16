package com.example.tidya.bottomnav

import com.example.tidya.R

sealed class BottomBarScreen(
    val  route: String,
    val title: String,
    val icon: Int,
    val icon_focused: Int
){
    // Home
    object Home: BottomBarScreen(
        route = "home",
        title = "Home",
        icon = R.drawable.ic_home,
        icon_focused = R.drawable.ic_home_light
    )

    // Search
    object Search: BottomBarScreen(
        route = "search",
        title = "Search",
        icon = R.drawable.ic_search,
        icon_focused = R.drawable.ic_search_light
    )

    // History
    object History: BottomBarScreen(
        route = "history",
        title = "History",
        icon = R.drawable.ic_history,
        icon_focused = R.drawable.ic_history_light
    )

    object Add: BottomBarScreen(
        route = "add",
        title = "Add",
        icon = R.drawable.baseline_add_24,
        icon_focused = R.drawable.baseline_add_24
    )

}
