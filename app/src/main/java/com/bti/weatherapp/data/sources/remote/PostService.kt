package com.bti.weatherapp.data.sources.remote

import com.bti.weatherapp.data.models.DPost
import com.bti.weatherapp.data.utils.NetworkResponse

interface PostService {
    suspend fun getPost(): NetworkResponse<DPost>
}