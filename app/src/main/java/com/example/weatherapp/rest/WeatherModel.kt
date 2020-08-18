package com.example.weatherapp.rest

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

//data class WeatherModel(@SerializedName("now") @Expose val now: Int)
class WeatherModel {
    @SerializedName("now")
    @Expose
    var now: String? = null

    @SerializedName("fact")
    @Expose
    var fact: Fact? = null

}