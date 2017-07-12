package com.jzarsuelo.android.weatherapp.ui.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.jzarsuelo.android.weatherapp.R;
import com.jzarsuelo.android.weatherapp.WeatherApp;
import com.jzarsuelo.android.weatherapp.di.component.ActivityComponent;
import com.jzarsuelo.android.weatherapp.di.component.DaggerActivityComponent;
import com.jzarsuelo.android.weatherapp.di.module.ActivityModule;

import butterknife.Unbinder;

/**
 * Base class for all {@link AppCompatActivity} that will be declared in this app. This class contains
 * methods for setting and cleaning up the Activity. It also contains common methods for all the Activities
 */

public abstract class BaseActivity extends AppCompatActivity
        implements MvpView {

    /**
     * Used for injecting dependency
     */
    private ActivityComponent mActivityComponent;

    /**
     * Used for cleanup {@link butterknife.ButterKnife} bindings
     */
    private Unbinder mUnBinder;

    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityComponent = DaggerActivityComponent
                .builder()
                .applicationComponent(((WeatherApp) getApplication()).getApplicationComponent())
                .activityModule(new ActivityModule(this))
                .build();
    }

    @Override
    protected void onDestroy() {

        if (mUnBinder != null) {
            mUnBinder.unbind();
        }

        super.onDestroy();
    }

    @Override
    public void onError(String message) {
        showMessage(message);
    }

    @Override
    public void showMessage(String message) {
        if (message != null) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, getString(R.string.general_error), Toast.LENGTH_SHORT).show();
        }
    }


    public ActivityComponent getActivityComponent() {
        return mActivityComponent;
    }

    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    @Override
    public void showLoading() {

        if (mProgressDialog == null) {

            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.show();

            if (mProgressDialog.getWindow() != null) {
                mProgressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            }

            mProgressDialog.setContentView(R.layout.progress_dialog);
            mProgressDialog.setIndeterminate(true);
        }

        mProgressDialog.show();
    }

    @Override
    public void hideLoading() {
        mProgressDialog.cancel();
    }
}
