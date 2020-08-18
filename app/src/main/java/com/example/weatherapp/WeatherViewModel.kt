package com.example.weatherapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.rest.Fact
import com.example.weatherapp.rest.WeatherModel
import com.example.weatherapp.utils.CallbackWeather
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherViewModel: ViewModel() {
    private var data: MutableLiveData<Fact> = MutableLiveData()
    init {
        data = MutableLiveData()
    }

    fun getData(): MutableLiveData<Fact> {
        loadData()
        return data
    }

    private fun loadData() {
//        val cb: CallbackWeather = CallbackWeather()
        App.getComponent()
            .getRESTUtils()
            .getData("60.039948", "30.252285", "ru_RU", "7", "true", "false")
            .enqueue(
                object : Callback<WeatherModel> {
                    override fun onFailure(call: Call<WeatherModel>, t: Throwable) {

                    }

                    override fun onResponse(
                        call: Call<WeatherModel>,
                        response: Response<WeatherModel>
                    ) {
                        val a = response
//                        data.value = response.body()?.fact
                        var b = data
                        setData(response.body()?.fact!!)
                        Log.i("APIW", "VM ${data.value?.temp}")
                        Log.i("APIW", "VM ${response.body()?.fact}")
                    }
                }
            )

    }

    fun setData(fact: Fact) {
        data.value = fact
    }
}