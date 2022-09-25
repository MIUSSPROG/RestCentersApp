package com.example.restcentersapp.presentation

import com.example.restcentersapp.R

sealed class Screen(val route: String){
    object BlogDetailScreen: Screen("blog_detail_screen")

    fun withArgs(vararg args: String): String{
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}

object Graph{
    const val ROOT = "root_graph"
    const val HOME = "hone_graph"
}

sealed class NavigationItem(val route: String, val icon: Int, val title: String){
    object Home: NavigationItem("home", R.drawable.ic_home_icon_2, "Главная")
    object Map: NavigationItem("map", R.drawable.ic_map_icon, "Карта")
    object Booking: NavigationItem("booking", R.drawable.ic_booked_icon, "Бронь")
    object Chats: NavigationItem("chats", R.drawable.ic_chats_icon, "Чаты")
    object Profile: NavigationItem("profile", R.drawable.ic_profile_icon, "Профиль")
}
