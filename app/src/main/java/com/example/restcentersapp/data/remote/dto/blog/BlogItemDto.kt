package com.example.restcentersapp.data.remote.dto.blog

import com.example.restcentersapp.data.remote.dto.ImageDto
import com.example.restcentersapp.data.remote.dto.toBlogImage
import com.example.restcentersapp.data.remote.dto.toFoodImage
import com.example.restcentersapp.domain.model.blog.BlogItem
import com.example.restcentersapp.domain.model.food.FoodItem
import com.google.gson.annotations.SerializedName

data class BlogItemDto(
    val id: Int,
    @SerializedName("image")
    val imageDto: ImageDto,
    val subtitle: String,
    val title: String
)

fun BlogItemDto.toBlogItem(): BlogItem {
    return BlogItem(
        id = id,
        image = imageDto.toBlogImage(),
        subtitle = subtitle,
        title = title
    )
}