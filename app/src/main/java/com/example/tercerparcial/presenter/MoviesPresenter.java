package com.example.tercerparcial.presenter;

import com.example.tercerparcial.bean.Movie;
import com.example.tercerparcial.model.IMoviesModel;
import com.example.tercerparcial.model.MoviesModel;
import com.example.tercerparcial.view.IMoviesView;

import java.util.List;

public class MoviesPresenter implements IMoviesPresenter{

    private IMoviesView moviesView;
    private IMoviesModel moviesModel;

    public MoviesPresenter(IMoviesView view){
        moviesView=view;
        moviesModel=new MoviesModel(this);
    }

    @Override
    public void getMovies() {
        moviesModel.getMovies();
    }

    @Override
    public void onSuccess(List<Movie> movies) {
        moviesView.onSuccess(movies);
    }

    @Override
    public void onError(String msg) {
        moviesView.onError(msg);
    }
}
