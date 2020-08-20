package com.example.weatherapp.rest.geocodemodel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GeocodeModel {

    @SerializedName("response")
    @Expose
    var response: GeoObjectCollection? = null
        set(value) {
            field = value
        }
}