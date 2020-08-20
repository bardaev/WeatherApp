package com.example.weatherapp

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.databinding.WeatherFragmentBinding
import com.example.weatherapp.rest.weathermodel.WeatherModel
import com.example.weatherapp.utils.DownloadImage

class WeatherFragment: Fragment() {

    lateinit var binding: WeatherFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ActivityCompat.requestPermissions(activity!!, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1)

        val view = inflater.inflate(R.layout.weather_fragment, container, false)
        binding = DataBindingUtil.setContentView(activity as Activity, R.layout.weather_fragment)
        val model  = ViewModelProviders.of(this).get(WeatherViewModel::class.java)
        val data = model.getData(getCoordinate()!!)
        binding.recycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerForecast.layoutManager = LinearLayoutManager(context)
        data.observe(viewLifecycleOwner, Observer<WeatherModel> {
            binding.fact = it.fact
            DownloadImage.insertImage(binding.factIcon, this.context!!, it.fact?.icon!!)
            binding.recycler.adapter = ForecastAdapter(this.context!!, it.forecasts?.get(0)?.hours!!)
            binding.recyclerForecast.adapter = WeekForecastAdapter(this.context!!, it.forecasts!!)

        })
        binding.swipeLayout.setOnRefreshListener {
            model.getData(getCoordinate()!!)
            binding.swipeLayout.isRefreshing = false
        }

        return view
    }

    fun getCoordinate(): Array<String>? {
        val locationManager = context?.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if (ActivityCompat.checkSelfPermission(
                context!!,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                context!!,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) { } else {
            val l = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER) as Location
            val coord = arrayOf(l.latitude.toString().replace(",", "."), l.longitude.toString().replace(",", "."))
            return coord
        }
        return null
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            1 -> {
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {}
                return
            }
        }
    }
}