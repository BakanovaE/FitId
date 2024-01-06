package com.example.exercises_impl.domain

import com.example.exercises_impl.model.data.Equipment
import com.example.exercises_impl.model.data.Muscles
import javax.inject.Inject

class GetSearchTypeUseCase
@Inject constructor(
    private val repository: ExercisesRepository
){

    suspend fun getMuscles(): List<Muscles>? =
        repository.getMuscles()

    suspend fun getEquipment(): List<Equipment>? =
        repository.getEquipment()
}