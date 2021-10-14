package com.github.alekseygett.weatherapp.feature.weather.di

import com.github.alekseygett.weatherapp.feature.common.data.api.WeatherRemoteSource
import com.github.alekseygett.weatherapp.feature.common.di.appModule
import com.github.alekseygett.weatherapp.feature.weather.data.WeatherRepository
import com.github.alekseygett.weatherapp.feature.weather.data.WeatherRepositoryImpl
import com.github.alekseygett.weatherapp.feature.weather.domain.WeatherInteractor
import com.github.alekseygett.weatherapp.feature.weather.ui.WeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val weatherModule = module {
    loadKoinModules(appModule)

    single<WeatherRepository> {
        WeatherRepositoryImpl(get<WeatherRemoteSource>())
    }

    single<WeatherInteractor> {
        WeatherInteractor(get<WeatherRepository>())
    }

    viewModel<WeatherViewModel> {
        WeatherViewModel(get<WeatherInteractor>())
    }
}