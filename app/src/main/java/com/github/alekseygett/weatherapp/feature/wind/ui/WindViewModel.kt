package com.github.alekseygett.weatherapp.feature.wind.ui

import androidx.lifecycle.viewModelScope
import com.github.alekseygett.weatherapp.base.BaseViewModel
import com.github.alekseygett.weatherapp.base.Event
import com.github.alekseygett.weatherapp.feature.wind.domain.WindInteractor
import kotlinx.coroutines.launch

class WindViewModel(
    private val interactor: WindInteractor,
    private val cityName: String
) : BaseViewModel<ViewState>() {

    override fun initialViewState() = ViewState(
        wind = null,
        errorMessage = null
    )

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UiEvent.OnWindRequest -> {
                viewModelScope.launch {
                    interactor.getWind(cityName).fold(
                        onSuccess = { wind ->
                            processDataEvent(DataEvent.OnSuccessWindRequest(wind))
                        },
                        onError = { error ->
                            val errorMessage = error.localizedMessage ?: "Something went wrong"
                            processDataEvent(DataEvent.OnFailureWindRequest(errorMessage))
                        }
                    )
                }
            }
            is UiEvent.OnErrorMessageShow -> {
                return previousState.copy(errorMessage = null)
            }
            is DataEvent.OnSuccessWindRequest -> {
                return previousState.copy(wind = event.wind)
            }
            is DataEvent.OnFailureWindRequest -> {
                return previousState.copy(errorMessage = event.errorMessage)
            }
        }

        return null
    }

}