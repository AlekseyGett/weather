package com.github.alekseygett.weatherapp.feature.wind.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.alekseygett.weatherapp.feature.wind.domain.WindInteractor
import com.github.alekseygett.weatherapp.feature.wind.domain.model.WindDomainModel
import kotlinx.coroutines.launch

class WindViewModel(
    private val interactor: WindInteractor,
    private val cityName: String
): ViewModel() {
    private val _wind: MutableLiveData<WindDomainModel> = MutableLiveData()

    val wind: LiveData<WindDomainModel>
        get() = _wind

    fun requestWind() {
        viewModelScope.launch {
            val wind = interactor.getWind(cityName)
            _wind.postValue(wind)
        }
    }
}