package concurrency.concurrent_collection;

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

public class ConcurrentMap {
    public static void main(String[] args) {

        //Map<Character, LongAdder> occurrence = new Hashtable<>();
        Map<Character, LongAdder> occurrence = new ConcurrentHashMap<>();

        String str = "ABCD ABCD ABCD";

        for(char character: str.toCharArray()){
            occurrence.computeIfAbsent(character, ch -> new LongAdder())
                    .increment();

            // for Hashtable / HashMap
            /*
            LongAdder adder = occurrence.get(character);
            if(adder == null)
                adder = new LongAdder();
            adder.increment();
            occurrence.put(character, adder);
             */
        }

        System.out.println(occurrence);
    }
}
