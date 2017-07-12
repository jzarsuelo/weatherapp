package com.jzarsuelo.android.weatherapp.ui.detail;

import com.jzarsuelo.android.weatherapp.data.network.model.WeatherSeveralCitiesIdResponseItem;
import com.jzarsuelo.android.weatherapp.ui.base.MvpView;

/**
 * Created by Pao on 12/7/17.
 */

public interface DetailMvpView extends MvpView {

    void updateView(WeatherSeveralCitiesIdResponseItem responseItem);

}
