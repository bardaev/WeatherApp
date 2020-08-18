package com.example.weatherapp.rest

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.weatherapp.BR
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Fact: BaseObservable() {

    @SerializedName("temp")
    @Expose
    @get:Bindable
    var temp: Int? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.temp)
        }

    @SerializedName("feels_like")
    @Expose
    @get:Bindable
    var feels_like: Int? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.feels_like)
        }

    @Bindable
    @SerializedName("icon")
    @Expose
    var icon: String? = null

    @Bindable
    @SerializedName("condition")
    @Expose
    var condition: String? = null

    @Bindable
    @SerializedName("wind_speed")
    @Expose
    var wind_speed: Int? = null

    @Bindable
    @SerializedName("pressure_mm")
    @Expose
    var pressure_mm: Int? = null

    @Bindable
    @SerializedName("humidity")
    @Expose
    var humidity: Int? = null

    @Bindable
    @SerializedName("daytime")
    @Expose
    var daytime: String? = null

    @Bindable
    @SerializedName("season")
    @Expose
    var season: String? = null

    @Bindable
    @SerializedName("prec_type")
    @Expose
    var prec_type: Int? = null

    @Bindable
    @SerializedName("cloudness")
    @Expose
    var cloudness: Int? = null

    @Bindable
    @SerializedName("phenom_icon")
    @Expose
    var phenom_icon: String? = null

    @Bindable
    @SerializedName("phenom_condition")
    @Expose
    var phenom_condition: String? = null
}