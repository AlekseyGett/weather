package com.github.alekseygett.weatherapp.feature.wind.domain

import com.github.alekseygett.weatherapp.feature.wind.data.WindRepository
import com.github.alekseygett.weatherapp.feature.wind.domain.model.WindDomainModel
import com.github.alekseygett.weatherapp.utils.attempt

class WindInteractor(private val repository: WindRepository) {
    suspend fun getWind(cityName: String) = attempt { repository.getWind(cityName) }
}