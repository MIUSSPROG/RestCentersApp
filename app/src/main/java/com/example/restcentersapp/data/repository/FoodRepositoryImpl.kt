package com.example.restcentersapp.data.repository

import com.example.restcentersapp.data.remote.RestPlacesApi
import com.example.restcentersapp.data.remote.dto.food.FoodItemDto
import com.example.restcentersapp.domain.repository.FoodRepository
import javax.inject.Inject

class FoodRepositoryImpl @Inject constructor(
    private val api: RestPlacesApi
): FoodRepository {
    override suspend fun getFood(): List<FoodItemDto> {
        return api.getFood().data
    }
}