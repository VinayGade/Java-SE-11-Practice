package collections;

import java.util.HashMap;
import java.util.Map;

public class FrequencyOfWords {

    public static void main(String[] args) {
        String sentence = "Java Programming Functional Programming Functional Interfaces";

        Map<String, Integer> frequencies = frequencyWords(sentence);

        frequencies.forEach((word, frequency) ->
            System.out.println("word: "+word+", frequency:"+frequency)
        );
    }

    static Map<String, Integer> frequencyWords(String sentence){

        String[] words = sentence.split(" ");
        Map<String, Integer> frequencies = new HashMap<>();

        for(String word: words){
            frequencies.put(word, frequencies.getOrDefault(word, 0)+ 1);
        }
        return frequencies;
    }
}
