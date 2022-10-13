package com.example.tercerparcial.bean;

import java.util.List;

public class Movie {
    public String title;
    public String year;
    public String runtime;
    public List<String> genres;
    public String director;
    public String actors;
    public String plot;
    public String posterUrl;

    public String getGenres(){
        return genres.toString().replace("[","").replace("]","");
    }

    public String getRuntime(){
        return runtime+" minutes";
    }

}
