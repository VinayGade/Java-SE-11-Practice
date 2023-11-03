package factory;

import java.util.*;

public class CollectionsNew {
    public static void main(String[] args) {

        // before Java 9

        List<String> names = new ArrayList<>();

        names.add("Vinay");
        names.add("Smita");
        names.add("Shruti");

        names = Collections.unmodifiableList(names);

        names.forEach(System.out::println);

        System.out.println("\nJava 9 List");

        // Java 9  List.of(..)   ... static method of List interface
        List<String> languages = List.of("Java","Scala", "Python", "TypeScript", "Golang", "Ruby");

        languages.forEach(System.out::println);

        System.out.println("\nJava 9 Set");

        Set<String> weekdays = Set.of("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");

        weekdays.forEach(System.out::println);

        // Java 9 Map
        Map<String, String> technologies = Map.of("Java" ,"Spring",
                "TypeScript", "Angular",
                "Python", "Django",
                "Ruby","Ruby on Rails");


        technologies.forEach((k, v) -> {
            System.out.println("Language = "+k+ ", Technology = "+v);
        });

        //Error provoking code
        /*
        List<String> fruits = List.of("Apple", "Banana", null, "Guava", "Mango", "Papaya", "Grapes", "Dates");

        //line 44 : NullPointerException

        Set<String> months = Set.of("January", "March", "April", "May", "June", "July", "March", "June");

        //line 48 : IllegalArgumentException ...duplicates not allowed in set

        technologies.put("JavaScript","Node"); //UnsupportedOperationException ...unmodifiable map

        languages.add("R"); //UnsupportedOperationException ...unmodifiable list
        */


    }
}
