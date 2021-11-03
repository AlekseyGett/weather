package com.github.alekseygett.weatherapp.feature.settings.ui

import androidx.lifecycle.viewModelScope
import com.github.alekseygett.weatherapp.base.BaseViewModel
import com.github.alekseygett.weatherapp.base.Event
import com.github.alekseygett.weatherapp.feature.settings.domain.SettingsInteractor
import kotlinx.coroutines.launch

class SettingsViewModel(private val interactor: SettingsInteractor) : BaseViewModel<ViewState>() {

    override fun initialViewState(): ViewState = ViewState(
        isCityNameRequested = false,
        cityName = "",
        cityNameSuggestions = emptyList(),
        isSettingsSaved = false,
        errorMessage = null
    )

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UiEvent.OnCachedCityNameRequest -> {
                val cityName = interactor.getCachedCityName() ?: ""
                processDataEvent(DataEvent.OnCachedCityNameRead(cityName))
            }
            is UiEvent.OnCachedCityNameShowed -> {
                return previousState.copy(isCityNameRequested = false)
            }
            is UiEvent.OnErrorMessageShowed -> {
                return previousState.copy(errorMessage = null)
            }
            is UiEvent.OnRequestSuggestions -> {
                viewModelScope.launch {
                    interactor.getCityNameSuggestions(event.prefix).fold(
                        onSuccess = { suggestions ->
                            processDataEvent(DataEvent.OnSuccessSuggestionsRequest(suggestions))
                        },
                        onError = { error ->
                            val errorMessage = error.localizedMessage ?: "Something went wrong"
                            processDataEvent(DataEvent.OnFailureSuggestionsRequest(errorMessage))
                        }
                    )
                }
            }
            is UiEvent.OnSaveButtonClick -> {
                interactor.saveCityName(event.cityName)
                processDataEvent(DataEvent.OnSettingsSave)
            }
            is DataEvent.OnSettingsSave -> {
                return previousState.copy(isSettingsSaved = true)
            }
            is DataEvent.OnCachedCityNameRead -> {
                return previousState.copy(isCityNameRequested = true, cityName = event.cityName)
            }
            is DataEvent.OnSuccessSuggestionsRequest -> {
                return previousState.copy(cityNameSuggestions = event.suggestions)
            }
            is DataEvent.OnFailureSuggestionsRequest -> {
                return previousState.copy(errorMessage = event.errorMessage)
            }
        }

        return null
    }

}