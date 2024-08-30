package collections;

import collections.comparison.Movie;

import java.util.*;

public class MoviesComparison {
    public static void main(String[] args) {

        NavigableSet<Movie> movies = new TreeSet<>();

        //List<Movie> movies = new ArrayList<>();

        movies.add(new Movie("Bahubali", 8.3, 2015));
        movies.add(new Movie("Janbar", 8.7, 1977));
        movies.add(new Movie("Mr India", 8.8, 1980));

        movies.add(new Movie("Amar Akbar Anthony", 8.9, 1983));

        //Collections.sort(movies);

        System.out.println("Movies after sorting:");
        for(Movie movie: movies)
            System.out.println(movie.getName()+" "+movie.getRating()+" "+movie.getYear());

    }
}
