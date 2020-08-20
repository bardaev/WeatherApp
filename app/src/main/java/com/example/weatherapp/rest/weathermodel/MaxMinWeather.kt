package com.example.weatherapp.rest.weathermodel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.weatherapp.BR
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MaxMinWeather: BaseObservable() {

    @SerializedName("temp_min")
    @Expose
    @get:Bindable
    var temp_min: Int? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.temp_min)
        }

    @SerializedName("temp_max")
    @Expose
    @get:Bindable
    var temp_max: Int? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.temp_max)
        }

    @SerializedName("icon")
    @Expose
    @get:Bindable
    var icon: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.icon)
        }
}