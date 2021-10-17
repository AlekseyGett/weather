package com.github.alekseygett.weatherapp.feature.settings.ui

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.github.alekseygett.weatherapp.R
import com.github.alekseygett.weatherapp.utils.setDebouncingTextListener
import org.koin.androidx.viewmodel.ext.android.viewModel

class SettingsActivity: AppCompatActivity() {
    private val viewModel: SettingsViewModel by viewModel()

    private lateinit var cityTextField: AutoCompleteTextView
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        setupView()
    }

    private fun setupView() {
        cityTextField = findViewById(R.id.cityDropdown)
        val saveButton: Button = findViewById(R.id.saveButton)

        adapter = ArrayAdapter<String>(
            this,
            R.layout.support_simple_spinner_dropdown_item,
            listOf()
        )

        cityTextField.setAdapter(adapter)

        cityTextField.setDebouncingTextListener { prefix ->
            viewModel.requestCitySuggestions(prefix)
        }

        saveButton.setOnClickListener {
            val cityName = cityTextField.text.toString()
            viewModel.saveCityName(cityName)
        }

        viewModel.cityName.observe(this, Observer(::setCityName))
        viewModel.citySuggestions.observe(this, Observer(::replaceSuggestions))
        viewModel.onSaveComplete.observe(this, Observer(::onSaveComplete))
    }

    private fun setCityName(cityName: String) {
        cityTextField.setText(cityName)
    }

    private fun replaceSuggestions(suggestions: List<String>) {
        adapter.clear()
        adapter.addAll(suggestions)
    }

    private fun onSaveComplete(complete: Boolean) {
        if (complete) {
            finish()
        }
    }
}