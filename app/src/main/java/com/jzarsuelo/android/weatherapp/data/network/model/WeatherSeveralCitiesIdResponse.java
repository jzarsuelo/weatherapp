package com.jzarsuelo.android.weatherapp.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Pao on 12/7/17.
 */

public class WeatherSeveralCitiesIdResponse {

    @SerializedName("cnt")
    @Expose
    private Integer cnt;

    @SerializedName("list")
    @Expose
    private List<WeatherSeveralCitiesIdResponseItem> responseItemList = null;

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public List<WeatherSeveralCitiesIdResponseItem> getResponseItemList() {
        return responseItemList;
    }

    public void setResponseItemList(List<WeatherSeveralCitiesIdResponseItem> responseItemList) {
        this.responseItemList = responseItemList;
    }
}
