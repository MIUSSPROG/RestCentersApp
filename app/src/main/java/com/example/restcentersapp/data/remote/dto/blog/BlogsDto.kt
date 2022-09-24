package com.example.restcentersapp.data.remote.dto.blog

import com.example.restcentersapp.domain.model.blog.Blogs

data class BlogsDto(
    val data: List<BlogItemDto>
)

fun BlogsDto.toBlogs(): Blogs {
    return Blogs(
        data = data.map { it.toBlogItem() }
    )
}