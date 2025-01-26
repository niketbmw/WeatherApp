package com.bti.weatherapp.data.sources.local.preference

import kotlinx.coroutines.flow.Flow

interface CounterPreferenceDataSource {
    suspend fun getCounterPreferenceValue(): Flow<Int>
    suspend fun updateCounterPreferenceValue(value: Int)
}