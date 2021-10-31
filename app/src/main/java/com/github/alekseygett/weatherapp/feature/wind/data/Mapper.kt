package com.github.alekseygett.weatherapp.feature.wind.data

import com.github.alekseygett.weatherapp.data.model.WeatherWindModel
import com.github.alekseygett.weatherapp.feature.wind.domain.model.WindDirection
import com.github.alekseygett.weatherapp.feature.wind.domain.model.WindDomainModel

fun WeatherWindModel.toDomainModel(): WindDomainModel {
    return WindDomainModel(
        this.speed,
        this.direction.toWindDirection()
    )
}

fun Int.toWindDirection(): WindDirection {
    return when (this) {
        !in 12..348 -> WindDirection.N
        in 12..33 -> WindDirection.NNE
        in 34..56 -> WindDirection.NE
        in 57..78 -> WindDirection.ENE
        in 79..101 -> WindDirection.E
        in 102..123 -> WindDirection.ESE
        in 124..146 -> WindDirection.SE
        in 147..168 -> WindDirection.SSE
        in 169..191 -> WindDirection.S
        in 192..213 -> WindDirection.SSW
        in 214..236 -> WindDirection.SW
        in 237..258 -> WindDirection.WSW
        in 259..281 -> WindDirection.W
        in 282..303 -> WindDirection.WNW
        in 304..326 -> WindDirection.NW
        in 327..348 -> WindDirection.NNW
        else -> WindDirection.VAR
    }
}