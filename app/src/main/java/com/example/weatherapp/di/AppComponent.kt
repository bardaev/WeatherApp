package com.example.weatherapp.di

import com.example.weatherapp.rest.WeatherApi
import dagger.Component

@Component(modules = [RESTModule::class])
interface AppComponent {
    fun getRESTUtils(): WeatherApi
}