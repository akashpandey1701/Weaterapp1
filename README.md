# Weaterapp1

For this app this steps are followed:-

Step 1:When the mainactivity is launched  MainActivity creates an instance of WeatherViewModel using WeatherViewModelFactory.
The WeatherViewModel is responsible for handling the weather data logic.

Step 2:WeatherRepository is initialized with the WeatherApiService, which is created using Retrofit. It provides the method to make network requests to the OpenWeather API.

Step 3:In the MainActivity, a WeatherScreen composable is set as the content view. The WeatherScreen composable receives the WeatherViewModel as a parameter.

Step 4:The WeatherScreen composable displays the UI and listens for updates from the WeatherViewModel.

Step5:The fetchWeather method calls the WeatherRepository's getWeather method using Kotlin coroutines. It passes the city name and API key to make the request.

Step 6:he WeatherRepository uses WeatherApiService to make a GET request to the OpenWeather API. It returns a WeatherResponse object containing the weather data.

Step 7:The WeatherRepository is responsible for handling the logic of making a network request.It uses the WeatherApiService interface to make a network call to the OpenWeather API.The repository uses Retrofit’s suspend function to handle the asynchronous API request and return a WeatherResponse object.



