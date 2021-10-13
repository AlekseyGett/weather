package com.github.alekseygett.weatherapp.feature.weather.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.github.alekseygett.weatherapp.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherActivity : AppCompatActivity() {
    private val weatherViewModel: WeatherViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        setupView()
    }

    private fun setupView() {
        val temperatureText: TextView = findViewById(R.id.temperatureText)

        weatherViewModel.weather.observe(this, { value ->
            temperatureText.text = value
        })

        weatherViewModel.requestWeather()
    }
}