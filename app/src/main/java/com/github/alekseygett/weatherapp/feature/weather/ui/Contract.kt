package com.github.alekseygett.weatherapp.feature.weather.ui

import com.github.alekseygett.weatherapp.base.Event
import com.github.alekseygett.weatherapp.feature.weather.domain.model.WeatherDomainModel

data class ViewState(
    val temperature: Double,
    val minTemperature: Double,
    val maxTemperature: Double,
    val humidity: Int,
    val errorMessage: String?
)

sealed class UiEvent : Event {
    object OnWeatherRequest : UiEvent()
    object OnErrorMessageShow : UiEvent()
}

sealed class DataEvent : Event {
    data class OnSuccessWeatherRequest(val weather: WeatherDomainModel) : DataEvent()
    data class OnFailureWeatherRequest(val errorMessage: String) : DataEvent()
}