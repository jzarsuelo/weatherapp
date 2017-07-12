package com.jzarsuelo.android.weatherapp.ui.detail;

import com.jzarsuelo.android.weatherapp.ui.base.MvpPresenter;

/**
 * Created by Pao on 12/7/17.
 */

public interface DetailMvpPresenter<V extends DetailMvpView> extends MvpPresenter<V> {

    void updateData(String id);

}
