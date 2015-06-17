package com.twu.biblioteca;

import java.io.IOException;

public class CheckOutMovies implements MenuOperations {
    private String successFullCheckOutMsg;
    private String unSuccessFullCheckOutMsg;
    private MovieList movieList;
    private String name;
    private ConsoleIO consoleIO;

    public CheckOutMovies(ConsoleIO consoleIO, MovieList movieList) {
        this.consoleIO = consoleIO;
        successFullCheckOutMsg = "Thank you! Enjoy the movie.\n";
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
        if (movieList.issueMovie(name))
            return successFullCheckOutMsg;
        return unSuccessFullCheckOutMsg;
    }
}