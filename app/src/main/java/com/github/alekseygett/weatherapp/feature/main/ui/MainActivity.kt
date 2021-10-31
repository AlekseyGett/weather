package com.github.alekseygett.weatherapp.feature.main.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.github.alekseygett.weatherapp.R
import com.github.alekseygett.weatherapp.feature.settings.ui.SettingsActivity
import com.github.alekseygett.weatherapp.feature.weather.ui.WeatherActivity
import com.github.alekseygett.weatherapp.feature.wind.ui.WindActivity
import com.github.alekseygett.weatherapp.utils.Constants
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity: AppCompatActivity() {
    private val viewModel: MainViewModel by viewModel()
    private var cityName = ""

    private lateinit var cityNameText: TextView
    private lateinit var weatherButton: Button
    private lateinit var windButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
    }

    override fun onResume() {
        super.onResume()
        viewModel.updateCityName()
    }

    private fun setupView() {
        cityNameText = findViewById(R.id.cityText)
        windButton = findViewById(R.id.windButton)
        weatherButton = findViewById(R.id.weatherButton)
        val settingsButton: Button = findViewById(R.id.settingsButton)

        windButton.setOnClickListener {
            openWindScreen()
        }

        weatherButton.setOnClickListener {
            openWeatherScreen()
        }

        settingsButton.setOnClickListener {
            openSettingsScreen()
        }

        viewModel.cityName.observe(this, Observer(::updateCityName))
        viewModel.weatherDataAvailable.observe(this, Observer(::setButtonsEnabled))
    }

    private fun updateCityName(cityName: String) {
        this.cityName = cityName
        cityNameText.text = cityName
    }

    private fun setButtonsEnabled(enabled: Boolean) {
        weatherButton.isEnabled = enabled
        windButton.isEnabled = enabled
    }

    private fun openWindScreen() {
        Intent(this, WindActivity::class.java)
            .apply { putExtra(Constants.cityNameKey, cityName) }
            .also { intent -> startActivity(intent) }
    }

    private fun openWeatherScreen() {
        Intent(this, WeatherActivity::class.java)
            .apply { putExtra(Constants.cityNameKey, cityName) }
            .also { intent -> startActivity(intent) }
    }

    private fun openSettingsScreen() {
        Intent(this, SettingsActivity::class.java).also { intent ->
            startActivity(intent)
        }
    }
}