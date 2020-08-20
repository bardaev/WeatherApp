package com.example.weatherapp.rest.weathermodel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.weatherapp.BR
import com.example.weatherapp.rest.weathermodel.Fact
import com.example.weatherapp.rest.weathermodel.Forecasts
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
    @get:Bindable
    var fact: Fact? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.fact)
        }

    @SerializedName("forecasts")
    @Expose
    @get:Bindable
    var forecasts: List<Forecasts>? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.forecasts)
        }
}