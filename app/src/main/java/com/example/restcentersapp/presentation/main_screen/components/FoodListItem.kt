package com.example.restcentersapp.presentation.main_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.restcentersapp.domain.model.food.FoodItem
import com.example.restcentersapp.util.robotoFamily

@Composable
fun FoodListItem(
    foodItem: FoodItem
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        ImageCard(url = foodItem.image.md)
        Text(
            text = foodItem.title,
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Start,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontFamily = robotoFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp
        )
        Text(
            text = foodItem.subtitle,
            style = MaterialTheme.typography.body2,
            textAlign = TextAlign.Start,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            fontFamily = robotoFamily,
            fontWeight = FontWeight.Light
        )
    }
}