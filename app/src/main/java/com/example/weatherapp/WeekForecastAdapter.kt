package com.example.weatherapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.rest.weathermodel.Forecasts
import com.example.weatherapp.utils.DownloadImage
import kotlinx.android.synthetic.main.item_forecast.view.*
import java.text.SimpleDateFormat

class WeekForecastAdapter(val context: Context, val forecast: List<Forecasts>): RecyclerView.Adapter<WeekForecastHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeekForecastHolder {
        return WeekForecastHolder(LayoutInflater.from(context).inflate(R.layout.item_forecast, parent, false), context)
    }

    override fun getItemCount(): Int {
        return forecast.size
    }

    override fun onBindViewHolder(holder: WeekForecastHolder, position: Int) {
        holder.bind(forecast[position].date!!, forecast[position].parts?.day?.temp_max!!, forecast[position].parts?.day?.temp_min!!, forecast[position].parts?.day?.icon!!)
    }
}

class WeekForecastHolder(view: View, val context: Context): RecyclerView.ViewHolder(view) {
    fun bind(date: String, temp_max: Int, temp_min: Int, icon: String) {
        val s = SimpleDateFormat("yyyy-MM-dd").parse(date)
        val sd = SimpleDateFormat("d LLLL").format(s)
        itemView.week_forecast_day.text = sd.toString()
        itemView.week_forecast_max.text = getTemp(temp_max)
        itemView.week_forecast_min.text = getTemp(temp_min)
        DownloadImage.insertImage(itemView.week_forecast_icon, context, icon)
    }

    fun getTemp(temp: Int): String {
        var t: String
        if (temp >= 0) t = "+${temp}"
        else t = "-${temp}}"
        return t
    }
}