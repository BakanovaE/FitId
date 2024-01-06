package com.example.network.di

import dagger.Module
import dagger.Provides

private const val REST_API_URL = "https://wger.de/api/v2/"

@Module
object HttpUrlModule {

    @Provides
    fun provideRestApiUrl(): String {
        return REST_API_URL
    }
}
