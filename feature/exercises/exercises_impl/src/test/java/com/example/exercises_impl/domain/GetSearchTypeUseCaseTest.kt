package com.example.exercises_impl.domain

import com.example.exercises_impl.utils.Constants.EQUIPMENT_LIST
import com.example.exercises_impl.utils.Constants.MUSCLES_LIST
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

internal class GetSearchTypeUseCaseTest{

    private val repository = mockk<ExercisesRepository>()
    private val useCase = GetSearchTypeUseCase(repository)

    @Before
    fun setUp() {
        with(repository) {
            coEvery { getMuscles() } returns MUSCLES_LIST
            coEvery { getEquipment() }returns EQUIPMENT_LIST
        }
    }

    @Test
    fun getEquipment() = runTest {
        assertThat(useCase.getEquipment()).isEqualTo(EQUIPMENT_LIST)
    }

    @Test
    fun getMuscles() = runTest {
        assertThat(useCase.getMuscles()).isEqualTo(MUSCLES_LIST)
    }
}