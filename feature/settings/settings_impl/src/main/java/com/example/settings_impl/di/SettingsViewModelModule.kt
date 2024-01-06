package com.example.settings_impl.di

import androidx.lifecycle.ViewModel
import com.example.core.viewmodel.ViewModelKey
import com.example.settings_impl.presentation.SettingsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface SettingsViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SettingsViewModel::class)
    fun provideSettingsViewModel(settingsViewModel: SettingsViewModel): ViewModel
}