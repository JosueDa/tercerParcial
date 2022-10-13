package com.example.tercerparcial.api;

import com.example.tercerparcial.bean.Data;
import com.example.tercerparcial.bean.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataApi {

    @GET("/books.json")
    Call<List<Data>> getData();

}