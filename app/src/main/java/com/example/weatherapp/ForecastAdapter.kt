package com.example.weatherapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.rest.weathermodel.Fact
import com.example.weatherapp.utils.DownloadImage
import kotlinx.android.synthetic.main.item_hour_weather.view.*
import java.text.SimpleDateFormat

class ForecastAdapter(val context: Context, val forecast: List<Fact>): RecyclerView.Adapter<ForecastHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastHolder {
        return ForecastHolder(LayoutInflater.from(context).inflate(R.layout.item_hour_weather, parent, false), context)
    }

    override fun getItemCount(): Int {
        return forecast.size
    }

    override fun onBindViewHolder(holder: ForecastHolder, position: Int) {
        holder.bind(forecast[position].hour_ts!!, forecast[position].icon!!, forecast[position].temp!!)
    }
}

class ForecastHolder(view: View, val context: Context): RecyclerView.ViewHolder(view) {
    fun bind(time: Int, icon: String, temp: Int) {
        val sd = SimpleDateFormat("k:m")
        itemView.forecast_time.text = sd.format(time)

        var t: String
        if (temp >= 0) t = "+${temp}"
        else t = "-${temp}}"
        itemView.forecast_temp.text = t
        DownloadImage.insertImage(itemView.forecast_icon, context, icon)
    }
}