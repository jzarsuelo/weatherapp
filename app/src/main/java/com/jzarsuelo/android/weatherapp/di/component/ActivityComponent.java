package com.jzarsuelo.android.weatherapp.di.component;

import com.jzarsuelo.android.weatherapp.di.PerActivity;
import com.jzarsuelo.android.weatherapp.di.module.ActivityModule;
import com.jzarsuelo.android.weatherapp.ui.main.MainActivity;
import com.jzarsuelo.android.weatherapp.ui.splash.SplashActivity;

import dagger.Component;

/**
 * Created by Pao on 11/7/17.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(SplashActivity splashActivity);

    void inject(MainActivity  mainActivity);
}
