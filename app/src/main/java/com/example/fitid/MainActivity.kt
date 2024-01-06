package com.example.fitid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.CompositionLocalProvider
import com.example.core.App
import com.example.core.LocalDependenciesProvider
import com.example.design_system.theme.FitIdTheme
import com.example.fitid.navigation.Navigation

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FitIdTheme {
                Surface {
                    CompositionLocalProvider(
                        LocalDependenciesProvider provides (application as App).getDependenciesProvider()
                    ) {
                        Navigation()
                    }
                }
            }
        }
    }
}
