package com.example.restcentersapp.data.remote.dto.food

import com.example.restcentersapp.data.remote.dto.ImageDto
import com.example.restcentersapp.data.remote.dto.toFoodImage
import com.example.restcentersapp.domain.model.food.FoodItem
import com.google.gson.annotations.SerializedName

data class FoodItemDto(
    val id: Int,
    @SerializedName("image")
    val imageDto: ImageDto,
    val subtitle: String,
    val title: String
)

fun FoodItemDto.toFoodItem(): FoodItem {
    return FoodItem(
        id = id,
        image =imageDto.toFoodImage(),
        subtitle = subtitle,
        title = title
    )
}