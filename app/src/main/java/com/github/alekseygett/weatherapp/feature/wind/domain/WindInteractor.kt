package com.github.alekseygett.weatherapp.feature.wind.domain

import com.github.alekseygett.weatherapp.feature.wind.data.WindRepository
import com.github.alekseygett.weatherapp.feature.wind.domain.model.WindDomainModel

class WindInteractor(private val repository: WindRepository) {
    suspend fun getWind(): WindDomainModel = repository.getWind()
}