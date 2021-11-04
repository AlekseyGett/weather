package com.github.alekseygett.weatherapp.feature.weather.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.alekseygett.weatherapp.databinding.ActivityWeatherBinding
import com.github.alekseygett.weatherapp.utils.Constants
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class WeatherActivity: AppCompatActivity() {

    private val viewModel: WeatherViewModel by viewModel { parametersOf(cityName) }

    private lateinit var binding: ActivityWeatherBinding

    private lateinit var cityName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cityName = intent.getStringExtra(Constants.cityNameKey) ?: "Moscow"

        viewModel.viewState.observe(this, ::render)
        viewModel.processUiEvent(UiEvent.OnWeatherRequest)
    }

    private fun render(viewState: ViewState) {
        binding.temperatureText.text = viewState.temperature.toString()
        binding.minTemperatureText.text = viewState.minTemperature.toString()
        binding.maxTemperatureText.text = viewState.maxTemperature.toString()
        binding.humidityText.text = viewState.humidity.toString()

        viewState.errorMessage?.let { errorMessage ->
            showErrorMessage(errorMessage)
            viewModel.processUiEvent(UiEvent.OnErrorMessageShow)
        }
    }

    private fun showErrorMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

}