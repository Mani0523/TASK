package com.example.practice.Retrofit.di

import com.example.practice.Retrofit.network.ApiService
import com.example.practice.Retrofit.network.ApiService.Companion.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi =
         Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()


    @Provides
    @Singleton
    fun providesApiService(moshi: Moshi): ApiService =
         Retrofit.Builder()
             .run {

                 baseUrl(ApiService.BASE_URL)
                 .addConverterFactory(MoshiConverterFactory.create(moshi))
                 .build()

             }.create(ApiService::class.java)

}