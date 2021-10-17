package com.github.alekseygett.weatherapp.feature.wind.data

import com.github.alekseygett.weatherapp.data.api.WeatherRemoteSource
import com.github.alekseygett.weatherapp.feature.wind.domain.model.WindDomainModel

class WindRepositoryImpl(private val dataSource: WeatherRemoteSource): WindRepository {
    override suspend fun getWind(cityName: String): WindDomainModel {
        return dataSource.getWeather(cityName).wind.toDomainModel()
    }
}