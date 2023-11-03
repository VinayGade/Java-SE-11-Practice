package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DistinctChars {

    public static void main(String[] args) {

        String str = "java streams and lambdas";

        //char[] chars = str.toCharArray();

        List<Character> chars =str.chars()
                .mapToObj( c -> (char) c)
                .distinct()
                .filter(c  -> c != ' ')
                .collect(Collectors.toList());

        System.out.println("\nCharacters in String : ");
        chars.forEach(ch -> System.out.print(" "+ch));

        // ATTEMPT USING MAP AND ARRAYS.STREAM

        List<String> words = Arrays.asList("Goodbye", "World");


        List<Stream<String>> uniqueChars = words.stream()
                .map(word -> word.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        List<String> uniqueCharacters = words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        System.out.println("\nDistinct characters in words array=");

        uniqueCharacters.forEach(c -> System.out.print(" "+c));

    }
}
