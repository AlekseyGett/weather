package com.github.alekseygett.weatherapp.feature.wind.ui

import com.github.alekseygett.weatherapp.base.Event
import com.github.alekseygett.weatherapp.feature.wind.domain.model.WindDomainModel

data class ViewState(
    val wind: WindDomainModel?,
    val errorMessage: String?
)

sealed class UiEvent : Event {
    object OnWindRequest : UiEvent()
    object OnErrorMessageShow : UiEvent()
}

sealed class DataEvent : Event {
    data class OnSuccessWindRequest(val wind: WindDomainModel) : DataEvent()
    data class OnFailureWindRequest(val errorMessage: String?) : DataEvent()
}