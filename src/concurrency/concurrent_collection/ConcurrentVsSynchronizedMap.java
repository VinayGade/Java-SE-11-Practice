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

        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            map.put(3, "Modification");
            iterator.next();
        }

        assert(map.size() == 3);
    }

}
