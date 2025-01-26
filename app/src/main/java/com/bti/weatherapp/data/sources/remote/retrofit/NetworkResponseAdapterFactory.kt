package com.bti.weatherapp.data.sources.remote.retrofit

import com.bti.weatherapp.data.utils.NetworkResponse
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class NetworkResponseAdapterFactory : CallAdapter.Factory() {

    override fun get(
        returnType: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {

        return when (getRawType(returnType)) {
            Call::class.java -> {
                val callType = getParameterUpperBound(0, returnType as ParameterizedType)
                val rawType = getRawType(callType)
                if (rawType != NetworkResponse::class.java) {
                    null
                } else {
                    val resultType = getParameterUpperBound(0, callType as ParameterizedType)
                    NetworkResponseAdapter<Any>(resultType)
                }
            }

            Deferred::class.java -> {
                val callType = getParameterUpperBound(0, returnType as ParameterizedType)
                val rawType = getRawType(callType)
                if (rawType != NetworkResponse::class.java) {
                    null
                } else {
                    val resultType = getParameterUpperBound(0, callType as ParameterizedType)
                    NetworkResponseAdapter<Any>(resultType)
                }
            }

            else -> null
        }
    }
}