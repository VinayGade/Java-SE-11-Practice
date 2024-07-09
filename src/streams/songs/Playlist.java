package streams.songs;

import beans.Song;
import beans.enums.Genre;

import java.util.Arrays;
import java.util.List;

public class Playlist {

    public List<Song> populatePlaylist() {
        return
        Arrays.asList(
                new Song(8, "Radioactive", "Imagine Dragons", Genre.ROCK, "Radioactive", "English", 4, 36, 10, 38, true),

                new Song(1, "Espresso", "Sabrina Carpenter", Genre.DANCE, "Espresso", "English", 2, 55, 8, 20, true),
                new Song(2, "If Only I", "Bebe Rexha", Genre.DANCE, "If Only I", "English", 2, 23, 10, 25, true),
                new Song(3, "The Greatest", "Sia", Genre.JAZZ, "This is Acting", "English", 3, 31, 8, 15, true),
                new Song(4, "Titanium", "Sia", Genre.POP, "Listen Again", "English", 4, 6, 10, 29, true),
                new Song(5, "Never Give Up", "Sia", Genre.JAZZ, "Never Give Up", "English", 3, 42, 9, 35, true),
                new Song(6, "Unstoppable", "Sia", Genre.JAZZ, "This is Acting", "English", 3, 38, 8, 20, true),

                new Song(11, "Single Soon", "Selena Gomez", Genre.RAP, "Single Soon", "English", 2, 52, 7, 12, true),
                new Song(12, "Calm Down", "Rema", Genre.DANCE, "Calm Down", "English", 4, 1, 7, 11, false),
                new Song(13, "Good For You", "Sia", Genre.ORCHESTRA, "Revival", "English", 3, 38, 7, 16, true),
                new Song(9, "Hearts On Fire", "John Cafferty", Genre.ROCK, "Rocky", "English", 4, 12, 10, 40, true),
                new Song(15, "Criminal", "Natasha", Genre.RAP, "Criminal", "Spanish", 3, 53, 6, 9, true),
                new Song(16, "Despacito", "Luis Fonsi", Genre.DANCE, "Despacito", "Spanish", 3, 50, 10, 20, true),

                new Song(21, "Cheap Thrills", "Sia", Genre.JAZZ, "This is Acting", "English", 3, 45, 5, 8, false),
                new Song(27, "Mayores", "Becky G", Genre.RAP, "Mala Santa", "Spanish", 3, 23, 7, 15, false),
                new Song(32, "Taki Taki", "Selena Gomez", Genre.POP, "Taki Taki", "Spanish", 3, 33, 6, 5, false),
                new Song(24, "No Time To Die", "Billie Eilish", Genre.ORCHESTRA, "No Time To Die", "English", 4, 2, 8, 10, false),
                new Song(58, "Bad Guy", "Billie Eilish", Genre.POP, "When We Fall Asleep", "English", 3, 14, 5, 5, false),
                new Song(63, "I Got You", "Bebe Rexha", Genre.DANCE, "Expectations", "English", 3, 12, 10, 29, true),

                new Song(65, "Beautiful", "Akon", Genre.POP, "Freedom", "English", 5, 12, 9, 22, true),
                new Song(67, "All Day and Night", "Jax Jones", Genre.DANCE, "Snacks", "English", 2, 52, 9, 17, true),
                new Song(65, "Love You Like a Love Song", "Selena Gomez", Genre.RAP, "Freedom", "English", 3, 28, 10, 21, true)
                );
    }
}
