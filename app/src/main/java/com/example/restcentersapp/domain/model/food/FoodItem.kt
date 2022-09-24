package com.example.restcentersapp.domain.model.food

data class FoodItem(
    val id: Int,
    val image: FoodItemImage,
    val subtitle: String,
    val title: String
)
