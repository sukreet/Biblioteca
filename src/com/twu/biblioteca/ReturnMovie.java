package com.twu.biblioteca;

import java.io.IOException;

public class ReturnMovie implements MenuOperations {
    private ConsoleIO consoleIO;
    private MovieList movieList;
    private String unSuccessfulReturnMsg;
    private String successfulReturnMsg;
    private String name;
    private User authorisedUser;
    private History history;

    public ReturnMovie(ConsoleIO consoleIO, MovieList movieList, User authorisedUser, History history) {
        this.consoleIO = consoleIO;
        this.movieList = movieList;
        unSuccessfulReturnMsg = "That is not a valid movie to return\n";
        successfulReturnMsg = "Thank you for returning the movie.\n";
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
        if (movieList.returnMovie(name)) {
            history.removeRecord(name, "Movie");
            return successfulReturnMsg;
        }
        return unSuccessfulReturnMsg;
    }
}
