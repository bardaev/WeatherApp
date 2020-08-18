package com.example.weatherapp.rest

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface WeatherApi {

    @Headers("X-Yandex-API-Key: paste your token")
    @GET("/v2/forecast")
    fun getData(@Query("lat") lat: String,
                @Query("lon") lon: String,
                @Query("lang") lang: String,
                @Query("limit") limit: String,
                @Query("hours") hours: String,
                @Query("extra") extra: String): Call<WeatherModel>
}