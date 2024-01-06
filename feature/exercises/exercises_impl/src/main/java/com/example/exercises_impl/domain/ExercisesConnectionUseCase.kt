package com.example.exercises_impl.domain

import javax.inject.Inject

class ExercisesConnectionUseCase @Inject constructor(
    private val exercisesConnectionRepository: ExercisesConnectionRepository
) {

    fun isOnlyWiFiRequired(): Boolean = exercisesConnectionRepository.isOnlyWiFiRequired()

    fun isWiFiConnectionEnabled(): Boolean = exercisesConnectionRepository.isWiFiConnectionEnabled()
}