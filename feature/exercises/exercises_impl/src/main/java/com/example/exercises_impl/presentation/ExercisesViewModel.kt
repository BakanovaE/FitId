package com.example.exercises_impl.presentation

import androidx.lifecycle.viewModelScope
import com.example.core.viewmodel.BaseViewModel
import com.example.exercises_impl.data.ResponseToChipsItemConverter
import com.example.exercises_impl.domain.ExercisesConnectionUseCase
import com.example.exercises_impl.domain.ExercisesUseCase
import com.example.exercises_impl.domain.GetSearchTypeUseCase
import com.example.exercises_impl.model.data.ExercisesFilter
import com.example.exercises_impl.model.presentation.ExercisesState
import com.example.exercises_impl.model.presentation.SearchTypeState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.lang.Exception
import java.lang.IllegalStateException
import javax.inject.Inject

class ExercisesViewModel
@Inject constructor(
    private val useCase: GetSearchTypeUseCase,
    private val converter: ResponseToChipsItemConverter,
    private val exercisesUseCase: ExercisesUseCase,
    private val exercisesConnectionUseCase: ExercisesConnectionUseCase
) : BaseViewModel() {

    val searchTypeStateFlow: StateFlow<SearchTypeState>
        get() = _searchTypeStateFlow.asStateFlow()
    private val _searchTypeStateFlow: MutableStateFlow<SearchTypeState> =
        MutableStateFlow(SearchTypeState.Loading)

    val exercisesStateFlow: StateFlow<ExercisesState?>
        get() = _exercisesStateFlow.asStateFlow()
    private val _exercisesStateFlow: MutableStateFlow<ExercisesState?> = MutableStateFlow(null)

    private fun checkConnection(): Boolean {
        return if (!exercisesConnectionUseCase.isOnlyWiFiRequired()) {
            true
        } else {
            exercisesConnectionUseCase.isWiFiConnectionEnabled()
        }
    }

    fun getMuscles() {
        if (checkConnection()) {
            viewModelScope.launch(Dispatchers.IO) {
                try {
                    val items = useCase.getMuscles()?.let { converter.convertMusclesToChips(it) }
                    if (!items.isNullOrEmpty()) {
                        _searchTypeStateFlow.value = SearchTypeState.Success(items)
                    }
                } catch (e: Exception) {
                    _searchTypeStateFlow.value = SearchTypeState.Error(e)
                }
            }
        } else {
            _searchTypeStateFlow.value = SearchTypeState.Error(IllegalStateException(CONNECTION_ERROR))
        }
    }

    fun getEquipment() {
        if (checkConnection()) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val items = useCase.getEquipment()?.let { converter.convertEquipmentToChips(it) }
                if (!items.isNullOrEmpty()) {
                    _searchTypeStateFlow.value = SearchTypeState.Success(items)
                }
            } catch (e: Exception) {
                _searchTypeStateFlow.value = SearchTypeState.Error(e)
            }
        }
        } else {
            _searchTypeStateFlow.value = SearchTypeState.Error(IllegalStateException(CONNECTION_ERROR))
        }
    }

    fun getExercises(filter: ExercisesFilter) {
        if (checkConnection()) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val exercises = exercisesUseCase.getExercises(filter)
                if (!exercises.isNullOrEmpty()) {
                    _exercisesStateFlow.value = ExercisesState.Success(exercises)
                }
            } catch (e: Exception) {
                _exercisesStateFlow.value = ExercisesState.Error(e)
            }
        }
    } else {
        _searchTypeStateFlow.value = SearchTypeState.Error(IllegalStateException(CONNECTION_ERROR))
    }
    }

    fun setLoadingState(){
        _exercisesStateFlow.value = null
        _exercisesStateFlow.value = ExercisesState.Loading
    }

    private companion object {
        const val CONNECTION_ERROR = "Only WiFi allowed. Turn on WiFi connection or change settings"
    }
}