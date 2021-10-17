package com.github.alekseygett.weatherapp.feature.settings.domain

import com.github.alekseygett.weatherapp.feature.settings.data.CitiesRepository
import com.github.alekseygett.weatherapp.utils.Preferences

class SettingsInteractor(
    private val repository: CitiesRepository,
    private val preferences: Preferences
) {
    suspend fun getCitySuggestions(prefix: String): List<String> = repository.getCities(prefix)

    fun getSavedCityName(): String? = preferences.cityName

    fun saveCityName(cityName: String) {
        preferences.cityName = cityName
    }
}