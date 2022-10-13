package com.example.tercerparcial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.tercerparcial.adapter.MoviesAdapter;
import com.example.tercerparcial.bean.Movie;
import com.example.tercerparcial.presenter.IMoviesPresenter;
import com.example.tercerparcial.presenter.MoviesPresenter;
import com.example.tercerparcial.view.IMoviesView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IMoviesView {

    private IMoviesPresenter presenter;
    private MoviesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);
        presenter= new MoviesPresenter(this);
        adapter= new MoviesAdapter(new ArrayList<>());
        presenter.getMovies();

        RecyclerView rvBooks = (RecyclerView) findViewById(R.id.books_list);
        rvBooks.setAdapter(adapter);
        rvBooks.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onSuccess(List<Movie> movies) {
        adapter.reloadData(movies);
    }

    @Override
    public void onError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}