package beans;

import beans.enums.Genre;

import java.util.Objects;

public class Song {

    int id;

    String title;
    String artist;

    Genre genre;
    String album;

    String language;

    int time_mins;
    int time_secs;
    int rating;

    int plays;
    boolean favourite;

    public Song(){}

    public Song(int id, String title, String artist, Genre genre, String album, String language,
                int time_mins, int time_secs, int rating, int plays, boolean favourite) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.album = album;
        this.language = language;
        this.time_mins = time_mins;
        this.time_secs = time_secs;
        this.rating = rating;
        this.plays = plays;
        this.favourite = favourite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getTime_mins() {
        return time_mins;
    }

    public void setTime_mins(int time_mins) {
        this.time_mins = time_mins;
    }

    public int getTime_secs() {
        return time_secs;
    }

    public void setTime_secs(int time_secs) {
        this.time_secs = time_secs;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getPlays() {
        return plays;
    }

    public void setPlays(int plays) {
        this.plays = plays;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", genre=" + genre +
                ", album='" + album + '\'' +
                ", time_mins=" + time_mins +
                ", time_secs=" + time_secs +
                ", rating=" + rating +
                ", plays=" + plays +
                ", favourite=" + favourite +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return time_mins == song.time_mins && time_secs == song.time_secs &&
                rating == song.rating && plays == song.plays && favourite == song.favourite &&
                Objects.equals(title, song.title) && Objects.equals(artist, song.artist) &&
                genre == song.genre && Objects.equals(album, song.album);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, artist, genre, album, time_mins, time_secs, rating, plays, favourite);
    }
}
