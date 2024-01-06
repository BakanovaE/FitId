package com.example.fitid.navigation

import android.app.Activity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.core.LocalDependenciesProvider
import com.example.core.find
import com.example.exercises.navigation.ExercisesEntry
import com.example.settings_api.navigation.SettingsEntry
import com.example.welcome_api.navigation.WelcomeEntry

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation() {
    val navController = rememberNavController()
    val destinations = LocalDependenciesProvider.current.destinations

    val welcomeScreen = destinations.find<WelcomeEntry>()
    val exercisesScreen = destinations.find<ExercisesEntry>()
    val settingsScreen = destinations.find<SettingsEntry>()

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Box {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text("Fitness Ideas")
                    },
                    navigationIcon = {
                        val activity = (LocalContext.current as? Activity)
                        IconButton(onClick = {
                            if (navController.previousBackStackEntry != null) {
                                navController.navigateUp()
                            } else {
                                activity?.finish()
                            }
                        }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = {
                            val destination = destinations
                                .find<SettingsEntry>()
                                .destination()
                            navController.navigate(destination)
                        }) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = "Button menu"
                            )
                        }
                    },
                    scrollBehavior = scrollBehavior,
                )
            }
        ) { innerPadding ->

            Box(
                Modifier
                    .fillMaxSize()
                    .padding(innerPadding)) {
                NavHost(navController, startDestination = welcomeScreen.destination()) {

                    with(welcomeScreen) {
                        composable(navController, destinations)
                    }
                    with(exercisesScreen) {
                        composable(navController, destinations)
                    }
                    with(settingsScreen) {
                        composable(navController, destinations)
                    }
                }
            }
        }
    }
}