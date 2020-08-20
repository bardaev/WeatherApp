package com.example.weatherapp.utils

import android.content.Context
import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.weatherapp.R
import com.example.weatherapp.WeatherFragment

class DownloadImage {
    companion object {
        fun insertImage(view: ImageView, context: Context, icon: String) {
            Glide.with(context)
                .load(Uri.parse("https://yastatic.net/weather/i/icons/blueye/color/svg/${icon}.svg"))
                .placeholder(R.drawable.ic_baseline_cloud_24)
                .into(view)
        }
    }
}