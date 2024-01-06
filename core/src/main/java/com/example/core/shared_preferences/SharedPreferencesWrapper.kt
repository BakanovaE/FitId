package com.example.core.shared_preferences

import android.content.Context
import android.content.SharedPreferences

interface SharedPreferencesWrapper {

    fun get(name: String, mode: Int = Context.MODE_PRIVATE): SharedPreferences?

    fun putValue(name: String, mode: Int = Context.MODE_PRIVATE, key: String, value: String)

    fun getValue(
        name: String,
        mode: Int = Context.MODE_PRIVATE,
        key: String,
        defaultValue: String?
    ): String?
}