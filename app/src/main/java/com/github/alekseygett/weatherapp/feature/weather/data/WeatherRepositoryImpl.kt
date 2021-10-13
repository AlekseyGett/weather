package com.github.alekseygett.weatherapp.feature.weather.data

import com.github.alekseygett.weatherapp.feature.weather.data.api.WeatherRemoteSource

class WeatherRepositoryImpl(private val dataSource: WeatherRemoteSource): WeatherRepository {
    override suspend fun getWeather(): String {
        return dataSource.getWeather().main.temperature.toString()
    }
}