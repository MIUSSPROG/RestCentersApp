package com.example.restcentersapp.presentation

sealed class Screen(val route: String){
    object BlogListScreen: Screen("blog_list_screen")
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
