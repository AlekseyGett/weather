package com.github.alekseygett.weatherapp.feature.weather.data

interface WeatherRepository {
    suspend fun getWeather(): String
}