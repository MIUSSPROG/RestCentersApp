package com.example.restcentersapp.data.remote

import com.example.restcentersapp.data.remote.dto.blog.BlogsDto
import com.example.restcentersapp.data.remote.dto.blog.BlogsItemDetailDto
import com.example.restcentersapp.data.remote.dto.food.FoodDto
import retrofit2.http.GET
import retrofit2.http.Query

interface RestPlacesApi {

    @GET("fun?id=117&type=food")
    suspend fun getFood(): FoodDto

    @GET("blog?id=117&format=card")
    suspend fun getBlogs(): BlogsDto

    @GET("blog-info?id=117")
    suspend fun getBlogById(@Query("blog_id") blogId: Int): BlogsItemDetailDto
}