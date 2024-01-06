package com.example.exercises_impl.domain

import com.example.exercises_impl.model.data.Equipment
import com.example.exercises_impl.model.data.ExerciseBaseInfo
import com.example.exercises_impl.model.data.ExercisesFilter
import com.example.exercises_impl.model.data.Muscles

interface ExercisesRepository {

    suspend fun getMuscles(): List<Muscles>?

    suspend fun getEquipment(): List<Equipment>?

    suspend fun getExercises(filter: ExercisesFilter): List<ExerciseBaseInfo>?
}