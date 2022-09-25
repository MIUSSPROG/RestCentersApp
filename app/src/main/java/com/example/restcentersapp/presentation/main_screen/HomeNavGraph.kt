package com.example.restcentersapp.presentation.main_screen

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.restcentersapp.presentation.Graph
import com.example.restcentersapp.presentation.HOME_GRAPH_ROUTE
import com.example.restcentersapp.presentation.Screen
import com.example.restcentersapp.presentation.blog_detail_screen.BlogDetailScreen
import com.example.restcentersapp.util.Constants.PARAM_BLOG_ID

fun NavGraphBuilder.homeNavGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = Screen.BlogDetailScreen.route + "/{$PARAM_BLOG_ID}",
        route = Graph.HOME
    ) {
        composable(Screen.BlogDetailScreen.route + "/{$PARAM_BLOG_ID}"){
            BlogDetailScreen(navController = navController)
        }
    }
}