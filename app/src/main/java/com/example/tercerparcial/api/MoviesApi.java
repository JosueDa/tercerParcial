package com.example.tercerparcial.api;

import com.example.tercerparcial.bean.Data;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MoviesApi {

    @GET("db.json")
    Call<Data> getData();

}