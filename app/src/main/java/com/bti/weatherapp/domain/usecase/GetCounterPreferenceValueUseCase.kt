package com.bti.weatherapp.domain.usecase

import com.bti.weatherapp.domain.repositories.CounterDataStoreRepository
import javax.inject.Inject

class GetCounterPreferenceValueUseCase @Inject constructor(
    private val counterDataStoreRepository: CounterDataStoreRepository
) {
    suspend operator fun invoke() = counterDataStoreRepository.getCounterPreferenceValue()
}