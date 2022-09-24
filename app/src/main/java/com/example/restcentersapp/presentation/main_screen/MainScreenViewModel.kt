package com.example.restcentersapp.presentation.main_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restcentersapp.domain.usecase.get_blog_list.GetBlogsUseCase
import com.example.restcentersapp.domain.usecase.get_food_list.GetFoodListUseCase
import com.example.restcentersapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getFoodListUseCase: GetFoodListUseCase,
    private val getBlogsUseCase: GetBlogsUseCase
): ViewModel() {

    private val _foodState = mutableStateOf(MainState())
    val foodState: State<MainState> = _foodState

    private val _blogsState = mutableStateOf(MainState())
    val blogsState: State<MainState> = _blogsState

    init {
        getFood()
        getBlogs()
    }

    private fun getFood(){
        getFoodListUseCase().onEach { result ->
            when(result){
                is Resource.Success -> {
                    _foodState.value = MainState(foodList = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _foodState.value = MainState(error = result.message ?: "Ошибка получения данных")
                }
                is Resource.Loading -> {
                    _foodState.value = MainState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getBlogs(){
        getBlogsUseCase().onEach { result ->
            when(result){
                is Resource.Success -> {
                    _blogsState.value = MainState(blogs = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _blogsState.value = MainState(error = result.message ?: "Ошибка получения данных")
                }
                is Resource.Loading -> {
                    _blogsState.value = MainState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }


}