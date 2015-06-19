package com.twu.biblioteca;

import java.io.IOException;

public class CheckOutMovies implements MenuOperations {
    private String successFullCheckOutMsg;
    private String unSuccessFullCheckOutMsg;
    private MovieList movieList;
    private String name;
    private ConsoleIO consoleIO;
    private User authorisedUser;
    private History history;

    public CheckOutMovies(ConsoleIO consoleIO, MovieList movieList, User authorisedUser, History history) {
        this.consoleIO = consoleIO;
        successFullCheckOutMsg = "Thank you! Enjoy the movie.\n";
        unSuccessFullCheckOutMsg = "That movie is not available.\n";
        this.movieList = movieList;
        this.authorisedUser = authorisedUser;
        this.history = history;

    }

    @Override
    public String action() {
        try {
            name = consoleIO.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (movieList.issueMovie(name)) {
            history.addRecord(authorisedUser.nameOfUser(),name,"Movie");
            return successFullCheckOutMsg;
        }
        return unSuccessFullCheckOutMsg;
    }
}