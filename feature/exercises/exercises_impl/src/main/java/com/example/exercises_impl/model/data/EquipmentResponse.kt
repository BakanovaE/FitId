package com.example.exercises_impl.model.data

data class EquipmentResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Equipment>
)