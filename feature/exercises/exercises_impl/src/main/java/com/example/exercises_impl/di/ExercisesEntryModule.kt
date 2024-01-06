package com.example.exercises_impl.di

import com.example.core.FeatureEntry
import com.example.core.FeatureEntryKey
import com.example.exercises.navigation.ExercisesEntry
import com.example.exercises_impl.navigation.ExercisesEntryImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
interface ExercisesEntryModule {

    @Binds
    @Singleton
    @IntoMap
    @FeatureEntryKey(ExercisesEntry::class)
    fun movieSearchEntry(entry: ExercisesEntryImpl): FeatureEntry
}