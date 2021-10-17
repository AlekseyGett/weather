package com.github.alekseygett.weatherapp.feature.settings.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.alekseygett.weatherapp.feature.settings.domain.SettingsInteractor
import kotlinx.coroutines.launch

class SettingsViewModel(private val interactor: SettingsInteractor): ViewModel() {
    private val _citySuggestions = MutableLiveData<List<String>>()
    private val _cityName = MutableLiveData<String>()
    private val _onSaveComplete = MutableLiveData<Boolean>(false)

    val citySuggestions: LiveData<List<String>> = _citySuggestions
    val cityName: LiveData<String> = _cityName
    val onSaveComplete: LiveData<Boolean> = _onSaveComplete

    init {
        val city = interactor.getSavedCityName() ?: ""
        _cityName.postValue(city)
    }

    fun requestCitySuggestions(prefix: String) {
        viewModelScope.launch {
            val suggestions = interactor.getCitySuggestions(prefix)
            _citySuggestions.postValue(suggestions)
        }
    }

    fun saveCityName(cityName: String) {
        interactor.saveCityName(cityName)
        _onSaveComplete.postValue(true)
    }
}