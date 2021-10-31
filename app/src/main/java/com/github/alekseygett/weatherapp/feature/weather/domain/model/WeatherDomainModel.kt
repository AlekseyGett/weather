package com.github.alekseygett.weatherapp.feature.weather.domain.model

data class WeatherDomainModel(
    val temperature: Double,
    val minTemperature: Double,
    val maxTemperature: Double,
    val humidity: Int
)