package com.example.restcentersapp.domain.repository

import com.example.restcentersapp.data.remote.dto.blog.BlogItemDto
import com.example.restcentersapp.data.remote.dto.blog.BlogsItemDescDto

interface BlogRepository {
    suspend fun getBlogs(): List<BlogItemDto>

    suspend fun getBlogById(blogId: Int): BlogsItemDescDto
}