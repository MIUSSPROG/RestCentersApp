package com.example.restcentersapp.data.remote.dto.food

import com.example.restcentersapp.domain.model.food.Food


data class FoodDto(
    val `data`: List<FoodItemDto>
)

fun FoodDto.toFood(): Food {
    return Food(
        data = data.map { it.toFoodItem() }
    )
}