package com.bti.weatherapp.domain.usecase

import com.bti.weatherapp.domain.repositories.CounterDataStoreRepository
import javax.inject.Inject

class UpdateCounterPreferenceValueUseCase @Inject constructor(
    private val counterDataStoreRepository: CounterDataStoreRepository
) {
    suspend operator fun invoke(value: Int) =
        counterDataStoreRepository.updateCounterPreferenceValue(value)
}