package com.bti.weatherapp.data.sources.remote

import com.bti.weatherapp.data.models.DPost
import com.bti.weatherapp.data.utils.NetworkResponse
import retrofit2.http.GET

interface PostServiceImpl : PostService {

    @GET("posts/1")
    override suspend fun getPost(): NetworkResponse<DPost>
}