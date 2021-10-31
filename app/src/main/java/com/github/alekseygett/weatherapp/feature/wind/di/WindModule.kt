package com.github.alekseygett.weatherapp.feature.wind.di

import com.github.alekseygett.weatherapp.data.api.WeatherRemoteSource
import com.github.alekseygett.weatherapp.feature.wind.data.WindRepository
import com.github.alekseygett.weatherapp.feature.wind.data.WindRepositoryImpl
import com.github.alekseygett.weatherapp.feature.wind.domain.WindInteractor
import com.github.alekseygett.weatherapp.feature.wind.ui.WindViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val windModule = module {
    single<WindRepository> {
        WindRepositoryImpl(get<WeatherRemoteSource>())
    }

    single<WindInteractor> {
        WindInteractor(get<WindRepository>())
    }

    viewModel<WindViewModel> { params ->
        WindViewModel(get<WindInteractor>(), cityName = params.get())
    }
}