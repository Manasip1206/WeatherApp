package com.example.session18weatherapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("weather")
    fun getCurrentWeather(
        @Query("q") place: String,
        @Query("appid") apiKey: String,
    ): Call<WeatherResponse>

}