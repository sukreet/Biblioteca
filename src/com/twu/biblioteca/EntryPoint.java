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
        FileHandler fileHandler = new FileHandler("listOfBooks.txt");
        seedDataForBooks = fileHandler.readListOfBooks();
        BookList bookList = new BookList(seedDataForBooks);
        Quit quit = new Quit();
        ConsoleIO consoleIO = new ConsoleIO(bufferedReader);
        CheckOutBook checkOutBook = new CheckOutBook(consoleIO, bookList);
        ReturnBook returnBook = new ReturnBook(consoleIO, bookList);
        ReadMovieList readMovieList = new ReadMovieList("listOfMovies.txt");
        ArrayList<Movie> seedDataForMovies;
        seedDataForMovies = readMovieList.readListOfMovies();
        MovieList movieList = new MovieList(seedDataForMovies);
        Menu menu = new Menu();
        CheckOutMovies checkOutMovies = new CheckOutMovies(consoleIO, movieList);
        Dispatcher dispatcher = new Dispatcher(bookList, quit, checkOutBook, returnBook, movieList, checkOutMovies, menu);

        App app = new App(dispatcher, menu, consoleIO);
        app.start();
    }
}
