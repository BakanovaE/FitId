package com.example.core

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface NetworkProvider {

//    @RestApi
    fun provideRetrofit(): Retrofit

    fun provideRetrofitBuilder(): Retrofit.Builder

    fun provideGson(): Gson

    fun provideGsonConverterFactory(): GsonConverterFactory
}