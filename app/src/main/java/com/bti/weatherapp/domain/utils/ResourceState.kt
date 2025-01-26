package com.bti.weatherapp.domain.utils

sealed class ResourceState<out T> {
    class Success<T>(val data: T) : ResourceState<T>()
    class Failure(val throwable: Throwable) : ResourceState<Nothing>()
}