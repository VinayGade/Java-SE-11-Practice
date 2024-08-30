package collections.comparison;

import beans.Dish;
import beans.Song;
import beans.enums.Category;
import streams.DishesGenerator;
import streams.songs.Playlist;

import java.util.*;

public class Search {

    public static void main(String[] args) {

        List<Integer> al = new ArrayList<Integer>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(10);
        al.add(20);

        // 10 is present at index 3.
        int index = Collections.binarySearch(al, 10);
        System.out.println("10 is at "+index);

        // 13 is not present. 13 would have been inserted
        // at position 4. So the function returns (-4-1)
        // which is -5.
        index = Collections.binarySearch(al, 13);
        System.out.println("13 is at "+index);

        List<Integer> list = new ArrayList<Integer>();
        list.add(100);
        list.add(50);
        list.add(30);
        list.add(10);
        list.add(2);

        // The last parameter specifies the comparator
        // method used for sorting.
        index = Collections.binarySearch(
                al, 50, Collections.reverseOrder());

        System.out.println("50 Found at index " + index);

        DishesGenerator dishGenerator = new DishesGenerator();

        List<Dish> menu = dishGenerator.populateSpecialMenu();

        // provide search attributes for Dish in Comparator

        Comparator<Dish> dishComparator = Comparator.comparing(Dish::getName);

        menu.sort(dishComparator);

        int chickenDishIndex = Collections.binarySearch(menu, new Dish(0,"Chicken Tikka Masala", 0, 0, null,false), dishComparator);

        System.out.println("Dish: Chicken tikka Masala, found at"+chickenDishIndex);

        String fishDish = "Prawns Biryani";
        String eggDish = "Egg Fried Rice";
        String muttonDish = "Mutton Paya Soup";
        String paneerDish = "Paneer Tikka Masala";
        String fruitDish = "Mango Milk Shake";

        int muttonIndex = Collections.binarySearch(menu, new Dish(0,muttonDish, 0, 0, null,false), dishComparator);

        int eggIndex = Collections.binarySearch(menu, new Dish(0,eggDish, 0, 0, null,false), dishComparator);

        int fishIndex = Collections.binarySearch(menu, new Dish(0,fishDish, 0, 0, null,false), dishComparator);

        int paneerIndex = Collections.binarySearch(menu, new Dish(0,paneerDish, 0, 0, null,false), dishComparator);

        int fruitIndex = Collections.binarySearch(menu, new Dish(0,fruitDish, 0, 0, null,false), dishComparator);

        System.out.println("Dish:"+ muttonDish + " found at "+ muttonIndex);

        System.out.println("Dish:"+ eggDish + " found at "+ eggIndex);

        System.out.println("Dish:"+ fishDish + " found at "+ fishIndex);

        System.out.println("Dish:"+ paneerDish + " found at "+ paneerIndex);

        System.out.println("Dish:"+ fruitDish + " found at "+ fruitIndex);

        //Comparator<Dish> dishCostComparator = Comparator.comparing(Dish::getPrice);

        // Comparator to compare songs by title
        Comparator<Dish> dishCostComparator = new Comparator<>() {
            @Override
            public int compare(Dish d1, Dish d2) {
                //return (d1.getPrice()-d2.getPrice() > 0) ? 1 : 0;
                return Double.compare(d1.getPrice(), d2.getPrice());
            }
        };

        menu.sort(dishCostComparator);

        //470 - 50

        int mostExpensiveIndex = Collections.binarySearch(menu, new Dish(0, "", 0, 470, null,false), dishComparator);

        System.out.println("Most expensive dish index ="+mostExpensiveIndex);

        int mostCheapIndex = Collections.binarySearch(menu, new Dish(0, "", 0, 50, null,false), dishComparator);

        System.out.println("Most cheap dish index ="+mostCheapIndex);

        // binary search on playlist of songs

        List<Song> playlist = new Playlist().populatePlaylist();

        // Comparator to compare songs by title
        Comparator<Song> titleComparator = new Comparator<Song>() {
            @Override
            public int compare(Song s1, Song s2) {
                return s1.getTitle().compareToIgnoreCase(s2.getTitle());
            }
        };

        // Sort the playlist by title
        playlist.sort(titleComparator);

        // Create a song to search for
        Song searchSong = new Song(0, "Hearts On Fire", "", null, "", "", 0, 0, 0, 0, false);

        // Perform binary search
        int songindex = Collections.binarySearch(playlist, searchSong, titleComparator);

        // Display the result
        if (songindex >= 0) {
            System.out.println("Song found at index: " + songindex);
            System.out.println(playlist.get(songindex));
        } else {
            System.out.println("Song not found in the playlist.");
        }

        //sort by plays (reverse)
        System.out.println("\nsort by plays (reverse) Most Played First");

        Comparator<Song> songPopularityComparator = Comparator.comparingInt(Song::getPlays);
        playlist.sort(songPopularityComparator);

        int mostPlays = Collections.binarySearch(playlist, new Song(0, "", "", null, "", "", 0, 0, 0, 40,true), songPopularityComparator);
        System.out.println("Most plays of song ="+mostPlays);

        Song mostPlayed = playlist.stream()
                .filter(song -> song.getPlays() == mostPlays)
                .findFirst()
                .get();

        System.out.println("Most played song (based on search)="+mostPlayed);

        // binarySearch() in a sorted array

        // Declaring and initializing byte arrays
        // to search over them
        byte byteArr[] = { 10, 20, 15, 22, 35 };
        char charArr[] = { 'g', 'p', 'q', 'c', 'i' };
        int intArr[] = { 10, 20, 15, 22, 35 };
        double doubleArr[] = { 10.2, 15.1, 2.2, 3.5 };
        float floatArr[] = { 10.2f, 15.1f, 2.2f, 3.5f };
        short shortArr[] = { 10, 20, 15, 22, 35 };

        // Using sort() method of Arrays class
        // and passing arrays to be sorted as in arguments
        Arrays.sort(byteArr);
        Arrays.sort(charArr);
        Arrays.sort(intArr);
        Arrays.sort(doubleArr);
        Arrays.sort(floatArr);
        Arrays.sort(shortArr);

        // Primitive datatypes
        byte byteKey = 35;
        char charKey = 'g';
        int intKey = 22;
        double doubleKey = 1.5;
        float floatKey = 35;
        short shortKey = 5;

        // Now in sorted array we will fetch and
        // return elements/indiciesaccessing indexes to show
        // array is really sorted

        System.out.println("binarySearch() in a sorted array");

        // Print commands where we are implementing
        System.out.println(
                byteKey + " found at index = "
                        + Arrays.binarySearch(byteArr, byteKey));
        System.out.println(
                charKey + " found at index = "
                        + Arrays.binarySearch(charArr, charKey));
        System.out.println(
                intKey + " found at index = "
                        + Arrays.binarySearch(intArr, intKey));
        System.out.println(
                doubleKey + " found at index = "
                        + Arrays.binarySearch(doubleArr, doubleKey));
        System.out.println(
                floatKey + " found at index = "
                        + Arrays.binarySearch(floatArr, floatKey));
        System.out.println(
                shortKey + " found at index = "
                        + Arrays.binarySearch(shortArr, shortKey));

        // sort subarray

        // Custom input array
        // It contains 8 elements as follows
        int[] arr = { 13, 7, 6, 45, 21, 9, 2, 100 };

        // Sort subarray from index 1 to 4, i.e.,
        // only sort subarray {7, 6, 45, 21} and
        // keep other elements as it is.
        Arrays.sort(arr, 1, 5);

        // Printing the updated array which is
        // sorted after 2 index inclusive till 5th index
        System.out.println("Modified arr[] : "
                + Arrays.toString(arr));
    }
}