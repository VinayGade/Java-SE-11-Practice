package collections;

import java.util.HashMap;

public class MapOperations {

    // Java SE 8 new Map methods :
    /*
    0. getOrDefault
    1. computeIfAbsent
    2. computeIfPresent
    3. putIfAbsent
    4. compute
    5. merge
    6. replace
    7. remove
    8. replaceAll
     */

    public static void main(String[] args) {

        // 0. getOrDefault()
        /*
        The Java HashMap getOrDefault() method returns the specified default value
        if the mapping for the specified key is not found in the hashmap.
         */
        HashMap<Integer, String> languages = new HashMap<>();

        // insert entries to the HashMap
        languages.put(1, "Java");
        languages.put(2, "Python");
        languages.put(3, "JavaScript");
        System.out.println("HashMap: " + languages);

        System.out.println("\n 0. getOrDefault( key, defaultValue) :");
        // mapping for the key is present in HashMap
        String value1 = languages.getOrDefault(1, "Not Found");
        System.out.println("Value for key 1:  " + value1);    // Java

        // ... since mapping for key 1 {1="Java"} present

        // mapping for the key is not present in HashMap
        String value2 = languages.getOrDefault(4, "Not Found");
        System.out.println("Value for key 4: " + value2);  // Not Found

        // ... Since the hashmap does not contain any mapping for key 4

        HashMap<String, Integer> prices = new HashMap<>();

        // insert entries to the HashMap
        prices.put("Shoes", 200);
        prices.put("Bag", 300);
        prices.put("Pant", 150);
        System.out.println("Original Prices Map: " + prices);

        //1.  computeIfAbsent(Key, Function)

        /*
        The Java HashMap computeIfAbsent() method computes a new value and associates it with the specified key
        if the key is not associated with any value in the hashmap.
        * */

        System.out.println("\n 1.  computeIfAbsent(Key, Function):");

        // compute the value of Shirt
        int shirtPrice = prices.computeIfAbsent("Shirt", key -> 280);
        System.out.println("Price of Shirt: " + shirtPrice);

        // print updated HashMap
        System.out.println("Updated HashMap: ");
        prices.forEach((k, v) -> System.out.println("item = "+k+", price = "+v));

        // 2. computeIfPresent
         /*
        The Java HashMap computeIfPresent() method computes a new value and associates it with the specified key
        if the key is already present in in the hashmap.
        * */

        System.out.println("\n 2.  computeIfPresent(Key, Function):");

        // recompute the value of Shoes with 10% VAT
        var shoesPrice = prices.computeIfPresent("Shoes",
                (key, value) -> value + value * 10/100);
        System.out.println("Price of Shoes after VAT: " + shoesPrice);

        // print updated HashMap
        System.out.println("Updated HashMap: " + prices);

        // 3. compute (K key, BiFunction remappingFunction)

        /*
        The Java HashMap compute() method computes a new value and
        associates it with the specified key in the hashmap.
        * */

        System.out.println("\n 3. compute(Key, Function):");

        // recompute the value of Bags with 20% discount
        int newPrice = prices.compute("Bag", (key, value) -> value - value * 20/100);
        System.out.println("Discounted Price of Bag: " + newPrice);

        // print updated HashMap
        System.out.println("Updated HashMap: " + prices);

        /*
        * 4. putIfAbsent
        *
        * The Java HashMap putIfAbsent() method inserts the specified key/value mapping to the hashmap
        * if the specified key is not present in the hashmap.
        * */
        System.out.println("\n 4. putIfAbsent(K key, V value):");

        languages.putIfAbsent(4, "Go");
        languages.putIfAbsent(2, "Scala");  // since key 2 is already present

        System.out.println("Updated languages Map: " + languages);

        prices.putIfAbsent("Shirt", 250);
        prices.putIfAbsent("Jeans", 450);
        prices.putIfAbsent("Bag", 250);  // since key Bag is already present

        System.out.println("Updated Product price Map: " + prices);

        System.out.println("\n 5. replace(K key, V oldValue, V newValue):");

        //  The Java HashMap replace() method replaces the mapping for
        //  the specified key with the specified new value in a hashmap.

        // replace mapping for key 2
        String value = languages.replace(3, "TypeScript");    //{3="JavaScript"} => {3="TypeScript"}
        languages.replace(5, "Scala");   // key 5 not present

        System.out.println("Replaced Value: " + value);
        System.out.println("Updated languages HashMap: " + languages);

        languages.putIfAbsent(5, "Scala");
        System.out.println("Updated languages HashMap: " + languages);

        System.out.println("\nHashMap replace() with Old Value");

        // create an HashMap
        HashMap<String, String> countries = new HashMap<>();

        // insert items to the HashMap
        countries.put("Washington", "America");
        countries.put("Ottawa", "Canada");
        countries.put("Canberra", "Australia");
        System.out.println("Countries:\n" + countries);

        // replace mapping {Washington = America}
        countries.replace("Washington", "America", "USA");  // return true

        countries.replace("Canberra", "New Zealand", "Victoria");  // return false

        //oldValue = "Australia" but found "New Zealand"
        //countries.replace("Canberra", "Australia", "Victoria");

        System.out.println("Countries after replace():\n" + countries);

        System.out.println("\n 6. hashmap.merge(key, value, remappingFunction)");

        /*
        * 6 . merge :
        * If the specified key is not already associated with a value or is associated with null,
        * associates it with the given non-null value. Otherwise, replaces the associated value
        * with the results of the given remapping function, or removes if the result is null.
        * This method may be of use when combining multiple mapped values for a key.
        * */

        /*
        * merge() Return Value
        returns the new value associated with the key
        returns null if no value associated with key
        *
        * */

        int returnedValue = prices.merge("Shorts", 100, (oldValue, newValue) -> oldValue + newValue);
        System.out.println("Price of Shorts: " + returnedValue);

        // print updated HashMap
        System.out.println("Updated product price HashMap: " + prices);
        // merge mapping for key Washington
        String capital = countries.merge("Washington", "USA", (oldValue, newValue) -> oldValue + "/" + newValue);
        System.out.println("Washington: " + capital);

        // print updated HashMap
        System.out.println("Updated HashMap: " + countries);

        HashMap<String, Integer> prices2 = new HashMap<>();

        //insert entries to the HashMap
        prices2.put("Shirt", 340);
        prices2.put("Shoes", 300);
        prices2.put("Jeans", 350);
        prices2.put("Chino", 380);
        prices2.put("Polo Shirt", 210);
        System.out.println("HashMap 1 :prices (old product prices): " + prices);
        System.out.println("HashMap 2 :prices2 (new product prices): " + prices2);

        // forEach() access each entries of prices2
        // merge() inserts each entry from prices2 to prices1
        prices2.forEach((k, v) -> prices.merge(k, v, (oldValue, newValue) -> {

            // return the smaller value
            if (oldValue < newValue) {
                return oldValue;
            }
            else {
                return newValue;
            }
        }));

        System.out.println("Merged HashMap: (prices)" + prices);

        System.out.println("Merged new prices2 into old prices map...");

        System.out.println("\n 7. hashmap.remove(Object key, Object value)");

        /*
        remove
        The remove() method takes two parameters.
        key - remove the mapping specified by this key
        value (optional) - removes the mapping only if the specified key maps to the specified value
        * */

        countries.put("Delhi", "India");
        countries.put("Kathmandu", "Nepal");
        System.out.println("Countries: " + countries);

        // remove mapping {Ottawa=Canada}
        countries.remove("Ottawa", "Canada");  // return true

        // remove mapping {Washington=USA}
        countries.remove("Washington", "USA");  // return false

        System.out.println("Countries after remove(): " + countries);

        //8. replaceAll
        System.out.println("\n 8. hashmap.replaceAll(Bifunction<K, V> function)");
        /*
        The Java HashMap replaceAll() method replaces all mappings of the hashmap with the result from the specified function.
        * */

        // Change all languages to uppercase
        languages.replaceAll((key, val) -> val.toUpperCase());
        System.out.println("Updated HashMap: " + languages);

        // create an HashMap
        HashMap<Integer, Integer> squares = new HashMap<>();

        // insert entries to the HashMap
        squares.put(5, 0);
        squares.put(8, 1);
        squares.put(9, 2);
        System.out.println("HashMap: " + squares);

        // replace all value with the square of key
        squares.replaceAll((key, square) -> key * key);;
        System.out.println("Updated squares HashMap: " + squares);

    }

}
