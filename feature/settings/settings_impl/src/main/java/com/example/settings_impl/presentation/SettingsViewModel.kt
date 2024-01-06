package com.example.settings_impl.presentation

import com.example.core.viewmodel.BaseViewModel
import com.example.settings_impl.domain.SettingsUseCase
import javax.inject.Inject

class SettingsViewModel
@Inject constructor(
    private val useCase: SettingsUseCase
) : BaseViewModel() {

    fun saveState(isOnlyWiFi: Boolean) = useCase.saveMode(isOnlyWiFi)

    fun isOnlyWiFiRequired(): Boolean = useCase.isOnlyWiFiRequired()
}