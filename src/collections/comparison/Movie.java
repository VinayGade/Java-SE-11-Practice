package collections.comparison;

public class Movie implements Comparable<Movie> {

    private String name;
    private double rating;
    private int year;
    @Override
    public int compareTo(Movie m) {
        return m.getName().compareTo(this.name);
        //return this.year - m.year;
    }

    public Movie(String name, double rating, int year){
        this.name = name;
        this.year = year;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    public int getYear() {
        return year;
    }
}
