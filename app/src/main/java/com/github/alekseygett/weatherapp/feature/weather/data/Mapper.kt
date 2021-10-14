package com.github.alekseygett.weatherapp.feature.weather.data

import com.github.alekseygett.weatherapp.feature.common.data.model.WeatherModel
import com.github.alekseygett.weatherapp.feature.weather.domain.model.WeatherDomainModel

fun WeatherModel.toWeatherDomainModel(): WeatherDomainModel {
    return WeatherDomainModel(
        this.main.temperature,
        this.main.minTemperature,
        this.main.maxTemperature,
        this.main.humidity
    )
}