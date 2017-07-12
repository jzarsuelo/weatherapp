package com.jzarsuelo.android.weatherapp.ui.main;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jzarsuelo.android.weatherapp.R;
import com.jzarsuelo.android.weatherapp.data.network.model.Weather;
import com.jzarsuelo.android.weatherapp.data.network.model.WeatherSeveralCitiesIdResponseItem;
import com.jzarsuelo.android.weatherapp.ui.detail.DetailActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Pao on 12/7/17.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private Context mContext;

    private List<WeatherSeveralCitiesIdResponseItem> mData;

    public MainAdapter(Context context) {
        mContext = context;
        mData = new ArrayList<WeatherSeveralCitiesIdResponseItem>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View rootView = LayoutInflater.from(mContext)
                .inflate(R.layout.item_weather, parent, false);

        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        if (getItemCount() == 0) {
            return;
        }

        WeatherSeveralCitiesIdResponseItem responseItem = mData.get(position);

        Weather weatherObj = responseItem.getWeather().get(0);
        String weatherStr = weatherObj.getMain() + " - " + weatherObj.getDescription();
        String temperatureStr = responseItem.getMain().getTemp().toString() + " C";
        String locationStr = responseItem.getName();

        holder.mWeatherTextView.setText( weatherStr );
        holder.mTemperature.setText( temperatureStr );
        holder.mLocationTextView.setText( locationStr );

    }

    @Override
    public int getItemCount() {

        if (mData == null) {
            return 0;
        } else {
            return mData.size();
        }

    }

    public void updateData(List<WeatherSeveralCitiesIdResponseItem> data) {

        mData = data;

        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text_weather)
        TextView mWeatherTextView;

        @BindView(R.id.text_location)
        TextView mLocationTextView;

        @BindView(R.id.text_temperature)
        TextView mTemperature;

        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (mData == null) {
                        return;
                    }

                    int position = getAdapterPosition();

                    WeatherSeveralCitiesIdResponseItem item = mData.get(position);

                    Intent i = new Intent(mContext, DetailActivity.class);
                    i.putExtra( DetailActivity.EXTRA_CITY_NAME, item.getName() );
                    i.putExtra( DetailActivity.EXTRA_CITY_ID, item.getId().toString() );

                    mContext.startActivity(i);
                }
            });

            ButterKnife.bind(this, itemView);
        }

    }

}
