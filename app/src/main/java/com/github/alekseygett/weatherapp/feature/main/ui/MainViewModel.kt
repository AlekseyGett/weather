package com.github.alekseygett.weatherapp.feature.main.ui

import com.github.alekseygett.weatherapp.base.BaseViewModel
import com.github.alekseygett.weatherapp.base.Event
import com.github.alekseygett.weatherapp.feature.main.domain.MainInteractor

class MainViewModel (private val interactor: MainInteractor) : BaseViewModel<ViewState>() {

    override fun initialViewState(): ViewState = ViewState(cityName = "")

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UiEvent.OnCachedCityNameRequest -> {
                val cityName = interactor.getCachedCityName() ?: ""
                processDataEvent(DataEvent.OnCachedCityNameRead(cityName))
            }
            is DataEvent.OnCachedCityNameRead -> {
                return previousState.copy(cityName = event.cityName)
            }
        }

        return null
    }

}
