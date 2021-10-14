package com.github.alekseygett.weatherapp.feature.weather.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.github.alekseygett.weatherapp.R
import com.github.alekseygett.weatherapp.feature.weather.di.weatherModule
import com.github.alekseygett.weatherapp.feature.weather.domain.model.WeatherDomainModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class WeatherActivity: AppCompatActivity() {
    private val weatherViewModel: WeatherViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        loadKoinModules(weatherModule)
        setupView()
    }

    private fun setupView() {
        weatherViewModel.weather.observe(this, Observer(::render))
        weatherViewModel.requestWeather()
    }

    private fun render(state: WeatherDomainModel) {
        val temperatureText: TextView = findViewById(R.id.temperatureText)
        val minTemperatureText: TextView = findViewById(R.id.minTemperatureText)
        val maxTemperatureText: TextView = findViewById(R.id.maxTemperatureText)
        val humidityText: TextView = findViewById(R.id.humidityText)

        temperatureText.text = state.temperature.toString()
        minTemperatureText.text = state.minTemperature.toString()
        maxTemperatureText.text = state.maxTemperature.toString()
        humidityText.text = state.humidity.toString()
    }

    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(weatherModule)
    }
}
