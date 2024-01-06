package com.example.exercises_impl.presentation

import android.app.Activity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.core.utils.Constants.SEARCH_TYPE_EQUIPMENT
import com.example.core.utils.Constants.SEARCH_TYPE_MUSCLES
import com.example.design_system.elements.FitIdAlert
import com.example.design_system.elements.FitIdDialog
import com.example.design_system.elements.FitIdLoader
import com.example.exercises_impl.model.data.ExerciseTranslationBaseInfo
import com.example.exercises_impl.model.data.ExercisesFilter
import com.example.exercises_impl.model.presentation.ExercisesState
import com.example.exercises_impl.model.presentation.SearchTypeState

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ExercisesScreen(
    searchType: String,
    viewModel: ExercisesViewModel,
    modifier: Modifier = Modifier
) {

    val chipItemsFlow = viewModel.searchTypeStateFlow.collectAsState()
    val exercisesStateFlow = viewModel.exercisesStateFlow.collectAsState()
    var showDialog by remember { mutableStateOf(false) }
    var exercise by remember { mutableStateOf<ExerciseTranslationBaseInfo?>(null) }
    val navController = rememberNavController()

    when (searchType) {
        SEARCH_TYPE_MUSCLES -> viewModel.getMuscles()
        SEARCH_TYPE_EQUIPMENT -> viewModel.getEquipment()
    }

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {

            when (val state = chipItemsFlow.value) {
                is SearchTypeState.Success -> {
                    val chips = state.items
                    chips.forEach { chipItem ->
                        SuggestionChip(
                            modifier = Modifier
                                .padding(horizontal = 6.dp)
                                .testTag("Chip"),
                            onClick = {
                                viewModel.setLoadingState()
                                val filter = when (searchType) {
                                    SEARCH_TYPE_MUSCLES -> ExercisesFilter(
                                        muscle = listOf(chipItem.id),
                                        equipment = null
                                    )

                                    SEARCH_TYPE_EQUIPMENT -> ExercisesFilter(
                                        muscle = null,
                                        equipment = listOf(chipItem.id)
                                    )

                                    else -> ExercisesFilter(null, null)
                                }
                                viewModel.getExercises(filter)
                            },
                            colors = SuggestionChipDefaults.suggestionChipColors(
                                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                            ),
                            border = SuggestionChipDefaults.suggestionChipBorder(
                                borderWidth = 1.dp
                            ),
                            label = {
                                Text(text = chipItem.name)
                            }
                        )
                    }
                }

                is SearchTypeState.Error -> {
                    val activity = (LocalContext.current as? Activity)
                    FitIdAlert(
                        onDismissRequest = {
                            showDialog = false
                            if (navController.previousBackStackEntry != null) {
                                navController.navigateUp()
                            } else {
                                activity?.finish()
                            }
                        },
                        description = state.exception.localizedMessage
                    )
                }

                is SearchTypeState.Loading -> {
                    FitIdLoader(modifier = Modifier.testTag("Loader"))
                }
            }
        }

        when (val state = exercisesStateFlow.value) {
            is ExercisesState.Success -> {
                LazyColumn(modifier = Modifier.padding(8.dp)) {
                    items(state.exercises) { exercises ->
                        exercises.exercises.forEach {
                            Text(
                                text = it.name,
                                modifier = Modifier
                                    .padding(4.dp)
                                    .clickable(onClick = {
                                        showDialog = true
                                        exercise = it
                                    })
                            )
                        }
                    }
                }
            }

            is ExercisesState.Loading -> {
                FitIdLoader(modifier = Modifier.testTag("Loader"))
            }

            is ExercisesState.Error -> {
                val activity = (LocalContext.current as? Activity)
                FitIdAlert(
                    onDismissRequest = {
                        showDialog = false
                        if (navController.previousBackStackEntry != null) {
                            navController.navigateUp()
                        } else {
                            activity?.finish()
                        }
                    },
                    description = state.exception.localizedMessage
                )
            }

            else -> {}
        }
    }


    if (showDialog) {
        exercise?.let {
            FitIdDialog(
                onDismissRequest = { showDialog = false },
                title = it.name,
                description = it.description
            )
        }
    }
}

