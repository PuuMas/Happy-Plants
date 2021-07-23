package com.example.mynewapp;

import com.google.gson.annotations.SerializedName;

public class DataValues {
    @SerializedName("water") private String water;
    @SerializedName("sun") private String sun;
    @SerializedName("tempature") private String tempature;
    @SerializedName("humidity") private String humidity;

    public String getWater() {
        return water;
    }

    public String getSun() {
        return sun;
    }

    public String getTempature() {
        return tempature;
    }

    public String getHumidity() {
        return humidity;
    }
}
