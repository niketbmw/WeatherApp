package com.bti.weatherapp.di

import com.bti.weatherapp.data.sources.remote.PostService
import com.bti.weatherapp.data.sources.remote.PostServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import com.bti.weatherapp.data.sources.remote.retrofit.NetworkResponseAdapterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideNetworkResponseAdapterFactory(): NetworkResponseAdapterFactory =
        NetworkResponseAdapterFactory()

    @Singleton
    @Provides
    fun provideMoshiConvertorFactory(): MoshiConverterFactory =
        MoshiConverterFactory.create()

    @Singleton
    @Provides
    fun provideRetrofit(
        converterFactory: MoshiConverterFactory,
        networkResponseAdapterFactory: NetworkResponseAdapterFactory
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addCallAdapterFactory(networkResponseAdapterFactory)
            .addConverterFactory(converterFactory)
            .build()

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit): PostService =
        retrofit.create(PostServiceImpl::class.java)

}