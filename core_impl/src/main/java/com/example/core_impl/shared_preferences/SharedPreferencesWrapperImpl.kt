package com.example.core_impl.shared_preferences

import android.content.Context
import android.content.SharedPreferences
import com.example.core.shared_preferences.SharedPreferencesWrapper
import javax.inject.Inject

class SharedPreferencesWrapperImpl
@Inject constructor(
    private val context: Context
) : SharedPreferencesWrapper {

    override fun get(name: String, mode: Int): SharedPreferences {
        return context.getSharedPreferences(name, mode)
    }

    override fun putValue(name: String, mode: Int, key: String, value: String) {
        val sharedPreferences = get(name, mode)
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    override fun getValue(name: String, mode: Int, key: String, defaultValue: String?): String? {
        val sharedPreferences = get(name, mode)
        return sharedPreferences.getString(key, defaultValue)
    }
}