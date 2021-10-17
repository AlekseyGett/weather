package com.github.alekseygett.weatherapp.feature.settings.data.api

import com.github.alekseygett.weatherapp.feature.settings.data.model.CitiesModel

class CitiesRemoteSource(private val api: CitiesApi) {
    suspend fun getCities(prefix: String): CitiesModel = api.getCities(prefix)
}