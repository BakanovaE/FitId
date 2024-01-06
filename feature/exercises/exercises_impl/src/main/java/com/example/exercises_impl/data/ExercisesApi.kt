package com.example.exercises_impl.data

import com.example.exercises_impl.model.data.EquipmentResponse
import com.example.exercises_impl.model.data.ExercisesResponse
import com.example.exercises_impl.model.data.MusclesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ExercisesApi {

    @GET("muscle")
    fun getMuscles(): Call<MusclesResponse>

    @GET("equipment")
    fun getEquipment(): Call<EquipmentResponse>

    @GET("exercisebaseinfo")
    fun getExercises(
        @Query("equipment") equipment: List<Int>?,
        @Query("muscles") muscle: List<Int>?,
        @Query("limit") limit: Int = 100
    ): Call<ExercisesResponse>
}