package com.github.alekseygett.weatherapp.feature.weather.data

import com.github.alekseygett.weatherapp.feature.weather.domain.model.WeatherDomainModel

interface WeatherRepository {
    suspend fun getWeather(cityName: String): WeatherDomainModel
}