package com.example.restcentersapp.domain.usecase.get_blog_list

import com.example.restcentersapp.data.remote.dto.blog.toBlogItem
import com.example.restcentersapp.data.remote.dto.food.toFoodItem
import com.example.restcentersapp.domain.model.blog.BlogItem
import com.example.restcentersapp.domain.repository.BlogRepository
import com.example.restcentersapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetBlogsUseCase @Inject constructor(
    private val repository: BlogRepository
) {
    operator fun invoke(): Flow<Resource<List<BlogItem>>> = flow {
        try {
            emit(Resource.Loading())
            val blogs = repository.getBlogs()
            emit(Resource.Success(data = blogs.map { it.toBlogItem() }))
        }catch (e: HttpException){
            emit(Resource.Error(message = "Ошибка сервера"))
        }catch (e: IOException){
            emit(Resource.Error(message = "Нет интернет соединения"))
        }
    }
}