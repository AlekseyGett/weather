package com.github.alekseygett.weatherapp.feature.wind.data

import com.github.alekseygett.weatherapp.feature.common.data.model.WeatherModel
import com.github.alekseygett.weatherapp.feature.wind.domain.model.WindDirection
import com.github.alekseygett.weatherapp.feature.wind.domain.model.WindDomainModel

fun WeatherModel.toWindDomainModel(): WindDomainModel {
    return WindDomainModel(
        this.wind.speed,
        this.wind.direction.toWindDirection()
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

//N = North (349 - 011 degrees)
//NNE = North-Northeast (012-033 degrees)
//NE = Northeast (034-056 degrees)
//ENE = East-Northeast (057-078 degrees)
//E = East (079-101 degrees)
//ESE = East-Southeast (102-123 degrees)
//SE = Southeast (124-146 degrees)
//SSE = South-Southeast (147-168 degrees)
//S = South (169-191 degrees)
//SSW = South-Southwest (192-213 degrees)
//SW = Southwest (214-236 degrees)
//WSW = West-Southwest (237-258 degrees)
//W = West (259-281 degrees)
//WNW = West-Northwest (282-303 degrees)
//NW = Northwest (304-326 degrees)
//NNW = North-Northwest (327-348 degrees)