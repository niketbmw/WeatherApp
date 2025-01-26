package com.bti.weatherapp.di

import dagger.Module
import dagger.hilt.InstallIn
import javax.inject.Singleton
import dagger.Provides
import com.bti.weatherapp.domain.usecase.GetPostUseCase
import com.bti.weatherapp.domain.usecase.RefreshPostUseCase
import com.bti.weatherapp.domain.usecase.GetCounterPreferenceValueUseCase
import com.bti.weatherapp.domain.usecase.UpdateCounterPreferenceValueUseCase
import com.bti.weatherapp.domain.repositories.CounterDataStoreRepository
import com.bti.weatherapp.domain.repositories.PostRepository
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideGetPostUseCase(repository: PostRepository) =
        GetPostUseCase(repository)

    @Singleton
    @Provides
    fun provideRefreshPostUseCase(repository: PostRepository) =
        RefreshPostUseCase(repository)

    @Singleton
    @Provides
    fun provideGetCounterPreferenceValueUseCase(
        counterDataStoreRepository: CounterDataStoreRepository
    ) = GetCounterPreferenceValueUseCase(counterDataStoreRepository)

    @Singleton
    @Provides
    fun provideUpdateCounterPreferenceValueUseCase(
        counterDataStoreRepository: CounterDataStoreRepository
    ) = UpdateCounterPreferenceValueUseCase(counterDataStoreRepository)

}