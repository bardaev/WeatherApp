package com.example.weatherapp.rest

import com.example.weatherapp.rest.geocodemodel.GeocodeModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GeocodeApi {

    @GET("/1.x")
    fun getCity(@Query("geocode") geocode: String,
                @Query("apikey") apikey: String,
                @Query("format") format: String,
                @Query("lang") lang: String): Call<GeocodeModel>
}