package com.example.exercises_impl.model.data

data class ExercisesResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<ExerciseBaseInfo>
)
