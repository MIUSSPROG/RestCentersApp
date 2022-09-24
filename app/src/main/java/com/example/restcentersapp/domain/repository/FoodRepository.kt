package com.example.restcentersapp.domain.repository

import com.example.restcentersapp.data.remote.dto.food.FoodItemDto

interface FoodRepository {
    suspend fun getFood(): List<FoodItemDto>
}