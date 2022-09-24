package com.example.restcentersapp.domain.model.blog

data class BlogItemDesc(
    val title: String,
    val subtitle: String,
    val date: String,
    val content: String,
    val image: BlogItemImage
)