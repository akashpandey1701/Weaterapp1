package com.example.weatherapp1.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp1.data.WeatherRepository
import com.example.weatherapp1.data.WeatherResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WeatherViewModel(private val repository: WeatherRepository) : ViewModel() {
    var weatherData: WeatherResponse? = null
    var errorMessage: String? = null
    var isLoading = false

    fun fetchWeather(cityName: String, apiKey: String) {
        isLoading = true
        viewModelScope.launch {
            try {
                weatherData = withContext(Dispatchers.IO) {
                    repository.getWeather(cityName, apiKey)
                }
                errorMessage = null
            } catch (e: Exception) {
                errorMessage = "Error fetching weather data"
                weatherData = null
            } finally {
                isLoading = false
            }
        }
    }
}
