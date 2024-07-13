package concurrency.concurrent_collection.fail_fast_safe_iter;

import java.util.ArrayList;
import java.util.Iterator;

/*
These iterators throw ConcurrentModificationException if a collection is modified while iterating over it.

They use original collection to traverse over the elements of the collection.

These iterators don’t require extra memory.

Ex : Iterators returned by ArrayList, Vector, HashMap.
* */

public class FailFastExample {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);

        Iterator<Integer> itr = al.iterator();
        while (itr.hasNext()) {
            if (itr.next() == 2) {
                // will not throw Exception
                itr.remove();
            }
        }

        System.out.println(al);

        itr = al.iterator();
        while (itr.hasNext()) {
            if (itr.next() == 3) {
                // will throw Exception on
                // next call of next() method
                al.remove(3);
            }
        }
    }
}
