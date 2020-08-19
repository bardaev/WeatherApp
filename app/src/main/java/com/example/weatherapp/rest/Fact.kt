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

    @SerializedName("icon")
    @Expose
    @get:Bindable
    var icon: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.icon)
        }

    @SerializedName("condition")
    @Expose
    @get:Bindable
    var condition: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.condition)
        }

    @SerializedName("wind_speed")
    @Expose
    @get:Bindable
    var wind_speed: Double? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.wind_speed)
        }

    @SerializedName("pressure_mm")
    @Expose
    @get:Bindable
    var pressure_mm: Int? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.pressure_mm)
        }

    @SerializedName("humidity")
    @Expose
    @get:Bindable
    var humidity: Int? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.humidity)
        }

    @SerializedName("daytime")
    @Expose
    @get:Bindable
    var daytime: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.daytime)
        }

    @SerializedName("season")
    @Expose
    @get:Bindable
    var season: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.season)
        }

    @SerializedName("prec_type")
    @Expose
    @get:Bindable
    var prec_type: Int? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.prec_type)
        }

    @SerializedName("cloudness")
    @Expose
    @get:Bindable
    var cloudness: Int? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.cloudness)
        }

    @SerializedName("phenom_icon")
    @Expose
    @get:Bindable
    var phenom_icon: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.phenom_icon)
        }

    @SerializedName("phenom_condition")
    @Expose
    @get:Bindable
    var phenom_condition: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.phenom_condition)
        }
}