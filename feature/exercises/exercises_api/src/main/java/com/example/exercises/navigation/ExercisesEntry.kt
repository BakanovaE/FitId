package com.example.exercises.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.core.ComposableFeatureEntry

abstract class ExercisesEntry : ComposableFeatureEntry {

    final override val featureRoute = "exercises/{$ARG_SEARCH_TYPE}"

    final override val arguments = listOf(
        navArgument(ARG_SEARCH_TYPE) {
            type = NavType.StringType
        }
    )

    fun destination(searchType: String): String =
        "exercises/$searchType"

    protected companion object {
        const val ARG_SEARCH_TYPE = "searchType"
    }
}