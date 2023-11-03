package collections.comparison;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQ {

    public static void main(String[] args) {

        PriorityQueue<String> q=new PriorityQueue<>(
                Comparator.comparingInt(String::length).reversed());
        q.add("C++");
        q.add("Java");
        q.add("Scala");
        q.add("Python");
        q.add("Go");
        q.add("Typescript");

        System.out.println("size ="+q.size());

        System.out.println("iterating q elements:");

        Iterator<String> qIter = q.iterator();
        while (qIter.hasNext()){
            System.out.println(qIter.next());
        }

        System.out.println(q.peek());
        System.out.println(q.poll());
        System.out.println("size ="+q.size());
    }
}
