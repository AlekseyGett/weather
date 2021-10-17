package com.github.alekseygett.weatherapp.feature.weather.domain

import com.github.alekseygett.weatherapp.feature.weather.data.WeatherRepository
import com.github.alekseygett.weatherapp.feature.weather.domain.model.WeatherDomainModel
import com.github.alekseygett.weatherapp.utils.Preferences

class WeatherInteractor(private val repository: WeatherRepository) {
    suspend fun getWeather(cityName: String): WeatherDomainModel = repository.getWeather(cityName)
}
