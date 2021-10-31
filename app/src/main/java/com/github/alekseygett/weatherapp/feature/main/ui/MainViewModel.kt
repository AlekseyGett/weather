package com.github.alekseygett.weatherapp.feature.main.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.alekseygett.weatherapp.feature.main.domain.MainInteractor

class MainViewModel(private val interactor: MainInteractor): ViewModel() {
    private val _cityName = MutableLiveData<String>("Unknown city")
    private val _weatherDataAvailable = MutableLiveData<Boolean>(false)

    val cityName: LiveData<String> = _cityName
    val weatherDataAvailable: LiveData<Boolean> = _weatherDataAvailable

    fun updateCityName() {
        val savedCityName = interactor.getSavedCityName()
        _cityName.postValue(savedCityName ?: "Unknown city")
        _weatherDataAvailable.postValue(savedCityName?.isNotBlank() ?: false)
    }
}