package com.github.alekseygett.weatherapp.feature.wind.data

import com.github.alekseygett.weatherapp.feature.wind.domain.model.WindDomainModel

interface WindRepository {
    suspend fun getWind(cityName: String): WindDomainModel
}