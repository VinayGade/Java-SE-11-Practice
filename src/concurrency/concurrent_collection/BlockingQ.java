package concurrency.concurrent_collection;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQ {

    public static void main(String[] args) {

        BlockingQueue<String> fruitsQ = new LinkedBlockingQueue<>();

        fruitsQ.offer("Apple");
        fruitsQ.offer("Banana");
        fruitsQ.offer("Guava");
        fruitsQ.offer("Pineapple");
        fruitsQ.offer("Orange");
        fruitsQ.offer("Watermelon");

        System.out.println( fruitsQ.peek());
        System.out.println( fruitsQ.size());
        System.out.println( fruitsQ.poll());
        System.out.println( fruitsQ.size());
        System.out.println( fruitsQ.contains("Watermelon"));

        System.out.println(fruitsQ);

        try {
            fruitsQ.offer("Grapes", 500, TimeUnit.MILLISECONDS);
            System.out.println( fruitsQ.size());
            System.out.println(fruitsQ);
            fruitsQ.poll(1000, TimeUnit.MILLISECONDS);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(fruitsQ);
        System.out.println( fruitsQ.size());
    }
}
