package com.example.weatherapp.rest.weathermodel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.weatherapp.BR
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Forecasts: BaseObservable() {

    @SerializedName("date")
    @Expose
    @get:Bindable
    var date: String? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.date)
        }

    @SerializedName("date_ts")
    @Expose
    @get:Bindable
    var date_ts: Int? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.date_ts)
        }

    @SerializedName("parts")
    @Expose
    @get:Bindable
    var parts: Parts? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.parts)
        }

    @SerializedName("hours")
    @Expose
    @get:Bindable
    var hours: List<Fact>? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.hours)
        }
}