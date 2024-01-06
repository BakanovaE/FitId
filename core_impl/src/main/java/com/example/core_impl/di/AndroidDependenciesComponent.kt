package com.example.core_impl.di

import android.content.Context
import com.example.core.AndroidDependenciesProvider
import dagger.Component

@Component(
    modules = [
        SharedPreferencesModule::class,
        AndroidDependenciesModule::class
    ]
)
interface AndroidDependenciesComponent : AndroidDependenciesProvider {

    companion object {

        fun init(
            context: Context
        ): AndroidDependenciesComponent {
            return DaggerAndroidDependenciesComponent.builder()
                .androidDependenciesModule(AndroidDependenciesModule(context))
                .build()
        }
    }
}