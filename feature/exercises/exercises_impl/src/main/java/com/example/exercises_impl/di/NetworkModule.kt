package com.example.exercises_impl.di

import com.example.core.FeatureScoped
import com.example.core.RestApi
import com.example.exercises_impl.data.ExercisesApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class NetworkModule {

    @FeatureScoped
    @Provides
    fun provideExercisesApi(retrofit: Retrofit): ExercisesApi {
        return retrofit.create(ExercisesApi::class.java)
    }
}