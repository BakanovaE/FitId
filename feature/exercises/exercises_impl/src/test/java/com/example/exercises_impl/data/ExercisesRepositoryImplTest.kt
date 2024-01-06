package com.example.exercises_impl.data

import com.example.exercises_impl.model.data.ExercisesFilter
import com.example.exercises_impl.utils.Constants.EQUIPMENT_LIST
import com.example.exercises_impl.utils.Constants.EXERCISES_LIST
import com.example.exercises_impl.utils.Constants.MUSCLES_LIST
import com.google.common.truth.Truth
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

internal class ExercisesRepositoryImplTest{

    private val exercisesApi = mockk<ExercisesApi>(relaxed = true)
    private val repository = ExercisesRepositoryImpl(exercisesApi)

    @Before
    fun setUp() {
        with (exercisesApi) {
            coEvery { getEquipment().execute().body()?.results} returns EQUIPMENT_LIST
            coEvery { getMuscles().execute().body()?.results} returns MUSCLES_LIST
            coEvery { getExercises(null, null).execute().body()?.results} returns EXERCISES_LIST
        }
    }

    @Test
    fun getEquipment() = runTest {
        Truth.assertThat(repository.getEquipment()).isEqualTo(EQUIPMENT_LIST)
    }

    @Test
    fun getMusclesFail() = runTest {
        Truth.assertThat(repository.getMuscles()).isEqualTo(MUSCLES_LIST)
    }

    @Test
    fun getExercises() = runTest {
        Truth.assertThat(repository.getExercises(ExercisesFilter(null, null))).isEqualTo(EXERCISES_LIST)
    }
}