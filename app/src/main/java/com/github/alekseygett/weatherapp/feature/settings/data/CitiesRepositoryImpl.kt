package com.github.alekseygett.weatherapp.feature.settings.data

import com.github.alekseygett.weatherapp.feature.settings.data.api.CitiesRemoteSource

class CitiesRepositoryImpl(private val dataSource: CitiesRemoteSource): CitiesRepository {
    override suspend fun getCities(prefix: String): List<String> =
        dataSource.getCities(prefix).data.map { it.name }
}