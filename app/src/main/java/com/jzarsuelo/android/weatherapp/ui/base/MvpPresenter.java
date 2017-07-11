package com.jzarsuelo.android.weatherapp.ui.base;

/**
 * Created by Pao on 12/7/17.
 */

public interface MvpPresenter<V extends MvpView> {

    void onAttach(V mvpView);

    void onDetach();
}
