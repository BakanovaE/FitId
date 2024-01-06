package com.example.network.di

import com.example.core.NetworkProvider
import dagger.Component

@Component(
    modules = [
        HttpUrlModule::class,
        NetworkModule::class
    ]
)
interface NetworkComponent: NetworkProvider {

    companion object {

        fun create(): NetworkProvider {
            return DaggerNetworkComponent.builder()
                .build()
        }
    }
}
