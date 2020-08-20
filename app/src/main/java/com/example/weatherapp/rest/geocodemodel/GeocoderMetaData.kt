package com.example.weatherapp.rest.geocodemodel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GeocoderMetaData {

    @SerializedName("Address")
    @Expose
    var address: Address? = null
}