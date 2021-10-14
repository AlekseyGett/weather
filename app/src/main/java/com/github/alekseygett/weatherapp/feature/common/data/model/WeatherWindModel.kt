package com.github.alekseygett.weatherapp.feature.common.data.model

import com.google.gson.annotations.SerializedName

data class WeatherWindModel(
    @SerializedName("speed")
    val speed: Double,
    @SerializedName("deg")
    val direction: Int
)