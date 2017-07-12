package com.jzarsuelo.android.weatherapp.ui.base;

/**
 * Created by Pao on 12/7/17.
 */

public interface MvpView {

    void onError(String message);

    void showMessage(String message);

    void setUp();

    void showLoading();

    void hideLoading();
}
