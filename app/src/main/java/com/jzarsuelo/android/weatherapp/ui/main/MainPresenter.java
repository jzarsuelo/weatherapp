package com.jzarsuelo.android.weatherapp.ui.main;

import com.jzarsuelo.android.weatherapp.R;
import com.jzarsuelo.android.weatherapp.data.DataManager;
import com.jzarsuelo.android.weatherapp.data.network.model.WeatherSeveralCitiesIdResponse;
import com.jzarsuelo.android.weatherapp.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

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

        if ( !getMvpView().isNetworkConnected() ) {
            getMvpView().showNoNetworkMessage();
            return;
        }

        // TODO change location of the static ids 
        String stringIds = "3067696,2643741,5391959";

        getMvpView().showLoading();

        getCompositeDisposable().add(
                getDataManager().getWeather(stringIds)
                    .subscribeOn( Schedulers.io() )
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<WeatherSeveralCitiesIdResponse>() {
                        @Override
                        public void accept(@NonNull WeatherSeveralCitiesIdResponse response)
                                throws Exception {

                            getMvpView().hideLoading();

                            if (response != null) {
                                getMvpView().updateWeatherData(response.getResponseItemList());
                            } else {
                                getMvpView().noDataFetched();
                            }

                        }
                    })
        );
    }
}
