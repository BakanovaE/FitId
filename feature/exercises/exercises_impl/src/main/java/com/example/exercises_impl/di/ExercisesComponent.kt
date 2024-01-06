package com.example.exercises_impl.di

import com.example.core.DependenciesProvider
import com.example.core.FeatureScoped
import com.example.core.ViewModelFactoryModule
import com.example.exercises_impl.presentation.ExercisesViewModel
import dagger.Component

@FeatureScoped
@Component(
    dependencies = [DependenciesProvider::class],
    modules = [
        ViewModelFactoryModule::class,
        ExercisesEntryModule::class,
        ExercisesViewModelModule::class,
        NetworkModule::class,
        DataModule::class
    ]
)
interface ExercisesComponent {

    val viewModel: ExercisesViewModel

    companion object {

        fun init(
            dependenciesProvider: DependenciesProvider
        ): ExercisesComponent {
            return DaggerExercisesComponent.factory()
                .create(dependenciesProvider = dependenciesProvider)
        }
    }

    @Component.Factory
    interface Factory {

        fun create(
            dependenciesProvider: DependenciesProvider
        ): ExercisesComponent
    }
}
