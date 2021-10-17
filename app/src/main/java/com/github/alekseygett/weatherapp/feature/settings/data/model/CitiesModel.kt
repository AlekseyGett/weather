package com.github.alekseygett.weatherapp.feature.settings.data.model

import com.google.gson.annotations.SerializedName

data class CitiesModel(
    @SerializedName("data")
    val data: List<CityModel>
)