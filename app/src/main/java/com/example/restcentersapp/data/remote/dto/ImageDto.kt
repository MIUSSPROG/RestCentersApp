package com.example.restcentersapp.data.remote.dto


import com.example.restcentersapp.domain.model.blog.BlogItemImage
import com.example.restcentersapp.domain.model.food.FoodItemImage

data class ImageDto(
    val lg: String,
    val md: String,
    val sm: String
)

fun ImageDto.toFoodImage(): FoodItemImage {
    return FoodItemImage(
        lg = lg,
        md = md,
        sm = sm
    )
}

fun ImageDto.toBlogImage(): BlogItemImage {
    return BlogItemImage(
        lg = lg,
        md = md,
        sm = sm
    )
}