package com.example.exercises_impl.model.presentation

import com.example.exercises_impl.model.data.ExerciseBaseInfo

sealed class ExercisesState {

    object Loading: ExercisesState()

    data class Success(
        val exercises: List<ExerciseBaseInfo>
    ): ExercisesState()

    data class Error(
        val exception: Throwable
    ): ExercisesState()
}