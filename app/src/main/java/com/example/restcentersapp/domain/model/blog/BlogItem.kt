package com.example.restcentersapp.domain.model.blog

import com.example.restcentersapp.domain.model.food.FoodItemImage

data class BlogItem(
    val id: Int,
    val image: BlogItemImage,
    val subtitle: String,
    val title: String
)
