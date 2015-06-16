package com.twu.biblioteca;

import java.util.ArrayList;

public class MovieList implements MenuOperations {

    private ArrayList<Movie> movies = new ArrayList<>();

    public MovieList(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String action() {

        String list = "";
        for (Movie movie : movies)
                list += movie.toString() + System.lineSeparator();
        return list;
    }
}

