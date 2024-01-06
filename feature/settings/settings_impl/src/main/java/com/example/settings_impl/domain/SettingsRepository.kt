package com.example.settings_impl.domain

interface SettingsRepository {

    fun saveMode(isOnlyWiFi: Boolean)

    fun isOnlyWiFiRequired(): Boolean
}
