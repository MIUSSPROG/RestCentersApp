package com.example.restcentersapp.domain.usecase.get_blog_list

import com.example.restcentersapp.data.remote.dto.blog.toBlogsItemDesc
import com.example.restcentersapp.domain.model.blog.BlogItem
import com.example.restcentersapp.domain.model.blog.BlogItemDesc
import com.example.restcentersapp.domain.repository.BlogRepository
import com.example.restcentersapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetBlogUseCase @Inject constructor(
    private val repository: BlogRepository
) {
    operator fun invoke(blogId: Int): Flow<Resource<BlogItemDesc>> = flow {
        try {
            emit(Resource.Loading())
            val blog = repository.getBlogById(blogId)
            emit(Resource.Success(blog.toBlogsItemDesc()))
        }catch (e: HttpException){
            emit(Resource.Error(message = "Ошибка сервера"))
        }catch (e: IOException){
            emit(Resource.Error(message = "Нет интернет соединения"))
        }
    }
}