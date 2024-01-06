package com.example.settings_impl.data

import com.example.core.shared_preferences.SharedPreferencesWrapper
import com.example.core.utils.Constants.CONNECTION_ALL
import com.example.core.utils.Constants.CONNECTION_SETTINGS
import com.example.core.utils.Constants.CONNECTION_WIFI
import com.example.core.utils.Constants.SETTINGS_PREFERENCES
import com.example.settings_impl.domain.SettingsRepository
import javax.inject.Inject

class SettingsRepositoryImpl
@Inject constructor(
    private val sharedPreferencesWrapper: SharedPreferencesWrapper
) : SettingsRepository {

    override fun saveMode(isOnlyWiFi: Boolean) {
        sharedPreferencesWrapper.putValue(
            name = SETTINGS_PREFERENCES,
            key = CONNECTION_SETTINGS,
            value = if (isOnlyWiFi) CONNECTION_WIFI else CONNECTION_ALL
        )
    }

    override fun isOnlyWiFiRequired(): Boolean {
        val value = sharedPreferencesWrapper.getValue(
            name = SETTINGS_PREFERENCES,
            key = CONNECTION_SETTINGS,
            defaultValue = CONNECTION_ALL
        )
        return when (value) {
            CONNECTION_WIFI -> true
            CONNECTION_ALL -> false
            else -> false
        }
    }
}