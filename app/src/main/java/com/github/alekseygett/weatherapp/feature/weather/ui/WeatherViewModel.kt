package com.github.alekseygett.weatherapp.feature.weather.ui

import androidx.lifecycle.viewModelScope
import com.github.alekseygett.weatherapp.base.BaseViewModel
import com.github.alekseygett.weatherapp.base.Event
import com.github.alekseygett.weatherapp.feature.weather.domain.WeatherInteractor
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val interactor: WeatherInteractor,
    private val cityName: String
) : BaseViewModel<ViewState>() {

    override fun initialViewState() = ViewState(
        temperature = 0.0,
        minTemperature = 0.0,
        maxTemperature = 0.0,
        humidity = 0,
        errorMessage = null
    )

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UiEvent.OnErrorMessageShow -> {
                return previousState.copy(errorMessage = null)
            }
            is UiEvent.OnWeatherRequest -> {
                viewModelScope.launch {
                    interactor.getWeather(cityName).fold(
                        onSuccess = { weather ->
                            processDataEvent(DataEvent.OnSuccessWeatherRequest(weather))
                        },
                        onError = { error ->
                            val errorMessage = error.localizedMessage ?: "Something went wrong"
                            processDataEvent(DataEvent.OnFailureWeatherRequest(errorMessage))
                        }
                    )
                }
            }
            is DataEvent.OnSuccessWeatherRequest -> {
                return previousState.copy(
                    temperature = event.weather.temperature,
                    minTemperature = event.weather.minTemperature,
                    maxTemperature = event.weather.maxTemperature,
                    humidity = event.weather.humidity
                )
            }
            is DataEvent.OnFailureWeatherRequest -> {
                return previousState.copy(errorMessage = event.errorMessage)
            }
        }

        return null
    }

}
