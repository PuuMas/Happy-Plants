package com.example.mynewapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("plants/{name}")
    Call < List<Plants> > getPlants (@Path("name") String name);

}
