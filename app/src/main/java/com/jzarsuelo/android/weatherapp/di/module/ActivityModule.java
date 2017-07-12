package com.jzarsuelo.android.weatherapp.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.jzarsuelo.android.weatherapp.di.PerActivity;
import com.jzarsuelo.android.weatherapp.ui.detail.DetailMvpPresenter;
import com.jzarsuelo.android.weatherapp.ui.detail.DetailMvpView;
import com.jzarsuelo.android.weatherapp.ui.detail.DetailPresenter;
import com.jzarsuelo.android.weatherapp.ui.main.MainMvpPresenter;
import com.jzarsuelo.android.weatherapp.ui.main.MainMvpView;
import com.jzarsuelo.android.weatherapp.ui.main.MainPresenter;
import com.jzarsuelo.android.weatherapp.ui.splash.SplashMvpPresenter;
import com.jzarsuelo.android.weatherapp.ui.splash.SplashMvpView;
import com.jzarsuelo.android.weatherapp.ui.splash.SplashPresenter;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Pao on 11/7/17.
 */

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        mActivity = activity;
    }

    @Provides
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(SplashPresenter<SplashMvpView> splashPresenter) {
        return splashPresenter;
    }

    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(MainPresenter<MainMvpView> mainPresenter) {
        return mainPresenter;
    }

    @Provides
    @PerActivity
    DetailMvpPresenter<DetailMvpView> provideDetailPresenter(DetailPresenter<DetailMvpView> detailPresenter) {
        return detailPresenter;
    }
}
