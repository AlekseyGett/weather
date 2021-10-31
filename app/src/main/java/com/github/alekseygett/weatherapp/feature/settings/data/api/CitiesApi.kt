package com.github.alekseygett.weatherapp.feature.settings.data.api

import com.github.alekseygett.weatherapp.feature.settings.data.model.CitiesModel
import retrofit2.http.GET
import retrofit2.http.Query

interface CitiesApi {
    @GET("v1/geo/cities")
    suspend fun getCities(
        @Query("namePrefix") prefix: String,
        @Query("limit") limit: Int = 5,
        @Query("offset") offset: Int = 0,
        @Query("sort") sort: String = "name"
    ): CitiesModel
}