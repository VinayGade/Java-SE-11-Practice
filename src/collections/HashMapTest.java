package collections;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<String, String>();

        map.put("Vinay","5346537");
        map.put("Ganesh","1385397");
        map.put("Nikhil","3971385");
        map.put("Vinay","994035");
        map.put(null, "502931");
        map.put(null, null);

        System.out.println(map.get("Vinay"));
        System.out.println(map.get(null));
    }
}
