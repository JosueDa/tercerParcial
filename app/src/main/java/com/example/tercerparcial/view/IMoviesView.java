package com.example.tercerparcial.view;

import com.example.tercerparcial.bean.Movie;

import java.util.List;

public interface IMoviesView {

    void onSuccess(List<Movie> movies);

    void onError(String msg);
}
