package com.example.settings_api.navigation

import com.example.core.ComposableFeatureEntry

abstract class SettingsEntry : ComposableFeatureEntry {

    final override val featureRoute = "settings"

    fun destination() = featureRoute
}