package com.example.exercises_impl.data

import com.example.exercises_impl.domain.ExercisesRepository
import com.example.exercises_impl.model.data.Equipment
import com.example.exercises_impl.model.data.ExerciseBaseInfo
import com.example.exercises_impl.model.data.ExercisesFilter
import com.example.exercises_impl.model.data.Muscles
import javax.inject.Inject

class ExercisesRepositoryImpl
@Inject constructor(
    private val exercisesApi: ExercisesApi
): ExercisesRepository {

    override suspend fun getMuscles(): List<Muscles>? =
        exercisesApi.getMuscles().execute().body()?.results

    override suspend fun getEquipment(): List<Equipment>? =
        exercisesApi.getEquipment().execute().body()?.results

    override suspend fun getExercises(filter: ExercisesFilter): List<ExerciseBaseInfo>? =
        exercisesApi.getExercises(filter.equipment, filter.muscle).execute().body()?.results
}
