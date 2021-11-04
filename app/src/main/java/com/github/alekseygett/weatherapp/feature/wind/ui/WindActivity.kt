package com.github.alekseygett.weatherapp.feature.wind.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.alekseygett.weatherapp.R
import com.github.alekseygett.weatherapp.databinding.ActivityWindBinding
import com.github.alekseygett.weatherapp.utils.Constants
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class WindActivity : AppCompatActivity() {

    private val viewModel: WindViewModel by viewModel { parametersOf(cityName) }

    private lateinit var binding: ActivityWindBinding

    private lateinit var cityName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWindBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cityName = intent.getStringExtra(Constants.cityNameKey) ?: "Moscow"

        viewModel.viewState.observe(this, ::render)
        viewModel.processUiEvent(UiEvent.OnWindRequest)
    }

    private fun render(viewState: ViewState) {
        viewState.wind?.let { wind ->
            val description = getString(
                R.string.wind_description,
                wind.speed, wind.direction.description
            )

            binding.windDescriptionText.text = description
        }

        viewState.errorMessage?.let { errorMessage ->
            showErrorMessage(errorMessage)
            viewModel.processUiEvent(UiEvent.OnErrorMessageShow)
        }
    }

    private fun showErrorMessage(errorMessage: String) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
    }

}
