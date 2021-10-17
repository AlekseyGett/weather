package com.github.alekseygett.weatherapp.feature.wind.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.github.alekseygett.weatherapp.R
import com.github.alekseygett.weatherapp.feature.wind.domain.model.WindDomainModel
import com.github.alekseygett.weatherapp.utils.Constants
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class WindActivity : AppCompatActivity() {
    private val windViewModel: WindViewModel by viewModel { parametersOf(cityName) }
    private lateinit var cityName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wind)

        cityName = intent.getStringExtra(Constants.cityNameKey) ?: "Moscow"

        setupView()
    }

    private fun setupView() {
        windViewModel.wind.observe(this, Observer(::render))
        windViewModel.requestWind()
    }

    private fun render(state: WindDomainModel) {
        val windDescriptionText: TextView = findViewById(R.id.windDescriptionText)

        val description = getString(R.string.wind_description, state.speed, state.direction.description)
        windDescriptionText.text = description
    }
}
