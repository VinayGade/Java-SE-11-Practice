package concurrency.concurrent_collection.fail_fast_safe_iter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FailFastExample2 {
    public static void main(String[] args) {
        Map<String, String> cityCode = new HashMap<String, String>();
        cityCode.put("Delhi", "India");
        cityCode.put("Moscow", "Russia");
        cityCode.put("New York", "USA");
        cityCode.put("Madrid", "Spain");
        cityCode.put("Berlin", "Germany");
        cityCode.put("Paris", "France");
        cityCode.put("London", "England");

        Iterator iterator = cityCode.keySet().iterator();

        while (iterator.hasNext()) {
            System.out.println(cityCode.get(iterator.next()));

            // adding an element to Map
            // exception will be thrown on next call
            // of next() method.
            cityCode.put("Istanbul", "Turkey");
        }
    }
}
