package com.github.alekseygett.weatherapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.alekseygett.weatherapp.feature.weather.ui.WeatherActivity

class MainActivity: AppCompatActivity() {
    private val presenter = MainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, WeatherActivity::class.java)
        startActivity(intent)
    }
}