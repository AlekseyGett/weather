package com.github.alekseygett.weatherapp.feature.main.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.github.alekseygett.weatherapp.databinding.ActivityMainBinding
import com.github.alekseygett.weatherapp.feature.settings.ui.SettingsActivity
import com.github.alekseygett.weatherapp.feature.weather.ui.WeatherActivity
import com.github.alekseygett.weatherapp.feature.wind.ui.WindActivity
import com.github.alekseygett.weatherapp.utils.Constants
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity: AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
    }

    override fun onResume() {
        super.onResume()
        viewModel.processUiEvent(UiEvent.OnCachedCityNameRequest)
    }

    private fun setupView() {
        binding.windButton.setOnClickListener {
            openWindScreen()
        }

        binding.weatherButton.setOnClickListener {
            openWeatherScreen()
        }

        binding.settingsButton.setOnClickListener {
            openSettingsScreen()
        }

        viewModel.viewState.observe(this, Observer(::render))
    }

    private fun render(viewState: ViewState) {
        binding.cityText.text = viewState.cityName

        viewState.cityName.isNotBlank().let { enabled ->
            binding.weatherButton.isEnabled = enabled
            binding.windButton.isEnabled = enabled
        }
    }

    private fun openWindScreen() {
        val cityName = binding.cityText.text.toString()

        Intent(this, WindActivity::class.java)
            .apply { putExtra(Constants.cityNameKey, cityName) }
            .also { intent -> startActivity(intent) }
    }

    private fun openWeatherScreen() {
        val cityName = binding.cityText.text.toString()

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