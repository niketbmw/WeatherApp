package com.bti.weatherapp.di

import com.bti.weatherapp.data.repositories.PostRepositoryImpl
import com.bti.weatherapp.data.sources.remote.PostService
import com.bti.weatherapp.domain.repositories.PostRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.bti.weatherapp.data.sources.local.dao.PostDatabaseDao
import com.bti.weatherapp.data.repositories.CounterDataStoreRepositoryImpl
import com.bti.weatherapp.domain.repositories.CounterDataStoreRepository
import com.bti.weatherapp.data.sources.local.preference.CounterPreferenceDataSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providePostRepository(postService: PostService, dao: PostDatabaseDao): PostRepository {
        return PostRepositoryImpl(postService, dao)
    }

    @Singleton
    @Provides
    fun provideCounterPreferenceRepository(
        counterPreferenceDataSource: CounterPreferenceDataSource
    ): CounterDataStoreRepository = CounterDataStoreRepositoryImpl(counterPreferenceDataSource)
}