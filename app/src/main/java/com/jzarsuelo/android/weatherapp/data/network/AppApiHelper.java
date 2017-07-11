package com.jzarsuelo.android.weatherapp.data.network;

import com.jzarsuelo.android.weatherapp.BuildConfig;
import com.jzarsuelo.android.weatherapp.data.network.model.WeatherSeveralCitiesIdResponse;
import com.jzarsuelo.android.weatherapp.data.network.service.OpenWeatherMapService;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Retrofit;

/**
 * Created by Pao on 12/7/17.
 */

public class AppApiHelper implements ApiHelper {

    Retrofit mRetrofit;

    OpenWeatherMapService mService;

    @Inject
    public AppApiHelper(Retrofit retrofit) {

        mRetrofit = retrofit;
        mService = mRetrofit.create(OpenWeatherMapService.class);
    }

    @Override
    public Observable<WeatherSeveralCitiesIdResponse> getWeather(String ids) {
        return mService.getWeather(ids, BuildConfig.OPEN_WEATHER_MAP_KEY);
    }
}
