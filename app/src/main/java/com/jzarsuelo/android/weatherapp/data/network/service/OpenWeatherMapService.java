package com.jzarsuelo.android.weatherapp.data.network.service;

import com.jzarsuelo.android.weatherapp.data.network.model.WeatherSeveralCitiesIdResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Contains all the HTTP request for
 * <a href="http://openweathermap.org/api">Open Weather Map API</a>
 */

public interface OpenWeatherMapService {

    @GET("group?units=metric")
    Observable<WeatherSeveralCitiesIdResponse> getWeather(@Query("id") String ids, @Query("appid") String apiKey);
}
