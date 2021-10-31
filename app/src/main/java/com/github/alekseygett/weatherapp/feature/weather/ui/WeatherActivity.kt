package com.github.alekseygett.weatherapp.feature.weather.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.github.alekseygett.weatherapp.R
import com.github.alekseygett.weatherapp.feature.weather.domain.model.WeatherDomainModel
import com.github.alekseygett.weatherapp.utils.Constants
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class WeatherActivity: AppCompatActivity() {
    private val weatherViewModel: WeatherViewModel by viewModel { parametersOf(cityName) }
    private lateinit var cityName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        cityName = intent.getStringExtra(Constants.cityNameKey) ?: "Moscow"

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
}
