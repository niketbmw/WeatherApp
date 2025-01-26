package com.bti.weatherapp.utils

sealed class UiState<out T> {
    object Empty : UiState<Nothing>()
    object Loading : UiState<Nothing>()
    class Success<T>(val data: T) : UiState<T>()
    class Failure(val throwable: Throwable) : UiState<Nothing>()
}