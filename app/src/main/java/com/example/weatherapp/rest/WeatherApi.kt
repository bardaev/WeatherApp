package com.example.weatherapp.rest

import com.example.weatherapp.rest.weathermodel.WeatherModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface WeatherApi {

    @Headers("X-Yandex-API-Key: 1eda7056-db89-4833-8bea-13c21b0c091d")
    @GET("/v2/forecast")
    fun getData(@Query("lat") lat: String,
                @Query("lon") lon: String,
                @Query("lang") lang: String,
                @Query("limit") limit: String,
                @Query("hours") hours: String,
                @Query("extra") extra: String): Call<WeatherModel>
}