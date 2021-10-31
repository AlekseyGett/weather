package com.github.alekseygett.weatherapp.data.api

import com.github.alekseygett.weatherapp.data.model.WeatherModel
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("weather")
    suspend fun getWeather(
        @Query("q") cityName: String,
        @Query("appid") appId: String = "7b4cdf27150f828bacdf1800ae1cdd30",
        @Query("units") units: String = "metric"
    ): WeatherModel
}