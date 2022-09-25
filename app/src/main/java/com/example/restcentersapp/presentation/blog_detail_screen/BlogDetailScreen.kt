package com.example.restcentersapp.presentation.blog_detail_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.restcentersapp.R
import com.example.restcentersapp.util.loadPicture
import com.example.restcentersapp.util.robotoFamily

@Composable
fun BlogDetailScreen(
    viewModel: BlogDetailViewModel = hiltViewModel(),
    navController: NavController
) {
    val state = viewModel.state.value
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { state.blog?.let { Text(text = it.title, overflow = TextOverflow.Ellipsis, maxLines = 2) } },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = stringResource(id = R.string.back)
                        )
                    }
                }
            )
        }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            state.blog?.let {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState)
                ) {
                    Box(modifier = Modifier.height(250.dp)) {
                        loadPicture(url = it.image.lg, modifier = Modifier.fillMaxSize())
                        if (state.isLoading){
                            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                        }
                    }
                    Column(modifier = Modifier.padding(10.dp)) {
                        Text(text = "Блог")
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = it.title,
                            style = MaterialTheme.typography.body1,
                            textAlign = TextAlign.Start,
                            fontFamily = robotoFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 22.sp
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(
                            text = it.subtitle,
                            style = MaterialTheme.typography.body1,
                            textAlign = TextAlign.Start,
                            fontFamily = robotoFamily,
                            fontWeight = FontWeight.Normal
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(
                            text = it.content,
                            style = MaterialTheme.typography.body2,
                            textAlign = TextAlign.Start,
                            fontFamily = robotoFamily,
                            fontWeight = FontWeight.Light,
                            fontSize = 16.sp
                        )
                    }
                }
            }
        }
    }
}