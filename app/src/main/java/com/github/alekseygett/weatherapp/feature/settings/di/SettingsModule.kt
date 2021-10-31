package com.github.alekseygett.weatherapp.feature.settings.di

import com.github.alekseygett.weatherapp.feature.settings.data.CitiesRepository
import com.github.alekseygett.weatherapp.feature.settings.data.CitiesRepositoryImpl
import com.github.alekseygett.weatherapp.feature.settings.data.api.CitiesApi
import com.github.alekseygett.weatherapp.feature.settings.data.api.CitiesRemoteSource
import com.github.alekseygett.weatherapp.feature.settings.domain.SettingsInteractor
import com.github.alekseygett.weatherapp.feature.settings.ui.SettingsViewModel
import com.github.alekseygett.weatherapp.utils.Preferences
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val CITIES_RETROFIT_NAME = "citiesRetrofit"
const val BASE_URL = "http://geodb-free-service.wirefreethought.com/"

val settingsModule = module {
    single<Retrofit>(named(CITIES_RETROFIT_NAME)) {
        Retrofit.Builder()
            .client(get())
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<CitiesApi> {
        get<Retrofit>(named(CITIES_RETROFIT_NAME)).create(CitiesApi::class.java)
    }

    single<CitiesRemoteSource> {
        CitiesRemoteSource(get<CitiesApi>())
    }

    single<CitiesRepository> {
        CitiesRepositoryImpl(get<CitiesRemoteSource>())
    }

    single<SettingsInteractor> {
        SettingsInteractor(get<CitiesRepository>(), get<Preferences>())
    }

    viewModel<SettingsViewModel> {
        SettingsViewModel(get<SettingsInteractor>())
    }
}