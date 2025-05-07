package com.example.demoandroidnetwork;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.demoandroidnetwork.R;
import com.example.demoandroidnetwork.Adapter.WeatherAdapter;
import com.example.demoandroidnetwork.Model.WeatherForecastModel;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView txtCityName,txtTemperature,txtCityTemperature;
    EditText editTextTextPersonName;
    ImageView imgSeasonForecast , imgSearch;
    ListView lvWeatherForecast;

    private WeatherAdapter weatherAdapter;

    ArrayList<WeatherForecastModel> weatherForecastModelList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        txtCityName = findViewById(R.id.txtCityName);
        txtTemperature = findViewById(R.id.txtTemperature);
        txtCityTemperature = findViewById(R.id.txtCityTemperature);
        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        imgSearch = findViewById(R.id.imgSearch);
        imgSeasonForecast = findViewById(R.id.imgSeasonForecast);
        lvWeatherForecast = findViewById(R.id.lvWeatherForecast);

        weatherForecastModelList= new ArrayList<>();
        weatherAdapter = new WeatherAdapter(this,weatherForecastModelList);

        lvWeatherForecast.setAdapter(weatherAdapter);
        GetData("Hanoi");
        imgSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetData(editTextTextPersonName.getText().toString());
                //weatherAdapter.notifyDataSetChanged();
            }
        });
    }
    private void GetData(String cityName) {
        String url ="https://api.weatherapi.com/v1/forecast.json?key=fc8f4188ad3f48d8a10132707221212&q="+cityName+"&days=1&aqi=no&alerts=no";
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        Log.d("BBB",url.toString());
        txtCityName.setText(cityName);
        weatherForecastModelList.clear();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,new Response.Listener<JSONObject>() {