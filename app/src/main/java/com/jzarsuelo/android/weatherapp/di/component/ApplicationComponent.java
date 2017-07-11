package com.jzarsuelo.android.weatherapp.di.component;

import com.jzarsuelo.android.weatherapp.WeatherApp;
import com.jzarsuelo.android.weatherapp.data.DataManager;
import com.jzarsuelo.android.weatherapp.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Pao on 11/7/17.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(WeatherApp app);

    DataManager getDataManager();
}
