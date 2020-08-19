package com.example.weatherapp.rest

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.weatherapp.BR
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Hours: BaseObservable() {

    @SerializedName("fact")
    @Expose
    @get:Bindable
    var fact: Fact? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.fact)
        }
}