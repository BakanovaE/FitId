package com.example.settings_impl.di

import com.example.core.DependenciesProvider
import com.example.core.FeatureScoped
import com.example.settings_impl.presentation.SettingsViewModel
import dagger.Component

@FeatureScoped
@Component(
    dependencies = [DependenciesProvider::class],
    modules = [
        SettingsEntryModule::class,
        SettingsViewModelModule::class,
        SettingsDataModule::class
    ]
)
interface SettingsComponent {

    val viewModel: SettingsViewModel

    companion object {

        fun init(
            dependenciesProvider: DependenciesProvider
        ): SettingsComponent {
            return DaggerSettingsComponent.factory()
                .create(dependenciesProvider = dependenciesProvider)
        }
    }

    @Component.Factory
    interface Factory {

        fun create(
            dependenciesProvider: DependenciesProvider
        ): SettingsComponent
    }
}