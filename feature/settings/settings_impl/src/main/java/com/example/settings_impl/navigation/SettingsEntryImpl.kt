package com.example.settings_impl.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.example.core.App
import com.example.core.Destinations
import com.example.core.viewmodel.injectedViewModel
import com.example.settings_api.navigation.SettingsEntry
import com.example.settings_impl.di.DaggerSettingsComponent
import com.example.settings_impl.presentation.SettingsPage
import javax.inject.Inject

class SettingsEntryImpl @Inject constructor(): SettingsEntry() {

    @Composable
    override fun Composable(
        navController: NavHostController,
        destinations: Destinations,
        backStackEntry: NavBackStackEntry
    ) {
        val app = LocalContext.current.applicationContext as App
        val viewModel = injectedViewModel {
            DaggerSettingsComponent.factory()
                .create(app.getDependenciesProvider())
                .viewModel
        }
        SettingsPage(viewModel)
    }
}
