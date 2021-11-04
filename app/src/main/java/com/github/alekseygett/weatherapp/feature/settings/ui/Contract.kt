package com.github.alekseygett.weatherapp.feature.settings.ui

import com.github.alekseygett.weatherapp.base.Event

data class ViewState(
    val isCityNameRequested: Boolean,
    val cityName: String,
    val cityNameSuggestions: List<String>,
    val isSettingsSaved: Boolean,
    val errorMessage: String?
)

sealed class UiEvent : Event {
    object OnCachedCityNameRequest : UiEvent()
    object OnCachedCityNameShow : UiEvent()
    object OnErrorMessageShow : UiEvent()
    data class OnRequestSuggestions(val prefix: String) : UiEvent()
    data class OnSaveButtonClick(val cityName: String) : UiEvent()
}

sealed class DataEvent : Event {
    object OnSettingsSave : DataEvent()
    data class OnCachedCityNameRead(val cityName: String) : DataEvent()
    data class OnSuccessSuggestionsRequest(val suggestions: List<String>) : DataEvent()
    data class OnFailureSuggestionsRequest(val errorMessage: String) : DataEvent()
}