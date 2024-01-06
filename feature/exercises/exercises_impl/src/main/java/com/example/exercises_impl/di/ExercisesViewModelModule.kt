package com.example.exercises_impl.di

import androidx.lifecycle.ViewModel
import com.example.core.viewmodel.ViewModelKey
import com.example.exercises_impl.presentation.ExercisesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ExercisesViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ExercisesViewModel::class)
    fun provideExercisesViewModel(exercisesViewModel: ExercisesViewModel): ViewModel
}