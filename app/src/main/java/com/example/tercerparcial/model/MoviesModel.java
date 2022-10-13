package com.example.tercerparcial.model;

import com.example.tercerparcial.api.ApiClient;
import com.example.tercerparcial.api.MoviesApi;
import com.example.tercerparcial.bean.Data;
import com.example.tercerparcial.bean.Movie;
import com.example.tercerparcial.presenter.IMoviesPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesModel implements IMoviesModel{

    IMoviesPresenter moviesPresenter;
    MoviesApi moviesApi;

    public MoviesModel(IMoviesPresenter presenter){
        this.moviesPresenter=presenter;
        moviesApi= ApiClient.getInstance().create(MoviesApi.class);
    }

    @Override
    public List<Movie> getMovies() {

        Call<Data> data=moviesApi.getData();
        data.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                Data data1=response.body();
                List<Movie> movies=data1.movies;
                moviesPresenter.onSuccess(movies);
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                moviesPresenter.onError("Error al traer las películas");
            }
        });
        return null;
    }
}
