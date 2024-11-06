package com.example.weatherapp1.data


class WeatherRepository(private val apiService: WeatherApiService) {
    suspend fun getWeather(cityName: String, apiKey: String): WeatherResponse {
        return apiService.getWeather(cityName, apiKey)
    }
}
