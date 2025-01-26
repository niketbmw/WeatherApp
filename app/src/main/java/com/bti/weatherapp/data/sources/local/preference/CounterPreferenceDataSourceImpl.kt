package com.bti.weatherapp.data.sources.local.preference

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CounterPreferenceDataSourceImpl @Inject constructor(
    private val counterDataStore: DataStore<Preferences>
) : CounterPreferenceDataSource {
    override suspend fun getCounterPreferenceValue(): Flow<Int> =
        counterDataStore.data.map { counterPreferences ->
            val counterValue = counterPreferences[CounterPreferenceKeys.COUNTER_VALUE] ?: 0
            counterValue
        }

    override suspend fun updateCounterPreferenceValue(value: Int) {
        counterDataStore.edit { counterPreference ->
            counterPreference[CounterPreferenceKeys.COUNTER_VALUE] = value
        }
    }
}