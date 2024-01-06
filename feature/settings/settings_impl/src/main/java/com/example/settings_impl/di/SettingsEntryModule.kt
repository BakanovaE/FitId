package com.example.settings_impl.di

import com.example.core.FeatureEntry
import com.example.core.FeatureEntryKey
import com.example.settings_api.navigation.SettingsEntry
import com.example.settings_impl.navigation.SettingsEntryImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
interface SettingsEntryModule {

    @Binds
    @Singleton
    @IntoMap
    @FeatureEntryKey(SettingsEntry::class)
    fun settingsEntry(entry: SettingsEntryImpl): FeatureEntry
}