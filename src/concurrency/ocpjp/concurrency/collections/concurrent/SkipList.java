package concurrency.ocpjp.concurrency.collections.concurrent;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class SkipList {

    public static void main(String[] args) {
         /*
    Concurrent Skip List Map = Concurrent TreeMap

    Concurrent Skip List Set = Concurrent TreeSet
     */

        String[] foods = { "Orange", "Tomato", "Banana", "Lemon", "Apple", "Pepper"};

        Set<String> fruits = new ConcurrentSkipListSet<>(/*Arrays.asList(foods)*/);

        int i=0;
        for(String foodItem: foods){
            if(i%2==0)
                fruits.add(foodItem);
            i++;
        }

        for(String fruit: fruits){
            System.out.println(fruit);
        }

        Map<String, String> capitals = new ConcurrentSkipListMap<>();

        capitals.put("India", "Delhi");
        capitals.put("USA", "New York");
        capitals.put("England", "London");
        capitals.put("France", "Paris");
        capitals.put("Germany", "Berlin");

        System.out.println("captials length ="+capitals.size());
        capitals.forEach((k, v)->{
            System.out.println(k+" "+v);
            capitals.remove(k);
        });

        System.out.println("captials length ="+capitals.size());
    }
}
