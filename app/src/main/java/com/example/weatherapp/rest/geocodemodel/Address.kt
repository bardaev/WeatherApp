package com.example.weatherapp.rest.geocodemodel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Address {

    @SerializedName("formatted")
    @Expose
    var formatted: String? = null
}