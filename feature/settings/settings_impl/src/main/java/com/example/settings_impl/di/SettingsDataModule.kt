package com.example.settings_impl.di

import com.example.core.FeatureScoped
import com.example.settings_impl.data.SettingsRepositoryImpl
import com.example.settings_impl.domain.SettingsRepository
import dagger.Binds
import dagger.Module

@Module
interface SettingsDataModule {

    @FeatureScoped
    @Binds
    fun provideSettingsRepository(repository: SettingsRepositoryImpl): SettingsRepository
}