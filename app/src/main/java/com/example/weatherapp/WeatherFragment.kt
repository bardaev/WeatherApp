package com.example.weatherapp

import android.app.Activity
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.weatherapp.databinding.WeatherFragmentBinding
import com.example.weatherapp.rest.Fact

class WeatherFragment: Fragment() {

    lateinit var binding: WeatherFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.weather_fragment, container, false)
        binding = DataBindingUtil.setContentView(activity as Activity, R.layout.weather_fragment)
        val model  = ViewModelProviders.of(this).get(WeatherViewModel::class.java)
        val data = model.getData()
        data.observe(viewLifecycleOwner, Observer<Fact> {
            binding.fact = it
            Glide.with(this)
                .load(Uri.parse("https://yastatic.net/weather/i/icons/blueye/color/svg/${it.icon}.svg"))
                .placeholder(R.drawable.ic_baseline_cloud_24)
                .into(binding.factIcon)

        })
        binding.swipeLayout.setOnRefreshListener {
            model.getData()
            binding.swipeLayout.isRefreshing = false
        }

        return view
    }

}