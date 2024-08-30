package collections;

import java.util.*;
import java.util.stream.Collectors;

public class MapDemo {

    public static void main(String[] args) {

        List<Map<String, Object>> listOfMaps = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("name", "John");
        map1.put("age", 30);
        listOfMaps.add(map1);

        Map<String, Object> map2 = new HashMap<>();
        map2.put("name", "Alice");
        map2.put("age", 25);
        listOfMaps.add(map2);

        iterateFlatMap(listOfMaps);

        String word = "Java SE 8 Functional Programming";
        int n = word.length();

        System.out.println("\nCharacter frequencies in sorted order: ");
        TreeMap<Character, Long> frequencies = findCharFrequency(word, n);
        TreeMap<Character, Integer> frequencieMap = charFrequency(word, n);

        for(Map.Entry<Character, Integer> entry: frequencieMap.entrySet())
            System.out.println("\nCharacter: "+entry.getKey()+", count= "+entry.getValue());
    }

    static void iterate(List<Map<String, Object>> listOfMaps){
        for (Map<String, Object> map : listOfMaps) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                System.out.format("%s: %s\n", key, value);
            }
        }
    }

    static void iterateFlatMap(List<Map<String, Object>> listOfMaps) {
        listOfMaps.stream()
                .flatMap(map -> map.entrySet().stream())
                .forEach(entry -> {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    System.out.format("%s: %s\n", key, value);
                });
    }

    public static TreeMap<Character, Integer> charFrequency(String word, int n){
        char[] chars = word.toCharArray();
        TreeMap<Character, Integer> frequencyMap = new TreeMap<>();
        for(int i=0; i<n; i++)
            frequencyMap.put(chars[i], frequencyMap.getOrDefault(chars[i], 0)+1);
        return frequencyMap;
    }

    public static TreeMap<Character, Long> findCharFrequency(String word, int n){
        TreeMap<Character, Long> frequencyMap = word.chars()
                .mapToObj(c -> (char) c) // Convert IntStream to Stream<Character>
                .collect(Collectors.groupingBy(
                        c -> c, // Character as the key
                        TreeMap::new, // Use TreeMap to maintain order
                        Collectors.counting() // Count frequency
                ));
        return frequencyMap;
    }
}