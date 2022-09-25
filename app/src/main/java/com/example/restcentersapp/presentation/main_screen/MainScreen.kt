package com.example.restcentersapp.presentation.main_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.restcentersapp.presentation.Screen
import com.example.restcentersapp.presentation.main_screen.components.BlogListItem
import com.example.restcentersapp.presentation.main_screen.components.FoodListItem
import com.example.restcentersapp.util.robotoFamily

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen(
    viewModel: MainScreenViewModel = hiltViewModel(),
    navController: NavController
) {
    val foodState = viewModel.foodState.value
    val blogsState = viewModel.blogsState.value
    val scrollState = rememberScrollState()

    Column(modifier = Modifier.padding(top = 20.dp, start = 10.dp, end = 10.dp).verticalScroll(scrollState)){
        Text(
            "Питание",
            modifier = Modifier.padding(start = 5.dp),
            fontSize = 25.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = robotoFamily
        )
        Box(modifier = Modifier
            .height(400.dp)
            .fillMaxWidth()){

            LazyVerticalGrid(
                cells = GridCells.Fixed(2),
                contentPadding = PaddingValues(top = 15.dp)
            ){
                items(foodState.foodList){ food ->
                    FoodListItem(foodItem = food)
                }
            }

            if (foodState.error.isNotBlank()){
                Text(
                    text = foodState.error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
            if (foodState.isLoading){
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent, contentColor = Color.Blue),
            border = BorderStroke(1.dp,Color.Blue),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Показать все (16)",
                modifier = Modifier.padding(10.dp)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            "Блог",
            modifier = Modifier.padding(start = 5.dp),
            fontSize = 25.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = robotoFamily
        )
        LazyRow{
            items(blogsState.blogs){ blog ->
                BlogListItem(
                    blogItem = blog,
                    modifier = Modifier.fillParentMaxWidth(),
                    onItemClick = {
                        navController.navigate(Screen.BlogDetailScreen.withArgs(blog.id.toString()))
                    }
                )
            }
        }
        Spacer(modifier = Modifier.height(480.dp))
    }
}