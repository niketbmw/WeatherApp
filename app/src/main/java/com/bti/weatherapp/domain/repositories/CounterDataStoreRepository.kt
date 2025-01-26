package com.bti.weatherapp.domain.repositories

import kotlinx.coroutines.flow.Flow

interface CounterDataStoreRepository {
    suspend fun getCounterPreferenceValue(): Flow<Int>
    suspend fun updateCounterPreferenceValue(value: Int)
}