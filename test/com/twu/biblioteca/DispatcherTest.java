package com.twu.biblioteca;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DispatcherTest {

    @Test
    public void shouldDisplayListOfBooksWhenUserGivesOne() {
        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book("Head First Java", "Kathy", 1995));
        list.add(new Book("Learning C", "John", 2000));
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(isr);
        Books books = new Books(list);
        CheckOut checkOut = new CheckOut(bufferedReader, books);
        ReturnBook returnBook = new ReturnBook(bufferedReader, books);
        Menu menu = new Menu();
        Dispatcher dispatcher = new Dispatcher(books, new Quit(), checkOut, returnBook, menu);

        String actualOutput = dispatcher.computeMenuOption(1);
        String expectedOutput = String.format("%-40s", "Head First Java") + String.format("%-40s", "Kathy") + String.format("%-40s", 1995) + System.lineSeparator()
                + String.format("%-40s", "Learning C") + String.format("%-40s", "John") + String.format("%-40s", 2000) + System.lineSeparator();

        assertThat(actualOutput, is(expectedOutput));
    }


    @Test
    public void shouldDisplayInvalidMenuOptionWhenIncorrectMenuOptionIsPassed() {
        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book("Head First Java", "Kathy", 1995));
        list.add(new Book("Learning C", "John", 2000));
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(isr);
        Books books = new Books(list);
        CheckOut checkOut = new CheckOut(bufferedReader, books);
        ReturnBook returnBook = new ReturnBook(bufferedReader, books);
        Menu menu = new Menu();
        Dispatcher dispatcher = new Dispatcher(books, new Quit(), checkOut, returnBook, menu);

        String actualOutput = dispatcher.computeMenuOption(8);

        assertThat(actualOutput, is("Select a valid option!"));
    }
}