package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadMovieList {
    String fileName;

    public ReadMovieList(String fileName) {
        this.fileName = fileName;
    }

    public ArrayList<Movie> readListOfMovies() throws IOException {
        ArrayList<Movie> listOfMovies = new ArrayList<>();
        String name, director, year, rating;
        int yearOfRelease;


        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                name = line.substring(0, 39);
                name = name.trim();
                director = line.substring(40, 79);
                director = director.trim();
                year = line.substring(80, 89);
                year = year.trim();
                yearOfRelease = Integer.parseInt(year);
                rating = line.substring(90, 99);
                rating = rating.trim();

                listOfMovies.add(new Movie(name, director, yearOfRelease, rating));

                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
        }

        return listOfMovies;
    }
}


