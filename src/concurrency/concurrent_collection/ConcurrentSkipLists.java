package concurrency.concurrent_collection;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class ConcurrentSkipLists {

    public static void main(String[] args) {

        Set<String> languages = new ConcurrentSkipListSet<>();

        languages.add("C");
        languages.add("Java");
        languages.add("JavaScript");
        languages.add("TypeScript");
        languages.add("Python");
        languages.add("Ruby");
        languages.add("Scala");

        for(String s : languages)
            System.out.println(s);

        Map<String, String> bookAuthorMap = new ConcurrentSkipListMap<>();
        bookAuthorMap.put("Complete Reference Java", "Herb Schildt");
        bookAuthorMap.put("Head First Java", "Kathy Sierra");
        bookAuthorMap.put("Functional Programming in Scala", "Martin Odersky");
        bookAuthorMap.put("Let Us C", "Yashwant Kanitkar");
        bookAuthorMap.put("Head First Python", "Bert Bates");

        for(String book: bookAuthorMap.keySet())
            System.out.println("Book = "+book +", Author = "+bookAuthorMap.get(book));
    }
}
