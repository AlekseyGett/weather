package com.github.alekseygett.weatherapp.feature.settings.domain

import com.github.alekseygett.weatherapp.feature.settings.data.CitiesRepository
import com.github.alekseygett.weatherapp.utils.Preferences
import com.github.alekseygett.weatherapp.utils.attempt

class SettingsInteractor(
    private val repository: CitiesRepository,
    private val preferences: Preferences
) {

    suspend fun getCityNameSuggestions(prefix: String) = attempt {
        repository.getCities(prefix)
    }

    fun getCachedCityName(): String? = preferences.cityName

    fun saveCityName(cityName: String) {
        preferences.cityName = cityName
    }

}