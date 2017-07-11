package com.jzarsuelo.android.weatherapp.ui.splash;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jzarsuelo.android.weatherapp.R;
import com.jzarsuelo.android.weatherapp.ui.base.BaseActivity;
import com.jzarsuelo.android.weatherapp.ui.main.MainActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class SplashActivity extends BaseActivity
        implements SplashMvpView {

    @Inject
    SplashMvpPresenter<SplashMvpView> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        setUp();
    }

    @Override
    public void navigateToMainScreen() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    @Override
    public void setUp() {

        setUnBinder(ButterKnife.bind(this));

        getActivityComponent().inject(this);

        mPresenter.onAttach(this);

        mPresenter.showSplashScreen();
    }
}
