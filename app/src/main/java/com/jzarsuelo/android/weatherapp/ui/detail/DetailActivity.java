package com.jzarsuelo.android.weatherapp.ui.detail;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.jzarsuelo.android.weatherapp.R;
import com.jzarsuelo.android.weatherapp.data.network.model.Weather;
import com.jzarsuelo.android.weatherapp.data.network.model.WeatherSeveralCitiesIdResponseItem;
import com.jzarsuelo.android.weatherapp.ui.base.BaseActivity;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends BaseActivity
        implements DetailMvpView {

    public static final String EXTRA_CITY_ID = "extra_city_id";

    public static final String EXTRA_CITY_NAME = "extra_city_name";

    @BindView(R.id.image_weather)
    ImageView mWeatherImageView;

    @BindView(R.id.text_description)
    TextView mDescriptionTextView;

    @BindView(R.id.text_min_temperature)
    TextView mMinTempTextView;

    @BindView(R.id.text_max_temperature)
    TextView mMaxTempTextView;

    @BindView(R.id.text_humidity)
    TextView mHumidityTextView;

    @Inject
    DetailMvpPresenter<DetailMvpView> mPresenter;

    private String mCityId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Intent i = getIntent();
        mCityId = i.getStringExtra(EXTRA_CITY_ID);

        String cityName = i.getStringExtra(EXTRA_CITY_NAME);
        setTitle(cityName);

        setUp();
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
                 mPresenter.updateData(mCityId);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setUp() {

        setUnBinder(ButterKnife.bind(this));

        getActivityComponent().inject(this);

        mPresenter.onAttach(this);
    }

    @Override
    public void updateView(WeatherSeveralCitiesIdResponseItem responseItem) {

        Weather weather = responseItem.getWeather().get(0);

        Picasso.with(this)
                .load("http://openweathermap.org/img/w/"+weather.getIcon()+".png")
                .into(mWeatherImageView);

        mDescriptionTextView.setText(weather.getDescription());
        mMaxTempTextView.setText( responseItem.getMain().getTempMax().toString() );
        mMinTempTextView.setText( responseItem.getMain().getTempMin().toString() );
        mHumidityTextView.setText( responseItem.getMain().getHumidity().toString() );
    }

    @Override
    public void noDataFetched() {
        onError( getString(R.string.error_no_data) );
    }
}
