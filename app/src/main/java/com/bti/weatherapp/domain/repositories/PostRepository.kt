package com.bti.weatherapp.domain.repositories

import com.bti.weatherapp.domain.entities.Post
import kotlinx.coroutines.flow.Flow
import com.bti.weatherapp.domain.utils.ResourceState

interface PostRepository {
    suspend fun getPost(): Flow<ResourceState<Post>>
    suspend fun getRemotePost()
}