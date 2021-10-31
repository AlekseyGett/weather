package com.github.alekseygett.weatherapp.feature.main.di

import com.github.alekseygett.weatherapp.feature.main.domain.MainInteractor
import com.github.alekseygett.weatherapp.feature.main.ui.MainViewModel
import com.github.alekseygett.weatherapp.utils.Preferences
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    single<MainInteractor> {
        MainInteractor(get<Preferences>())
    }

    viewModel<MainViewModel> {
        MainViewModel(get<MainInteractor>())
    }
}