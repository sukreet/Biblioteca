package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MenuTest {


    @Test
    public void shouldDisplayMenuOptiions() {
        Menu menu = new Menu();

        String actualOutput = menu.displayMenuOptions();
        String expectedOutput = "1 : List Of Books\n2 : Quit\n3 : Checkout Book\n4 : Return Book\n5 : List Of Movies\n6 : Check out Movie\n7 : Return Movie\n";
        assertThat(actualOutput, is(expectedOutput));
    }

    @Test
    public void shouldReturnCorrectSizeOfList() {
        Menu menu = new Menu();

        int actualResult = menu.returnMenuSize();

        assertThat(actualResult, is(7));
    }


}
