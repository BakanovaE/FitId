package com.example.fitid.di

import com.example.exercises_impl.di.ExercisesEntryModule
import com.example.settings_impl.di.SettingsEntryModule
import com.example.welcome_impl.di.WelcomeEntryModule
import dagger.Module

@Module(
    includes = [
        WelcomeEntryModule::class,
        ExercisesEntryModule::class,
        SettingsEntryModule::class
    ]
)
interface NavigationModule