package iq;

/*
How to find duplicate elements in a given integers list in java using Stream functions
* */

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

//10,20,30,40,40,30,50
public class Duplicates {

    List<Integer> listDuplicateUsingFilterAndSetAdd(List<Integer> list) {
        Set<Integer> elements = new HashSet<Integer>();
        return list.stream()
                .filter(n -> !elements.add(n))
                .collect(Collectors.toList());
    }

    List<Integer> listDuplicateUsingCollectionsFrequency(List<Integer> list) {
        List<Integer> duplicates = new ArrayList<>();
        Set<Integer> set = list.stream()
                .filter(i -> Collections.frequency(list, i) > 1)
                .collect(Collectors.toSet());
        duplicates.addAll(set);
        return duplicates;
    }

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10,20,30,40,40,30,50, 100, 90, 80, 10, 30, 50);

        // identify duplicate elements using Stream API

        Set<Integer> duplicates = numbers.stream()
                .filter(n -> Collections.frequency(numbers, n)>1)
                .collect(Collectors.toSet());

        Set<Integer> duplicates2 = numbers.stream()
                .filter(n -> numbers
                        .stream()
                        .filter(x -> x == n)
                        .count() > 1)
                .collect(Collectors.toSet());

        System.out.println("duplicate elements using Stream API:");
        duplicates.forEach(System.out::println);

        /*
        List<Integer> distinct = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

         */

        // without using Stream

        Map<Integer, Integer> frequency=new HashMap<>();

        for(int x: numbers){
            if(frequency.containsKey(x))
                frequency.put(x, frequency.get(x)+1);
            else
                frequency.put(x, 1);
        }

        System.out.println("duplicate elements using frequency map:");
        frequency.forEach((k, v)->{
            if(v > 1)
                System.out.println(k);
        });

        //distinct.forEach(System.out::print);

        System.out.println("Find all distinct strings");
        //Find all distinct strings
        List<String> list = Arrays.asList("A", "B", "C", "D", "A", "B", "C");
        // Get list without duplicates
        List<String> distinctItems = list.stream()
                .distinct()
                .collect(Collectors.toList());
        // Let's verify distinct elements
        System.out.println(distinctItems);

        ArrayList<Integer> numbersList
                = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8));

        System.out.println("Find all distinct elements using set");

        Set<Integer> setWithoutDuplicates = numbersList.stream()
                .collect(Collectors.toSet());
        System.out.println(setWithoutDuplicates);

        // Collectors.toMap() – To Count Duplicates

        // ArrayList with duplicate elements

        System.out.println("count all duplicate elements using Map");
        Map<Integer, Long> elementCountMap = numbersList.stream()
                .collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum));
        System.out.println(elementCountMap);

        //Find, Count and Remove Duplicate Elements from Array

        Integer[] numArray = new Integer[]{1, 2, 3, 4, 5, 1, 3, 5};

        System.out.println("count all elements using HashMap");

        Map<Integer, Long> map = new HashMap<>();
        for (int i : numArray) {
            if (map.containsKey(i)) { //this element is in the map already
                map.put(i, map.get(i) + 1);
            } else { //found a new element
                map.put(i, 1L);
            }
        }

        System.out.println("count all elements using counting");

        Map<Integer, Long> frequencyMap = Arrays.stream(numArray)
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));

        frequencyMap.forEach((k, v) ->
                System.out.println("element = "+k+", frequency = "+v));


        long duplicateCount = map.keySet()
                .stream()
                .filter(k -> frequencyMap.get(k) > 1)
                .count();

        System.out.println("Count of duplicate elements : "+duplicateCount);

        Integer[] duplicateElementsArray = map.keySet()
                .stream()
                .filter(k -> map.get(k) > 1)
                .toArray(Integer[]::new);

        System.out.println("Duplicate elements in the array : " + Arrays.toString(duplicateElementsArray));

        Integer[] uniqueElementsArray = map.keySet()
                .stream()
                .filter(k -> map.get(k) == 1)
                .toArray(Integer[]::new);

        System.out.println("Unique elements in the array : " + Arrays.toString(uniqueElementsArray));

        //Using Stream and Set
        Integer[] nums = new Integer[]{1, 2, 3, 4, 5, 1, 3, 5};
        Set<Integer> distinctElementsSet = new HashSet<>();
        Integer[] duplicateNumbers = Arrays.stream(nums)
                .filter(e -> !distinctElementsSet.add(e))
                .toArray(Integer[]::new);
        System.out.println("Duplicate elements in the array : " + Arrays.toString(duplicateNumbers));  //1, 3, 5]
        int duplicateNumbersCount = duplicateNumbers.length;
        System.out.println("Count of duplicate elements : " + duplicateNumbersCount);   //3

        distinctElementsSet.removeAll(Arrays.asList(duplicateNumbers));
        Integer[] uniqueElements = distinctElementsSet.toArray(Integer[]::new);
        System.out.println("Unique elements in the array : " + Arrays.toString(uniqueElements));  //[2, 4]
    }
}
