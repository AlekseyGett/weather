package com.github.alekseygett.weatherapp.data.api

import com.github.alekseygett.weatherapp.data.model.WeatherModel

class WeatherRemoteSource(private val api: WeatherApi) {
    suspend fun getWeather(cityName: String): WeatherModel =
        api.getWeather(cityName, "7b4cdf27150f828bacdf1800ae1cdd30")
}