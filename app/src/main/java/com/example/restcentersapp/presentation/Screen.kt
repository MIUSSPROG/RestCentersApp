package com.example.restcentersapp.presentation

import com.example.restcentersapp.R

sealed class Screen(val route: String){
//    object BlogListScreen: Screen("blog_list_screen")
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
    object Home: NavigationItem("home", R.drawable.home_icon, "Главная")
    object Map: NavigationItem("map", R.drawable.map_icon, "Карта")
    object Booking: NavigationItem("booking", R.drawable.booked, "Бронь")
    object Chats: NavigationItem("chats", R.drawable.chats, "Чаты")
    object Profile: NavigationItem("profile", R.drawable.profile_icon, "Профиль")
}
