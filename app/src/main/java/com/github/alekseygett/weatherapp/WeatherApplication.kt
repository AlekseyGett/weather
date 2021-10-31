package com.github.alekseygett.weatherapp

import android.app.Application
import com.github.alekseygett.weatherapp.di.appModule
import com.github.alekseygett.weatherapp.feature.main.di.mainModule
import com.github.alekseygett.weatherapp.feature.settings.di.settingsModule
import com.github.alekseygett.weatherapp.feature.weather.di.weatherModule
import com.github.alekseygett.weatherapp.feature.wind.di.windModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class WeatherApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@WeatherApplication)
            modules(appModule, mainModule, weatherModule, windModule, settingsModule)
        }
    }
}