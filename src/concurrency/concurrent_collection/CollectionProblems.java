package concurrency.concurrent_collection;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CollectionProblems {

    public static void main(String[] args) {
        //Map<String, String> programmingInterests = new HashMap<>();  //(0)
        // Exception in thread "main" java.util.ConcurrentModificationException

        // (1) solve problem using ConcurrentHashMap
        Map<String, String> programmingInterests = new ConcurrentHashMap<>();

        programmingInterests.put("Vinay", "Java");
        programmingInterests.put("Smita", "Typescript");
        programmingInterests.put("Rahul", "Python");
        programmingInterests.put("Shruti", "Scala");

        for(String name : programmingInterests.keySet()){
            System.out.println(name+" loves coding in "+programmingInterests.get(name));
            programmingInterests.remove(name);
        }
    }
}
