package collections;

// Java program to demonstrate
// methods of Spliterator

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

public class SpliteratorDemo
{
    public static void main(String[] args)
    {
        // Create an array list for doubles.
        ArrayList<Integer> al = new ArrayList<>();

        // Add values to the array list.
        al.add(1);
        al.add(2);
        al.add(-3);
        al.add(-4);
        al.add(5);
        al.add(2);
        al.add(10);

        // Obtain a Stream to the array list.
        Stream<Integer> str = al.stream();

        // getting Spliterator object on al
        Spliterator<Integer> spliterator = str.spliterator();

        /*
        var distinct = splitr1.DISTINCT;
        int sorted = splitr1.SORTED;

         */
        // estimateSize method
        System.out.println("estimate size : " + spliterator.estimateSize());

        // getExactSizeIfKnown method
        System.out.println("exact size : " + spliterator.getExactSizeIfKnown());

        // hasCharacteristics and characteristics method
        System.out.println(spliterator.hasCharacteristics(spliterator.characteristics()));

        System.out.println("Content of arraylist :");
        // forEachRemaining method
        spliterator.forEachRemaining((n) -> System.out.println(n));

        // Obtaining another Stream to the array list.
        Stream<Integer> str1 = al.stream();
        spliterator = str1.spliterator();

        // trySplit() method
        Spliterator<Integer> splitr2 = spliterator.trySplit();

        // If splitr1 could be split, use splitr2 first.
        if(splitr2 != null) {
            System.out.println("Output from splitr2: ");
            splitr2.forEachRemaining((n) -> System.out.println(n));
        }

        // Now, use the splitr
        System.out.println("\nOutput from splitr1: ");
        spliterator.forEachRemaining((n) -> System.out.println(n));

        int expected = Spliterator.ORDERED | Spliterator.SIZED | Spliterator.SUBSIZED;

        int sorted = spliterator.SORTED;

        System.out.println(spliterator.characteristics() == expected);  //true

        if (spliterator.hasCharacteristics(Spliterator.ORDERED)) {
            System.out.println("ORDERED");
        }

        if (spliterator.hasCharacteristics(Spliterator.DISTINCT)) {
            System.out.println("DISTINCT");
        }

        if (spliterator.hasCharacteristics(Spliterator.SORTED)) {
            System.out.println("SORTED");
        }

        if (spliterator.hasCharacteristics(Spliterator.SIZED)) {
            System.out.println("SIZED");
        }

        if (spliterator.hasCharacteristics(Spliterator.CONCURRENT)) {
            System.out.println("CONCURRENT");
        }

        if (spliterator.hasCharacteristics(Spliterator.IMMUTABLE)) {
            System.out.println("IMMUTABLE");
        }

        if (spliterator.hasCharacteristics(Spliterator.NONNULL)) {
            System.out.println("NONNULL");
        }

        if (spliterator.hasCharacteristics(Spliterator.SUBSIZED)) {
            System.out.println("SUBSIZED");
        }




    }
}

