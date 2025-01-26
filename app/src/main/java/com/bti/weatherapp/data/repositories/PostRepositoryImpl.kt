package com.bti.weatherapp.data.repositories

import com.bti.weatherapp.data.sources.remote.PostService
import com.bti.weatherapp.domain.entities.Post
import com.bti.weatherapp.domain.repositories.PostRepository
import com.bti.weatherapp.domain.utils.ResourceState
import com.bti.weatherapp.data.utils.NetworkResponse
import com.bti.weatherapp.data.models.toDomain
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.mapNotNull
import javax.inject.Inject
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.mapNotNull
import com.bti.weatherapp.data.sources.local.dao.PostDatabaseDao
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.Dispatchers

class PostRepositoryImpl @Inject constructor(
    private val postService: PostService,
    private val postDatabaseDao: PostDatabaseDao
) : PostRepository {
    override suspend fun getPost() =
        postDatabaseDao.getPost().mapNotNull { dataModel ->
            dataModel?.let { ResourceState.Success(it.toDomain()) }
        }

    override suspend fun getRemotePost() {
        // Making Network Call to get data from API
        when (val recentFetchedApiData = postService.getPost()) {
            is NetworkResponse.Success -> {
                // Update db with fresh fetched network data
                recentFetchedApiData.data?.let { dataModel ->
                    postDatabaseDao.insertPost(dataModel)
                }
            }

            else -> {}
        }
    }
}