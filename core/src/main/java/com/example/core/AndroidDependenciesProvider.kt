package com.example.core

import android.content.Context
import com.example.core.shared_preferences.SharedPreferencesWrapper

interface AndroidDependenciesProvider {

    fun provideSharedPreferencesWrapper(): SharedPreferencesWrapper

    fun provideContext(): Context
}