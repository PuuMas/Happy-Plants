package com.example.mynewapp;

import com.google.gson.annotations.SerializedName;

public class Plants {
    @SerializedName("Id") private int Id;
    @SerializedName("herb_name") private String herbName;
    @SerializedName("latin_name") private String latinName;
    @SerializedName("temp") private int temp;
    @SerializedName("water") private String water;
    @SerializedName("humidity") private Float humidity;
    @SerializedName("sun") private String sun;
    @SerializedName("ph") private Float ph;

    public int getId() {
        return Id;
    }

    public String getHerbName() {
        return herbName;
    }

    public String getLatinName() {
        return latinName;
    }

    public int getTemp() {
        return temp;
    }

    public String getWater() {
        return water;
    }

    public Float getHumidity() {
        return humidity;
    }

    public String getSun() {
        return sun;
    }

    public Float getPh() {
        return ph;
    }
}
