package com.example.welcome_api.navigation

import com.example.core.ComposableFeatureEntry

abstract class WelcomeEntry : ComposableFeatureEntry {

    final override val featureRoute = "welcome"

    fun destination() = featureRoute
}