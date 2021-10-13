package com.github.alekseygett.weatherapp.feature.weather.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.alekseygett.weatherapp.feature.weather.domain.WeatherInteractor
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class WeatherViewModel(private val interactor: WeatherInteractor): ViewModel() {

    private val _weather: MutableLiveData<String> = MutableLiveData("")

    val weather: LiveData<String>
        get() = _weather

    fun requestWeather() {
        viewModelScope.launch {
            delay(5000) // wait 5 sec
            _weather.postValue(interactor.getWeather())
        }
    }
}