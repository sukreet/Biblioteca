package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MenuTest {


    @Test
    public void shouldDisplayMenuOptiions() {
        Menu menu = new Menu();

        String actualOutput = menu.displayMenuOptions();

        assertThat(actualOutput, is("1 : List Of Books\n2 : Quit\n3 : Checkout Book\n4 : Return Book\n"));
    }

    @Test
    public void shouldReturnCorrectSizeOfList() {
        Menu menu = new Menu();

        int actualResult = menu.returnMenuSize();

        assertThat(actualResult, is(4));
    }


}
