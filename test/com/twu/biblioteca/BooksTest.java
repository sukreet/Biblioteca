package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class BooksTest {

    @Test
    public void shouldDisplayBookListInDetailsInProperFormat() {

        Books books = new Books();

        String expectedFormat = books.toString();
        String actualFormat = String.format("%-40s", "Head First Java") + String.format("%-40s", "Kathy") + String.format("%-40s", 1995) + System.lineSeparator()
                + String.format("%-40s", "Learning C") + String.format("%-40s", "John") + String.format("%-40s", 2000) + System.lineSeparator();

        assertEquals(expectedFormat, actualFormat);
    }
    
     @Test
         public void testForReflexivity() {
             Books books = new Books();
     
             assertEquals(books, books);
         }
     
         @Test
         public void testForComparingNullObjectsWithA() {
              Books book = new Books();
     
             assertThat(book, not(equalTo(null)));
         }
     
         @Test
         public void testForEquality() {
              Books firstBooks = new Books();
              Books secondBooks = new Books();
     
             assertEquals(firstBooks,  secondBooks );
         }
     
         @Test
         public void testForDifferentObjects() {
             Books books = new Books();
             Object one = new Integer(1);
     
             assertThat(books, not(equalTo(one)));
         }
     
         @Test
         public void testForTransitivity() {
              Books firstBooks = new Books();
              Books secondBooks= new Books();
              Books thirdBooks= new Books();
     
             assertEquals(firstBooks, secondBooks);
             assertEquals(secondBooks, firstBooks);
             assertEquals(firstBooks, thirdBooks);
         }
     
         @Test
         public void testForSymmetry() {
              Books firstBooks = new Books();
              Books secondBooks = new Books();
     
             assertEquals(firstBooks, secondBooks);
             assertEquals(secondBooks, firstBooks);
         }
     
         @Test
         public void equalityTestForHashCode() {
              Books firstBooks= new Books();
              Books secondBooks = new Books();
     
             assertEquals(firstBooks.hashCode(), secondBooks.hashCode());
         }

}