package com.jzarsuelo.android.weatherapp.ui.splash;

import com.jzarsuelo.android.weatherapp.ui.base.MvpPresenter;

/**
 * Created by Pao on 12/7/17.
 */

public interface SplashMvpPresenter<V extends SplashMvpView> extends MvpPresenter<V> {

    void showSplashScreen();

}
