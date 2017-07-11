package com.jzarsuelo.android.weatherapp.ui.main;

import com.jzarsuelo.android.weatherapp.data.DataManager;
import com.jzarsuelo.android.weatherapp.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Pao on 12/7/17.
 */

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V>
        implements MainMvpPresenter<V> {

    @Inject
    public MainPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void updateData() {
        
    }
}
