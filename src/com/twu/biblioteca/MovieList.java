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
        for (Movie movie : movies) {
            if (movie.checkAvailability())
                list += movie.toString() + System.lineSeparator();
        }
        return list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieList movieList = (MovieList) o;

        return !(movies != null ? !movies.equals(movieList.movies) : movieList.movies != null);

    }

    @Override
    public int hashCode() {
        return movies != null ? movies.hashCode() : 0;
    }

    public boolean checkExistence(String name) {
        for (Movie movie : movies) {
            if (movie.checkNameIs(name))
                return true;
        }
        return false;
    }


    public boolean issueMovie(String name) {
        for (Movie movie : movies) {
            if (movie.checkNameIs(name) && movie.checkAvailability()) {
                movie.issueMovie();
                return true;
            }
        }
        return false;
    }

    public boolean checkAvailability(String name) {
        for (Movie movie : movies) {
            if (movie.checkNameIs(name))
                return movie.checkAvailability();
        }
        return false;
    }

    public boolean returnMovie(String name) {
        for (Movie movie : movies) {
            if (movie.checkNameIs(name) && !movie.checkAvailability()) {
                movie.returnMovie();
                return true;
            }
        }
        return false;
    }
}