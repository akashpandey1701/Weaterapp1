package com.example.weatherapp1.data



data class WeatherResponse(
    val main: Main
) {
    data class Main(
        val temp: Double
    )
}

