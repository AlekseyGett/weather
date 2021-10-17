package com.github.alekseygett.weatherapp.feature.weather.di

import com.github.alekseygett.weatherapp.data.api.WeatherRemoteSource
import com.github.alekseygett.weatherapp.feature.weather.data.WeatherRepository
import com.github.alekseygett.weatherapp.feature.weather.data.WeatherRepositoryImpl
import com.github.alekseygett.weatherapp.feature.weather.domain.WeatherInteractor
import com.github.alekseygett.weatherapp.feature.weather.ui.WeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val weatherModule = module {
    single<WeatherRepository> {
        WeatherRepositoryImpl(get<WeatherRemoteSource>())
    }

    single<WeatherInteractor> {
        WeatherInteractor(get<WeatherRepository>())
    }

    viewModel<WeatherViewModel> { params ->
        WeatherViewModel(get<WeatherInteractor>(), cityName = params.get())
    }
}