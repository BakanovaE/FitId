package com.example.core_impl.di

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AndroidDependenciesModule(
    private val context: Context
) {

    @Provides
    fun provideAppContext(): Context {
        return context
    }
}