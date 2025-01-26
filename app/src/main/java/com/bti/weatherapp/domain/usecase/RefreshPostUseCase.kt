package com.bti.weatherapp.domain.usecase

import com.bti.weatherapp.domain.repositories.PostRepository
import javax.inject.Inject

class RefreshPostUseCase @Inject constructor(private val repository: PostRepository) {
    suspend operator fun invoke() = repository.getRemotePost()
}