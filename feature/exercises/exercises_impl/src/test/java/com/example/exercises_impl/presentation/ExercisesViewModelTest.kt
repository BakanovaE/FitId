package com.example.exercises_impl.presentation

import com.example.exercises_impl.data.ResponseToChipsItemConverter
import com.example.exercises_impl.domain.ExercisesConnectionUseCase
import com.example.exercises_impl.domain.ExercisesUseCase
import com.example.exercises_impl.domain.GetSearchTypeUseCase
import com.example.exercises_impl.model.data.ExercisesFilter
import com.example.exercises_impl.model.presentation.ExercisesState
import com.example.exercises_impl.model.presentation.SearchTypeState
import com.example.exercises_impl.utils.Constants.CHIPS_LIST
import com.example.exercises_impl.utils.Constants.EQUIPMENT_LIST
import com.example.exercises_impl.utils.Constants.EXERCISES_LIST
import com.example.exercises_impl.utils.Constants.MUSCLES_LIST
import com.google.common.truth.Truth
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test

internal class ExercisesViewModelTest {

    private val useCase: GetSearchTypeUseCase = mockk(relaxed = true)
    private val converter: ResponseToChipsItemConverter = mockk(relaxed = true)
    private val exercisesUseCase: ExercisesUseCase = mockk(relaxed = true)
    private val exercisesConnectionUseCase: ExercisesConnectionUseCase = mockk(relaxed = true)
    private lateinit var viewModel: ExercisesViewModel

    @Before
    fun setUp() {
        viewModel =
            ExercisesViewModel(useCase, converter, exercisesUseCase, exercisesConnectionUseCase)
    }

    @Test
    fun `testing load any connection type search type muscles`() {
        coEvery { exercisesConnectionUseCase.isOnlyWiFiRequired() } returns false
        coEvery { useCase.getMuscles() } returns MUSCLES_LIST
        every { converter.convertMusclesToChips(MUSCLES_LIST) } returns CHIPS_LIST
        viewModel.getMuscles()
        coVerify(exactly = 1) { useCase.getMuscles() }
        coVerify(exactly = 0) { useCase.getEquipment() }
        verify(exactly = 1) { exercisesConnectionUseCase.isOnlyWiFiRequired() }
        verify(exactly = 0) { exercisesConnectionUseCase.isWiFiConnectionEnabled() }
        verify(exactly = 1) { converter.convertMusclesToChips(any()) }
        verify(exactly = 0) { converter.convertEquipmentToChips(any()) }
        Truth.assertThat(viewModel.searchTypeStateFlow.value).isEqualTo(
            SearchTypeState.Success(
                CHIPS_LIST
            )
        )
    }

    @Test
    fun `testing load wifi connection search type muscles`() {
        coEvery { exercisesConnectionUseCase.isOnlyWiFiRequired() } returns true
        coEvery { exercisesConnectionUseCase.isWiFiConnectionEnabled() } returns true
        coEvery { useCase.getMuscles() } returns MUSCLES_LIST
        every { converter.convertMusclesToChips(MUSCLES_LIST) } returns CHIPS_LIST
        viewModel.getMuscles()
        coVerify(exactly = 1) { useCase.getMuscles() }
        coVerify(exactly = 0) { useCase.getEquipment() }
        verify(exactly = 1) { exercisesConnectionUseCase.isOnlyWiFiRequired() }
        verify(exactly = 1) { exercisesConnectionUseCase.isWiFiConnectionEnabled() }
        verify(exactly = 1) { converter.convertMusclesToChips(any()) }
        verify(exactly = 0) { converter.convertEquipmentToChips(any()) }
        Truth.assertThat(viewModel.searchTypeStateFlow.value).isEqualTo(
            SearchTypeState.Success(
                CHIPS_LIST
            )
        )
    }

    @Test
    fun `testing load any connection type search type equipment`() {
        coEvery { exercisesConnectionUseCase.isOnlyWiFiRequired() } returns false
        coEvery { useCase.getEquipment() } returns EQUIPMENT_LIST
        every { converter.convertEquipmentToChips(EQUIPMENT_LIST) } returns CHIPS_LIST
        viewModel.getEquipment()
        coVerify(exactly = 0) { useCase.getMuscles() }
        coVerify(exactly = 1) { useCase.getEquipment() }
        verify(exactly = 1) { exercisesConnectionUseCase.isOnlyWiFiRequired() }
        verify(exactly = 0) { exercisesConnectionUseCase.isWiFiConnectionEnabled() }
        verify(exactly = 0) { converter.convertMusclesToChips(any()) }
        verify(exactly = 1) { converter.convertEquipmentToChips(any()) }
        Truth.assertThat(viewModel.searchTypeStateFlow.value).isEqualTo(
            SearchTypeState.Success(
                CHIPS_LIST
            )
        )
    }

    @Test
    fun `testing load wifi connection search type equipment`() {
        coEvery { exercisesConnectionUseCase.isOnlyWiFiRequired() } returns true
        coEvery { exercisesConnectionUseCase.isWiFiConnectionEnabled() } returns true
        coEvery { useCase.getEquipment() } returns EQUIPMENT_LIST
        every { converter.convertEquipmentToChips(EQUIPMENT_LIST) } returns CHIPS_LIST
        viewModel.getEquipment()
        coVerify(exactly = 0) { useCase.getMuscles() }
        coVerify(exactly = 1) { useCase.getEquipment() }
        verify(exactly = 1) { exercisesConnectionUseCase.isOnlyWiFiRequired() }
        verify(exactly = 1) { exercisesConnectionUseCase.isWiFiConnectionEnabled() }
        verify(exactly = 0) { converter.convertMusclesToChips(any()) }
        verify(exactly = 1) { converter.convertEquipmentToChips(any()) }
        Truth.assertThat(viewModel.searchTypeStateFlow.value).isEqualTo(
            SearchTypeState.Success(
                CHIPS_LIST
            )
        )
    }

    @Test
    fun `testing load any connection type exercises`() {
        coEvery { exercisesConnectionUseCase.isOnlyWiFiRequired() } returns false
        coEvery { exercisesUseCase.getExercises(any()) } returns EXERCISES_LIST
        viewModel.getExercises(ExercisesFilter(listOf(1), listOf(2)))
        coVerify(exactly = 1) { exercisesUseCase.getExercises(any()) }
        verify(exactly = 1) { exercisesConnectionUseCase.isOnlyWiFiRequired() }
        verify(exactly = 0) { exercisesConnectionUseCase.isWiFiConnectionEnabled() }
        Truth.assertThat(viewModel.exercisesStateFlow.value).isEqualTo(
            ExercisesState.Success(
                EXERCISES_LIST
            )
        )
    }

    @Test
    fun `testing load wifi connection exercises`() {
        coEvery { exercisesConnectionUseCase.isOnlyWiFiRequired() } returns true
        coEvery { exercisesConnectionUseCase.isWiFiConnectionEnabled() } returns true
        coEvery { exercisesUseCase.getExercises(any()) } returns EXERCISES_LIST
        viewModel.getExercises(ExercisesFilter(listOf(1), listOf(2)))
        coVerify(exactly = 1) { exercisesUseCase.getExercises(any()) }
        verify(exactly = 1) { exercisesConnectionUseCase.isOnlyWiFiRequired() }
        verify(exactly = 1) { exercisesConnectionUseCase.isWiFiConnectionEnabled() }
        Truth.assertThat(viewModel.exercisesStateFlow.value).isEqualTo(
            ExercisesState.Success(
                EXERCISES_LIST
            )
        )
    }
}