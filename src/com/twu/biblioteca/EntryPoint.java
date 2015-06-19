package com.twu.biblioteca;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class EntryPoint {

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(isr);
        ArrayList<Book> seedDataForBooks;
        ReadBookList readBookList = new ReadBookList("listOfBooks.txt");
        seedDataForBooks = readBookList.readListOfBooks();
        BookList bookList = new BookList(seedDataForBooks);
        Quit quit = new Quit();
        ConsoleIO consoleIO = new ConsoleIO(bufferedReader);
        ReadMovieList readMovieList = new ReadMovieList("listOfMovies.txt");
        ArrayList<Movie> seedDataForMovies;
        seedDataForMovies = readMovieList.readListOfMovies();
        MovieList movieList = new MovieList(seedDataForMovies);
        Menu menu = new Menu();
        History history = new History();
        User authorisedUser;
        ArrayList<User> userList = new ArrayList<>();
        userList.add(new User("sukreet", "111-1111", "930129876", "src@gmail.com", "password", false));
        userList.add(new User("Bhawesh", "111-1112", "930109876", "bk@gmail.com", "password", false));
        userList.add(new User("librarian", "000-0000", "930127876", "as1@gmail.com", "password", true));

        while (true) {
            Login login = new Login(userList);
            consoleIO.display("Enter ID and Password or quit\n");
            String libraryID = consoleIO.read();
            if (libraryID.equals("quit"))
                System.exit(0);
            String password = consoleIO.read();
            authorisedUser = login.authoriseUser(libraryID, password);
            if (authorisedUser == null) {
                consoleIO.display("Invalid Credentials\n");
                continue;
            }
            if (authorisedUser.userIsLibrarian())
                consoleIO.display(history.show());
            else {
                CheckOutBook checkOutBook = new CheckOutBook(consoleIO, bookList, authorisedUser, history);
                ReturnBook returnBook = new ReturnBook(consoleIO, bookList, authorisedUser, history);
                CheckOutMovies checkOutMovies = new CheckOutMovies(consoleIO, movieList, authorisedUser, history);
                ReturnMovie returnMovie = new ReturnMovie(consoleIO, movieList, authorisedUser, history);
                Dispatcher dispatcher = new Dispatcher(bookList, quit, checkOutBook, returnBook, movieList, checkOutMovies, returnMovie, menu, authorisedUser);
                App app = new App(dispatcher, menu, consoleIO);
                app.start();
            }
        }
    }
}