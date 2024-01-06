package com.example.exercises_impl.model.data

data class MusclesResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results:  List<Muscles>
)