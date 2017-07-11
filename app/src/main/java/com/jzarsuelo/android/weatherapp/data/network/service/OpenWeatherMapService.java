package com.jzarsuelo.android.weatherapp.data.network.service;

import com.jzarsuelo.android.weatherapp.data.network.model.WeatherSeveralCitiesIdResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Pao on 12/7/17.
 */

public interface OpenWeatherMapService {

    @GET("/group?units=metric")
    Observable<WeatherSeveralCitiesIdResponse> getWeather(@Query("id") String ids, @Query("appid") String apiKey);
}
