package com.github.alekseygett.weatherapp.feature.wind.di

import com.github.alekseygett.weatherapp.feature.common.data.api.WeatherRemoteSource
import com.github.alekseygett.weatherapp.feature.common.di.appModule
import com.github.alekseygett.weatherapp.feature.wind.data.WindRepository
import com.github.alekseygett.weatherapp.feature.wind.data.WindRepositoryImpl
import com.github.alekseygett.weatherapp.feature.wind.domain.WindInteractor
import com.github.alekseygett.weatherapp.feature.wind.ui.WindViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val windModule = module {
    loadKoinModules(appModule)

    single<WindRepository> {
        WindRepositoryImpl(get<WeatherRemoteSource>())
    }

    single<WindInteractor> {
        WindInteractor(get<WindRepository>())
    }

    viewModel<WindViewModel> {
        WindViewModel(get<WindInteractor>())
    }
}