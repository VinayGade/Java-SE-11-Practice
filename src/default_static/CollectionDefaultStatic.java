package default_static;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CollectionDefaultStatic {
    public static void main(String[] args) {

        List<String> languages = new ArrayList<>(List.of("Java", "Scala", "Python", "TypeScript", "Golang", "Ruby"));

        languages.sort(Comparator.naturalOrder());

        System.out.println("\nProgramming languages sorted in natural order :");
        languages.forEach(System.out::println);

        List<String> fruits = Arrays.asList("Apple", "Banana", "Guava", "Mango", "Papaya", "Grapes", "Dates", "Orange");

        fruits.sort(Comparator.reverseOrder());  // List : sort(comparator)   ...Default method

        System.out.println("\nFruits sorted in reverse order :");
        fruits.forEach(System.out::println);
    }
}
