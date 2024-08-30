package collections;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterFrequency{
    
    public Map<String, Long> characterFrequency(String string){
        
        /*
         Map<String, Long> songByLanguage =
                playlist.stream()
                        .collect(groupingBy(
                                Song::getLanguage, Collectors.counting()));
        */

        String[] stringChars = string.split("");
        
        Map<String, Long> frequencyMap = Arrays.stream(stringChars)
            .filter(s -> !s.equals(" "))
            .collect(Collectors.groupingBy(
                Function.identity(), Collectors.counting()));

        return frequencyMap;
    }
}