package com.example.tercerparcial.presenter;

import com.example.tercerparcial.bean.Movie;

import java.util.List;

public interface IMoviesPresenter {

    void onSuccess(List<Movie> movies);

    void onError(String msg);

}
