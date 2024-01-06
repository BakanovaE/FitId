package com.example.welcome_impl.di

import com.example.core.DependenciesProvider
import com.example.core.FeatureScoped
import dagger.Component

@FeatureScoped
@Component(
    dependencies = [DependenciesProvider::class],
    modules = [
        WelcomeEntryModule::class
    ]
)
interface WelcomeComponent