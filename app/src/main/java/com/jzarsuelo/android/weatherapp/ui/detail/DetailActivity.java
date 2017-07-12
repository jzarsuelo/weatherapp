package com.jzarsuelo.android.weatherapp.ui.detail;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.jzarsuelo.android.weatherapp.R;
import com.jzarsuelo.android.weatherapp.data.network.model.WeatherSeveralCitiesIdResponseItem;
import com.jzarsuelo.android.weatherapp.ui.base.BaseActivity;

public class DetailActivity extends BaseActivity
        implements DetailMvpView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);

        Drawable refreshIcon = menu.findItem(R.id.action_refresh).getIcon();
        DrawableCompat.setTint(refreshIcon, ContextCompat.getColor(this, android.R.color.white));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        final int itemId = item.getItemId();

        switch (itemId) {
            case R.id.action_refresh:
                // mPresenter.updateData();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setUp() {

    }

    @Override
    public void updateView(WeatherSeveralCitiesIdResponseItem responseItem) {

    }
}
