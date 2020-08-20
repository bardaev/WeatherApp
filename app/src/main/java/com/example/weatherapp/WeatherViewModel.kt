package com.example.weatherapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.rest.weathermodel.WeatherModel

class WeatherViewModel: ViewModel() {
    private var data: MutableLiveData<WeatherModel> = MutableLiveData()

    fun getData(coord: Array<String>): MutableLiveData<WeatherModel> {
        val thread = Thread(
            Runnable {
                val city = App.getComponent().getGeocode().getCity("${coord[1]},${coord[0]}", "fe04255f-9431-4f2c-8c8b-2da08d5c6ecb", "json", "ru_RU").execute()
                val response = App.getComponent().getRESTUtils().getData(coord[0], coord[1], "ru_RU", "7", "true", "false").execute()
                val weatherModel = response.body()
                weatherModel?.fact?.city = city.body()?.response?.featureMember?.get(0)?.metaDataProperty?.address?.formatted
                data.postValue(weatherModel)
            }
        )
        thread.start()
        thread.join()
        return data
    }

}