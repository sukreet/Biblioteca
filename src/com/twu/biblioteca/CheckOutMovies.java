package com.twu.biblioteca;

import java.io.IOException;

public class CheckOutMovies implements MenuOperations {
    private String successFullCheckOutMsg;
    private String unSuccessFullCheckOutMsg;
    private MovieList movieList;
    private String name;
    private ConsoleIO consoleIO;
    private User authorisedUser;

    public CheckOutMovies(ConsoleIO consoleIO, MovieList movieList, User authorisedUser) {
        this.consoleIO = consoleIO;
        successFullCheckOutMsg = "Thank you! Enjoy the movie.\n";
        unSuccessFullCheckOutMsg = "That movie is not available.\n";
        this.movieList = movieList;
        this.authorisedUser = authorisedUser;

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