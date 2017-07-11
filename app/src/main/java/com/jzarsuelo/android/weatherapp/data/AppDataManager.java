package com.jzarsuelo.android.weatherapp.data;

import com.jzarsuelo.android.weatherapp.data.network.ApiHelper;
import com.jzarsuelo.android.weatherapp.data.network.model.WeatherSeveralCitiesIdResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Created by Pao on 12/7/17.
 */
@Singleton
public class AppDataManager implements DataManager {

    ApiHelper mApiHelper;

    @Inject
    public AppDataManager(ApiHelper apiHelper) {

        mApiHelper = apiHelper;
    }

    @Override
    public Observable<WeatherSeveralCitiesIdResponse> getWeather(String ids) {
        return mApiHelper.getWeather(ids);
    }
}
