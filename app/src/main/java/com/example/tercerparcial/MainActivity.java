package com.example.tercerparcial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.tercerparcial.adapter.BooksAdapter;
import com.example.tercerparcial.adapter.MoviesAdapter;
import com.example.tercerparcial.bean.Book;
import com.example.tercerparcial.bean.Movie;
import com.example.tercerparcial.presenter.BookPresenter;
import com.example.tercerparcial.presenter.IBookPresenter;
import com.example.tercerparcial.presenter.IMoviesPresenter;
import com.example.tercerparcial.presenter.MoviesPresenter;
import com.example.tercerparcial.view.IBookView;
import com.example.tercerparcial.view.IMoviesView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IMoviesView, IBookView {

    private IMoviesPresenter presenter;
    private MoviesAdapter adapter;
    private IBookPresenter iBookPresenter;
    private BooksAdapter bookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter= new MoviesPresenter(this);
        adapter= new MoviesAdapter(new ArrayList<>());
        presenter.getMovies();

        RecyclerView rvMovies = (RecyclerView) findViewById(R.id.movies_list);
        rvMovies.setAdapter(adapter);
        rvMovies.setLayoutManager(new LinearLayoutManager(this));

        iBookPresenter= new BookPresenter(this);
        bookAdapter= new BooksAdapter(new ArrayList<>());
        iBookPresenter.getBooks();

        RecyclerView rvBooks = (RecyclerView) findViewById(R.id.books_list);
        rvBooks.setAdapter(bookAdapter);
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

    @Override
    public void onBooksSuccess(List<Book> books) {
        bookAdapter.reloadData(books);
    }

    @Override
    public void onBooksFail(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}