package com.github.alekseygett.weatherapp.feature.wind.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import com.github.alekseygett.weatherapp.R
import com.github.alekseygett.weatherapp.feature.wind.di.windModule
import com.github.alekseygett.weatherapp.feature.wind.domain.model.WindDomainModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class WindActivity : AppCompatActivity() {
    private val windViewModel: WindViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wind)

        loadKoinModules(windModule)
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

    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(windModule)
    }
}
