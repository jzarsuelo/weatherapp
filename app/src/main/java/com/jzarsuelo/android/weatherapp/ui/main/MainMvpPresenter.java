package com.jzarsuelo.android.weatherapp.ui.main;

import com.jzarsuelo.android.weatherapp.ui.base.MvpPresenter;

/**
 * Created by Pao on 12/7/17.
 */

public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {

    void updateData();

}
