package com.example.fitid.di

import android.app.Application
import android.content.Context
import com.example.core.AndroidDependenciesProvider
import com.example.core.DependenciesProvider
import com.example.core.NetworkProvider
import com.example.core.ViewModelFactoryModule
import com.example.core_impl.di.AndroidDependenciesComponent
import com.example.network.di.NetworkComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [
        NetworkProvider::class,
        AndroidDependenciesProvider::class
    ],
    modules = [
        AppModule::class,
        ViewModelFactoryModule::class,
        NavigationModule::class
    ]
)
interface AppComponent : DependenciesProvider {
    companion object {

        fun init(
            context: Context
        ): AppComponent {
            val networkProvider = NetworkComponent.create()
            val androidDependenciesProvider = AndroidDependenciesComponent.init(context)
            return DaggerAppComponent.builder()
                .networkProvider(networkProvider)
                .androidDependenciesProvider(androidDependenciesProvider)
                .build()
        }
    }

    fun inject(app: Application)
}