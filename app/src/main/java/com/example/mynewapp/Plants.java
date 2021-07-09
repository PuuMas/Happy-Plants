package com.example.mynewapp;

import com.google.gson.annotations.SerializedName;

public class Plants {
    @SerializedName("id") private int Id;
    @SerializedName("herb_name") private String herbName;
    @SerializedName("latin_name") private String latinName;
    @SerializedName("temp") private double temp;
    @SerializedName("water") private String water;
    @SerializedName("humidity") private double humidity;
    @SerializedName("sun") private String sun;
    @SerializedName("ph") private double ph;

    public int getId() {
        return Id;
    }

    public String getHerbName() {
        return herbName;
    }

    public String getLatinName() {
        return latinName;
    }

    public double getTemp() {
        return temp;
    }

    public String getWater() {
        return water;
    }

    public double getHumidity() {
        return humidity;
    }

    public String getSun() {
        return sun;
    }

    public double getPh() {
        return ph;
    }
}
