package com.example.settings_impl.domain

import javax.inject.Inject

class SettingsUseCase @Inject constructor(
    private val repository: SettingsRepository
) {

    fun saveMode(isOnlyWiFi: Boolean) = repository.saveMode(isOnlyWiFi)

    fun isOnlyWiFiRequired(): Boolean = repository.isOnlyWiFiRequired()
}