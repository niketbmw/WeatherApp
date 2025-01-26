package com.bti.weatherapp.di

import com.bti.weatherapp.data.sources.local.preference.CounterPreferenceDataSource
import com.bti.weatherapp.data.sources.local.preference.CounterPreferenceDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Suppress("UnnecessaryAbstractClass")
@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Singleton
    @Binds
    abstract fun provideCounterPreferenceDataStoreSource(
        counterPreferenceDataSourceImpl: CounterPreferenceDataSourceImpl
    ): CounterPreferenceDataSource
}