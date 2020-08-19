package com.example.weatherapp.rest

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.weatherapp.BR
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

//data class WeatherModel(@SerializedName("now") @Expose val now: Int)
class WeatherModel: BaseObservable() {

    @SerializedName("now")
    @Expose
    @get:Bindable
    var now: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.now)
        }

    @SerializedName("fact")
    @Expose
    var fact: Fact? = null

}