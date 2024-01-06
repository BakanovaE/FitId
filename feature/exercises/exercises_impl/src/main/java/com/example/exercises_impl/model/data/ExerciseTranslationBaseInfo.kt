package com.example.exercises_impl.model.data

import java.util.UUID

data class ExerciseTranslationBaseInfo(
    val id: Int,
    val uuid: UUID,
    val name: String,
    val exercise_base: Int,
    val description: String,
    val created: String,
    val language: Int,
    val aliases: List<ExerciseInfoAlias>,
    val notes: List<ExerciseComment>,
    val license: Int,
    val license_title: String,
    val license_object_url: String,
    val license_author: String?,
    val license_author_url: String,
    val license_derivative_source_url: String,
    val author_history: List<String>
)
