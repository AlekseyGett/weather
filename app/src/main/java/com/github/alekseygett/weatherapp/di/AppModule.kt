package com.github.alekseygett.weatherapp.di

import com.github.alekseygett.weatherapp.data.api.WeatherApi
import com.github.alekseygett.weatherapp.data.api.WeatherRemoteSource
import com.github.alekseygett.weatherapp.utils.Preferences
import com.github.alekseygett.weatherapp.utils.PreferencesImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val weatherRetrofitName = "weatherRetrofit"
const val BASE_URL = "https://api.openweathermap.org/data/2.5/"

val appModule = module {
    single<OkHttpClient> {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor())
            .build()
    }

    single<Retrofit>(named(weatherRetrofitName)) {
        Retrofit.Builder()
            .client(get())
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<WeatherApi> {
        get<Retrofit>(named(weatherRetrofitName)).create(WeatherApi::class.java)
    }

    single<WeatherRemoteSource> {
        WeatherRemoteSource(get<WeatherApi>())
    }

    single<Preferences> {
        PreferencesImpl(androidContext())
    }
}