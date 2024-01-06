package com.example.fitid

import android.app.Application
import com.example.core.App
import com.example.core.DependenciesProvider
import com.example.fitid.di.AppComponent

class MainApp : Application(), App {

    private var appComponent: AppComponent? = null

    override fun onCreate() {
        super.onCreate()
        getAppComponent().inject(this)
    }

    override fun getDependenciesProvider(): DependenciesProvider {
        return getAppComponent()
    }

    override fun cleanComponent() {
        appComponent = null
    }

    private fun getAppComponent(): AppComponent {
        if (appComponent == null) {
            appComponent = AppComponent.init(applicationContext)
        }
        return appComponent!!
    }
}