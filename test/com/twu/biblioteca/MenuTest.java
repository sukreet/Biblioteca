package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MenuTest {

    @Test
    public void shouldDisplayListOfBooksWhenUserGivesOne() {
        Menu menu = new Menu();

        String actualOutput = menu.computeMenuOption(1);
        String expectedOutput = String.format("%-40s", "Head First Java") + String.format("%-40s", "Kathy") + String.format("%-40s", 1995) + System.lineSeparator()
                + String.format("%-40s", "Learning C") + String.format("%-40s", "John") + String.format("%-40s", 2000) + System.lineSeparator();

        assertThat(actualOutput, is(expectedOutput));
    }

    @Test
    public void shouldDisplayMenuOptiions() {
        Menu menu = new Menu();

        String actualOutput = menu.displayMenuOptions();

        assertThat(actualOutput, is("1 : List Of Books\n2 : Quit\n"));
    }

    @Test
    public void shouldDisplayInvalidMenuOptionWhenIncorrectMenuOptionIsPassed() {
        Menu menu = new Menu();

        String actualMessage = menu.computeMenuOption(4);

        assertThat(actualMessage, is("Select a valid option!"));
    }


}