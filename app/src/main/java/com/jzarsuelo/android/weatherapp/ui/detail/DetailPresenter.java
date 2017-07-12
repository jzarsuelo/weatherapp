package com.jzarsuelo.android.weatherapp.ui.detail;

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

public class DetailPresenter<V extends DetailMvpView> extends BasePresenter<V>
        implements DetailMvpPresenter<V> {

    @Inject
    public DetailPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void updateData(String id) {

        getMvpView().showLoading();

        getCompositeDisposable().add(
                getDataManager().getWeather(id)
                        .subscribeOn( Schedulers.io() )
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<WeatherSeveralCitiesIdResponse>() {
                            @Override
                            public void accept(@NonNull WeatherSeveralCitiesIdResponse response)
                                    throws Exception {

                                getMvpView().hideLoading();

                                if (response != null) {
                                    getMvpView().updateView(response.getResponseItemList().get(0));
                                } else {
                                    getMvpView().noDataFetched();
                                }

                            }
                        })
        );
    }
}
