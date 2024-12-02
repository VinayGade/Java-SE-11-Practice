package basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Collection2Arr {
    public static void main(String[] args) {
        List sampleList = Arrays.asList("Java", "Kotlin");
        String[] sampleArray = (String[])sampleList.toArray(String[]::new);

        /*
        List<String> sampleList = Arrays.asList("Java", "Kotlin");
        String[] sampleArray = sampleList.toArray(String[]::new);
        * */

        for(String s : sampleArray)
            System.out.println(s);

        List<Integer> nums = new ArrayList<>();
        List<Integer> evens = nums.stream()
                .filter(x -> x%2==0)
                .collect(Collectors.toUnmodifiableList());

        /*
        evens.add(4); //java.lang.UnsupportedOperationException
         */

        //Predicate.not()

        List<String> options = Arrays.asList("Like", " ","Share", " ", "Subscribe", "\n\n");
        List<String> withoutBlanks = options.stream()
                .filter(Predicate.not(String::isBlank))
                .collect(Collectors.toList());

        withoutBlanks.forEach(System.out::println);

        List<String> myList = Arrays.asList(" ","   ","Jan","Feb","Mar");


        //orElseThrow
        String str = myList.stream()
                .filter(Predicate.not(String::isBlank))
                .findFirst()
                .orElseThrow();

        System.out.println(str);
    }
}
