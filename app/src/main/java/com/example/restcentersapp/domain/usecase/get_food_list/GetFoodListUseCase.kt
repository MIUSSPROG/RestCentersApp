package com.example.restcentersapp.domain.usecase.get_food_list

import com.example.restcentersapp.data.remote.dto.food.toFoodItem
import com.example.restcentersapp.domain.model.food.FoodItem
import com.example.restcentersapp.domain.repository.FoodRepository
import com.example.restcentersapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetFoodListUseCase @Inject constructor(
    private val repository: FoodRepository
) {
    operator fun invoke(): Flow<Resource<List<FoodItem>>> = flow {
        try {
            emit(Resource.Loading())
            val foodList = repository.getFood()
            emit(Resource.Success(data = foodList.map { it.toFoodItem() }))
        }catch (e: HttpException){
            emit(Resource.Error(message = "Ошибка сервера"))
        }catch (e: IOException){
            emit(Resource.Error(message = "Нет интернет соединения"))
        }
    }
}