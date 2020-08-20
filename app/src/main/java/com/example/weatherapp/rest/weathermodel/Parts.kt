package com.example.weatherapp.rest.weathermodel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.weatherapp.BR
import com.example.weatherapp.rest.weathermodel.MaxMinWeather
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Parts: BaseObservable() {

    @SerializedName("day")
    @Expose
    @get:Bindable
    var day: MaxMinWeather? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.day)
        }

    @SerializedName("night")
    @Expose
    @get:Bindable
    var night: MaxMinWeather? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.night)
        }
}