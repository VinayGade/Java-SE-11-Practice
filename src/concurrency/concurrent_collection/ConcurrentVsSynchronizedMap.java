package concurrency.concurrent_collection;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Collections.*;

public class ConcurrentVsSynchronizedMap {

    @Test
    public void whenRemoveAndAddOnHashMap_thenConcurrentModificationError() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "baeldung");
        map.put(2, "HashMap");
        Map<Integer, String> synchronizedMap = synchronizedMap(map);
        Iterator<Map.Entry<Integer, String>> iterator = synchronizedMap.entrySet().iterator();
        while (iterator.hasNext()) {
            synchronizedMap.put(3, "Modification");
            iterator.next();
        }
    }

    @Test
    public void retrievalAndUpdate_ConcurrentHashMap(){
        Map<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "baeldung");
        map.put(2, "HashMap");

        // Fail Safe iterator
        /*
Fail-safe iterators allow modifications of a collection while iterating over it.
These iterators don’t throw any Exception if a collection is modified while iterating over it.
They use copy of original collection to traverse over the elements of the collection.
These iterators require extra memory for cloning of collection.
Ex : ConcurrentHashMap, CopyOnWriteArrayList
        * */

        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            map.put(3, "Modification");
            iterator.next();
        }

        assert(map.size() == 3);
    }

}
