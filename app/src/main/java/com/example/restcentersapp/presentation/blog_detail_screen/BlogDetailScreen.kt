package com.example.restcentersapp.presentation.blog_detail_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun BlogDetailScreen(title: String?) {
    Box(modifier = Modifier.background(Color.White).fillMaxSize()) {
        title?.let {
            Text(text = it)
        }
    }
}