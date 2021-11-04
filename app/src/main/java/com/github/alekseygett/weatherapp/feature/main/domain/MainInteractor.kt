package com.github.alekseygett.weatherapp.feature.main.domain

import com.github.alekseygett.weatherapp.utils.Preferences

class MainInteractor(private val preferences: Preferences) {
    fun getCachedCityName(): String? = preferences.cityName
}