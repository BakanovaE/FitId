package com.example.exercises_impl.model.data

import java.util.UUID

data class ExerciseImage(
    val id: Int,
    val uuid: UUID,
    val exercise_base: Int,
    val exercise_base_uuid: UUID,
    val image: String,
    val is_main: Boolean,
    val style: String,
    val license: Int,
    val license_title: String,
    val license_object_url: String,
    val license_author: String?,
    val license_author_url: String,
    val license_derivative_source_url: String,
    val author_history: List<String>
)
