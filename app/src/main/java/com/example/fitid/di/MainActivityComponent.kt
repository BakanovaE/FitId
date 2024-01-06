package com.example.fitid.di

import com.example.core.DependenciesProvider
import com.example.fitid.MainActivity
import dagger.Component

@Component(
    dependencies = [
        DependenciesProvider::class,
//        WelcomeNavigator::class
    ]
)
interface MainActivityComponent {

    companion object {

        fun init(
            dependenciesProvider: DependenciesProvider
        ): MainActivityComponent {
            return DaggerMainActivityComponent.builder()
                .dependenciesProvider(dependenciesProvider)
//                .welcomeNavigator(dependenciesProvider.getNavigator())
                .build()
        }
    }

    fun inject(mainActivity: MainActivity)
}