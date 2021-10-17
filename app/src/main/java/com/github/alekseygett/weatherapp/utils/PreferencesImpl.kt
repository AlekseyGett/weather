package com.github.alekseygett.weatherapp.utils

import android.content.Context
import android.content.Context.MODE_PRIVATE

private const val PREFERENCES_NAME = "weatherAppPreferences"
private const val CITY_NAME_KEY = "cityName"

class PreferencesImpl(context: Context): Preferences {
    private val sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE)

    override var cityName: String?
        get() = sharedPreferences.getString(CITY_NAME_KEY, null)
        set(value) {
            val editor = sharedPreferences.edit()
            editor.putString(CITY_NAME_KEY, value)
            editor.apply()
        }
}