package com.github.alekseygett.weatherapp.feature.weather.data

import com.github.alekseygett.weatherapp.feature.common.data.api.WeatherRemoteSource
import com.github.alekseygett.weatherapp.feature.weather.domain.model.WeatherDomainModel

class WeatherRepositoryImpl(private val dataSource: WeatherRemoteSource): WeatherRepository {
    override suspend fun getWeather(): WeatherDomainModel {
        return dataSource.getWeather().toWeatherDomainModel()
    }
}