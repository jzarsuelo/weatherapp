package com.jzarsuelo.android.weatherapp.data.network;

import com.jzarsuelo.android.weatherapp.data.network.model.WeatherSeveralCitiesIdResponse;

import io.reactivex.Observable;

/**
 * Created by Pao on 12/7/17.
 */

public interface ApiHelper {

    Observable<WeatherSeveralCitiesIdResponse> getWeather(String ids);
}
