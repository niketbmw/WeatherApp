package com.bti.weatherapp.data.utils

sealed class NetworkResponse<out T> {
    class Success<T>(val data: T?) : NetworkResponse<T>()
    class Failure(val throwable: Throwable) : NetworkResponse<Nothing>()
    class Unauthorized(val throwable: Throwable) : NetworkResponse<Nothing>()
}