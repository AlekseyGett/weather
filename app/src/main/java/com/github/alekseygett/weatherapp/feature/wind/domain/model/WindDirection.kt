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