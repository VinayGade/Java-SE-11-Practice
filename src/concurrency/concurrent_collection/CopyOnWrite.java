package concurrency.concurrent_collection;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWrite {

    public static void main(String[] args) {

        List<String> fruits = new CopyOnWriteArrayList<>();

        fruits.add("apple");
        fruits.add("banana");
        fruits.add("grapes");

        System.out.println("\nlist size = "+fruits.size());

        for(String s : fruits){
            System.out.println(s);
            fruits.add(s);
        }

        System.out.println(fruits);

        System.out.println("\nlist size = "+fruits.size());

        Set<String> languages = new CopyOnWriteArraySet<>();

        languages.add("C");
        languages.add("Java");
        languages.add("JavaScript");
        languages.add("TypeScript");
        languages.add("Python");
        languages.add("Ruby");
        languages.add("Scala");

        System.out.println("\nset size = "+languages.size());

        for(String s : languages){
            System.out.println(s);
            languages.add(s);
        }

        System.out.println(languages);
        System.out.println("\nset size = "+languages.size());
    }
}
