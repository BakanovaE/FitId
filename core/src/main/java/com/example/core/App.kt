package com.example.core

interface App {

    fun getDependenciesProvider(): DependenciesProvider

    fun cleanComponent()
}
