package com.example.core

import androidx.compose.runtime.compositionLocalOf

interface DependenciesProvider : NetworkProvider, AndroidDependenciesProvider {

    val destinations: Destinations
}

val LocalDependenciesProvider =
    compositionLocalOf<DependenciesProvider> { error("No dependencies provider found!") }