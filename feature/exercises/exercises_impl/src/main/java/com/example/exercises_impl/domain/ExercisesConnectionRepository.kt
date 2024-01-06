package com.example.exercises_impl.domain

interface ExercisesConnectionRepository {

    fun isOnlyWiFiRequired(): Boolean

    fun isWiFiConnectionEnabled(): Boolean
}