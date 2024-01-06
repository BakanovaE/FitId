package com.example.welcome_impl.di

import com.example.core.FeatureEntry
import com.example.core.FeatureEntryKey
import com.example.welcome_api.navigation.WelcomeEntry
import com.example.welcome_impl.navigation.WelcomeEntryImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
interface WelcomeEntryModule {

    @Binds
    @Singleton
    @IntoMap
    @FeatureEntryKey(WelcomeEntry::class)
    fun movieSearchEntry(entry: WelcomeEntryImpl): FeatureEntry
}