package com.github.alekseygett.weatherapp.feature.weather.data

import com.github.alekseygett.weatherapp.data.model.WeatherMainModel
import com.github.alekseygett.weatherapp.feature.weather.domain.model.WeatherDomainModel

fun WeatherMainModel.toDomainModel(): WeatherDomainModel =
    WeatherDomainModel(
        temperature,
        minTemperature,
        maxTemperature,
        humidity
    )