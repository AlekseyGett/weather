package com.github.alekseygett.weatherapp.feature.common.data.api

import com.github.alekseygett.weatherapp.feature.common.data.model.WeatherModel

class WeatherRemoteSource(private val api: WeatherApi) {
    suspend fun getWeather(): WeatherModel {
        return api.getWeather("Moscow", "7b4cdf27150f828bacdf1800ae1cdd30")
    }
}