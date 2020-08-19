package com.example.weatherapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.rest.Fact
import com.example.weatherapp.rest.InstanceApi
import com.example.weatherapp.rest.WeatherModel
import com.example.weatherapp.utils.CallbackWeather
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherViewModel: ViewModel() {
    private var data: MutableLiveData<Fact> = MutableLiveData()

    fun getData(): MutableLiveData<Fact> {
        val thread = Thread(
            object : Runnable {
                override fun run() {
                    val response = App.getComponent().getRESTUtils().getData("60.039948", "30.252285", "ru_RU", "7", "true", "false").execute()
                    data.postValue(response.body()?.fact)
                }
            }
        )
        thread.start()
        thread.join()
        return data
    }

}