package com.github.alekseygett.weatherapp.feature.settings.ui

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.github.alekseygett.weatherapp.R
import com.github.alekseygett.weatherapp.databinding.ActivitySettingsBinding
import com.github.alekseygett.weatherapp.utils.setDebouncingTextListener
import org.koin.androidx.viewmodel.ext.android.viewModel

class SettingsActivity: AppCompatActivity() {

    private val viewModel: SettingsViewModel by viewModel()

    private lateinit var binding: ActivitySettingsBinding

    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
    }

    override fun onResume() {
        super.onResume()
        viewModel.processUiEvent(UiEvent.OnCachedCityNameRequest)
    }

    private fun setupView() {
        adapter = ArrayAdapter<String>(
            this,
            R.layout.support_simple_spinner_dropdown_item,
            mutableListOf()
        )

        binding.cityDropdown.setAdapter(adapter)

        binding.cityDropdown.setDebouncingTextListener { prefix ->
            viewModel.processUiEvent(UiEvent.OnRequestSuggestions(prefix))
        }

        binding.saveButton.setOnClickListener {
            val cityName = binding.cityDropdown.text.toString()
            viewModel.processUiEvent(UiEvent.OnSaveButtonClick(cityName))
        }

        viewModel.viewState.observe(this, Observer(::render))
    }

    private fun render(viewState: ViewState) {
        if (viewState.isCityNameRequested) {
            binding.cityDropdown.setText(viewState.cityName)
            viewModel.processUiEvent(UiEvent.OnCachedCityNameShow)
        }

        replaceCityNameSuggestions(viewState.cityNameSuggestions)

        viewState.errorMessage?.let { errorMessage ->
            showErrorMessage(errorMessage)
            viewModel.processUiEvent(UiEvent.OnErrorMessageShow)
        }

        if (viewState.isSettingsSaved) {
            finish()
        }
    }

    private fun replaceCityNameSuggestions(suggestions: List<String>) {
        adapter.clear()
        adapter.addAll(suggestions)
    }

    private fun showErrorMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

}