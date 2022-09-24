package com.example.restcentersapp.presentation.main_screen

import com.example.restcentersapp.domain.model.blog.BlogItem
import com.example.restcentersapp.domain.model.food.FoodItem

data class MainState(
    val isLoading: Boolean = false,
    val foodList: List<FoodItem> = emptyList(),
    val blogs: List<BlogItem> = emptyList(),
    val error: String = ""
)
