package com.example.core_impl.di

import com.example.core.shared_preferences.SharedPreferencesWrapper
import com.example.core_impl.shared_preferences.SharedPreferencesWrapperImpl
import dagger.Binds
import dagger.Module

@Module
interface SharedPreferencesModule {

    @Binds
    fun provideSharedPreferencesWrapper(
        sharedPreferencesWrapper: SharedPreferencesWrapperImpl
    ): SharedPreferencesWrapper
}