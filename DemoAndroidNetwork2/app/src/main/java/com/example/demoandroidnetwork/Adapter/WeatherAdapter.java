package com.example.demoandroidnetwork.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demoandroidnetwork.Model.WeatherForecastModel;
import com.example.demoandroidnetwork.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class WeatherAdapter extends BaseAdapter {
    private Context context;
    private List<WeatherForecastModel>weatherForecastModelList;

    public WeatherAdapter(Context context, List<WeatherForecastModel> weatherForecastModelList) {
        this.context = context;
        this.weatherForecastModelList = weatherForecastModelList;
    }

    @Override
    public int getCount() {
        return weatherForecastModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.layout_weather_items, null);
        }
        TextView txtTimeForecast = view.findViewById(R.id.txtTimeForecast);
        TextView txtTemperatureForecast = view.findViewById(R.id.txtTemperatureForecast);
        TextView txtWindForecast = view.findViewById(R.id.txtWindForecast);
        ImageView imgForecast = view.findViewById(R.id.imgForecast);


        WeatherForecastModel weatherForecastModel = weatherForecastModelList.get(i);
        txtTimeForecast.setText( "" + weatherForecastModel.getTime());
        txtTemperatureForecast.setText(weatherForecastModel.getTemperature()+"°C");
        txtWindForecast.setText(weatherForecastModel.getWindSpeed()+" km");

        Picasso.get().load("https:"+weatherForecastModel.getIcon()).into(imgForecast);
        return view;
    }
}
