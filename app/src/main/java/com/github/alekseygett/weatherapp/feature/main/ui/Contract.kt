package com.github.alekseygett.weatherapp.feature.main.ui

import com.github.alekseygett.weatherapp.base.Event

data class ViewState(
    val cityName: String
)

sealed class UiEvent() : Event {
    object OnCachedCityNameRequest : DataEvent()
}

sealed class DataEvent() : Event {
    data class OnCachedCityNameRead(val cityName: String) : DataEvent()
}