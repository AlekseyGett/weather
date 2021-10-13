package com.github.alekseygett.weatherapp.feature.weather.domain

import com.github.alekseygett.weatherapp.feature.weather.data.WeatherRepository

class WeatherInteractor(private val repository: WeatherRepository) {
    suspend fun getWeather(): String = repository.getWeather()
}