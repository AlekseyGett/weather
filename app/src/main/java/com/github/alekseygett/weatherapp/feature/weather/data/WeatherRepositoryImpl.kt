package com.github.alekseygett.weatherapp.feature.weather.data

import com.github.alekseygett.weatherapp.data.api.WeatherRemoteSource
import com.github.alekseygett.weatherapp.feature.weather.domain.model.WeatherDomainModel

class WeatherRepositoryImpl(private val dataSource: WeatherRemoteSource): WeatherRepository {
    override suspend fun getWeather(cityName: String): WeatherDomainModel =
        dataSource.getWeather(cityName).main.toDomainModel()
}