package com.example.weatherapp.rest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InstanceApi {
    companion object {
        fun getApi(): WeatherApi {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.weather.yandex.ru")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(WeatherApi::class.java)
        }

        fun getGeocodeApi(): GeocodeApi {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://geocode-maps.yandex.ru")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(GeocodeApi::class.java)
        }
    }
}