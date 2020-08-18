package com.example.weatherapp.utils

import android.util.Log
import com.example.weatherapp.WeatherViewModel
import com.example.weatherapp.rest.WeatherModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CallbackWeather(val viewModel: WeatherViewModel): Callback<WeatherModel> {

    override fun onResponse(call: Call<WeatherModel>, response: Response<WeatherModel>) {
//        viewModel.getData().postValue(response.body()?.fact)
//        viewModel.setData(response.body()?.fact)
        Log.i("APIW", response.body()?.fact?.temp.toString())
    }

    override fun onFailure(call: Call<WeatherModel>, t: Throwable) {

    }
}