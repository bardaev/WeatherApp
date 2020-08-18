package com.example.weatherapp

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.weatherapp.databinding.WeatherFragmentBinding
import com.example.weatherapp.rest.Fact
import com.example.weatherapp.rest.WeatherModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
            Log.i("APIW", it.temp.toString())
        })
        binding.swipeLayout.setOnRefreshListener {
            model.getData()
            binding.swipeLayout.isRefreshing = false
        }

//        App.getComponent().getRESTUtils().getData("59.938067", "30.328274", "ru_RU", "7", "true", "false")
//            .enqueue(
//                object : Callback<WeatherModel> {
//                    override fun onFailure(call: Call<WeatherModel>, t: Throwable) {}
//
//                    override fun onResponse(
//                        call: Call<WeatherModel>,
//                        response: Response<WeatherModel>
//                    ) {
//                        binding.fact = response.body()?.fact
//                    }
//                }
//            )
        return view
    }
}