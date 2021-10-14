package com.github.alekseygett.weatherapp.feature.weather.domain

import com.github.alekseygett.weatherapp.feature.weather.data.WeatherRepository
import com.github.alekseygett.weatherapp.feature.weather.domain.model.WeatherDomainModel

class WeatherInteractor(private val repository: WeatherRepository) {
    suspend fun getWeather(): WeatherDomainModel = repository.getWeather()
}