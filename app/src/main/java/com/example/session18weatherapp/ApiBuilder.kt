package com.example.session18weatherapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Making retrofit object for api calling
object ApiBuilder {
     val retrofitBuilder = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        //GsonConverterFactory.create() to specify that Gson should be used for JSON conversion.
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        //Creates an implementation of the Weather Api interface using the configured Retrofit instance.
        .create(WeatherApi::class.java)
}