package concurrency.ocpjp.concurrency.collections.synchronous;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SynchronizedMap {
    public static void main(String[] args) {
        Map<String, Integer> foodData = new HashMap<>();
        foodData.put("Apple", 120); //cost per kg
        foodData.put("Banana", 20);
        foodData.put("Tomato", 80);

        foodData.forEach((food, cost) ->
                System.out.println("food:"+food+", cost="+cost));

        Map<String, Integer> synchronizedFoodData = Collections
                .synchronizedMap(foodData);

        for(String key: synchronizedFoodData.keySet()){
            synchronizedFoodData.remove(key); // java.util.ConcurrentModificationException
        }
    }
}
