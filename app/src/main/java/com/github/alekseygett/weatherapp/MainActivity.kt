package com.github.alekseygett.weatherapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.github.alekseygett.weatherapp.feature.weather.ui.WeatherActivity
import com.github.alekseygett.weatherapp.feature.wind.ui.WindActivity

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
    }

    private fun setupView() {
        val windButton: Button = findViewById(R.id.windButton)
        val weatherButton: Button = findViewById(R.id.weatherButton)
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
    }

    private fun openWindScreen() {
        Intent(this, WindActivity::class.java).also { intent ->
            startActivity(intent)
        }
    }

    private fun openWeatherScreen() {
        Intent(this, WeatherActivity::class.java).also { intent ->
            startActivity(intent)
        }
    }

    private fun openSettingsScreen() {

    }
}