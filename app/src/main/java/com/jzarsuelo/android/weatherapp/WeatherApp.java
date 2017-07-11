package com.jzarsuelo.android.weatherapp;

import android.app.Application;
import android.content.Context;

import com.jzarsuelo.android.weatherapp.di.component.ApplicationComponent;
import com.jzarsuelo.android.weatherapp.di.component.DaggerApplicationComponent;
import com.jzarsuelo.android.weatherapp.di.module.ApplicationModule;

import javax.inject.Inject;

/**
 * Created by Pao on 12/7/17.
 */

public class WeatherApp extends Application {

    @Inject
    Context mContext;

    protected ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        mApplicationComponent.inject(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
