package com.github.alekseygett.weatherapp.feature.settings.data

interface CitiesRepository {
    suspend fun getCities(prefix: String): List<String>
}