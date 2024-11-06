package com.example.weatherapp1.ui1


import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherapp1.viewmodel.WeatherViewModel

@Composable
fun WeatherScreen(viewModel: WeatherViewModel) {
    var cityName = "New Delhi"
    val apiKey = "d89a49975b1ff3e8536341009247837a"

    LaunchedEffect(Unit) {
        viewModel.fetchWeather(cityName, apiKey)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (viewModel.isLoading) {
            CircularProgressIndicator()
        } else {
            viewModel.weatherData?.let { weather ->
                Text("City: $cityName")
                Text("Temperature: ${weather.main.temp} °C")
            } ?: run {
                Text(viewModel.errorMessage ?: "No data available")
            }
        }
    }
}
