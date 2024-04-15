package collections.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseList {

    public static void main(String[] args) {

        List<String> languages = List.of("Java","Python","GoLang", "JavaScript",
                "Dart", "Scala", "Ruby", "C++", "TypeScript", "R", "Rust");

        System.out.println(reverseList(languages));

        List<Integer> numbers = List.of(10, 20, 40, 60, 80, 100, 150, 200, 250, 500);
        System.out.println(reverseList(numbers));
    }

    public static <T> List<T> reverseList(List<T> original) {
        List<T> reversed = new ArrayList<>(original);
        Collections.reverse(reversed);
        return reversed;
    }
}
