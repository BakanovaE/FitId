package com.example.settings_impl

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.performClick
import com.example.design_system.theme.FitIdTheme
import com.example.settings_impl.domain.SettingsUseCase
import com.example.settings_impl.presentation.SettingsPage
import com.example.settings_impl.presentation.SettingsViewModel
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SettingsPageTest {

    private val checked = mutableStateOf(false)
    private val useCase = mockk<SettingsUseCase>(relaxed = true)
    private val viewModel = SettingsViewModel(useCase)

    @Rule
    @JvmField
    var composeTestRule: ComposeContentTestRule = createComposeRule()

    @Before
    fun launchContent() {
        composeTestRule.setContent {
            FitIdTheme {
                SettingsPage(viewModel)
            }
        }
    }

    @Test
    fun testSwitch() {
        composeTestRule.onNode(hasTestTag("settings_connection_switch"), true)
            .assertExists()
    }

    @Test
    fun testSwitchOff() {
        composeTestRule.onNode(hasTestTag("settings_connection_switch"), true)
            .assertIsOff()
    }

    @Test
    fun testSwitchTurnsOn() {
        checked.value = true
        composeTestRule.onNode(hasTestTag("settings_connection_switch"), true)
            .assertIsOn()
    }

    @Test
    fun testSwitchTurningOnTriggeredSaveStateFun() {
        checked.value = false
        composeTestRule.onNode(hasTestTag("settings_connection_switch"), true)
            .performClick()
        verify { viewModel.saveState(true) }
    }
}