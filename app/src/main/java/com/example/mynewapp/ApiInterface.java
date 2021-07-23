package com.example.mynewapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {
    @GET("plants/{name}")
    Call < List<Plants> > getPlants (@Path("name") String name);

    @GET("/{name}")
    Call < List<DataValues> > getDataValues (@Path("name") String name);

}
