package com.github.alekseygett.weatherapp.feature.settings.data.model

import com.google.gson.annotations.SerializedName

data class CityModel(
    @SerializedName("city")
    val name: String
)