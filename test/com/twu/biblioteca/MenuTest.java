package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MenuTest {

    @Test
    public void shouldDisplayListOfBooksWhenUserGivesOne() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Head First Java", "Kathy", 1995));
        books.add(new Book("Learning C", "John", 2000));
        Menu menu = new Menu(new Books(books));

        String actualOutput = menu.computeMenuOption(1);
        String expectedOutput = String.format("%-40s", "Head First Java") + String.format("%-40s", "Kathy") + String.format("%-40s", 1995) + System.lineSeparator()
                + String.format("%-40s", "Learning C") + String.format("%-40s", "John") + String.format("%-40s", 2000) + System.lineSeparator();

        assertThat(actualOutput, is(expectedOutput));
    }

    @Test
    public void shouldDisplayMenuOptiions() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Head First Java", "Kathy", 1995));
        books.add(new Book("Learning C", "John", 2000));
        Menu menu = new Menu(new Books(books));

        String actualOutput = menu.displayMenuOptions();

        assertThat(actualOutput, is("1 : List Of Books\n2 : Quit\n3 : Checkout Book\n"));
    }

    @Test
    public void shouldDisplayInvalidMenuOptionWhenIncorrectMenuOptionIsPassed() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Head First Java", "Kathy", 1995));
        books.add(new Book("Learning C", "John", 2000));
        Menu menu = new Menu(new Books(books));

        String actualMessage = menu.computeMenuOption(8);

        assertThat(actualMessage, is("Select a valid option!"));
    }

}