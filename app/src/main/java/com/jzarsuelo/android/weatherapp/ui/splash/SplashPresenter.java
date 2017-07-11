package com.jzarsuelo.android.weatherapp.ui.splash;

import com.jzarsuelo.android.weatherapp.data.DataManager;
import com.jzarsuelo.android.weatherapp.ui.base.BasePresenter;
import com.jzarsuelo.android.weatherapp.ui.base.MvpPresenter;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Pao on 12/7/17.
 */

public class SplashPresenter<V extends SplashMvpView> extends BasePresenter<V>
        implements SplashMvpPresenter<V> {

    private static final long SPLASH_SCREEN_DELAY = 2;

    @Inject
    public SplashPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void showSplashScreen() {

        Observable.timer(SPLASH_SCREEN_DELAY, TimeUnit.SECONDS)
            .subscribe(new Consumer<Long>() {
                @Override
                public void accept(@NonNull Long aLong) throws Exception {
                    getMvpView().navigateToMainScreen();
                }
            });

    }
}
