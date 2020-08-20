package com.example.weatherapp.di

import com.example.weatherapp.rest.GeocodeApi
import com.example.weatherapp.rest.InstanceApi
import com.example.weatherapp.rest.WeatherApi
import dagger.Module
import dagger.Provides

@Module
class RESTModule {

    @Provides
    fun provideRESTUtils(): WeatherApi {
        return InstanceApi.getApi()
    }

    @Provides
    fun provideGeocode(): GeocodeApi {
        return InstanceApi.getGeocodeApi()
    }
}