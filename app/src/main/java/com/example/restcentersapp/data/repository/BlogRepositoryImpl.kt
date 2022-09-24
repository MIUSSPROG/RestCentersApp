package com.example.restcentersapp.data.repository

import com.example.restcentersapp.data.remote.RestPlacesApi
import com.example.restcentersapp.data.remote.dto.blog.BlogItemDto
import com.example.restcentersapp.data.remote.dto.blog.BlogsItemDescDto
import com.example.restcentersapp.domain.repository.BlogRepository
import javax.inject.Inject

class BlogRepositoryImpl @Inject constructor(
    private val api: RestPlacesApi
): BlogRepository {
    override suspend fun getBlogs(): List<BlogItemDto> {
        return api.getBlogs().data
    }

    override suspend fun getBlogById(blogId: Int): BlogsItemDescDto {
        return api.getBlogById(blogId).data
    }

}