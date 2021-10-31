package com.github.alekseygett.weatherapp.feature.wind.domain.model

enum class WindDirection(val description: String) {
    N("North"),
    NNE("North-Northeast"),
    NE("Northeast"),
    ENE("East-Northeast"),
    E("East"),
    ESE("East-Southeast"),
    SE("Southeast"),
    SSE("South-Southeast"),
    S("South"),
    SSW("South-Southwest"),
    SW("Southwest"),
    WSW("West-Southwest"),
    W("West"),
    WNW("West-Northwest"),
    NW("Northwest"),
    NNW("North-Northwest"),
    VAR("Variable")
}