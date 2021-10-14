package com.github.alekseygett.weatherapp.feature.common.data.model

import com.google.gson.annotations.SerializedName

data class WeatherModel(
    @SerializedName("main")
    val main: WeatherMainModel,
    @SerializedName("wind")
    val wind: WeatherWindModel
)