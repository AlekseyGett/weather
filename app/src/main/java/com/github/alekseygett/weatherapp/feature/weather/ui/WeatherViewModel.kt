package com.github.alekseygett.weatherapp.feature.weather.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.alekseygett.weatherapp.feature.weather.domain.WeatherInteractor
import com.github.alekseygett.weatherapp.feature.weather.domain.model.WeatherDomainModel
import kotlinx.coroutines.launch

class WeatherViewModel(private val interactor: WeatherInteractor): ViewModel() {
    private val _weather: MutableLiveData<WeatherDomainModel> = MutableLiveData()

    val weather: LiveData<WeatherDomainModel>
        get() = _weather

    fun requestWeather() {
        viewModelScope.launch {
            val weather = interactor.getWeather()
            _weather.postValue(weather)
        }
    }
}