package com.jzarsuelo.android.weatherapp.ui.main;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.jzarsuelo.android.weatherapp.R;
import com.jzarsuelo.android.weatherapp.data.network.model.WeatherSeveralCitiesIdResponseItem;
import com.jzarsuelo.android.weatherapp.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity
        implements MainMvpView{

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.recycler_weather)
    RecyclerView mRecyclerView;

    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;

    private MainAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUp();

        mAdapter = new MainAdapter(this);

        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));

    }

    @Override
    protected void onStart() {
        super.onStart();

        mPresenter.updateData();
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
                mPresenter.updateData();
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
    public void updateWeatherData(List<WeatherSeveralCitiesIdResponseItem> data) {
        mAdapter.updateData(data);
    }

    @Override
    public void noDataFetched() {
        onError( getString(R.string.error_no_data) );
    }
}
