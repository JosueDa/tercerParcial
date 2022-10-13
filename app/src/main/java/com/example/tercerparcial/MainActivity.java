package com.example.tercerparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tercerparcial.bean.Movie;
import com.example.tercerparcial.view.IMoviesView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IMoviesView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onSuccess(List<Movie> movies) {

    }

    @Override
    public void onError(String msg) {

    }
}