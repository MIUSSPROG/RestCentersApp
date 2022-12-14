package com.example.restcentersapp.presentation.blog_detail_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.restcentersapp.domain.usecase.get_blog_list.GetBlogUseCase
import com.example.restcentersapp.util.Constants.PARAM_BLOG_ID
import com.example.restcentersapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BlogDetailViewModel @Inject constructor(
    private val getBlogUseCase: GetBlogUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf(BlogDetailState())
    val state: State<BlogDetailState> = _state

    init {
        savedStateHandle.get<Int>(PARAM_BLOG_ID)?.let {  blogId ->
            getBlogDetail(blogId)
        }
    }

    private fun getBlogDetail(blogId: Int){
        getBlogUseCase(blogId).onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = BlogDetailState(blog = result.data)
                }
                is Resource.Error -> {
                    _state.value = BlogDetailState(error = result.message ?: "Ошибка получения данных")
                }
                is Resource.Loading -> {
                    _state.value = BlogDetailState(isLoading = true)
                }
            }
        }
    }

}