package com.example.exercises_impl.data

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.example.core.shared_preferences.SharedPreferencesWrapper
import com.example.core.utils.Constants
import com.example.exercises_impl.domain.ExercisesConnectionRepository
import javax.inject.Inject

class ExercisesConnectionRepositoryImpl
@Inject constructor(
    private val sharedPreferencesWrapper: SharedPreferencesWrapper,
    private val context: Context
): ExercisesConnectionRepository{

    override fun isOnlyWiFiRequired(): Boolean {
        val value = sharedPreferencesWrapper.getValue(
            name = Constants.SETTINGS_PREFERENCES,
            key = Constants.CONNECTION_SETTINGS,
            defaultValue = Constants.CONNECTION_ALL
        )
        return when (value) {
            Constants.CONNECTION_WIFI -> true
            Constants.CONNECTION_ALL -> false
            else -> false
        }
    }

    override fun isWiFiConnectionEnabled(): Boolean =
        context.getConnectionType() == 2

    private fun Context.getConnectionType(): Int {
        var result = 0
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        cm.run {
            getNetworkCapabilities(cm.activeNetwork)?.run {
                when {
                    hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        result = 2
                    }

                    hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        result = 1
                    }

                    hasTransport(NetworkCapabilities.TRANSPORT_VPN) -> {
                        result = 3
                    }
                }
            }
        }
        return result
    }
}