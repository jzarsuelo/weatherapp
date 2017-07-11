package com.jzarsuelo.android.weatherapp.ui.main;

import com.jzarsuelo.android.weatherapp.data.network.model.WeatherSeveralCitiesIdResponseItem;
import com.jzarsuelo.android.weatherapp.ui.base.MvpView;

import java.util.List;

/**
 * Created by Pao on 12/7/17.
 */

public interface MainMvpView extends MvpView {

    void updateWeatherData(List<WeatherSeveralCitiesIdResponseItem> data);

}
