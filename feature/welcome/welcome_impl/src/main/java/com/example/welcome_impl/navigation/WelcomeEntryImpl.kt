package com.example.welcome_impl.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.example.core.Destinations
import com.example.core.find
import com.example.exercises.navigation.ExercisesEntry
import com.example.welcome_api.navigation.WelcomeEntry
import com.example.welcome_impl.presentation.StartPage
import javax.inject.Inject

class WelcomeEntryImpl @Inject constructor(): WelcomeEntry() {

    @Composable
    override fun Composable(
        navController: NavHostController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry
    ) {
        StartPage(onButtonClick = { searchType ->
            val destination = destinations
                .find<ExercisesEntry>()
                .destination(searchType)
            navController.navigate(destination)
        })
    }
}