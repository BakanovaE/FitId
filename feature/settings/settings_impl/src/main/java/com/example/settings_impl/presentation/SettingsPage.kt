package com.example.settings_impl.presentation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.example.design_system.animation.EnterAnimation

@Composable
fun SettingsPage(viewModel: SettingsViewModel, modifier: Modifier = Modifier) {

    EnterAnimation {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier) {
            val savedConnectionState = viewModel.isOnlyWiFiRequired()
            val connectionState = remember { mutableStateOf(savedConnectionState) }
            Switch(
                checked = connectionState.value,
                onCheckedChange = {
                    connectionState.value = it
                    viewModel.saveState(it)
                },
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .testTag("settings_connection_switch")
            )
            Text(text = "Use only Wi-Fi", modifier = Modifier.padding(horizontal = 8.dp))
        }
    }
}
