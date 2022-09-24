package com.example.restcentersapp.presentation.blog_detail_screen

import com.example.restcentersapp.domain.model.blog.BlogItem
import com.example.restcentersapp.domain.model.blog.BlogItemDesc
import com.example.restcentersapp.domain.model.food.FoodItem

data class BlogDetailState(
    val isLoading: Boolean = false,
    val blog: BlogItemDesc? = null,
    val error: String = ""
)