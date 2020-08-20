package com.example.weatherapp.rest.geocodemodel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GeoObjectCollection {

    @SerializedName("metaDataProperty")
    @Expose
    var metaDataProperty: Any? = null
        set(value) {
            field = value
        }

    @SerializedName("featureMember")
    @Expose
    var featureMember: List<GeoObject>? = null
        set(value) {
            field = value
        }
}