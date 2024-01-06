package com.example.exercises_impl.domain

import com.example.exercises_impl.model.data.ExercisesFilter
import com.example.exercises_impl.utils.Constants
import com.google.common.truth.Truth
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

internal class ExercisesUseCaseTest {

    private val repository = mockk<ExercisesRepository>()
    private val useCase = ExercisesUseCase(repository)

    @Before
    fun setUp() {
        coEvery {
            repository.getExercises(
                ExercisesFilter(
                    listOf(1),
                    null
                )
            )
        } returns Constants.EXERCISES_LIST
    }

    @Test
    fun getExercises() = runTest {
        Truth.assertThat(useCase.getExercises(ExercisesFilter(
            listOf(1),
            null
        ))).isEqualTo(Constants.EXERCISES_LIST)
    }
}