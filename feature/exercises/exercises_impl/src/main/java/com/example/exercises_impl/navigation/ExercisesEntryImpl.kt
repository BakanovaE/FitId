package com.example.exercises_impl.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.example.core.App
import com.example.core.Destinations
import com.example.core.viewmodel.injectedViewModel
import com.example.exercises.navigation.ExercisesEntry
import com.example.exercises_impl.di.DaggerExercisesComponent
import com.example.exercises_impl.presentation.ExercisesScreen
import javax.inject.Inject

class ExercisesEntryImpl @Inject constructor(): ExercisesEntry() {

    @Composable
    override fun Composable(
        navController: NavHostController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry
    ) {
        val app = LocalContext.current.applicationContext as App
        val viewModel = injectedViewModel {
            DaggerExercisesComponent.factory()
                .create(app.getDependenciesProvider())
                .viewModel
        }
        val searchType = backStackEntry.arguments?.getString(ARG_SEARCH_TYPE) ?: "unknown search type"
        ExercisesScreen(searchType, viewModel)
    }
}
