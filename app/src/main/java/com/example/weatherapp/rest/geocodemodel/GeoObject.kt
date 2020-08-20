package com.example.weatherapp.rest.geocodemodel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GeoObject {

    @SerializedName("metaDataProperty")
    @Expose
    var metaDataProperty: GeocoderMetaData? = null
}