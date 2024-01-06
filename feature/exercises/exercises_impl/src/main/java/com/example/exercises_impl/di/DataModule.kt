package com.example.exercises_impl.di

import com.example.core.FeatureScoped
import com.example.exercises_impl.data.ExercisesConnectionRepositoryImpl
import com.example.exercises_impl.data.ExercisesRepositoryImpl
import com.example.exercises_impl.domain.ExercisesConnectionRepository
import com.example.exercises_impl.domain.ExercisesRepository
import dagger.Binds
import dagger.Module

@Module
interface DataModule {

    @FeatureScoped
    @Binds
    abstract fun provideExercisesRepository(repository: ExercisesRepositoryImpl): ExercisesRepository

    @FeatureScoped
    @Binds
    abstract fun provideExercisesConnectionRepository(repository: ExercisesConnectionRepositoryImpl): ExercisesConnectionRepository
}