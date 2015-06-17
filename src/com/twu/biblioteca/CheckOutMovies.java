package com.twu.biblioteca;

import java.io.IOException;

public class CheckOutMovies implements MenuOperations {
    private String unSuccessFullCheckOutMsg;
    private MovieList movieList;
    private String name;
    private ConsoleIO consoleIO;

    public CheckOutMovies(ConsoleIO consoleIO, MovieList movieList) {
        this.consoleIO = consoleIO;
        unSuccessFullCheckOutMsg = "That movie is not available.\n";
        this.movieList = movieList;

    }

    @Override
    public String action() {
        try {
            name = consoleIO.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        movieList.issueMovie(name);
        return  unSuccessFullCheckOutMsg;
    }
}