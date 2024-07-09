package streams.songs;

import beans.Dish;
import beans.Song;
import beans.enums.Category;
import beans.enums.Genre;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class SongStream {

    public static void main(String[] args) {

        List<Song> playlist = new Playlist().populatePlaylist();

        List<Song> favourites = playlist.stream().filter(Song::isFavourite)
                .collect(Collectors.toList());

        System.out.println("\nfavourites songs");

        favourites.forEach(System.out::println);

        long popCount = playlist.stream()
                .filter(song -> song.getGenre().name().equalsIgnoreCase("POP"))
                .count();
        System.out.println("\nPop song count =" + popCount);

        List<Song> popular = playlist.stream()
                .filter(song -> song.getRating() > 7)
                .collect(Collectors.toList());

        List<Song> hits = playlist.stream()
                .filter(song -> song.getPlays() > 15)
                .collect(Collectors.toList());

        List<Song> identicals = playlist.stream()
                .filter(song -> song.getTitle().equalsIgnoreCase(song.getAlbum()))
                .collect(Collectors.toList());

        System.out.println("\nPopular songs");
        System.out.println("\nPopular song count =" + popular.size());
        popular.forEach(System.out::println);

        System.out.println("\nhit songs");
        System.out.println("\nhit song count =" + hits.size());
        hits.forEach(System.out::println);

        System.out.println("\nsong title == album");
        System.out.println("\nsong title == album =" + identicals.size());
        identicals.forEach(System.out::println);


        Map<String, List<Song>> groupByArtist = playlist.stream()
                .collect(groupingBy(Song::getArtist));

        Map<Genre, List<Song>> groupByGenre = playlist.stream()
                .collect(groupingBy(Song::getGenre));

        Map<Integer, List<Song>> groupByRating = playlist.stream()
                .collect(groupingBy(Song::getRating));

        System.out.println("\nPlaylist Group by Language :");

        Map<String, List<Song>> groupByLanguage = playlist.stream()
                .collect(Collectors.groupingBy(Song::getLanguage,
                        Collectors.toList()));

        groupByLanguage.forEach((k, v) -> {
            System.out.println("\nLanguage=" + k);
            System.out.println("\nsongs");
            v.forEach(System.out::println);
        });

        System.out.println("\nPlaylist group by artist");
        groupByArtist.forEach((k, v) -> {
            System.out.println("\nArtist=" + k);
            System.out.println("\nsongs");
            v.forEach(System.out::println);
        });

        System.out.println("\nPlaylist group by Gnere");
        groupByGenre.forEach((k, v) -> {
            System.out.println("\nGnere=" + k);
            System.out.println("\nsongs");
            v.forEach(System.out::println);
        });

        System.out.println("\nPlaylist group by Rating");
        groupByRating.forEach((k, v) -> {
            System.out.println("\nRating=" + k);
            System.out.println("\nsongs");
            v.forEach(System.out::println);
        });

        //least played track
        Optional<Song> leastPlayed = playlist.stream()
                .collect(Collectors.minBy(
                        Comparator.comparingInt(Song::getPlays)));

        System.out.println("\nLeast Played Track");
        if(leastPlayed.isPresent())
            System.out.println(leastPlayed.get());

        //most frequently played track (most favorite song(s))
        Optional<Song> favoriteSong = playlist.stream()
                .max(Comparator.comparingInt(Song::getPlays));

        /*
        Optional<Song> favoriteSong = playlist.stream()
                .collect(Collectors.maxBy(
                        Comparator.comparingInt(Song::getPlays)));
                        */

        System.out.println("\nMost Favorite Song");
        favoriteSong.ifPresent(System.out::println);

        //longest track
        Map<Genre, Optional<Song>> longestTrackGenre = playlist.stream().collect(
                Collectors.groupingBy(Song::getGenre,
                        Collectors.maxBy(Comparator.comparingInt(
                                song -> (song.getTime_mins() * 60 + song.getTime_secs())))));

        System.out.println("\nLongest Track each Genre:");
        longestTrackGenre.forEach((genre, song) -> {
            System.out.println(genre.name());
            song.ifPresent(System.out::println);
        });


        //smallest track
        Optional<Song> smallestTrack = playlist.stream().sorted(Comparator.comparingInt(
                (song) -> (song.getTime_mins() * 60 +song.getTime_secs()))).findFirst();

        Optional<Song> largestTrack = playlist.stream().max(Comparator.comparingInt(
                (song) -> (song.getTime_mins() * 60 + song.getTime_secs())));

        System.out.println("Longest Track : "+(largestTrack.isPresent()?largestTrack.get():"Not found"));

        System.out.println("smallest Track : "+(smallestTrack.isPresent()?smallestTrack.get():"Not found"));

        //most frequently played track each genre
        System.out.println("\n Most frequently played track each genre");

        Map<Genre, Optional<Song>> mostFrequentPlayedSongGenre = playlist.stream().collect(
                Collectors.groupingBy(Song::getGenre,
                    Collectors.maxBy(Comparator.comparingInt(Song::getPlays))));

        mostFrequentPlayedSongGenre.forEach((genre, song) -> {
            System.out.println(genre.name());
            song.ifPresent(System.out::println);
        });

        //most frequently played track title and artist each genre

        // Total time of playlist (Hours , mins format)

        int totalTime = playlist.stream().reduce(0, (time, song)
                -> (time + (song.getTime_mins() * 60 + song.getTime_secs())), Integer::sum);

        int secs = totalTime % 60;
        int mins = totalTime / 60;
        int hrs = 0;
        if(mins > 60) {
            hrs = mins / 60;
            mins = mins % 60;
        }

        System.out.println("\n Playlist total time = "+hrs+" hours "+mins+" minutes "+secs+" seconds.");

        System.out.println("\nPlaylist summary Genre");

        Map<Genre, IntSummaryStatistics> summarizePlaylistPerGenre = playlist.stream()
                .collect(Collectors.groupingBy(Song::getGenre,
                        Collectors.summarizingInt(
                                Song::getPlays)));

        summarizePlaylistPerGenre.forEach((k, v) -> {
            System.out.println(k.name());
            System.out.println(v);
        });

        //count frequency of track each genre
        Map<Genre, Long> songByGenre =
                playlist.stream()
                        .collect(groupingBy(
                                Song::getGenre, Collectors.counting()));

        System.out.println("\nfrequency of track each genre");
        songByGenre.forEach((k, v) -> {
            System.out.println(k+" : "+v);
        });

        //count frequency of track each language
        Map<String, Long> songByLanguage =
                playlist.stream()
                        .collect(groupingBy(
                                Song::getLanguage, Collectors.counting()));

        System.out.println("\nfrequency of track each Language");
        songByLanguage.forEach((k, v) -> {
            System.out.println(k+" : "+v);
        });


        System.out.println("\nPartition by Favorite :");

        Map<Boolean, Set<Song>> partitionByFavorite = playlist.stream()
                .collect(Collectors.partitioningBy(Song::isFavourite,
                        Collectors.toSet()));

        partitionByFavorite.forEach((k, v) -> {
            System.out.println( (k ? "\nfavorite " : "\ndisliked ") + "songs");
            v.forEach(System.out::println);
        });

        System.out.println("\n ........ sorting .........");

        //sort by artist
        System.out.println("\nsort by artist");
        playlist.sort(Comparator.comparing(Song::getArtist));
        playlist.forEach(System.out::println);

        //sort by album
        System.out.println("\nsort by album");
        playlist.sort(Comparator.comparing(Song::getAlbum));
        playlist.forEach(System.out::println);

        //sort by genre
        System.out.println("\nsort by genre");
        playlist.sort(Comparator.comparing(song -> song.getGenre().name()));
        playlist.forEach(System.out::println);

        //sort by rating (reverse)
        System.out.println("\nsort by rating (reverse) Highest rated first");
        playlist.sort(Comparator.comparingInt(Song::getRating).reversed());
        playlist.forEach(System.out::println);

        //sort by plays (reverse)
        System.out.println("\nsort by plays (reverse) Most Played First");
        playlist.sort(Comparator.comparingInt(Song::getPlays).reversed());
        playlist.forEach(System.out::println);
    }
}
