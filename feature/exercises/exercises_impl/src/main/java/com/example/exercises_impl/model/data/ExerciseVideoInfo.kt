package com.example.exercises_impl.model.data

import java.util.UUID

data class ExerciseVideoInfo(
    val id: Int,
    val uuid: UUID,
    val exercise_base: Int,
    val video: String,
    val is_main: Boolean,
    val size: Int,
    val duration: String,
    val width: Int,
    val height: Int,
    val codec: String,
    val codec_long: String,
    val license: Int,
    val license_title: String,
    val license_object_url: String,
    val license_author: String?,
    val license_author_url: String,
    val license_derivative_source_url: String,
    val author_history: List<String>
)
