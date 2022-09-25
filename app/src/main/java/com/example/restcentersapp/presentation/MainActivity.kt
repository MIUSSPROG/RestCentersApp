package com.example.restcentersapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.example.restcentersapp.presentation.blog_detail_screen.BlogDetailScreen
import com.example.restcentersapp.presentation.main_screen.MainScreen
import com.example.restcentersapp.presentation.main_screen.homeNavGraph
import com.example.restcentersapp.ui.BottomNavItem
import com.example.restcentersapp.ui.theme.RestCentersAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RestCentersAppTheme {
                val navController = rememberNavController()

                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(
                            items = listOf(
                                BottomNavItem(
                                    name = "Home",
                                    route = "home",
                                    icon = Icons.Default.Home
                                ),
                                BottomNavItem(
                                    name = "map",
                                    route = "map",
//                                    icon = ImageVector.vectorResource(R.drawable.map)
                                    icon = Icons.Default.Create
                                ),
                                BottomNavItem(
                                    name = "booking",
                                    route = "booking",
//                                    icon = ImageVector.vectorResource(R.drawable.booked)
                                    icon = Icons.Default.Add
                                ),
                                BottomNavItem(
                                    name = "chats",
                                    route = "chats",
//                                    icon = ImageVector.vectorResource(R.drawable.chats)
                                    icon = Icons.Default.List
                                ),
                                BottomNavItem(
                                    name = "profile",
                                    route = "profile",
                                    icon = Icons.Default.Person
                                )
                            ),
                            navController = navController,
                            onItemClick ={
                                navController.navigate(it.route)
                            }
                        )
                    }
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        Navigation(navController = navController)
                    }
                }
            }
        }
    }
}

const val HOME_GRAPH_ROUTE = "home"
const val MAP_GRAPH_ROUTE = "map"
const val BOOKING_GRAPH_ROUTE = "booking"
const val CHATS_GRAPH_ROUTE = "chats"
const val PROFILE_GRAPH_ROUTE = "profile"

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = HOME_GRAPH_ROUTE){

        homeNavGraph(navController = navController)

        composable(MAP_GRAPH_ROUTE){
            MapScreen()
        }
        composable(BOOKING_GRAPH_ROUTE){
            BookingScreen()
        }
        composable(CHATS_GRAPH_ROUTE){
            ChatsScreen()
        }
        composable(PROFILE_GRAPH_ROUTE){
            ProfileScreen()
        }
    }
}

@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.White
    ) {
        items.forEach{ item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(item)},
                selectedContentColor = Color.Blue,
                unselectedContentColor = Color.Gray,
                icon = {
                    Column(horizontalAlignment = CenterHorizontally) {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.name
                        )
                        Text(
                            text = item.name,
                            textAlign = TextAlign.Center,
                            fontSize = 10.sp
                        )
                    }
                }
            )
        }
    }
}

@Composable
fun HomeScreen(
    navController: NavController
) {
    MainScreen(navController = navController)
}

@Composable
fun MapScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Text(text = "Map screen")
    }
}

@Composable
fun BookingScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Text(text = "Booking screen")
    }
}

@Composable
fun ChatsScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Text(text = "Chats screen")
    }
}

@Composable
fun ProfileScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Text(text = "Profile screen")
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RestCentersAppTheme {
        Greeting("Android")
    }
}