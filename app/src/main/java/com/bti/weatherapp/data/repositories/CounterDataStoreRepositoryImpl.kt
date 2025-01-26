package com.bti.weatherapp.data.repositories

import com.bti.weatherapp.data.sources.local.preference.CounterPreferenceDataSource
import com.bti.weatherapp.domain.repositories.CounterDataStoreRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CounterDataStoreRepositoryImpl @Inject constructor(
    private val counterPreferenceDataSource: CounterPreferenceDataSource
) : CounterDataStoreRepository {
    override suspend fun getCounterPreferenceValue(): Flow<Int> {
        return counterPreferenceDataSource.getCounterPreferenceValue()
    }

    override suspend fun updateCounterPreferenceValue(value: Int) {
        return counterPreferenceDataSource.updateCounterPreferenceValue(value)
    }
}