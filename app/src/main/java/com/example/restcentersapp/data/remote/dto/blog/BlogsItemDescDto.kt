package com.example.restcentersapp.data.remote.dto.blog

import com.example.restcentersapp.domain.model.blog.BlogItemDesc
import com.example.restcentersapp.domain.model.blog.BlogItemImage

data class BlogsItemDescDto(
    val title: String,
    val subtitle: String,
    val date: String,
    val content: String,
    val image: BlogItemImage
)

fun BlogsItemDescDto.toBlogsItemDesc(): BlogItemDesc {
    return BlogItemDesc(
        title = title,
        subtitle = subtitle,
        date = date,
        content = content,
        image = image
    )
}