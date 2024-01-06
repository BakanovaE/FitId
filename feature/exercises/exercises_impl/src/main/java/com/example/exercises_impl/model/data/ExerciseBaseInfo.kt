package com.example.exercises_impl.model.data

import java.util.Date
import java.util.UUID

data class ExerciseBaseInfo(
    val id: Int,
    val uuid: UUID,
    val created: Date,
    val last_update: Date,
    val last_update_global: Date,
    val category: ExerciseCategory,
    val muscles: List<Muscles>,
    val muscles_secondary: List<Muscles>,
    val equipment: List<Equipment>,
    val licence: License,
    val license_author: String?,
    val images: List<ExerciseImage>,
    val exercises: List<ExerciseTranslationBaseInfo>,
    val variations: Int,
    val videos: List<ExerciseVideoInfo>,
    val author_history: List<String>,
    val total_authors_history: List<String>
)
