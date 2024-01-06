package com.example.exercises_impl.domain

import com.example.exercises_impl.model.data.ExercisesFilter
import javax.inject.Inject

class ExercisesUseCase
@Inject constructor(
    private val repository: ExercisesRepository
) {

    suspend fun getExercises(filter: ExercisesFilter) = repository.getExercises(filter)
}